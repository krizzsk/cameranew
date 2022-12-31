package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayt {
    private final Object lock;
    private volatile int zzecy;
    private volatile long zzecz;

    private zzayt() {
        this.lock = new Object();
        this.zzecy = zzays.zzecu;
        this.zzecz = 0L;
    }

    public final void zzxo() {
        int i2;
        long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
        synchronized (this.lock) {
            int i3 = this.zzecy;
            i2 = zzays.zzecw;
            if (i3 == i2) {
                if (this.zzecz + ((Long) zzwr.zzqr().zzd(zzabp.zzcxl)).longValue() <= currentTimeMillis) {
                    this.zzecy = zzays.zzecu;
                }
            }
        }
        long currentTimeMillis2 = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzecy != 2) {
                return;
            }
            this.zzecy = 3;
            if (this.zzecy == i2) {
                this.zzecz = currentTimeMillis2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzayt(zzayq zzayqVar) {
        this();
    }
}
