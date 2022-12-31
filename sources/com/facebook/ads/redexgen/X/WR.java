package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class WR implements CQ {
    public int A00;
    public int A01;
    public long A02;
    public final long A04;
    public final HR A05;
    public byte[] A03 = new byte[65536];
    public final byte[] A06 = new byte[4096];

    public WR(HR hr, long j2, long j3) {
        this.A05 = hr;
        this.A02 = j2;
        this.A04 = j3;
    }

    private int A00(int i2) {
        int min = Math.min(this.A00, i2);
        A05(min);
        return min;
    }

    private int A01(byte[] bArr, int i2, int i3) {
        int i4 = this.A00;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.A03, 0, bArr, i2, min);
        A05(min);
        return min;
    }

    private int A02(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.A05.read(bArr, i2 + i4, i3 - i4);
            if (read == -1) {
                if (i4 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i4 + read;
        }
        throw new InterruptedException();
    }

    private void A03(int i2) {
        if (i2 != -1) {
            this.A02 += i2;
        }
    }

    private void A04(int i2) {
        int i3 = this.A01 + i2;
        byte[] bArr = this.A03;
        if (i3 > bArr.length) {
            this.A03 = Arrays.copyOf(this.A03, C0923Il.A06(bArr.length * 2, 65536 + i3, 524288 + i3));
        }
    }

    private void A05(int i2) {
        this.A00 -= i2;
        this.A01 = 0;
        byte[] bArr = this.A03;
        int i3 = this.A00;
        if (i3 < this.A03.length - 524288) {
            bArr = new byte[i3 + 65536];
        }
        System.arraycopy(this.A03, i2, bArr, 0, this.A00);
        this.A03 = bArr;
    }

    public final boolean A06(int i2, boolean z) throws IOException, InterruptedException {
        A04(i2);
        int min = Math.min(this.A00 - this.A01, i2);
        while (min < i2) {
            min = A02(this.A03, this.A01, i2, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.A01 += i2;
        this.A00 = Math.max(this.A00, this.A01);
        return true;
    }

    public final boolean A07(int i2, boolean z) throws IOException, InterruptedException {
        int A00 = A00(i2);
        while (A00 < i2 && A00 != -1) {
            A00 = A02(this.A06, -A00, Math.min(i2, this.A06.length + A00), A00, z);
        }
        A03(A00);
        return A00 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final void A3J(int i2) throws IOException, InterruptedException {
        A06(i2, false);
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final long A6p() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final long A74() {
        return this.A02 + this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final long A79() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final void ACp(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        ACq(bArr, i2, i3, false);
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final boolean ACq(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        if (!A06(i3, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i3, bArr, i2, i3);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final boolean ADI(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        int A01 = A01(bArr, i2, i3);
        while (A01 < i3 && A01 != -1) {
            A01 = A02(bArr, i2, i3, A01, z);
        }
        A03(A01);
        return A01 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final void ADr() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final int AEe(int i2) throws IOException, InterruptedException {
        int A00 = A00(i2);
        if (A00 == 0) {
            byte[] bArr = this.A06;
            A00 = A02(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        A03(A00);
        return A00;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final void AEh(int i2) throws IOException, InterruptedException {
        A07(i2, false);
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int A01 = A01(bArr, i2, i3);
        if (A01 == 0) {
            A01 = A02(bArr, i2, i3, 0, true);
        }
        A03(A01);
        return A01;
    }

    @Override // com.facebook.ads.redexgen.X.CQ
    public final void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        ADI(bArr, i2, i3, false);
    }
}
