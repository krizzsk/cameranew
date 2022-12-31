package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdas implements zzeqb<zzdat> {
    private final zzeqo<zzdnp> zzfvf;

    private zzdas(zzeqo<zzdnp> zzeqoVar) {
        this.zzfvf = zzeqoVar;
    }

    public static zzdas zzal(zzeqo<zzdnp> zzeqoVar) {
        return new zzdas(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdat(this.zzfvf.get());
    }
}
