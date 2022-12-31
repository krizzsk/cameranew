package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.android.gms.tasks.j;
import com.google.firebase.iid.WakeLockHolder;
import com.google.firebase.iid.WithinAppServiceBinder;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.ExecutorService;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes2.dex */
public abstract class EnhancedIntentService extends Service {
    private Binder binder;
    private int lastStartId;
    @VisibleForTesting
    final ExecutorService executor = FcmExecutors.newIntentHandleExecutor();
    private final Object lock = new Object();
    private int runningTasks = 0;

    private void finishTask(Intent intent) {
        if (intent != null) {
            WakeLockHolder.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            int i2 = this.runningTasks - 1;
            this.runningTasks = i2;
            if (i2 == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public g<Void> processIntent(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return j.e(null);
        }
        final h hVar = new h();
        this.executor.execute(new Runnable(this, intent, hVar) { // from class: com.google.firebase.messaging.EnhancedIntentService$$Lambda$0
            private final EnhancedIntentService arg$1;
            private final Intent arg$2;
            private final h arg$3;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = intent;
                this.arg$3 = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.arg$1.lambda$processIntent$0$EnhancedIntentService(this.arg$2, this.arg$3);
            }
        });
        return hVar.a();
    }

    protected Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, g gVar) {
        finishTask(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$processIntent$0$EnhancedIntentService(Intent intent, h hVar) {
        try {
            handleIntent(intent);
        } finally {
            hVar.c(null);
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.binder == null) {
            this.binder = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() { // from class: com.google.firebase.messaging.EnhancedIntentService.1
                @Override // com.google.firebase.iid.WithinAppServiceBinder.IntentHandler
                public g<Void> handle(Intent intent2) {
                    return EnhancedIntentService.this.processIntent(intent2);
                }
            });
        }
        return this.binder;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i2, int i3) {
        VdsAgent.onServiceStartCommand(this, intent, i2, i3);
        synchronized (this.lock) {
            this.lastStartId = i3;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        g<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.m()) {
            finishTask(intent);
            return 2;
        }
        processIntent.b(EnhancedIntentService$$Lambda$1.$instance, new c(this, intent) { // from class: com.google.firebase.messaging.EnhancedIntentService$$Lambda$2
            private final EnhancedIntentService arg$1;
            private final Intent arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = intent;
            }

            @Override // com.google.android.gms.tasks.c
            public void onComplete(g gVar) {
                this.arg$1.lambda$onStartCommand$1$EnhancedIntentService(this.arg$2, gVar);
            }
        });
        return 3;
    }

    boolean stopSelfResultHook(int i2) {
        return stopSelfResult(i2);
    }
}
