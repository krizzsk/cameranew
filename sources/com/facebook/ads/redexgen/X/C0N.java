package com.facebook.ads.redexgen.X;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: com.facebook.ads.redexgen.X.0N  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0N extends BufferedInputStream {
    public static String[] A03 = {"hHZOxXwAkKvoKhhBaEkDET3K9Dqf", "5rJSRpPdF8KF8uXWImzbaIQKFcw1ndDO", "6QZm8Ah", "xZscB3eTttYWUeptNSmdVwNeb0ugkTew", "aaCt8fo", "HFDxsqP", "jqG6j3VzD3iXGVjyym9gTZpwoM0I", "1czQANy8yDzooPN28ziBSeiajns8goae"};
    public int A00;
    public int A01;
    public boolean A02;

    public C0N(InputStream inputStream) {
        super(inputStream);
        this.A00 = Integer.MAX_VALUE;
    }

    public final boolean A00() {
        return this.A02;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        this.A00 = i2;
        super.mark(i2);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = this.A01;
        if (i2 + 1 > this.A00) {
            this.A02 = true;
            return -1;
        }
        this.A01 = i2 + 1;
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        if (this.A01 + bArr.length > this.A00) {
            this.A02 = true;
            return -1;
        }
        return super.read(bArr);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.A01 + i3 > this.A00) {
            this.A02 = true;
            return -1;
        }
        int read = super.read(bArr, i2, i3);
        this.A01 += read;
        return read;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.A00 = Integer.MAX_VALUE;
        super.reset();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) throws IOException {
        long j3 = this.A01 + j2;
        long j4 = this.A00;
        if (A03[7].charAt(12) != 's') {
            String[] strArr = A03;
            strArr[0] = "Fna28k1RdkWP4Be7lWkb754aZDXI";
            strArr[6] = "zys9PRe7zcJWxbuDguQ9TXt7Qhgb";
            if (j3 > j4) {
                this.A02 = true;
                return 0L;
            }
            this.A01 = (int) (this.A01 + j2);
            long skip = super.skip(j2);
            if (A03[5].length() != 7) {
                String[] strArr2 = A03;
                strArr2[4] = "3ofKHV0";
                strArr2[2] = "cjaCIpO";
                return skip;
            }
            String[] strArr3 = A03;
            strArr3[4] = "nrvpyz2";
            strArr3[2] = "1Ep1yQ1";
            return skip;
        }
        throw new RuntimeException();
    }
}
