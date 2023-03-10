package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbm implements zzeqb<zzdbk> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<zzdnp> zzfvf;
    private final zzeqo<zzazn> zzfze;

    private zzdbm(zzeqo<zzdzv> zzeqoVar, zzeqo<zzdnp> zzeqoVar2, zzeqo<zzazn> zzeqoVar3) {
        this.zzewf = zzeqoVar;
        this.zzfvf = zzeqoVar2;
        this.zzfze = zzeqoVar3;
    }

    public static zzdbm zzaa(zzeqo<zzdzv> zzeqoVar, zzeqo<zzdnp> zzeqoVar2, zzeqo<zzazn> zzeqoVar3) {
        return new zzdbm(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdbk(this.zzewf.get(), this.zzfvf.get(), this.zzfze.get());
    }
}
