package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdzz extends zzeaa implements zzdzv, ScheduledExecutorService {
    private final ScheduledExecutorService zziav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzz(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zziav = (ScheduledExecutorService) zzdwl.checkNotNull(scheduledExecutorService);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
        zzeah zzf = zzeah.zzf(callable);
        return new zzeac(zzf, this.zziav.schedule(zzf, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzeab zzeabVar = new zzeab(runnable);
        return new zzeac(zzeabVar, this.zziav.scheduleAtFixedRate(zzeabVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzeab zzeabVar = new zzeab(runnable);
        return new zzeac(zzeabVar, this.zziav.scheduleWithFixedDelay(zzeabVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        zzeah zza = zzeah.zza(runnable, (Object) null);
        return new zzeac(zza, this.zziav.schedule(zza, j2, timeUnit));
    }
}
