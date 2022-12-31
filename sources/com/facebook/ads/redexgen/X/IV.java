package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class IV {
    public static byte[] A03;
    public static String[] A04 = {"HJCnnsvFRKCxDDAbEWuhDIcdg3xeT1pm", "aXWy8CvsRXCMVcJtmBA1wVRdgUuSFZpH", "GQPvM", "pDI65rPXKWggiakX8tUTXOsWDv9apWvH", "LM6A01RjpialbK5Oi", "vEfQavrNrAXrkYYeEOthMrPonFtv4Upj", "EEXi7u9hiAizt85cGACEO5SSNblzx1I5", "5Jpn3XfqvoPj"};
    public byte[] A00;
    public int A01;
    public int A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 24);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-33, 4, 12, -9, 2, -1, -6, -74, -21, -22, -36, -61, -50, -74, 9, -5, 7, 11, -5, 4, -7, -5, -74, -7, 5, 4, 10, -1, 4, 11, -9, 10, -1, 5, 4, -74, -8, 15, 10, -5, -48, -74, -67, -30, -22, -43, -32, -35, -40, -108, -55, -56, -70, -95, -84, -108, -25, -39, -27, -23, -39, -30, -41, -39, -108, -38, -35, -26, -25, -24, -108, -42, -19, -24, -39, -82, -108, -113, -86, -85, 91, -99, -92, -81, 91, -87, -86, -81, 91, -75, -96, -83, -86, 117, 91, -49, -50, -64, -89, -78};
    }

    static {
        A01();
    }

    public IV() {
    }

    public IV(int i2) {
        this.A00 = new byte[i2];
        this.A01 = i2;
    }

    public IV(byte[] bArr) {
        this.A00 = bArr;
        this.A01 = bArr.length;
    }

    public IV(byte[] bArr, int i2) {
        this.A00 = bArr;
        this.A01 = i2;
    }

    public final char A02() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        return (char) ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) | ((bArr[i2] & Draft_75.END_OF_FRAME) << 8));
    }

    public final double A03() {
        return Double.longBitsToDouble(A0L());
    }

    public final int A04() {
        return this.A01 - this.A02;
    }

    public final int A05() {
        byte[] bArr = this.A00;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int A06() {
        return this.A02;
    }

    public final int A07() {
        return this.A01;
    }

    public final int A08() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = (bArr[i2] & Draft_75.END_OF_FRAME) << 24;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = i3 | ((bArr[i4] & Draft_75.END_OF_FRAME) << 16);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = i5 | ((bArr[i6] & Draft_75.END_OF_FRAME) << 8);
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return (bArr[i8] & Draft_75.END_OF_FRAME) | i7;
    }

    public final int A09() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 24) >> 8;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = i3 | ((bArr[i4] & Draft_75.END_OF_FRAME) << 8);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        return (bArr[i6] & Draft_75.END_OF_FRAME) | i5;
    }

    public final int A0A() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = bArr[i2] & Draft_75.END_OF_FRAME;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = i3 | ((bArr[i4] & Draft_75.END_OF_FRAME) << 8);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = i5 | ((bArr[i6] & Draft_75.END_OF_FRAME) << 16);
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return ((bArr[i8] & Draft_75.END_OF_FRAME) << 24) | i7;
    }

    public final int A0B() {
        int A0A = A0A();
        if (A0A >= 0) {
            return A0A;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A0A);
    }

    public final int A0C() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = bArr[i2] & Draft_75.END_OF_FRAME;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return ((bArr[i4] & Draft_75.END_OF_FRAME) << 8) | i3;
    }

    public final int A0D() {
        int b2 = A0E();
        int b3 = A0E();
        int b4 = A0E();
        int b22 = (b2 << 21) | (b3 << 14);
        int b32 = b4 << 7;
        return b22 | b32 | A0E();
    }

    public final int A0E() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        return bArr[i2] & Draft_75.END_OF_FRAME;
    }

    public final int A0F() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = (bArr[i2] & Draft_75.END_OF_FRAME) << 8;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = (bArr[i4] & Draft_75.END_OF_FRAME) | i3;
        this.A02 += 2;
        return i5;
    }

    public final int A0G() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = (bArr[i2] & Draft_75.END_OF_FRAME) << 16;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = i3 | ((bArr[i4] & Draft_75.END_OF_FRAME) << 8);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        return (bArr[i6] & Draft_75.END_OF_FRAME) | i5;
    }

    public final int A0H() {
        int A08 = A08();
        if (A08 >= 0) {
            return A08;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A08);
    }

    public final int A0I() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = (bArr[i2] & Draft_75.END_OF_FRAME) << 8;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return (bArr[i4] & Draft_75.END_OF_FRAME) | i3;
    }

    public final long A0J() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 40) | ((bArr[i8] & 255) << 48) | ((255 & bArr[i9]) << 56);
    }

    public final long A0K() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((255 & bArr[i5]) << 24);
    }

    public final long A0L() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = this.A02;
        this.A02 = i6 + 1;
        int i7 = this.A02;
        this.A02 = i7 + 1;
        int i8 = this.A02;
        this.A02 = i8 + 1;
        int i9 = this.A02;
        this.A02 = i9 + 1;
        return ((bArr[i2] & 255) << 56) | ((bArr[i3] & 255) << 48) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (255 & bArr[i9]);
    }

    public final long A0M() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8) | (255 & bArr[i5]);
    }

    public final long A0N() {
        long A0L = A0L();
        if (A0L >= 0) {
            return A0L;
        }
        throw new IllegalStateException(A00(77, 18, 35) + A0L);
    }

    public final long A0O() {
        int i2 = 0;
        long j2 = this.A00[this.A02];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            int j3 = 1 << i3;
            int i4 = ((j3 & j2) > 0L ? 1 : ((j3 & j2) == 0L ? 0 : -1));
            if (A04[3].charAt(7) == 'H') {
                throw new RuntimeException();
            }
            A04[7] = "lhGNf9ZIwuKG";
            if (i4 != 0) {
                i3--;
            } else if (i3 < 6) {
                int j4 = 1 << i3;
                j2 &= j4 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            int i5 = 1;
            while (i5 < i2) {
                byte[] bArr = this.A00;
                int i6 = this.A02;
                byte b = bArr[i6 + i5];
                if ((b & 192) == 128) {
                    long j5 = j2 << 6;
                    String[] strArr = A04;
                    String str = strArr[5];
                    String str2 = strArr[6];
                    int charAt = str.charAt(9);
                    int i7 = str2.charAt(9);
                    if (charAt != i7) {
                        A04[7] = "BvJ8XuqLfWkj";
                        int i8 = b & 63;
                        j2 = j5 | i8;
                        i5 += 0;
                    } else {
                        A04[7] = "bl64THqm1YbP";
                        int i9 = b & 63;
                        j2 = j5 | i9;
                        i5++;
                    }
                } else {
                    throw new NumberFormatException(A00(0, 42, 126) + j2);
                }
            }
            int i10 = this.A02;
            this.A02 = i10 + i2;
            return j2;
        }
        throw new NumberFormatException(A00(42, 35, 92) + j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
        if (r6.A02 == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        if (r6.A02 == r3) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String A0P() {
        /*
            r6 = this;
            int r0 = r6.A04()
            if (r0 != 0) goto L28
            r3 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.IV.A04
            r0 = 3
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 72
            if (r1 == r0) goto L22
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IV.A04
            java.lang.String r1 = "Lp13SRVWSAlchtHB237WPpHnlSgF4gaJ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "rKST0dS6uAv5sauBNsTeIX1rNmAgPgcE"
            r0 = 6
            r2[r0] = r1
            return r3
        L22:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L28:
            int r5 = r6.A02
        L2a:
            int r0 = r6.A01
            if (r5 >= r0) goto L3b
            byte[] r0 = r6.A00
            r0 = r0[r5]
            boolean r0 = com.facebook.ads.redexgen.X.C0923Il.A0d(r0)
            if (r0 != 0) goto L3b
            int r5 = r5 + 1
            goto L2a
        L3b:
            int r4 = r6.A02
            int r0 = r5 - r4
            r3 = 3
            if (r0 < r3) goto L5d
            byte[] r2 = r6.A00
            r1 = r2[r4]
            r0 = -17
            if (r1 != r0) goto L5d
            int r0 = r4 + 1
            r1 = r2[r0]
            r0 = -69
            if (r1 != r0) goto L5d
            int r0 = r4 + 2
            r1 = r2[r0]
            r0 = -65
            if (r1 != r0) goto L5d
            int r4 = r4 + r3
            r6.A02 = r4
        L5d:
            byte[] r2 = r6.A00
            int r1 = r6.A02
            int r0 = r5 - r1
            java.lang.String r4 = com.facebook.ads.redexgen.X.C0923Il.A0R(r2, r1, r0)
            r6.A02 = r5
            int r2 = r6.A02
            int r3 = r6.A01
            if (r2 != r3) goto L70
            return r4
        L70:
            byte[] r0 = r6.A00
            r1 = r0[r2]
            r0 = 13
            if (r1 != r0) goto La5
            int r0 = r2 + 1
            r6.A02 = r0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.IV.A04
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 5
            if (r1 == r0) goto L99
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IV.A04
            java.lang.String r1 = "7WLwSFEg60VT5h1w5xCSRnUKgnyD8yNS"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "aRAvn4znRhpfiIQyr1UPz3MngzOxDO2U"
            r0 = 0
            r2[r0] = r1
            int r0 = r6.A02
            if (r0 != r3) goto La5
        L98:
            return r4
        L99:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IV.A04
            java.lang.String r1 = "q7voCOqIwzwrpNWuoMFHLwpJUMmmskbB"
            r0 = 3
            r2[r0] = r1
            int r0 = r6.A02
            if (r0 != r3) goto La5
            goto L98
        La5:
            byte[] r0 = r6.A00
            int r2 = r6.A02
            r1 = r0[r2]
            r0 = 10
            if (r1 != r0) goto Lb3
            int r0 = r2 + 1
            r6.A02 = r0
        Lb3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IV.A0P():java.lang.String");
    }

    public final String A0Q() {
        if (A04() == 0) {
            return null;
        }
        int i2 = this.A02;
        while (i2 < this.A01 && this.A00[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.A00;
        int i3 = this.A02;
        String A0R = C0923Il.A0R(bArr, i3, i2 - i3);
        this.A02 = i2;
        int i4 = this.A02;
        if (i4 < this.A01) {
            this.A02 = i4 + 1;
        }
        return A0R;
    }

    public final String A0R(int lastIndex) {
        if (lastIndex == 0) {
            return A00(0, 0, 47);
        }
        int i2 = lastIndex;
        int i3 = (this.A02 + lastIndex) - 1;
        if (i3 < this.A01 && this.A00[i3] == 0) {
            i2--;
        }
        String A0R = C0923Il.A0R(this.A00, this.A02, i2);
        this.A02 += lastIndex;
        return A0R;
    }

    public final String A0S(int i2) {
        return A0T(i2, Charset.forName(A00(95, 5, 98)));
    }

    public final String A0T(int i2, Charset charset) {
        String str = new String(this.A00, this.A02, i2, charset);
        this.A02 += i2;
        return str;
    }

    public final short A0U() {
        byte[] bArr = this.A00;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        int i3 = (bArr[i2] & Draft_75.END_OF_FRAME) << 8;
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return (short) ((bArr[i4] & Draft_75.END_OF_FRAME) | i3);
    }

    public final void A0V() {
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0W(int i2) {
        A0b(A05() < i2 ? new byte[i2] : this.A00, i2);
    }

    public final void A0X(int i2) {
        I6.A03(i2 >= 0 && i2 <= this.A00.length);
        this.A01 = i2;
    }

    public final void A0Y(int i2) {
        I6.A03(i2 >= 0 && i2 <= this.A01);
        this.A02 = i2;
    }

    public final void A0Z(int i2) {
        A0Y(this.A02 + i2);
    }

    public final void A0a(IU iu, int i2) {
        A0c(iu.A00, 0, i2);
        iu.A07(0);
    }

    public final void A0b(byte[] bArr, int i2) {
        this.A00 = bArr;
        this.A01 = i2;
        this.A02 = 0;
    }

    public final void A0c(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.A00, this.A02, bArr, i2, i3);
        this.A02 += i3;
    }
}
