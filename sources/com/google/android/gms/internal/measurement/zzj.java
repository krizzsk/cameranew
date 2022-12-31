package com.google.android.gms.internal.measurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzj implements zzh {
    private zzj() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzj(zzi zziVar) {
    }

    public static final ExecutorService zzc(int i2, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.measurement.zzh
    public final ExecutorService zza(int i2) {
        return zzc(1, Executors.defaultThreadFactory(), 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzh
    public final ExecutorService zzb(ThreadFactory threadFactory, int i2) {
        return zzc(1, threadFactory, 1);
    }
}
