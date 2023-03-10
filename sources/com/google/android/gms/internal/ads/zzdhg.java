package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhg implements zzeqb<zzdhe> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzarw> zzexx;
    private final zzeqo<ScheduledExecutorService> zzfrq;

    public zzdhg(zzeqo<zzarw> zzeqoVar, zzeqo<ScheduledExecutorService> zzeqoVar2, zzeqo<Context> zzeqoVar3) {
        this.zzexx = zzeqoVar;
        this.zzfrq = zzeqoVar2;
        this.zzewk = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdhe(this.zzexx.get(), this.zzfrq.get(), this.zzewk.get());
    }
}
