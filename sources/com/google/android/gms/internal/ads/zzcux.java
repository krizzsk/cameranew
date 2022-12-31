package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcux implements zzeqb<zzcuy> {
    private final zzeqo<zzcim> zzexc;
    private final zzeqo<zzckn> zzexw;
    private final zzeqo<zzdoc> zzeyk;
    private final zzeqo<zzdrz> zzgjp;

    private zzcux(zzeqo<zzdoc> zzeqoVar, zzeqo<zzcim> zzeqoVar2, zzeqo<zzckn> zzeqoVar3, zzeqo<zzdrz> zzeqoVar4) {
        this.zzeyk = zzeqoVar;
        this.zzexc = zzeqoVar2;
        this.zzexw = zzeqoVar3;
        this.zzgjp = zzeqoVar4;
    }

    public static zzcux zzf(zzeqo<zzdoc> zzeqoVar, zzeqo<zzcim> zzeqoVar2, zzeqo<zzckn> zzeqoVar3, zzeqo<zzdrz> zzeqoVar4) {
        return new zzcux(zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcuy(this.zzeyk.get(), this.zzexc.get(), this.zzexw.get(), this.zzgjp.get());
    }
}
