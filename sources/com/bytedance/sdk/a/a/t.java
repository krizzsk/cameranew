package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class t {
    public static final t c = new t() { // from class: com.bytedance.sdk.a.a.t.1
        @Override // com.bytedance.sdk.a.a.t
        public t a(long j2) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public t a(long j2, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public void g() throws IOException {
        }
    };
    private boolean a;
    private long b;

    /* renamed from: d  reason: collision with root package name */
    private long f852d;

    public t a(long j2, TimeUnit timeUnit) {
        if (j2 >= 0) {
            if (timeUnit != null) {
                this.f852d = timeUnit.toNanos(j2);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j2);
    }

    public long b_() {
        return this.f852d;
    }

    public boolean c() {
        return this.a;
    }

    public long c_() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t e() {
        this.f852d = 0L;
        return this;
    }

    public t f() {
        this.a = false;
        return this;
    }

    public void g() throws IOException {
        if (!Thread.interrupted()) {
            if (this.a && this.b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public t a(long j2) {
        this.a = true;
        this.b = j2;
        return this;
    }
}
