package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdq implements zzeqb<zzcdh> {
    private final zzeqo<zzccl> zzfig;
    private final zzeqo<zzcgk> zzfjj;
    private final zzeqo<zzchq> zzggo;
    private final zzeqo<zzbkm> zzggp;

    public zzcdq(zzeqo<zzchq> zzeqoVar, zzeqo<zzcgk> zzeqoVar2, zzeqo<zzbkm> zzeqoVar3, zzeqo<zzccl> zzeqoVar4) {
        this.zzggo = zzeqoVar;
        this.zzfjj = zzeqoVar2;
        this.zzggp = zzeqoVar3;
        this.zzfig = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcdh(this.zzggo.get(), this.zzfjj.get(), this.zzggp.get(), this.zzfig.get());
    }
}
