package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdda implements zzeqb<zzdcy> {
    private final zzeqo<zzdzv> zzewf;

    private zzdda(zzeqo<zzdzv> zzeqoVar) {
        this.zzewf = zzeqoVar;
    }

    public static zzdda zzao(zzeqo<zzdzv> zzeqoVar) {
        return new zzdda(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdcy(this.zzewf.get());
    }
}
