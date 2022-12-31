package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbpp implements zzeqb<com.google.android.gms.ads.internal.zza> {
    private final zzeqo<Context> zzewk;
    private final zzbpq zzfxr;
    private final zzeqo<zzawz> zzfxs;

    private zzbpp(zzbpq zzbpqVar, zzeqo<Context> zzeqoVar, zzeqo<zzawz> zzeqoVar2) {
        this.zzfxr = zzbpqVar;
        this.zzewk = zzeqoVar;
        this.zzfxs = zzeqoVar2;
    }

    public static zzbpp zza(zzbpq zzbpqVar, zzeqo<Context> zzeqoVar, zzeqo<zzawz> zzeqoVar2) {
        return new zzbpp(zzbpqVar, zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.zza) zzeqh.zza(new com.google.android.gms.ads.internal.zza(this.zzewk.get(), this.zzfxs.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
