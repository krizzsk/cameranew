package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcko implements zzeqb<zzckl> {
    private final zzeqo<zzckw> zzexi;
    private final zzeqo<zzayy> zzezq;

    private zzcko(zzeqo<zzckw> zzeqoVar, zzeqo<zzayy> zzeqoVar2) {
        this.zzexi = zzeqoVar;
        this.zzezq = zzeqoVar2;
    }

    public static zzcko zzag(zzeqo<zzckw> zzeqoVar, zzeqo<zzayy> zzeqoVar2) {
        return new zzcko(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzckl(this.zzexi.get(), this.zzezq.get());
    }
}
