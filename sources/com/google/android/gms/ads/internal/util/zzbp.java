package com.google.android.gms.ads.internal.util;

import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbp {
    private long a;
    @GuardedBy("lock")
    private long b = Long.MIN_VALUE;
    private final Object c = new Object();

    public zzbp(long j2) {
        this.a = j2;
    }

    public final boolean tryAcquire() {
        synchronized (this.c) {
            long a = com.google.android.gms.ads.internal.zzr.zzky().a();
            if (this.b + this.a > a) {
                return false;
            }
            this.b = a;
            return true;
        }
    }

    public final void zzfb(long j2) {
        synchronized (this.c) {
            this.a = j2;
        }
    }
}
