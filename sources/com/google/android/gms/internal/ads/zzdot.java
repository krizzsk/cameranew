package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdot implements zzeqb<Context> {
    private final zzeqo<Context> zzfxw;
    private final zzdor zzhml;

    private zzdot(zzdor zzdorVar, zzeqo<Context> zzeqoVar) {
        this.zzhml = zzdorVar;
        this.zzfxw = zzeqoVar;
    }

    public static zzdot zza(zzdor zzdorVar, zzeqo<Context> zzeqoVar) {
        return new zzdot(zzdorVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzhml, this.zzfxw.get());
    }

    public static Context zza(zzdor zzdorVar, Context context) {
        return (Context) zzeqh.zza(context, "Cannot return null from a non-@Nullable @Provides method");
    }
}
