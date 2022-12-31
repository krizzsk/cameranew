package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbop implements zzeqb<zzboq> {
    private final zzeqo<zzbsm> zzfgg;

    private zzbop(zzeqo<zzbsm> zzeqoVar) {
        this.zzfgg = zzeqoVar;
    }

    public static zzbop zze(zzeqo<zzbsm> zzeqoVar) {
        return new zzbop(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzboq(this.zzfgg.get());
    }
}
