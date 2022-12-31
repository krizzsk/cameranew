package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcad implements zzeqb<zzcrj<zzbyy>> {
    private final zzeqo<zzdzv> zzfux;
    private final zzeqo<zzdrj> zzfvi;
    private final zzeqo<zzctr> zzfvj;
    private final zzeqo<zzcwe> zzfvk;

    public zzcad(zzeqo<zzdrj> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<zzctr> zzeqoVar3, zzeqo<zzcwe> zzeqoVar4) {
        this.zzfvi = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzfvj = zzeqoVar3;
        this.zzfvk = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzcrj) zzeqh.zza(new zzcwi(this.zzfvi.get(), this.zzfux.get(), this.zzfvk.get(), this.zzfvj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
