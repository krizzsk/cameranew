package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdzg<V> extends zzdww implements Future<V> {
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return zzazf().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return zzazf().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return zzazf().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return zzazf().isDone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdww
    /* renamed from: zzbad */
    public abstract Future<? extends V> zzazf();

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzazf().get(j2, timeUnit);
    }
}
