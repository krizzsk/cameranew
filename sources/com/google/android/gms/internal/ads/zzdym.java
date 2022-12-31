package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdym<I, O> extends zzdyn<I, O, zzdyu<? super I, ? extends O>, zzdzw<? extends O>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdym(zzdzw<? extends I> zzdzwVar, zzdyu<? super I, ? extends O> zzdyuVar) {
        super(zzdzwVar, zzdyuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdzw) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        zzdyu zzdyuVar = (zzdyu) obj;
        zzdzw<O> zzf = zzdyuVar.zzf(obj2);
        zzdwl.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyuVar);
        return zzf;
    }
}
