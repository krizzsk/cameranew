package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwq implements zzeqb<Set<zzbya<zzbrr>>> {
    private final zzbwg zzgav;

    private zzbwq(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbwq zzo(zzbwg zzbwgVar) {
        return new zzbwq(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzama(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
