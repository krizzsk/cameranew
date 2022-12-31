package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzceo implements zzeqb<zzcem> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<com.google.android.gms.ads.internal.util.zzay> zzfdj;
    private final zzeqo<Clock> zzfsz;

    public zzceo(zzeqo<com.google.android.gms.ads.internal.util.zzay> zzeqoVar, zzeqo<Clock> zzeqoVar2, zzeqo<Executor> zzeqoVar3) {
        this.zzfdj = zzeqoVar;
        this.zzfsz = zzeqoVar2;
        this.zzewf = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcem(this.zzfdj.get(), this.zzfsz.get(), this.zzewf.get());
    }
}
