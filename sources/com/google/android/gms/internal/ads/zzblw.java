package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblw implements zzeqb<zzbts> {
    private final zzeqo<Clock> zzfsz;
    private final zzeqo<ScheduledExecutorService> zzfun;

    public zzblw(zzeqo<ScheduledExecutorService> zzeqoVar, zzeqo<Clock> zzeqoVar2) {
        this.zzfun = zzeqoVar;
        this.zzfsz = zzeqoVar2;
    }

    public static zzbts zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbts) zzeqh.zza(new zzbts(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfun.get(), this.zzfsz.get());
    }
}
