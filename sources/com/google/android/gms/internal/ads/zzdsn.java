package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsn implements zzeqb<zzdso> {
    private final zzeqo<zzdsh> zzewt;
    private final zzeqo<zzdsj> zzgme;

    public zzdsn(zzeqo<zzdsj> zzeqoVar, zzeqo<zzdsh> zzeqoVar2) {
        this.zzgme = zzeqoVar;
        this.zzewt = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdso(this.zzgme.get(), this.zzewt.get());
    }
}
