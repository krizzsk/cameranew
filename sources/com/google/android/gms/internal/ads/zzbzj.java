package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzj implements zzeqb<zzbya<zzair>> {
    private final zzeqo<zzcgz> zzftr;
    private final zzbyz zzgbk;

    public zzbzj(zzbyz zzbyzVar, zzeqo<zzcgz> zzeqoVar) {
        this.zzgbk = zzbyzVar;
        this.zzftr = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzftr.get(), zzazp.zzeih), "Cannot return null from a non-@Nullable @Provides method");
    }
}
