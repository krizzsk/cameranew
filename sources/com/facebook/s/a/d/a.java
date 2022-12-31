package com.facebook.s.a.d;

import androidx.annotation.VisibleForTesting;
import com.facebook.s.a.a.d;
/* compiled from: DropFramesFrameScheduler.java */
/* loaded from: classes.dex */
public class a implements b {
    private final d a;
    private long b = -1;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // com.facebook.s.a.d.b
    public long a(long j2) {
        long d2 = d();
        long j3 = 0;
        if (d2 == 0) {
            return -1L;
        }
        if (e() || j2 / d() < this.a.b()) {
            long j4 = j2 % d2;
            int a = this.a.a();
            for (int i2 = 0; i2 < a && j3 <= j4; i2++) {
                j3 += this.a.i(i2);
            }
            return j2 + (j3 - j4);
        }
        return -1L;
    }

    @Override // com.facebook.s.a.d.b
    public int b(long j2, long j3) {
        long d2 = d();
        if (d2 == 0) {
            return c(0L);
        }
        if (e() || j2 / d2 < this.a.b()) {
            return c(j2 % d2);
        }
        return -1;
    }

    @VisibleForTesting
    int c(long j2) {
        int i2 = 0;
        long j3 = 0;
        do {
            j3 += this.a.i(i2);
            i2++;
        } while (j2 >= j3);
        return i2 - 1;
    }

    public long d() {
        long j2 = this.b;
        if (j2 != -1) {
            return j2;
        }
        this.b = 0L;
        int a = this.a.a();
        for (int i2 = 0; i2 < a; i2++) {
            this.b += this.a.i(i2);
        }
        return this.b;
    }

    public boolean e() {
        return this.a.b() == 0;
    }
}
