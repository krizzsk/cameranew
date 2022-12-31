package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbqr implements zzeqb<zzbqs> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdmw> zzfvr;
    private final zzeqo<zzarz> zzfyk;

    private zzbqr(zzeqo<Context> zzeqoVar, zzeqo<zzdmw> zzeqoVar2, zzeqo<zzarz> zzeqoVar3) {
        this.zzewk = zzeqoVar;
        this.zzfvr = zzeqoVar2;
        this.zzfyk = zzeqoVar3;
    }

    public static zzbqr zzl(zzeqo<Context> zzeqoVar, zzeqo<zzdmw> zzeqoVar2, zzeqo<zzarz> zzeqoVar3) {
        return new zzbqr(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbqs(this.zzewk.get(), this.zzfvr.get(), this.zzfyk.get());
    }
}
