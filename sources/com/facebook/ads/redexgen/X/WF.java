package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class WF extends Cd {
    public static byte[] A05;
    public static String[] A06 = {"HrBrUDmtAiHhEIFi", "ovhYl7NWEd171z8PJdmzSHTS5BmNRwGh", "O04BUWOaHdfjopELTyPlWCM73tUUR1GH", "jF3DEBpuUmaMt5XqjGdbc3EKLhdJIOP", "6wGSczOuIh6bVbI0f7FgwzIt", "67fT6B3p0kUWiMxqOkjfZNmnVryLDGGV", "w97Hra0FQmNyyw573", "JpIXAL9FgQ2FQzjAVAZn2BwWekNoW7nE"};
    public int A00;
    public int A01;
    public boolean A02;
    public final IV A03;
    public final IV A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{1, 62, 51, 50, 56, 119, 49, 56, 37, 58, 54, 35, 119, 57, 56, 35, 119, 36, 34, 39, 39, 56, 37, 35, 50, 51, 109, 119, 91, 68, 73, 72, 66, 2, 76, 91, 78};
    }

    static {
        A01();
    }

    public WF(InterfaceC0771Cb interfaceC0771Cb) {
        super(interfaceC0771Cb);
        this.A04 = new IV(IR.A03);
        this.A03 = new IV(4);
    }

    @Override // com.facebook.ads.redexgen.X.Cd
    public final void A0B(IV iv, long j2) throws AS {
        int A0E = iv.A0E();
        long A09 = j2 + (iv.A09() * 1000);
        if (A0E == 0 && !this.A02) {
            IV videoSequence = new IV(new byte[iv.A04()]);
            iv.A0c(videoSequence.A00, 0, iv.A04());
            C0925In A00 = C0925In.A00(videoSequence);
            this.A01 = A00.A02;
            super.A00.A5S(Format.A03(null, A00(28, 9, 114), null, -1, -1, A00.A03, A00.A01, -1.0f, A00.A04, -1, A00.A00, null));
            this.A02 = true;
        } else if (A0E != 1 || !this.A02) {
        } else {
            byte[] bArr = this.A03.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i2 = 4 - this.A01;
            int i3 = 0;
            while (iv.A04() > 0) {
                iv.A0c(this.A03.A00, i2, this.A01);
                this.A03.A0Y(0);
                int A0H = this.A03.A0H();
                this.A04.A0Y(0);
                super.A00.AE4(this.A04, 4);
                super.A00.AE4(iv, A0H);
                i3 = i3 + 4 + A0H;
            }
            InterfaceC0771Cb interfaceC0771Cb = super.A00;
            int i4 = this.A00 != 1 ? 0 : 1;
            if (A06[6].length() == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[1] = "SxoTsTEtYbkIpzmogJvkXCUruqqJ7knT";
            strArr[7] = "DX7TKSEUbLiNIzjv4P1HkLtMAUktYoJf";
            interfaceC0771Cb.AE5(A09, i4, i3, 0, null);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Cd
    public final boolean A0C(IV iv) throws WG {
        int A0E = iv.A0E();
        int i2 = (A0E >> 4) & 15;
        int i3 = A0E & 15;
        if (i3 == 7) {
            this.A00 = i2;
            return i2 != 5;
        }
        throw new WG(A00(0, 28, 8) + i3);
    }
}
