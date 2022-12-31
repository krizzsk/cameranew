package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdao implements zzeqb<zzdam> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdnp> zzfvf;
    private final zzeqo<ViewGroup> zzgvb;
    private final zzeqo<zzdzv> zzhak;

    public zzdao(zzeqo<zzdzv> zzeqoVar, zzeqo<Context> zzeqoVar2, zzeqo<zzdnp> zzeqoVar3, zzeqo<ViewGroup> zzeqoVar4) {
        this.zzhak = zzeqoVar;
        this.zzewk = zzeqoVar2;
        this.zzfvf = zzeqoVar3;
        this.zzgvb = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdam(this.zzhak.get(), this.zzewk.get(), this.zzfvf.get(), this.zzgvb.get());
    }
}
