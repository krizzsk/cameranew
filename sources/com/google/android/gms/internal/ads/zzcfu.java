package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcfu implements zzeqb<zzcfn> {
    private final zzeqo<Executor> zzfux;
    private final zzeqo<zzbkm> zzggp;
    private final zzeqo<zzbxz> zzgio;

    public zzcfu(zzeqo<Executor> zzeqoVar, zzeqo<zzbkm> zzeqoVar2, zzeqo<zzbxz> zzeqoVar3) {
        this.zzfux = zzeqoVar;
        this.zzggp = zzeqoVar2;
        this.zzgio = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcfn(this.zzfux.get(), this.zzggp.get(), this.zzgio.get());
    }
}
