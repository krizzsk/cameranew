package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqf implements zzeqb<zzcqg> {
    private final zzeqo<zzcqb> zzgrb;

    private zzcqf(zzeqo<zzcqb> zzeqoVar) {
        this.zzgrb = zzeqoVar;
    }

    public static zzcqf zzah(zzeqo<zzcqb> zzeqoVar) {
        return new zzcqf(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcqg(this.zzgrb.get());
    }
}
