package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class WE implements Ch {
    public static byte[] A07;
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC0773Cj A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<C0772Cg> A05 = new ArrayDeque<>();
    public final C0774Co A04 = new C0774Co();

    static {
        A05();
    }

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{101, -118, -110, 125, -120, -123, Byte.MIN_VALUE, 60, -127, -120, -127, -119, -127, -118, -112, 60, -112, -107, -116, -127, 60, -73, -36, -28, -49, -38, -41, -46, -114, -44, -38, -35, -49, -30, -114, -31, -41, -24, -45, -88, -114, -95, -58, -50, -71, -60, -63, -68, 120, -63, -58, -52, -67, -65, -67, -54, 120, -53, -63, -46, -67, -110, 120, -64, -31, -33, -42, -37, -44, -115, -46, -39, -46, -38, -46, -37, -31, -115, -32, -42, -25, -46, -89, -115};
    }

    private double A00(CQ cq, int i2) throws IOException, InterruptedException {
        long A02 = A02(cq, i2);
        if (i2 == 4) {
            return Float.intBitsToFloat((int) A02);
        }
        return Double.longBitsToDouble(A02);
    }

    private long A01(CQ cq) throws IOException, InterruptedException {
        cq.ADr();
        while (true) {
            cq.ACp(this.A06, 0, 4);
            int A00 = C0774Co.A00(this.A06[0]);
            if (A00 != -1 && A00 <= 4) {
                int A01 = (int) C0774Co.A01(this.A06, A00, false);
                if (this.A03.A8P(A01)) {
                    cq.AEh(A00);
                    return A01;
                }
            }
            cq.AEh(1);
        }
    }

    private long A02(CQ cq, int i2) throws IOException, InterruptedException {
        cq.readFully(this.A06, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.A06[i3] & Draft_75.END_OF_FRAME);
        }
        return j2;
    }

    private String A04(CQ cq, int trimmedLength) throws IOException, InterruptedException {
        if (trimmedLength == 0) {
            return A03(0, 0, 34);
        }
        byte[] bArr = new byte[trimmedLength];
        cq.readFully(bArr, 0, trimmedLength);
        while (trimmedLength > 0 && bArr[trimmedLength - 1] == 0) {
            trimmedLength--;
        }
        return new String(bArr, 0, trimmedLength);
    }

    @Override // com.facebook.ads.redexgen.X.Ch
    public final void A8B(InterfaceC0773Cj interfaceC0773Cj) {
        this.A03 = interfaceC0773Cj;
    }

    @Override // com.facebook.ads.redexgen.X.Ch
    public final boolean ADF(CQ cq) throws IOException, InterruptedException {
        long j2;
        int i2;
        I6.A04(this.A03 != null);
        while (true) {
            if (!this.A05.isEmpty()) {
                long A79 = cq.A79();
                j2 = this.A05.peek().A01;
                if (A79 >= j2) {
                    InterfaceC0773Cj interfaceC0773Cj = this.A03;
                    i2 = this.A05.pop().A00;
                    interfaceC0773Cj.A59(i2);
                    return true;
                }
            }
            if (this.A01 == 0) {
                long A05 = this.A04.A05(cq, true, false, 4);
                if (A05 == -2) {
                    A05 = A01(cq);
                }
                if (A05 == -1) {
                    return false;
                }
                this.A00 = (int) A05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(cq, false, true, 8);
                this.A01 = 2;
            }
            int A6P = this.A03.A6P(this.A00);
            if (A6P != 0) {
                if (A6P == 1) {
                    long A792 = cq.A79();
                    this.A05.push(new C0772Cg(this.A00, A792 + this.A02));
                    this.A03.AEm(this.A00, A792, this.A02);
                    this.A01 = 0;
                    return true;
                } else if (A6P == 2) {
                    long j3 = this.A02;
                    if (j3 <= 8) {
                        this.A03.A8D(this.A00, A02(cq, (int) j3));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AS(A03(41, 22, 60) + this.A02);
                } else if (A6P == 3) {
                    long j4 = this.A02;
                    if (j4 <= 2147483647L) {
                        this.A03.AEu(this.A00, A04(cq, (int) j4));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AS(A03(63, 21, 81) + this.A02);
                } else if (A6P == 4) {
                    this.A03.A3p(this.A00, (int) this.A02, cq);
                    this.A01 = 0;
                    return true;
                } else if (A6P == 5) {
                    long j5 = this.A02;
                    if (j5 == 4 || j5 == 8) {
                        this.A03.A5O(this.A00, A00(cq, (int) this.A02));
                        this.A01 = 0;
                        return true;
                    }
                    throw new AS(A03(21, 20, 82) + this.A02);
                } else {
                    throw new AS(A03(0, 21, 0) + A6P);
                }
            }
            cq.AEh((int) this.A02);
            this.A01 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.Ch
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
