package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcfz implements zzeqb<zzcga> {
    private final zzeqo<String> zzfza;
    private final zzeqo<zzccd> zzgcy;
    private final zzeqo<zzcbu> zzgir;

    private zzcfz(zzeqo<String> zzeqoVar, zzeqo<zzcbu> zzeqoVar2, zzeqo<zzccd> zzeqoVar3) {
        this.zzfza = zzeqoVar;
        this.zzgir = zzeqoVar2;
        this.zzgcy = zzeqoVar3;
    }

    public static zzcfz zzp(zzeqo<String> zzeqoVar, zzeqo<zzcbu> zzeqoVar2, zzeqo<zzccd> zzeqoVar3) {
        return new zzcfz(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcga(this.zzfza.get(), this.zzgir.get(), this.zzgcy.get());
    }
}
