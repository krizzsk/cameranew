package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdqw<E, V> implements zzdzw<V> {
    private final E zzhpu;
    private final String zzhpv;
    private final zzdzw<V> zzhpw;

    @VisibleForTesting(otherwise = 3)
    public zzdqw(E e2, String str, zzdzw<V> zzdzwVar) {
        this.zzhpu = e2;
        this.zzhpv = str;
        this.zzhpw = zzdzwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzw
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhpw.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzhpw.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhpw.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzhpw.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzhpw.isDone();
    }

    public final String toString() {
        String str = this.zzhpv;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzaxh() {
        return this.zzhpu;
    }

    public final String zzaxi() {
        return this.zzhpv;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhpw.get(j2, timeUnit);
    }
}
