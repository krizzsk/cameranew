package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwl implements zzeqb<Set<zzbya<com.google.android.gms.ads.internal.overlay.zzq>>> {
    private final zzbwg zzgav;

    private zzbwl(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbwl zzi(zzbwg zzbwgVar) {
        return new zzbwl(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzamj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
