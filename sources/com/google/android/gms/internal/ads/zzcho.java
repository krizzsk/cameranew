package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcho implements zzeqb<String> {
    private final zzeqo<zzdnp> zzfvf;

    public zzcho(zzeqo<zzdnp> zzeqoVar) {
        this.zzfvf = zzeqoVar;
    }

    public static String zzb(zzdnp zzdnpVar) {
        return (String) zzeqh.zza(zzdnpVar.zzhle.zzhki == zzdnh.zzhkm ? "rewarded_interstitial" : "rewarded", "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzb(this.zzfvf.get());
    }
}
