package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzm implements zzeqb<Set<zzbya<zzbrm>>> {
    private final zzeqo<zzbql> zzftr;
    private final zzbyz zzgbk;

    private zzbzm(zzbyz zzbyzVar, zzeqo<zzbql> zzeqoVar) {
        this.zzgbk = zzbyzVar;
        this.zzftr = zzeqoVar;
    }

    public static zzbzm zze(zzbyz zzbyzVar, zzeqo<zzbql> zzeqoVar) {
        return new zzbzm(zzbyzVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgbk.zzb(this.zzftr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
