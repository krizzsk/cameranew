package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrg implements zzeqb<zzbrh> {
    private final zzeqo<zzcrq> zzfaj;
    private final zzeqo<zzdmw> zzfvr;
    private final zzeqo<String> zzfza;

    private zzbrg(zzeqo<zzdmw> zzeqoVar, zzeqo<String> zzeqoVar2, zzeqo<zzcrq> zzeqoVar3) {
        this.zzfvr = zzeqoVar;
        this.zzfza = zzeqoVar2;
        this.zzfaj = zzeqoVar3;
    }

    public static zzbrg zzm(zzeqo<zzdmw> zzeqoVar, zzeqo<String> zzeqoVar2, zzeqo<zzcrq> zzeqoVar3) {
        return new zzbrg(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbrh(this.zzfvr.get(), this.zzfza.get(), this.zzfaj.get());
    }
}
