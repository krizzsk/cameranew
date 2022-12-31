package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwv implements zzeqb<Set<zzbya<zzbtt>>> {
    private final zzbwg zzgav;

    private zzbwv(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbwv zzu(zzbwg zzbwgVar) {
        return new zzbwv(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzamh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
