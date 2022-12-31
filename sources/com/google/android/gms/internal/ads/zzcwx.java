package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwx<AdT> implements zzeqb<zzcwt<AdT>> {
    private final zzeqo<zzdzv> zzfux;
    private final zzeqo<zzdrj> zzfvi;
    private final zzeqo<zzacl> zzgww;
    private final zzeqo<zzcwy<AdT>> zzgxb;

    public zzcwx(zzeqo<zzdrj> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<zzacl> zzeqoVar3, zzeqo<zzcwy<AdT>> zzeqoVar4) {
        this.zzfvi = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzgww = zzeqoVar3;
        this.zzgxb = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcwt(this.zzfvi.get(), this.zzfux.get(), this.zzgww.get(), this.zzgxb.get());
    }
}
