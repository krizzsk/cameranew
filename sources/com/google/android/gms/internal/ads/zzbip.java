package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbip implements zzeqb<zzdtm> {
    private final zzeqo<Context> zzewk;

    public zzbip(zzeqo<Context> zzeqoVar) {
        this.zzewk = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdtm) zzeqh.zza(new zzdtm(this.zzewk.get(), com.google.android.gms.ads.internal.zzr.zzlf().zzzp()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
