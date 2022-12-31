package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwt implements zzeqb<Set<zzbya<AdMetadataListener>>> {
    private final zzbwg zzgav;

    private zzbwt(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbwt zzr(zzbwg zzbwgVar) {
        return new zzbwt(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(this.zzgav.zzamc(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
