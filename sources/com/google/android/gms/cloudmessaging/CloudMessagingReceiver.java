package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService zza = com.google.android.gms.internal.cloudmessaging.zza.zza().zza(new com.google.android.gms.common.util.v.a("firebase-iid-executor"), zzf.zza);

    @WorkerThread
    private final int zza(@NonNull Context context, @NonNull Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            onNotificationOpen(context, extras);
            return -1;
        } else if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            onNotificationDismissed(context, extras);
            return -1;
        } else {
            Log.e("CloudMessagingReceiver", "Unknown notification action");
            return 500;
        }
    }

    @WorkerThread
    private final int zzb(@NonNull Context context, @NonNull Intent intent) {
        com.google.android.gms.tasks.g<Void> d2;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        if (TextUtils.isEmpty(stringExtra)) {
            d2 = com.google.android.gms.tasks.j.e(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, stringExtra);
            d2 = e.c(context).d(2, bundle);
        }
        int onMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            com.google.android.gms.tasks.j.b(d2, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("Message ack failed: ");
            sb.append(valueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return onMessageReceive;
    }

    @NonNull
    protected Executor getBroadcastExecutor() {
        return this.zza;
    }

    @WorkerThread
    protected abstract int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage);

    @WorkerThread
    protected void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
    }

    @WorkerThread
    protected void onNotificationOpen(@NonNull Context context, @NonNull Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull final Context context, @NonNull final Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if (intent == null) {
            return;
        }
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        getBroadcastExecutor().execute(new Runnable(this, intent, context, isOrderedBroadcast, goAsync) { // from class: com.google.android.gms.cloudmessaging.d
            private final CloudMessagingReceiver a;
            private final Intent b;
            private final Context c;

            /* renamed from: d  reason: collision with root package name */
            private final boolean f3582d;

            /* renamed from: e  reason: collision with root package name */
            private final BroadcastReceiver.PendingResult f3583e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = intent;
                this.c = context;
                this.f3582d = isOrderedBroadcast;
                this.f3583e = goAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.zza(this.b, this.c, this.f3582d, this.f3583e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int zzb;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                zzb = zza(context, intent2);
            } else {
                zzb = zzb(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(zzb);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
