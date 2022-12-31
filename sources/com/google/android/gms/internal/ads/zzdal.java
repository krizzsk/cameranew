package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdal implements zzeqb<zzdaj> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzcmx> zzgnv;

    public zzdal(zzeqo<Executor> zzeqoVar, zzeqo<zzcmx> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzgnv = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdaj(this.zzewf.get(), this.zzgnv.get());
    }
}
