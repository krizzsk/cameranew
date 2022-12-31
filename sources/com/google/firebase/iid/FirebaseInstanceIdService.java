package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
@Deprecated
/* loaded from: classes2.dex */
public class FirebaseInstanceIdService extends Service {
    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @WorkerThread
    @Deprecated
    public void onTokenRefresh() {
    }
}
