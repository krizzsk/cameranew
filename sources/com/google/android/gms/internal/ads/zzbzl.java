package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzl implements zzeqb<zzaxd> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdnp> zzfvf;
    private final zzbyz zzgbk;

    private zzbzl(zzbyz zzbyzVar, zzeqo<Context> zzeqoVar, zzeqo<zzdnp> zzeqoVar2) {
        this.zzgbk = zzbyzVar;
        this.zzewk = zzeqoVar;
        this.zzfvf = zzeqoVar2;
    }

    public static zzbzl zza(zzbyz zzbyzVar, zzeqo<Context> zzeqoVar, zzeqo<zzdnp> zzeqoVar2) {
        return new zzbzl(zzbyzVar, zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzaxd) zzeqh.zza(new zzaxd(this.zzewk.get(), this.zzfvf.get().zzhkx), "Cannot return null from a non-@Nullable @Provides method");
    }
}
