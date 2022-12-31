package com.tapjoy.internal;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public final class fi {
    public static final fi a = new fi(-1);
    public final long b;
    public long c;

    public fi(long j2) {
        this.b = j2;
        this.c = SystemClock.elapsedRealtime();
    }

    public final boolean a() {
        try {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    public final boolean a(long j2) {
        try {
            return (SystemClock.elapsedRealtime() - this.c) + j2 > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    public fi() {
        this.b = 3600000L;
        try {
            this.c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.c = -1L;
        }
    }
}
