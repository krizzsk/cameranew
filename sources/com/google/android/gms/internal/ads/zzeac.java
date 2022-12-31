package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeac<V> extends zzdzi<V> implements zzdzw<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zziay;

    public zzeac(zzdzw<V> zzdzwVar, ScheduledFuture<?> scheduledFuture) {
        super(zzdzwVar);
        this.zziay = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdzg, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zziay.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return this.zziay.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zziay.getDelay(timeUnit);
    }
}
