package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqa implements zzeqb<zzcpv> {
    private final zzeqo<zzcpt> zzfco;
    private final zzeqo<zzdzv> zzgqr;

    private zzcqa(zzeqo<zzcpt> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        this.zzfco = zzeqoVar;
        this.zzgqr = zzeqoVar2;
    }

    public static zzcqa zzaq(zzeqo<zzcpt> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        return new zzcqa(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcpv(this.zzfco.get(), this.zzgqr.get());
    }
}
