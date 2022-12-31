package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddv implements zzeqb<zzddo> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<com.google.android.gms.ads.internal.util.zzf> zzfag;
    private final zzeqo<zzdnp> zzfvf;
    private final zzeqo<PackageInfo> zzfyt;

    public zzddv(zzeqo<zzdzv> zzeqoVar, zzeqo<zzdnp> zzeqoVar2, zzeqo<PackageInfo> zzeqoVar3, zzeqo<com.google.android.gms.ads.internal.util.zzf> zzeqoVar4) {
        this.zzewf = zzeqoVar;
        this.zzfvf = zzeqoVar2;
        this.zzfyt = zzeqoVar3;
        this.zzfag = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzddo(this.zzewf.get(), this.zzfvf.get(), this.zzfyt.get(), this.zzfag.get());
    }
}
