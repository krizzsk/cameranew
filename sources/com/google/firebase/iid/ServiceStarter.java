package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
public class ServiceStarter {
    public static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    public static final int ERROR_UNKNOWN = 500;
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    @Nullable
    @GuardedBy("this")
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasWakeLockPermission = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    public static PendingIntent createMessagingPendingIntent(Context context, int i2, Intent intent, int i3) {
        Intent wrapServiceIntent = wrapServiceIntent(context, ACTION_MESSAGING_EVENT, intent);
        VdsAgent.onPendingIntentGetBroadcastBefore(context, i2, wrapServiceIntent, i3);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, wrapServiceIntent, i3);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, i2, wrapServiceIntent, i3, broadcast);
        return broadcast;
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName startService;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", resolveServiceClassName.length() != 0 ? "Restricting intent to a specific service: ".concat(resolveServiceClassName) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                startService = WakeLockHolder.startWakefulService(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startService == null) {
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return DeeplinkCallback.ERROR_LINK_NOT_EXIST;
            }
            return -1;
        } catch (IllegalStateException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf);
            Log.e("FirebaseInstanceId", sb.toString());
            return TypedValues.CycleType.TYPE_VISIBILITY;
        } catch (SecurityException e3) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e3);
            return 401;
        }
    }

    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (instance == null) {
                instance = new ServiceStarter();
            }
            serviceStarter = instance;
        }
        return serviceStarter;
    }

    @Nullable
    private synchronized String resolveServiceClassName(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.firebaseMessagingServiceClassName;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    this.firebaseMessagingServiceClassName = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                } else {
                    this.firebaseMessagingServiceClassName = serviceInfo.name;
                }
                return this.firebaseMessagingServiceClassName;
            }
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str3);
            sb.append("/");
            sb.append(str4);
            Log.e("FirebaseInstanceId", sb.toString());
            return null;
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    @VisibleForTesting
    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    public static void startMessagingServiceViaReceiver(Context context, Intent intent) {
        context.sendBroadcast(wrapServiceIntent(context, ACTION_MESSAGING_EVENT, intent));
    }

    @Nullable
    public static Intent unwrapServiceIntent(Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (parcelableExtra instanceof Intent) {
            return (Intent) parcelableExtra;
        }
        return null;
    }

    private static Intent wrapServiceIntent(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction(ACTION_MESSAGING_EVENT);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    @MainThread
    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    @MainThread
    public int startMessagingService(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
