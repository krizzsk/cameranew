package com.google.android.gms.internal.ads;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxa implements zzeqb<zzbwg> {
    private final zzbwg zzgav;

    private zzbxa(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbxa zzz(zzbwg zzbwgVar) {
        return new zzbxa(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzbwg zzbwgVar = this.zzgav;
        Objects.requireNonNull(zzbwgVar);
        return (zzbwg) zzeqh.zza(zzbwgVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
