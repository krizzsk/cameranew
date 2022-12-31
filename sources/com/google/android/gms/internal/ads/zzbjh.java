package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjh implements zzeqb<zzbji> {
    private final zzeqo<com.google.android.gms.ads.internal.util.zzf> zzfag;

    private zzbjh(zzeqo<com.google.android.gms.ads.internal.util.zzf> zzeqoVar) {
        this.zzfag = zzeqoVar;
    }

    public static zzbjh zza(zzeqo<com.google.android.gms.ads.internal.util.zzf> zzeqoVar) {
        return new zzbjh(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbji(this.zzfag.get());
    }
}
