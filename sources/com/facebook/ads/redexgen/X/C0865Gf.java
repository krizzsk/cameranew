package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Gf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0865Gf {
    public static String[] A09 = {"dgnk6daQ0T87wOoHtyty7iRYaKvd8BzP", "TK3sWG", "r0T7HSyuXxeUz69yLbXIR4BhIiF2UDCf", "E94UIter8sht222SneNEBcgvWBNv8GHv", "qg4jsBrtjCwX7ZbqQAPOhxC1noKxQthL", "J", "sUrKaEkRL4ABh9brwle2ScDHOfoRuahW", "YVc6k2"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final IV A07 = new IV();
    public final int[] A08 = new int[256];

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(IV iv, int i2) {
        int A0G;
        if (i2 < 4) {
            return;
        }
        iv.A0Z(3);
        int i3 = i2 - 4;
        if ((iv.A0E() & 128) != 0) {
            if (i3 < 7 || (A0G = iv.A0G()) < 4) {
                return;
            }
            this.A01 = iv.A0I();
            this.A00 = iv.A0I();
            this.A07.A0W(A0G - 4);
            i3 -= 7;
        }
        int A06 = this.A07.A06();
        int A07 = this.A07.A07();
        if (A06 < A07 && i3 > 0) {
            int bytesToRead = Math.min(i3, A07 - A06);
            iv.A0c(this.A07.A00, A06, bytesToRead);
            this.A07.A0Y(A06 + bytesToRead);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(IV iv, int i2) {
        if (i2 < 19) {
            return;
        }
        this.A05 = iv.A0I();
        this.A04 = iv.A0I();
        iv.A0Z(11);
        this.A02 = iv.A0I();
        this.A03 = iv.A0I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(IV iv, int i2) {
        if (i2 % 5 != 2) {
            return;
        }
        iv.A0Z(2);
        Arrays.fill(this.A08, 0);
        int i3 = i2 / 5;
        for (int r = 0; r < i3; r++) {
            int A0E = iv.A0E();
            int A0E2 = iv.A0E();
            int A0E3 = iv.A0E();
            int A0E4 = iv.A0E();
            int entryCount = iv.A0E();
            int cb = A0E4 - 128;
            double d2 = A0E2 - (cb * 0.34414d);
            int i4 = A0E3 - 128;
            int i5 = (int) (d2 - (i4 * 0.71414d));
            int i6 = A0E4 - 128;
            int[] iArr = this.A08;
            int i7 = C0923Il.A06((int) (A0E2 + ((A0E3 - 128) * 1.402d)), 0, 255);
            int i8 = (entryCount << 24) | (i7 << 16);
            int i9 = C0923Il.A06(i5, 0, 255);
            iArr[A0E] = i8 | (i9 << 8) | C0923Il.A06((int) (A0E2 + (i6 * 1.772d)), 0, 255);
        }
        this.A06 = true;
    }

    /* JADX WARN: Incorrect condition in loop: B:20:0x003b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.GK A06() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0865Gf.A06():com.facebook.ads.redexgen.X.GK");
    }

    public final void A07() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0W(0);
        this.A06 = false;
    }
}
