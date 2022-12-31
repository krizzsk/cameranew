package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzazu implements Executor {
    private final Handler zzeik = new com.google.android.gms.ads.internal.util.zzg(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzr.zzkr();
                com.google.android.gms.ads.internal.util.zzj.zza(com.google.android.gms.ads.internal.zzr.zzkv().getApplicationContext(), th);
                throw th;
            }
        }
        this.zzeik.post(runnable);
    }
}
