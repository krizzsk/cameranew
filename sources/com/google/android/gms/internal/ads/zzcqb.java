package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqb {
    private int responseCode = 0;
    private long zzgqs = 0;
    private long zzgqt = 0;
    private long zzgqu = 0;
    private final Object zzgqv = new Object();
    private final Object zzgqw = new Object();
    private final Object zzgqx = new Object();
    private final Object zzgqy = new Object();

    public final int getResponseCode() {
        int i2;
        synchronized (this.zzgqv) {
            i2 = this.responseCode;
        }
        return i2;
    }

    public final synchronized long zzaru() {
        long j2;
        synchronized (this.zzgqx) {
            j2 = this.zzgqt;
        }
        return j2;
    }

    public final void zzea(int i2) {
        synchronized (this.zzgqv) {
            this.responseCode = i2;
        }
    }

    public final void zzeq(long j2) {
        synchronized (this.zzgqw) {
            this.zzgqs = j2;
        }
    }

    public final synchronized void zzer(long j2) {
        synchronized (this.zzgqy) {
            this.zzgqu = j2;
        }
    }

    public final synchronized void zzfe(long j2) {
        synchronized (this.zzgqx) {
            this.zzgqt = j2;
        }
    }

    public final long zzow() {
        long j2;
        synchronized (this.zzgqw) {
            j2 = this.zzgqs;
        }
        return j2;
    }

    public final synchronized long zzox() {
        long j2;
        synchronized (this.zzgqy) {
            j2 = this.zzgqu;
        }
        return j2;
    }
}
