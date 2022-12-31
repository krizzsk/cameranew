package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbts extends zzbwf<zzbtw> {
    private final Clock zzbqg;
    @GuardedBy("this")
    private boolean zzfsp;
    private final ScheduledExecutorService zzfth;
    @GuardedBy("this")
    private long zzftj;
    @GuardedBy("this")
    private long zzftk;
    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzfzq;

    public zzbts(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzftj = -1L;
        this.zzftk = -1L;
        this.zzfsp = false;
        this.zzfth = scheduledExecutorService;
        this.zzbqg = clock;
    }

    public final void zzalt() {
        zza(zzbtv.zzfzg);
    }

    private final synchronized void zzfd(long j2) {
        ScheduledFuture<?> scheduledFuture = this.zzfzq;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzfzq.cancel(true);
        }
        this.zzftj = this.zzbqg.a() + j2;
        this.zzfzq = this.zzfth.schedule(new zzbtx(this), j2, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfsp) {
            ScheduledFuture<?> scheduledFuture = this.zzfzq;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.zzfzq.cancel(true);
                this.zzftk = this.zzftj - this.zzbqg.a();
            } else {
                this.zzftk = -1L;
            }
            this.zzfsp = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfsp) {
            if (this.zzftk > 0 && this.zzfzq.isCancelled()) {
                zzfd(this.zzftk);
            }
            this.zzfsp = false;
        }
    }

    public final synchronized void zzals() {
        this.zzfsp = false;
        zzfd(0L);
    }

    public final synchronized void zzdx(int i2) {
        if (i2 <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i2);
        if (this.zzfsp) {
            long j2 = this.zzftk;
            if (j2 <= 0 || millis >= j2) {
                millis = j2;
            }
            this.zzftk = millis;
            return;
        }
        long a = this.zzbqg.a();
        long j3 = this.zzftj;
        if (a > j3 || j3 - this.zzbqg.a() > millis) {
            zzfd(millis);
        }
    }
}
