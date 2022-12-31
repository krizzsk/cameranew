package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdzb extends zzdza<V> {
    private final /* synthetic */ zzdyy zziah;
    private final Callable<V> zziai;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdzb(zzdyy zzdyyVar, Callable<V> callable, Executor executor) {
        super(zzdyyVar, executor);
        this.zziah = zzdyyVar;
        this.zziai = (Callable) zzdwl.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdza
    final void setValue(V v) {
        this.zziah.set(v);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdzs
    final V zzbab() throws Exception {
        return this.zziai.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdzs
    final String zzbac() {
        return this.zziai.toString();
    }
}
