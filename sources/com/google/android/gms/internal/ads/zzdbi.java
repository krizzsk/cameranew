package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbi implements zzeqb<zzdbg> {
    private final zzeqo<zzcin> zzewd;
    private final zzeqo<zzdzv> zzhak;
    private final zzeqo<String> zzhay;

    private zzdbi(zzeqo<String> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<zzcin> zzeqoVar3) {
        this.zzhay = zzeqoVar;
        this.zzhak = zzeqoVar2;
        this.zzewd = zzeqoVar3;
    }

    public static zzdbi zzz(zzeqo<String> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<zzcin> zzeqoVar3) {
        return new zzdbi(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdbg(this.zzhay.get(), this.zzhak.get(), this.zzewd.get());
    }
}
