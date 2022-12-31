package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpk implements zzeqb<zzcph> {
    private final zzeqo<zzayy> zzezq;
    private final zzeqo<zzdrz> zzgjp;
    private final zzeqo<zzdsa> zzgqg;

    private zzcpk(zzeqo<zzdsa> zzeqoVar, zzeqo<zzdrz> zzeqoVar2, zzeqo<zzayy> zzeqoVar3) {
        this.zzgqg = zzeqoVar;
        this.zzgjp = zzeqoVar2;
        this.zzezq = zzeqoVar3;
    }

    public static zzcpk zzy(zzeqo<zzdsa> zzeqoVar, zzeqo<zzdrz> zzeqoVar2, zzeqo<zzayy> zzeqoVar3) {
        return new zzcpk(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcph(this.zzgqg.get(), this.zzgjp.get(), this.zzezq.get());
    }
}
