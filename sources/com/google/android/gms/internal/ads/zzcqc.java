package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqc implements zzeqb<zzcpz> {
    private final zzeqo<zzcqi> zzgqz;

    private zzcqc(zzeqo<zzcqi> zzeqoVar) {
        this.zzgqz = zzeqoVar;
    }

    public static zzcqc zzag(zzeqo<zzcqi> zzeqoVar) {
        return new zzcqc(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcpz(this.zzgqz.get());
    }
}
