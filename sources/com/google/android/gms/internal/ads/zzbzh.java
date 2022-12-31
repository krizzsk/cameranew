package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzh implements zzeqb<zzbya<zzbtb>> {
    private final zzeqo<zzcai> zzftr;
    private final zzbyz zzgbk;

    private zzbzh(zzbyz zzbyzVar, zzeqo<zzcai> zzeqoVar) {
        this.zzgbk = zzbyzVar;
        this.zzftr = zzeqoVar;
    }

    public static zzbzh zzc(zzbyz zzbyzVar, zzeqo<zzcai> zzeqoVar) {
        return new zzbzh(zzbyzVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzftr.get(), zzazp.zzeig), "Cannot return null from a non-@Nullable @Provides method");
    }
}
