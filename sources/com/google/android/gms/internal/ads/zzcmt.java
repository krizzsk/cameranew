package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmt implements zzeqb<zzcnj> {
    private final zzeqo<Context> zzewk;

    private zzcmt(zzeqo<Context> zzeqoVar) {
        this.zzewk = zzeqoVar;
    }

    public static zzcmt zzac(zzeqo<Context> zzeqoVar) {
        return new zzcmt(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzcnj) zzeqh.zza(new zzcnj(this.zzewk.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
