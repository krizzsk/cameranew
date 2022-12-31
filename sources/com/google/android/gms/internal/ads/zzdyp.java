package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyp<I, O> extends zzdyn<I, O, zzdvz<? super I, ? extends O>, O> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyp(zzdzw<? extends I> zzdzwVar, zzdvz<? super I, ? extends O> zzdvzVar) {
        super(zzdzwVar, zzdvzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    final void setResult(@NullableDecl O o) {
        set(o);
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    @NullableDecl
    final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdvz) obj).apply(obj2);
    }
}
