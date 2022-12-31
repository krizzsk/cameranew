package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddi implements zzeqb<zzddg> {
    private final zzeqo<zzdzv> zzewf;

    private zzddi(zzeqo<zzdzv> zzeqoVar) {
        this.zzewf = zzeqoVar;
    }

    public static zzddi zzap(zzeqo<zzdzv> zzeqoVar) {
        return new zzddi(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzddg(this.zzewf.get());
    }
}
