package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbqd implements zzeqb<zzbya<zzbsh>> {
    private final zzeqo<zzbqs> zzewe;
    private final zzbps zzfxv;

    private zzbqd(zzbps zzbpsVar, zzeqo<zzbqs> zzeqoVar) {
        this.zzfxv = zzbpsVar;
        this.zzewe = zzeqoVar;
    }

    public static zzbqd zzb(zzbps zzbpsVar, zzeqo<zzbqs> zzeqoVar) {
        return new zzbqd(zzbpsVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzewe.get(), zzazp.zzeih), "Cannot return null from a non-@Nullable @Provides method");
    }
}
