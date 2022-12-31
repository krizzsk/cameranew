package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Vh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1246Vh implements DV {
    public static byte[] A06;
    public static String[] A07 = {"Jiy", "2wEJIBTa4RvP8yrIwKSodHRjo9", "akcZBAKpF", "EuZb8kUx1OZ", "XeLxT4hCbfpB8vk3L3qpbFThh9kK", "oaj", "R8TqjunyKtvNfOkCV", "nGIequV"};
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<C0792Dg> A04;
    public final InterfaceC0771Cb[] A05;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{117, 100, 100, 120, 125, 119, 117, 96, 125, 123, 122, 59, 112, 98, 118, 103, 97, 118, 103};
    }

    static {
        A01();
    }

    public C1246Vh(List<C0792Dg> list) {
        this.A04 = list;
        this.A05 = new InterfaceC0771Cb[list.size()];
    }

    private boolean A02(IV iv, int i2) {
        if (iv.A04() == 0) {
            return false;
        }
        if (iv.A0E() != i2) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) {
        InterfaceC0771Cb[] interfaceC0771CbArr;
        if (this.A03) {
            if (this.A00 == 2 && !A02(iv, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(iv, 0)) {
                return;
            }
            int A062 = iv.A06();
            int A04 = iv.A04();
            for (InterfaceC0771Cb output : this.A05) {
                iv.A0Y(A062);
                output.AE4(iv, A04);
            }
            this.A01 += A04;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        int i2 = 0;
        while (true) {
            InterfaceC0771Cb[] interfaceC0771CbArr = this.A05;
            String[] strArr = A07;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "6Yign7KSgGvnaQ3UG";
            strArr2[0] = "Q7U";
            if (i2 < interfaceC0771CbArr.length) {
                C0792Dg c0792Dg = this.A04.get(i2);
                c0795Dj.A05();
                InterfaceC0771Cb AF1 = cr.AF1(c0795Dj.A03(), 3);
                AF1.A5S(Format.A0A(c0795Dj.A04(), A00(0, 19, 88), null, -1, 0, Collections.singletonList(c0792Dg.A02), c0792Dg.A01, null));
                this.A05[i2] = AF1;
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
        if (this.A03) {
            for (InterfaceC0771Cb interfaceC0771Cb : this.A05) {
                interfaceC0771Cb.AE5(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        if (!z) {
            return;
        }
        this.A03 = true;
        this.A02 = j2;
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        this.A03 = false;
    }
}
