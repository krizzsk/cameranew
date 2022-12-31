package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class DG {
    public static String[] A05 = {"YmqCfQGeJdZscNiSsRHgK8Xqwc4qCDQV", "BEVC1cuwi5mxHrGOZ29iGldY3rFRULVC", "DSPc42zLHxXdWx97yn92wynUTyNm", "qbq", "Vn6wbfa2hXyYQug1oukzP6oQFgTa", "a4c", "hss", "EwoauNNUoRbyLKR"};
    public int A01;
    public boolean A02;
    public final DH A03 = new DH();
    public final IV A04 = new IV(new byte[65025], 0);
    public int A00 = -1;

    private int A00(int i2) {
        this.A01 = 0;
        int i3 = 0;
        while (this.A01 + i2 < this.A03.A02) {
            int[] iArr = this.A03.A09;
            int i4 = this.A01;
            this.A01 = i4 + 1;
            int i5 = iArr[i4 + i2];
            i3 += i5;
            if (i5 != 255) {
                break;
            }
        }
        return i3;
    }

    public final DH A01() {
        return this.A03;
    }

    public final IV A02() {
        return this.A04;
    }

    public final void A03() {
        this.A03.A02();
        this.A04.A0V();
        this.A00 = -1;
        this.A02 = false;
    }

    public final void A04() {
        if (this.A04.A00.length == 65025) {
            return;
        }
        IV iv = this.A04;
        iv.A00 = Arrays.copyOf(iv.A00, Math.max(65025, this.A04.A07()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c8, code lost:
        if (r7.A03.A09[r3 - 1] != 5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ee, code lost:
        if (r7.A03.A09[r3 - 1] != 255) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A05(com.facebook.ads.redexgen.X.CQ r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DG.A05(com.facebook.ads.redexgen.X.CQ):boolean");
    }
}
