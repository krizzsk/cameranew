package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: com.facebook.ads.redexgen.X.Or  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1076Or extends InputStream {
    public int A00;
    public long A01;
    public HR A02;
    public final Uri A03;
    public final HQ A04;

    public C1076Or(Uri uri, HQ hq) throws IOException {
        this.A04 = hq;
        this.A03 = uri;
        A00(0);
    }

    private void A00(int i2) throws IOException {
        HR hr = this.A02;
        if (hr != null) {
            hr.close();
        }
        this.A02 = this.A04.A4C();
        this.A01 = (int) this.A02.ACf(new HV(this.A03, i2, -1L, null));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return read(new byte[1]);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.A02.read(bArr, i2, i3);
        this.A00 += read;
        return read;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        long j3 = this.A01 - this.A00;
        if (j3 <= 0) {
            return 0L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        this.A00 = (int) (this.A00 + j2);
        A00(this.A00);
        return j2;
    }
}
