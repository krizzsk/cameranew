package com.google.android.gms.internal.ads;

import java.lang.Throwable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyj<V, X extends Throwable> extends zzdyg<V, X, zzdyu<? super X, ? extends V>, zzdzw<? extends V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyj(zzdzw<? extends V> zzdzwVar, Class<X> cls, zzdyu<? super X, ? extends V> zzdyuVar) {
        super(zzdzwVar, cls, zzdyuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyg
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdzw) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdyg
    final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzdyu zzdyuVar = (zzdyu) obj;
        zzdzw zzf = zzdyuVar.zzf(th);
        zzdwl.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyuVar);
        return zzf;
    }
}
