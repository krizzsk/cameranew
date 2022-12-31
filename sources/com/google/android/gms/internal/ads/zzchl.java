package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzug;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzchl implements zzeqb<zzug.zza.EnumC0160zza> {
    private final zzeqo<zzdnp> zzfvf;

    public zzchl(zzeqo<zzdnp> zzeqoVar) {
        this.zzfvf = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzug.zza.EnumC0160zza enumC0160zza;
        if (this.zzfvf.get().zzhle.zzhki == zzdnh.zzhkm) {
            enumC0160zza = zzug.zza.EnumC0160zza.REWARDED_INTERSTITIAL;
        } else {
            enumC0160zza = zzug.zza.EnumC0160zza.REWARD_BASED_VIDEO_AD;
        }
        return (zzug.zza.EnumC0160zza) zzeqh.zza(enumC0160zza, "Cannot return null from a non-@Nullable @Provides method");
    }
}
