package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
/* loaded from: assets/audience_network.dex */
public final class WB implements CP {
    public static byte[] A0p;
    public static String[] A0q = {"PtjeSixlQpPnp33LbTolurfrF5aBxWMN", "zsPWFAYo6WN4WLRLivc6JVSph6JkIRth", "XheyHWRN6othIFLpaes4AkwCM0c9DMBL", "WLz3vbqVAvFNW8GJMAEq6yPWbMM9CaUw", "Xodlb2gLYburpvZCOlf7Ugos4D", "3NxGJ5nCydCtg30cLxHhJHXlDiPWCbyN", "QrznFntGQRtbXA7cSaAHWbiKbufqFBbd", "iW7nVRcCTDgQKTtcLRaOezFHTOIda"};
    public static final CS A0r;
    public static final UUID A0s;
    public static final byte[] A0t;
    public static final byte[] A0u;
    public static final byte[] A0v;
    public static final byte[] A0w;
    public static final byte[] A0x;
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public CR A0N;
    public Cl A0O;
    public IL A0P;
    public IL A0Q;
    public ByteBuffer A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public int[] A0b;
    public final SparseArray<Cl> A0c;
    public final Ch A0d;
    public final C0774Co A0e;
    public final IV A0f;
    public final IV A0g;
    public final IV A0h;
    public final IV A0i;
    public final IV A0j;
    public final IV A0k;
    public final IV A0l;
    public final IV A0m;
    public final IV A0n;
    public final boolean A0o;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0p, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0p = new byte[]{34, 108, 109, 118, 34, 113, 119, 114, 114, 109, 112, 118, 103, 102, 104, 125, 124, 41, 119, 104, 125, Byte.MAX_VALUE, 41, 119, 104, 125, Byte.MAX_VALUE, 41, 119, 104, 125, Byte.MAX_VALUE, 41, 84, 65, 67, 21, 75, 84, 65, 67, 21, 75, 84, 65, 67, 21, 93, 84, 65, 66, 21, 86, 82, 68, 68, 114, 99, 99, 126, 121, 112, 100, 84, 126, 103, Byte.MAX_VALUE, 114, 101, 90, 120, 115, 114, 55, 25, 7, 25, 25, 27, 55, 41, 55, 53, 69, 57, 39, 60, 44, 43, 73, 87, 76, 92, 91, 39, 77, 80, 88, 90, 77, 91, 91, 111, 113, 106, 122, 125, 1, 98, 97, 125, 125, 98, 107, 125, 125, 28, 2, 24, 28, 30, 110, 9, 23, 14, 4, 9, 11, 58, 36, 54, 43, 62, 60, 84, 55, 73, 80, 78, 92, 65, 84, 86, 62, 93, 34, 8, 22, 4, 26, 102, 8, 10, 4, 27, 5, 21, 10, 15, 9, 37, 59, 52, 39, 41, 75, 45, 42, 48, 75, 40, 45, 48, 6, 24, 19, 21, 18, 2, 15, 3, 74, 84, 93, 68, 89, 73, 66, 88, 88, 122, 117, 60, 111, 59, 104, 120, 122, 119, 126, 59, 111, 114, 118, 126, 120, 116, Byte.MAX_VALUE, 126, 59, 107, 105, 114, 116, 105, 59, 111, 116, 59, 111, 114, 118, 126, 120, 116, Byte.MAX_VALUE, 126, 72, 120, 122, 119, 126, 59, 121, 126, 114, 117, 124, 59, 104, 126, 111, 53, 34, 14, 12, 3, 8, 15, 8, 15, 6, 65, 4, 15, 2, 19, 24, 17, 21, 8, 14, 15, 65, 0, 15, 5, 65, 2, 14, 12, 17, 19, 4, 18, 18, 8, 14, 15, 65, 8, 18, 65, 15, 14, 21, 65, 18, 20, 17, 17, 14, 19, 21, 4, 5, 9, 37, 36, 62, 47, 36, 62, 9, 37, 39, 58, 11, 38, 45, 37, 106, 99, 79, 78, 84, 69, 78, 84, 101, 78, 67, 97, 76, 71, 79, 0, 79, 99, 98, 120, 105, 98, 120, 73, 98, 111, 99, 104, 101, 98, 107, 67, 126, 104, 105, 126, 44, 75, 103, 102, 124, 109, 102, 124, 77, 102, 107, 103, 108, 97, 102, 111, 91, 107, 103, 120, 109, 40, 40, 3, 15, 56, 21, 28, 9, 76, 1, 42, 38, 17, 60, 53, 32, 23, 32, 36, 33, 19, 32, 55, 54, 44, 42, 43, 101, 16, 23, 24, 25, 117, 57, 52, 54, 60, 59, 50, 117, 38, 52, 56, 37, 57, 48, 117, 38, 60, 47, 48, 117, 58, 32, 33, 117, 58, 51, 117, 39, 52, 59, 50, 48, 123, 74, 77, 66, 67, 93, 106, 110, 107, 89, 106, 125, 124, 102, 96, 97, 47, 61, 22, 27, 10, 1, 8, 12, 29, 28, 88, 44, 10, 25, 27, 19, 88, 30, 23, Draft_75.CR, 22, 28, 88, 26, Draft_75.CR, 12, 88, 59, 23, 22, 12, 29, 22, 12, 61, 22, 27, 51, 29, 1, 49, 60, 88, 15, 25, 11, 88, 22, 23, 12, 88, 30, 23, Draft_75.CR, 22, 28, 95, 98, 110, Byte.MAX_VALUE, 116, 105, 115, 117, 116, 58, 120, 115, 110, 58, 115, 105, 58, 105, Byte.MAX_VALUE, 110, 58, 115, 116, 58, 105, 115, 125, 116, 123, 118, 58, 120, 99, 110, Byte.MAX_VALUE, 105, 64, 93, 66, 78, 91, 21, 15, 124, 91, 78, 93, 91, 3, 15, 106, 65, 75, 3, 15, 125, 74, 78, 75, 96, 93, 75, 74, 93, 3, 15, 99, 78, 86, 74, 93, 3, 15, 124, 91, 86, 67, 74, 3, 15, 97, 78, 66, 74, 3, 15, 98, 78, 93, 72, 70, 65, 99, 3, 15, 98, 78, 93, 72, 70, 65, 125, 3, 15, 98, 78, 93, 72, 70, 65, 121, 3, 15, 106, 73, 73, 74, 76, 91, 3, 15, 123, 74, 87, 91, 48, 29, 31, 21, 18, 27, 92, 19, 18, 16, 5, 92, 15, 9, 12, 12, 19, 14, 8, 25, 24, 92, 21, 18, 92, 47, 21, 17, 12, 16, 25, 62, 16, 19, 31, 23, 15, 82, 31, 51, 60, 54, 51, 38, 61, 32, 43, 114, 55, 62, 55, 63, 55, 60, 38, 114, 1, 55, 55, 57, 27, 22, 114, 61, 32, 114, 1, 55, 55, 57, 2, 61, 33, 59, 38, 59, 61, 60, 114, 60, 61, 38, 114, 52, 61, 39, 60, 54, 122, 66, 91, 67, 94, 71, 91, 82, 23, 100, 82, 80, 90, 82, 89, 67, 23, 82, 91, 82, 90, 82, 89, 67, 68, 23, 89, 88, 67, 23, 68, 66, 71, 71, 88, 69, 67, 82, 83, 54, 23, 88, 14, 25, 20, 17, 28, 88, 12, 10, 25, 27, 19, 11, 88, 15, 29, 10, 29, 88, 30, 23, Draft_75.CR, 22, 28, 68, 101, 42, 124, 107, 102, 99, 110, 42, 124, 107, 120, 99, 100, 126, 42, 102, 111, 100, 109, 126, 98, 42, 103, 107, 121, 97, 42, 108, 101, Byte.MAX_VALUE, 100, 110, 96, 108, 119, 101, 113, 96, 102, 113, 43, 39, 48, 60, 53, 46, 87, 40, 63, 43, 68, 72, 67, 82, 79, 67, 56, 86, 68, 68, 81, 93, 86, 71, 90, 86, 45, 87, 86, 68, 58, 69, 73, 64, 89, 84, 69, 67, 84, 51, 8, 3, 30, 22, 3, 5, 18, 3, 2, 70, 15, 2, 92, 70, 24, 35, 40, 53, 61, 40, 46, 57, 40, 41, 109, 33, 44, 46, 36, 35, 42, 109, 59, 44, 33, 56, 40, 119, 109, 60, 53, 39, 58, 47, 45, 88, 5, 12, 30, 3, 22, 20, 103, 124, 26, 0, 28, 124, 18, 3, 75, 66, 80, 77, 88, 90, 41, 50, 84, 78, 82, 50, 92, 78, 77, 44, 37, 55, 42, 63, 61, 78, 85, 51, 41, 53, 85, 59, 44, 57, 86, 95, 77, 80, 69, 71, 52, 47, 73, 83, 79, 47, 83, 80, 6, 15, 29, 0, 21, 23, 24, Byte.MAX_VALUE, 25, 3, 31, Byte.MAX_VALUE, 24, 21, 6, 19, 53, 60, 46, 48, 76, 53, 37, 52, 76, 37, 44, 54, 49, 32, 32, 97, 104, 
        99, Byte.MAX_VALUE, 114, 120, 101, 118, 68, 77, 68, 66, 42, 12, 5, 12, 10, 99, 113, 125, 104, 110, 115, 111, 119, 125, 116, 107, 102, 103, 109, 45, 117, 103, 96, 111, 63, 45, 42, 37};
    }

    static {
        A06();
        A0r = new WD();
        A0w = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        A0x = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0t = C0923Il.A0i(A03(539, 90, 21));
        A0u = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        A0v = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0s = new UUID(72057594037932032L, -9223371306706625679L);
    }

    public WB() {
        this(0);
    }

    public WB(int i2) {
        this(new WE(), i2);
    }

    public WB(Ch ch, int i2) {
        this.A0K = -1L;
        this.A0M = -9223372036854775807L;
        this.A0G = -9223372036854775807L;
        this.A0H = -9223372036854775807L;
        this.A0F = -1L;
        this.A0J = -1L;
        this.A0E = -9223372036854775807L;
        this.A0d = ch;
        this.A0d.A8B(new WC(this, null));
        this.A0o = (i2 & 1) == 0;
        this.A0e = new C0774Co();
        this.A0c = new SparseArray<>();
        this.A0k = new IV(4);
        this.A0n = new IV(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0l = new IV(4);
        this.A0i = new IV(IR.A03);
        this.A0h = new IV(4);
        this.A0j = new IV();
        this.A0m = new IV();
        this.A0f = new IV(8);
        this.A0g = new IV();
    }

    private int A00(CQ cq, InterfaceC0771Cb interfaceC0771Cb, int i2) throws IOException, InterruptedException {
        int AE3;
        int A04 = this.A0j.A04();
        if (A04 > 0) {
            AE3 = Math.min(i2, A04);
            if (A0q[7].length() == 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0q;
            strArr[2] = "aDvj6xsBYLtfkWvKOvjAJhuXcdkZRgYf";
            strArr[6] = "uG0ceA84GetZ2PjOc8Op6VIqDQh3bhN9";
            interfaceC0771Cb.AE4(this.A0j, AE3);
        } else {
            AE3 = interfaceC0771Cb.AE3(cq, i2, false);
        }
        this.A07 += AE3;
        this.A08 += AE3;
        return AE3;
    }

    private long A01(long j2) throws AS {
        long j3 = this.A0M;
        if (j3 != -9223372036854775807L) {
            return C0923Il.A0F(j2, j3, 1000L);
        }
        throw new AS(A03(189, 54, 33));
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x0064 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.facebook.ads.redexgen.X.CY A02() {
        /*
            r11 = this;
            long r3 = r11.A0K
            r8 = 0
            r1 = -1
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L2e
            long r3 = r11.A0H
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L2e
            com.facebook.ads.redexgen.X.IL r0 = r11.A0Q
            if (r0 == 0) goto L2e
            int r0 = r0.A02()
            if (r0 == 0) goto L2e
            com.facebook.ads.redexgen.X.IL r0 = r11.A0P
            if (r0 == 0) goto L2e
            int r1 = r0.A02()
            com.facebook.ads.redexgen.X.IL r0 = r11.A0Q
            int r0 = r0.A02()
            if (r1 == r0) goto L3a
        L2e:
            r11.A0Q = r8
            r11.A0P = r8
            long r1 = r11.A0H
            com.facebook.ads.redexgen.X.WN r0 = new com.facebook.ads.redexgen.X.WN
            r0.<init>(r1)
            return r0
        L3a:
            com.facebook.ads.redexgen.X.IL r0 = r11.A0Q
            int r7 = r0.A02()
            int[] r9 = new int[r7]
            long[] r6 = new long[r7]
            long[] r5 = new long[r7]
            long[] r4 = new long[r7]
            r10 = 0
        L49:
            if (r10 >= r7) goto L61
            com.facebook.ads.redexgen.X.IL r0 = r11.A0Q
            long r0 = r0.A03(r10)
            r4[r10] = r0
            long r0 = r11.A0K
            com.facebook.ads.redexgen.X.IL r2 = r11.A0P
            long r2 = r2.A03(r10)
            long r0 = r0 + r2
            r6[r10] = r0
            int r10 = r10 + 1
            goto L49
        L61:
            r10 = 0
        L62:
            int r0 = r7 + (-1)
            if (r10 >= r0) goto L7c
            int r0 = r10 + 1
            r0 = r6[r0]
            r2 = r6[r10]
            long r0 = r0 - r2
            int r2 = (int) r0
            r9[r10] = r2
            int r0 = r10 + 1
            r2 = r4[r0]
            r0 = r4[r10]
            long r2 = r2 - r0
            r5[r10] = r2
            int r10 = r10 + 1
            goto L62
        L7c:
            int r10 = r7 + (-1)
            long r2 = r11.A0K
            long r0 = r11.A0L
            long r2 = r2 + r0
            int r0 = r7 + (-1)
            r0 = r6[r0]
            long r2 = r2 - r0
            int r0 = (int) r2
            r9[r10] = r0
            int r10 = r7 + (-1)
            long r0 = r11.A0H
            int r2 = r7 + (-1)
            r2 = r4[r2]
            long r0 = r0 - r2
            r5[r10] = r0
            r11.A0Q = r8
            r11.A0P = r8
            com.facebook.ads.redexgen.X.WS r0 = new com.facebook.ads.redexgen.X.WS
            r0.<init>(r9, r6, r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WB.A02():com.facebook.ads.redexgen.X.CY");
    }

    private void A05() {
        this.A07 = 0;
        this.A08 = 0;
        this.A09 = 0;
        this.A0S = false;
        this.A0X = false;
        this.A0U = false;
        this.A0A = 0;
        this.A00 = (byte) 0;
        this.A0T = false;
        this.A0j.A0V();
    }

    private void A07(CQ cq, int i2) throws IOException, InterruptedException {
        if (this.A0k.A07() >= i2) {
            return;
        }
        if (this.A0k.A05() < i2) {
            IV iv = this.A0k;
            iv.A0b(Arrays.copyOf(iv.A00, Math.max(this.A0k.A00.length * 2, i2)), this.A0k.A07());
        }
        cq.readFully(this.A0k.A00, this.A0k.A07(), i2 - this.A0k.A07());
        this.A0k.A0X(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0102, code lost:
        if (r0 < r6) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(com.facebook.ads.redexgen.X.CQ r11, com.facebook.ads.redexgen.X.Cl r12, int r13) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WB.A08(com.facebook.ads.redexgen.X.CQ, com.facebook.ads.redexgen.X.Cl, int):void");
    }

    private void A09(CQ cq, byte[] bArr, int i2) throws IOException, InterruptedException {
        int length = bArr.length + i2;
        if (this.A0m.A05() < length) {
            this.A0m.A00 = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.A0m.A00, 0, bArr.length);
        }
        cq.readFully(this.A0m.A00, bArr.length, i2);
        this.A0m.A0W(length);
    }

    private void A0A(CQ cq, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int min = Math.min(i3, this.A0j.A04());
        cq.readFully(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.A0j.A0c(bArr, i2, min);
        }
        this.A07 += i3;
    }

    private void A0B(Cl cl, long j2) {
        if (cl.A0X != null) {
            cl.A0X.A03(cl, j2);
        } else {
            if (A03(843, 11, 56).equals(cl.A0Y)) {
                A0C(cl, A03(33, 19, 75), 19, 1000L, A0x);
            } else {
                if (A03(833, 10, 45).equals(cl.A0Y)) {
                    A0C(cl, A03(14, 19, 119), 21, 10000L, A0v);
                }
            }
            cl.A0W.AE5(j2, this.A01, this.A08, 0, cl.A0V);
        }
        this.A0V = true;
        A05();
    }

    private void A0C(Cl cl, String str, int i2, long j2, byte[] bArr) {
        A0D(this.A0m.A00, this.A0C, str, i2, j2, bArr);
        InterfaceC0771Cb interfaceC0771Cb = cl.A0W;
        IV iv = this.A0m;
        interfaceC0771Cb.AE4(iv, iv.A07());
        this.A08 += this.A0m.A07();
    }

    public static void A0D(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] A0i;
        if (j2 == -9223372036854775807L) {
            A0i = bArr2;
        } else {
            int i3 = (int) (j2 / 3600000000L);
            long j4 = j2 - ((i3 * 3600) * 1000000);
            int i4 = (int) (j4 / 60000000);
            long j5 = j4 - ((i4 * 60) * 1000000);
            int lastValue = (int) (j5 / 1000000);
            A0i = C0923Il.A0i(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(lastValue), Integer.valueOf((int) ((j5 - (lastValue * 1000000)) / j3))));
        }
        System.arraycopy(A0i, 0, bArr, i2, bArr2.length);
    }

    private boolean A0E(CW cw, long j2) {
        if (this.A0Y) {
            this.A0J = j2;
            cw.A00 = this.A0F;
            this.A0Y = false;
            return true;
        }
        if (this.A0a) {
            long j3 = this.A0J;
            if (j3 != -1) {
                cw.A00 = j3;
                this.A0J = -1L;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x018a, code lost:
        if (r3.equals(r4) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0199, code lost:
        if (A03(122, 6, 114).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a9, code lost:
        if (A03(146, 8, 115).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b9, code lost:
        if (A03(160, 13, 94).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c9, code lost:
        if (A03(843, 11, 56).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d9, code lost:
        if (A03(833, 10, 45).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e9, code lost:
        if (A03(854, 8, 44).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01f9, code lost:
        if (A03(823, 10, 66).equals(r4) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0209, code lost:
        if (A03(815, 8, 9).equals(r4) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x020d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x021f, code lost:
        if (r3.equals(r4) == false) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0F(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WB.A0F(java.lang.String):boolean");
    }

    public static int[] A0H(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    public final void A0I(int i2) throws AS {
        if (i2 == 160) {
            if (this.A04 != 2) {
                return;
            }
            if (!this.A0W) {
                this.A01 |= 1;
            }
            A0B(this.A0c.get(this.A05), this.A0D);
            this.A04 = 0;
            return;
        }
        if (A0q[3].charAt(28) == 'C') {
            String[] strArr = A0q;
            strArr[2] = "rbl1Q01lKztgjfT5AU1HA1uCy8pKF6Jb";
            strArr[6] = "0IgewP00Z0tSvfgvmyCD0no1Nhaiy8Yj";
            if (i2 == 174) {
                if (A0F(this.A0O.A0Y)) {
                    Cl cl = this.A0O;
                    cl.A09(this.A0N, cl.A0N);
                    this.A0c.put(this.A0O.A0N, this.A0O);
                }
                this.A0O = null;
                return;
            } else if (i2 == 19899) {
                int i3 = this.A0B;
                if (i3 != -1) {
                    long j2 = this.A0I;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.A0F = j2;
                            return;
                        }
                        return;
                    }
                }
                throw new AS(A03(667, 50, 104));
            } else if (i2 == 25152) {
                if (this.A0O.A0c) {
                    if (this.A0O.A0V != null) {
                        this.A0O.A0U = new DrmInitData(new DrmInitData.SchemeData(A3.A04, A03(1024, 10, 56), this.A0O.A0V.A03));
                        return;
                    }
                    throw new AS(A03(449, 55, 66));
                }
                return;
            } else if (A0q[7].length() != 22) {
                A0q[4] = "mvRw2Aey0bC26pGUqGZgnnTCCn";
                if (i2 == 28032) {
                    if (this.A0O.A0c && this.A0O.A0f != null) {
                        throw new AS(A03(243, 53, 91));
                    }
                    return;
                } else if (i2 == 357149030) {
                    if (this.A0M == -9223372036854775807L) {
                        this.A0M = 1000000L;
                    }
                    long j3 = this.A0G;
                    if (j3 != -9223372036854775807L) {
                        this.A0H = A01(j3);
                        return;
                    }
                    return;
                } else if (i2 != 374648427) {
                    if (i2 == 475249515 && !this.A0a) {
                        this.A0N.AEA(A02());
                        this.A0a = true;
                        return;
                    }
                    return;
                } else if (this.A0c.size() != 0) {
                    this.A0N.A5A();
                    return;
                } else {
                    throw new AS(A03(756, 26, 66));
                }
            }
        }
        throw new RuntimeException();
    }

    public final void A0J(int i2, double d2) {
        if (i2 == 181) {
            this.A0O.A0O = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.A0O.A06 = (float) d2;
                    return;
                case 21970:
                    this.A0O.A07 = (float) d2;
                    return;
                case 21971:
                    this.A0O.A04 = (float) d2;
                    return;
                case 21972:
                    this.A0O.A05 = (float) d2;
                    return;
                case 21973:
                    this.A0O.A02 = (float) d2;
                    return;
                case 21974:
                    this.A0O.A03 = (float) d2;
                    return;
                case 21975:
                    this.A0O.A08 = (float) d2;
                    return;
                case 21976:
                    this.A0O.A09 = (float) d2;
                    return;
                case 21977:
                    this.A0O.A00 = (float) d2;
                    return;
                case 21978:
                    this.A0O.A01 = (float) d2;
                    return;
                default:
                    return;
            }
        } else {
            this.A0G = (long) d2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0354, code lost:
        throw new com.facebook.ads.redexgen.X.AS(A03(396, 37, 111));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x013f, code lost:
        if (r5 == 8) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0141, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c8, code lost:
        if (r5 == 8) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01cc, code lost:
        r2 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0K(int r19, int r20, com.facebook.ads.redexgen.X.CQ r21) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WB.A0K(int, int, com.facebook.ads.redexgen.X.CQ):void");
    }

    public final void A0L(int i2, long j2) throws AS {
        String A03 = A03(0, 14, 56);
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            throw new AS(A03(327, 21, 54) + j2 + A03);
        } else if (i2 != 20530) {
            switch (i2) {
                case 131:
                    this.A0O.A0Q = (int) j2;
                    return;
                case 136:
                    this.A0O.A0Z = j2 == 1;
                    return;
                case 155:
                    this.A0C = A01(j2);
                    return;
                case 159:
                    this.A0O.A0B = (int) j2;
                    return;
                case 176:
                    this.A0O.A0R = (int) j2;
                    return;
                case 179:
                    this.A0Q.A04(A01(j2));
                    return;
                case 186:
                    this.A0O.A0J = (int) j2;
                    return;
                case 215:
                    this.A0O.A0N = (int) j2;
                    return;
                case 231:
                    this.A0E = A01(j2);
                    return;
                case 241:
                    if (this.A0Z) {
                        return;
                    }
                    this.A0P.A04(j2);
                    this.A0Z = true;
                    return;
                case 251:
                    this.A0W = true;
                    return;
                case 16980:
                    if (j2 == 3) {
                        return;
                    }
                    throw new AS(A03(296, 16, 112) + j2 + A03);
                case 17029:
                    if (j2 >= 1 && j2 <= 2) {
                        return;
                    }
                    throw new AS(A03(377, 19, 127) + j2 + A03);
                case 17143:
                    if (j2 == 1) {
                        return;
                    }
                    throw new AS(A03(433, 16, 53) + j2 + A03);
                case 18401:
                    if (j2 == 5) {
                        return;
                    }
                    throw new AS(A03(312, 15, 26) + j2 + A03);
                case 18408:
                    if (j2 == 1) {
                        return;
                    }
                    throw new AS(A03(52, 22, 45) + j2 + A03);
                case 21420:
                    this.A0I = this.A0K + j2;
                    return;
                case 21432:
                    int i3 = (int) j2;
                    if (i3 == 0) {
                        this.A0O.A0P = 0;
                        return;
                    } else if (i3 == 1) {
                        this.A0O.A0P = 2;
                        return;
                    } else if (i3 == 3) {
                        this.A0O.A0P = 1;
                        return;
                    } else if (i3 != 15) {
                        return;
                    } else {
                        this.A0O.A0P = 3;
                        return;
                    }
                case 21680:
                    this.A0O.A0I = (int) j2;
                    return;
                case 21682:
                    this.A0O.A0H = (int) j2;
                    return;
                case 21690:
                    this.A0O.A0G = (int) j2;
                    return;
                case 21930:
                    this.A0O.A0a = j2 == 1;
                    return;
                case 22186:
                    this.A0O.A0S = j2;
                    return;
                case 22203:
                    this.A0O.A0T = j2;
                    return;
                case 25188:
                    this.A0O.A0A = (int) j2;
                    return;
                case 2352003:
                    this.A0O.A0F = (int) j2;
                    return;
                case 2807729:
                    this.A0M = j2;
                    return;
                default:
                    switch (i2) {
                        case 21945:
                            int i4 = (int) j2;
                            if (i4 == 1) {
                                this.A0O.A0C = 2;
                                return;
                            } else if (i4 != 2) {
                                return;
                            } else {
                                this.A0O.A0C = 1;
                                return;
                            }
                        case 21946:
                            int i5 = (int) j2;
                            if (i5 != 1) {
                                if (A0q[4].length() != 26) {
                                    throw new RuntimeException();
                                }
                                A0q[7] = "BNY";
                                if (i5 == 16) {
                                    Cl cl = this.A0O;
                                    String[] strArr = A0q;
                                    if (strArr[2].charAt(10) != strArr[6].charAt(10)) {
                                        cl.A0E = 6;
                                        return;
                                    }
                                    String[] strArr2 = A0q;
                                    strArr2[2] = "2BcX3syCXJtWqdpX1qkuhAX2qE5R3ro0";
                                    strArr2[6] = "aMiDNxLEmFtOjuqrXAq5lyKODggVFywu";
                                    cl.A0E = 6;
                                    return;
                                } else if (i5 == 18) {
                                    this.A0O.A0E = 7;
                                    return;
                                } else if (i5 != 6 && i5 != 7) {
                                    return;
                                }
                            }
                            this.A0O.A0E = 3;
                            return;
                        case 21947:
                            Cl cl2 = this.A0O;
                            cl2.A0b = true;
                            int i6 = (int) j2;
                            if (i6 == 1) {
                                cl2.A0D = 1;
                                return;
                            } else if (i6 == 9) {
                                cl2.A0D = 6;
                                return;
                            } else if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
                                return;
                            } else {
                                this.A0O.A0D = 2;
                                return;
                            }
                        case 21948:
                            this.A0O.A0K = (int) j2;
                            return;
                        case 21949:
                            this.A0O.A0L = (int) j2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            int i7 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
            if (A0q[7].length() != 22) {
                A0q[1] = "hD31tqXIhnGrFxqSOgo1vvmOI12OLqRQ";
                if (i7 == 0) {
                    return;
                }
            } else if (i7 == 0) {
                return;
            }
            throw new AS(A03(348, 21, 50) + j2 + A03);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d0, code lost:
        if (r5 != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
        r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
        if (com.facebook.ads.redexgen.X.WB.A0q[7].length() == 22) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e1, code lost:
        com.facebook.ads.redexgen.X.WB.A0q[4] = "xUjpTE6fi698I1UVKMv3yTWS8T";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e8, code lost:
        if (r5 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ea, code lost:
        r7.A0K = r9;
        r7.A0L = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f6, code lost:
        if (r5 != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        throw new com.facebook.ads.redexgen.X.AS(A03(717, 39, 13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010e, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0M(int r8, long r9, long r11) throws com.facebook.ads.redexgen.X.AS {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WB.A0M(int, long, long):void");
    }

    public final void A0N(int i2, String str) throws AS {
        if (i2 == 134) {
            this.A0O.A0Y = str;
        } else if (i2 != 17026) {
            if (i2 != 2274716) {
                return;
            }
            Cl.A02(this.A0O, str);
        } else if (A03(1034, 4, 114).equals(str) || A03(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 8, 38).equals(str)) {
        } else {
            throw new AS(A03(369, 8, 86) + str + A03(0, 14, 56));
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A0N = cr;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        this.A0V = false;
        boolean z = true;
        while (z && !this.A0V) {
            z = this.A0d.ADF(cq);
            if (z && A0E(cw, cq.A79())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i2 = 0; i2 < this.A0c.size(); i2++) {
            this.A0c.valueAt(i2).A07();
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A0E = -9223372036854775807L;
        this.A04 = 0;
        this.A0d.reset();
        this.A0e.A06();
        A05();
        for (int i2 = 0; i2 < this.A0c.size(); i2++) {
            this.A0c.valueAt(i2).A08();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        return new Cn().A01(cq);
    }
}
