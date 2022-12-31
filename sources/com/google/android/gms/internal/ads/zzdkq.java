package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdkq implements zzeqb<zzdkn<zzblk, zzblq>> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdov> zzeyu;
    private final zzeqo<zzdpq> zzeyv;

    public zzdkq(zzeqo<Context> zzeqoVar, zzeqo<zzdov> zzeqoVar2, zzeqo<zzdpq> zzeqoVar3) {
        this.zzewk = zzeqoVar;
        this.zzeyu = zzeqoVar2;
        this.zzeyv = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdkn) zzeqh.zza(zzdkr.zzb(this.zzewk.get(), this.zzeyu.get(), this.zzeyv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
