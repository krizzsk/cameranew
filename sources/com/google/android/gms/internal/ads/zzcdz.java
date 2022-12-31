package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdz implements zzeqb<zzcea> {
    private final zzeqo<zzcch> zzfih;
    private final zzeqo<zzccd> zzgcy;

    public zzcdz(zzeqo<zzccd> zzeqoVar, zzeqo<zzcch> zzeqoVar2) {
        this.zzgcy = zzeqoVar;
        this.zzfih = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcea(this.zzgcy.get(), this.zzfih.get());
    }
}
