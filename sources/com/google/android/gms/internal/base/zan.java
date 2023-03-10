package com.google.android.gms.internal.base;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class zan implements zam {
    private zan() {
    }

    @Override // com.google.android.gms.internal.base.zam
    @NonNull
    public final ExecutorService zaa(int i2, int i3) {
        return zaa(4, Executors.defaultThreadFactory(), i3);
    }

    @Override // com.google.android.gms.internal.base.zam
    @NonNull
    public final ExecutorService zaa(int i2, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
