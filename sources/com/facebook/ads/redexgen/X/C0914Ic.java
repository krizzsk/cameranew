package com.facebook.ads.redexgen.X;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* renamed from: com.facebook.ads.redexgen.X.Ic  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0914Ic extends BufferedOutputStream {
    public boolean A00;

    public C0914Ic(OutputStream outputStream) {
        super(outputStream);
    }

    public C0914Ic(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    public final void A00(OutputStream outputStream) {
        I6.A04(this.A00);
        this.out = outputStream;
        this.count = 0;
        this.A00 = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A00 = true;
        Throwable th = null;
        try {
            flush();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.out.close();
        } catch (Throwable e2) {
            if (th == null) {
                th = e2;
            }
        }
        if (th != null) {
            C0923Il.A0Y(th);
        }
    }
}
