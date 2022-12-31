package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbws implements zzeqb<Set<zzbya<zzbse>>> {
    private final zzbwg zzgav;

    private zzbws(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbws zzq(zzbwg zzbwgVar) {
        return new zzbws(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzamf(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
