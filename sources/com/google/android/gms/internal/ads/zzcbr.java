package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbr implements zzeqb<zzcbs> {
    private final zzeqo<zzccd> zzgcy;

    private zzcbr(zzeqo<zzccd> zzeqoVar) {
        this.zzgcy = zzeqoVar;
    }

    public static zzcbr zzy(zzeqo<zzccd> zzeqoVar) {
        return new zzcbr(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcbs(this.zzgcy.get());
    }
}
