package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.j;
import java.util.concurrent.ExecutionException;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static Intent createServiceIntent(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    @WorkerThread
    protected int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) j.a(new FcmBroadcastProcessor(context).process(cloudMessage.Q()))).intValue();
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send message to service.", e2);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    @WorkerThread
    protected void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
        try {
            j.a(new FcmBroadcastProcessor(context).process(createServiceIntent(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle)));
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send notification dismissed event to service.", e2);
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    @WorkerThread
    protected void onNotificationOpen(@NonNull Context context, @NonNull Bundle bundle) {
        try {
            j.a(new FcmBroadcastProcessor(context).process(createServiceIntent(context, "com.google.firebase.messaging.NOTIFICATION_OPEN", bundle)));
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send notification open event to service.", e2);
        }
    }
}
