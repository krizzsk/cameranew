package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcs implements zzeqb<zzdco> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<Context> zzfxw;

    private zzdcs(zzeqo<Context> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        this.zzfxw = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzdco zza(Context context, zzdzv zzdzvVar) {
        return new zzdco(context, zzdzvVar);
    }

    public static zzdcs zzau(zzeqo<Context> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        return new zzdcs(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfxw.get(), this.zzewf.get());
    }
}
