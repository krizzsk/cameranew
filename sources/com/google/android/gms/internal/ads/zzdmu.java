package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmu {
    private final Clock zzbqg;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private volatile int zzhiw = zzdmx.zzhkb;
    private volatile long zzecz = 0;

    public zzdmu(Clock clock) {
        this.zzbqg = clock;
    }

    private final void zzauw() {
        long currentTimeMillis = this.zzbqg.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhiw == zzdmx.zzhkd) {
                if (this.zzecz + ((Long) zzwr.zzqr().zzd(zzabp.zzcxl)).longValue() <= currentTimeMillis) {
                    this.zzhiw = zzdmx.zzhkb;
                }
            }
        }
    }

    private final void zzr(int i2, int i3) {
        zzauw();
        long currentTimeMillis = this.zzbqg.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhiw != i2) {
                return;
            }
            this.zzhiw = i3;
            if (this.zzhiw == zzdmx.zzhkd) {
                this.zzecz = currentTimeMillis;
            }
        }
    }

    public final boolean zzaux() {
        boolean z;
        synchronized (this.lock) {
            zzauw();
            z = this.zzhiw == zzdmx.zzhkc;
        }
        return z;
    }

    public final boolean zzauy() {
        boolean z;
        synchronized (this.lock) {
            zzauw();
            z = this.zzhiw == zzdmx.zzhkd;
        }
        return z;
    }

    public final void zzbl(boolean z) {
        if (z) {
            zzr(zzdmx.zzhkb, zzdmx.zzhkc);
        } else {
            zzr(zzdmx.zzhkc, zzdmx.zzhkb);
        }
    }

    public final void zzxo() {
        zzr(zzdmx.zzhkc, zzdmx.zzhkd);
    }
}
