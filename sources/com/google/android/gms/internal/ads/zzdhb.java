package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhb implements zzeqb<zzdgz> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<zzayg> zzexx;
    private final zzeqo<String> zzfyr;

    public zzdhb(zzeqo<zzayg> zzeqoVar, zzeqo<zzdzv> zzeqoVar2, zzeqo<String> zzeqoVar3) {
        this.zzexx = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzfyr = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdgz(this.zzexx.get(), this.zzewf.get(), this.zzfyr.get());
    }
}
