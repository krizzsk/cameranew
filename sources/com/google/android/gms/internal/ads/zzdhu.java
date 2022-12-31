package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhu implements zzeqb<zzdhv> {
    private final zzeqo<zzbgc> zzewg;
    private final zzeqo<Executor> zzfux;
    private final zzeqo<zzdil> zzgyt;
    private final zzeqo<Context> zzhex;
    private final zzeqo<zzdkn<zzbkx, zzblg>> zzhey;
    private final zzeqo<zzdnr> zzhez;

    public zzdhu(zzeqo<Context> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzbgc> zzeqoVar3, zzeqo<zzdkn<zzbkx, zzblg>> zzeqoVar4, zzeqo<zzdil> zzeqoVar5, zzeqo<zzdnr> zzeqoVar6) {
        this.zzhex = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzewg = zzeqoVar3;
        this.zzhey = zzeqoVar4;
        this.zzgyt = zzeqoVar5;
        this.zzhez = zzeqoVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdhv(this.zzhex.get(), this.zzfux.get(), this.zzewg.get(), this.zzhey.get(), this.zzgyt.get(), this.zzhez.get());
    }
}
