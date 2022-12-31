package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcnv implements zzeqb<zzcnw> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzaxc> zzfqr;

    private zzcnv(zzeqo<Context> zzeqoVar, zzeqo<zzaxc> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzfqr = zzeqoVar2;
    }

    public static zzcnv zzal(zzeqo<Context> zzeqoVar, zzeqo<zzaxc> zzeqoVar2) {
        return new zzcnv(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcnw(this.zzewk.get(), this.zzfqr.get());
    }
}
