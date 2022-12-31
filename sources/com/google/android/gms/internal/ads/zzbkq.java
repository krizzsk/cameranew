package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkq implements zzrm {
    private final Clock zzbqg;
    private final ScheduledExecutorService zzfth;
    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzfti;
    @GuardedBy("this")
    private long zzftj = -1;
    @GuardedBy("this")
    private long zzftk = -1;
    @GuardedBy("this")
    private Runnable zzedk = null;
    @GuardedBy("this")
    private boolean zzftl = false;

    public zzbkq(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfth = scheduledExecutorService;
        this.zzbqg = clock;
        com.google.android.gms.ads.internal.zzr.zzku().zza(this);
    }

    private final synchronized void zzajc() {
        if (!this.zzftl) {
            ScheduledFuture<?> scheduledFuture = this.zzfti;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzfti.cancel(true);
                this.zzftk = this.zzftj - this.zzbqg.a();
            } else {
                this.zzftk = -1L;
            }
            this.zzftl = true;
        }
    }

    private final synchronized void zzajd() {
        ScheduledFuture<?> scheduledFuture;
        if (this.zzftl) {
            if (this.zzftk > 0 && (scheduledFuture = this.zzfti) != null && scheduledFuture.isCancelled()) {
                this.zzfti = this.zzfth.schedule(this.zzedk, this.zzftk, TimeUnit.MILLISECONDS);
            }
            this.zzftl = false;
        }
    }

    public final synchronized void zza(int i2, Runnable runnable) {
        this.zzedk = runnable;
        long j2 = i2;
        this.zzftj = this.zzbqg.a() + j2;
        this.zzfti = this.zzfth.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final void zzp(boolean z) {
        if (z) {
            zzajd();
        } else {
            zzajc();
        }
    }
}
