package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Li  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0992Li implements Closeable {
    @Nullable
    public C0991Lh A00;
    public boolean A01;
    public final C0990Lg A02;
    public final Runnable A03;

    public C0992Li(long j2, Runnable runnable) {
        this.A02 = new C0990Lg(j2);
        this.A02.A02();
        this.A03 = runnable;
        this.A01 = false;
    }

    private final synchronized void A03() {
        if (this.A00 == null && !this.A01) {
            this.A00 = new C0991Lh(this);
        }
    }

    public final C0990Lg A04() {
        return this.A02;
    }

    public final synchronized void A05() {
        if (this.A01) {
            return;
        }
        if (this.A00 == null) {
            this.A00 = new C0991Lh(this);
        }
        this.A00.A00();
    }

    public final synchronized void A06() {
        if (this.A02.A05() && !this.A01) {
            A03();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0991Lh c0991Lh;
        synchronized (this) {
            this.A01 = true;
            c0991Lh = this.A00;
        }
        if (c0991Lh != null) {
            c0991Lh.close();
        }
    }
}
