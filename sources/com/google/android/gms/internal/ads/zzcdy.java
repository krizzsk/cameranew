package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdy implements zzeqb<zzcdp> {
    private final zzeqo<zzcgk> zzfjj;
    private final zzeqo<zzchq> zzggo;

    public zzcdy(zzeqo<zzchq> zzeqoVar, zzeqo<zzcgk> zzeqoVar2) {
        this.zzggo = zzeqoVar;
        this.zzfjj = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcdp(this.zzggo.get(), this.zzfjj.get());
    }
}
