package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmv implements zzeqb<zzdmq> {
    private final zzeqo<zzdnk> zzfpa;
    private final zzeqo<zzdmc> zzgys;
    private final zzeqo<zzdlh> zzhfh;

    public zzdmv(zzeqo<zzdmc> zzeqoVar, zzeqo<zzdlh> zzeqoVar2, zzeqo<zzdnk> zzeqoVar3) {
        this.zzgys = zzeqoVar;
        this.zzhfh = zzeqoVar2;
        this.zzfpa = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdmq(this.zzgys.get(), this.zzhfh.get(), this.zzfpa.get());
    }
}
