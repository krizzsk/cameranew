package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeaj extends zzdzs<V> {
    private final Callable<V> zziai;
    private final /* synthetic */ zzeah zzibd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaj(zzeah zzeahVar, Callable<V> callable) {
        this.zzibd = zzeahVar;
        this.zziai = (Callable) zzdwl.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdzs
    final boolean isDone() {
        return this.zzibd.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdzs
    final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzibd.set(v);
        } else {
            this.zzibd.setException(th);
        }
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
