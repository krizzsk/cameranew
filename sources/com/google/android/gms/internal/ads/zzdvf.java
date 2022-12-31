package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdvf implements zzdve {
    private zzdvf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ExecutorService zza(ThreadFactory threadFactory, int i2) {
        return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ExecutorService zzb(ThreadFactory threadFactory, int i2) {
        return zza(1, threadFactory, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ExecutorService zzel(int i2) {
        return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ExecutorService zzem(int i2) {
        return zza(1, Executors.defaultThreadFactory(), i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ExecutorService zza(int i2, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final ScheduledExecutorService zzb(int i2, ThreadFactory threadFactory, int i3) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }
}
