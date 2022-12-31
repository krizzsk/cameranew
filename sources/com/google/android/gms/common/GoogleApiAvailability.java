package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.base.zap;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f3590d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final GoogleApiAvailability f3591e = new GoogleApiAvailability();

    /* renamed from: f  reason: collision with root package name */
    public static final int f3592f = GoogleApiAvailabilityLight.a;
    @GuardedBy("mLock")
    private String c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class a extends zap {
        private final Context a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int f2 = GoogleApiAvailability.this.f(this.a);
            if (GoogleApiAvailability.this.h(f2)) {
                GoogleApiAvailability.this.o(this.a, f2);
            }
        }
    }

    @NonNull
    public static GoogleApiAvailability getInstance() {
        return f3591e;
    }

    @Nullable
    static Dialog p(@NonNull Context context, int i2, com.google.android.gms.common.internal.f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.e.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c = com.google.android.gms.common.internal.e.c(context, i2);
        if (c != null) {
            builder.setPositiveButton(c, fVar);
        }
        String g2 = com.google.android.gms.common.internal.e.g(context, i2);
        if (g2 != null) {
            builder.setTitle(g2);
        }
        return builder.create();
    }

    static void q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.a0(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void s(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i2), null), new IllegalArgumentException());
        if (i2 == 18) {
            r(context);
        } else if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String f2 = com.google.android.gms.common.internal.e.f(context, i2);
            String e2 = com.google.android.gms.common.internal.e.e(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(f2).setStyle(new NotificationCompat.BigTextStyle().bigText(e2));
            if (com.google.android.gms.common.util.i.d(context)) {
                com.google.android.gms.common.internal.q.m(com.google.android.gms.common.util.o.g());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (com.google.android.gms.common.util.i.f(context)) {
                    style.addAction(com.google.android.gms.base.R.drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.string.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(e2);
            }
            if (com.google.android.gms.common.util.o.k()) {
                com.google.android.gms.common.internal.q.m(com.google.android.gms.common.util.o.k());
                String u = u();
                if (u == null) {
                    u = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b = com.google.android.gms.common.internal.e.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", b, 4));
                    } else if (!b.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                style.setChannelId(u);
            }
            Notification build = style.build();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                c.f3642d.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, build);
            VdsAgent.onNotify(notificationManager, i3, build);
        }
    }

    @VisibleForTesting(otherwise = 2)
    private final String u() {
        String str;
        synchronized (f3590d) {
            str = this.c;
        }
        return str;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    public Intent b(Context context, int i2, @Nullable String str) {
        return super.b(context, i2, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Nullable
    public PendingIntent c(Context context, int i2, int i3) {
        return super.c(context, i2, i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @NonNull
    public final String e(int i2) {
        return super.e(i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int f(Context context) {
        return super.f(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int g(Context context, int i2) {
        return super.g(context, i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean h(int i2) {
        return super.h(i2);
    }

    public Dialog k(Activity activity, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i2, com.google.android.gms.common.internal.f.a(activity, b(activity, i2, "d"), i3), onCancelListener);
    }

    @Nullable
    public PendingIntent l(Context context, ConnectionResult connectionResult) {
        if (connectionResult.T()) {
            return connectionResult.S();
        }
        return c(context, connectionResult.Q(), 0);
    }

    public boolean m(Activity activity, int i2, int i3) {
        return n(activity, i2, i3, null);
    }

    public boolean n(Activity activity, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog k2 = k(activity, i2, i3, onCancelListener);
        if (k2 == null) {
            return false;
        }
        q(activity, k2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int i2) {
        s(context, i2, null, d(context, i2, 0, "n"));
    }

    final void r(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean t(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent l2 = l(context, connectionResult);
        if (l2 != null) {
            s(context, connectionResult.Q(), null, GoogleApiActivity.a(context, l2, i2));
            return true;
        }
        return false;
    }
}
