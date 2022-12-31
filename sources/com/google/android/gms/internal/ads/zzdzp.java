package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdzp<V> {
    private final boolean zzhzs;
    private final zzdxd<zzdzw<? extends V>> zziao;

    private zzdzp(boolean z, zzdxd<zzdzw<? extends V>> zzdxdVar) {
        this.zzhzs = z;
        this.zziao = zzdxdVar;
    }

    public final <C> zzdzw<C> zzb(Callable<C> callable, Executor executor) {
        return new zzdyy(this.zziao, this.zzhzs, executor, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdzp(boolean z, zzdxd zzdxdVar, zzdzn zzdznVar) {
        this(z, zzdxdVar);
    }
}
