package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcud implements zzeqb<zzctx> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<zzcen> zzfdq;
    private final zzeqo<zzcau> zzgtg;
    private final zzeqo<zzdof<zzcgk>> zzgus;

    public zzcud(zzeqo<zzcau> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<zzcen> zzeqoVar3, zzeqo<zzdof<zzcgk>> zzeqoVar4) {
        this.zzgtg = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzfdq = zzeqoVar3;
        this.zzgus = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzctx(this.zzgtg.get(), this.zzewf.get(), this.zzfdq.get(), this.zzgus.get());
    }
}
