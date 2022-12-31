package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdou implements zzeqb<com.google.android.gms.ads.internal.util.zzf> {
    private final zzeqo<zzayo> zzhas;
    private final zzdor zzhml;

    private zzdou(zzdor zzdorVar, zzeqo<zzayo> zzeqoVar) {
        this.zzhml = zzdorVar;
        this.zzhas = zzeqoVar;
    }

    public static com.google.android.gms.ads.internal.util.zzf zza(zzdor zzdorVar, zzayo zzayoVar) {
        return (com.google.android.gms.ads.internal.util.zzf) zzeqh.zza(zzayoVar.zzxs(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdou zzb(zzdor zzdorVar, zzeqo<zzayo> zzeqoVar) {
        return new zzdou(zzdorVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzhml, this.zzhas.get());
    }
}
