package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
/* loaded from: assets/audience_network.dex */
public final class X3 implements C8L {
    public static X3 A06;
    public static byte[] A07;
    public static String[] A08 = {"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    @Nullable
    public C0U A00;
    @Nullable
    public C8K A01;
    @Nullable
    public C8Y A02;
    @Nullable
    public C9C A03;
    @Nullable
    public InterfaceC0941Jf A04;
    @Nullable
    public GC A05;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A06(int r4, int r5, int r6) {
        /*
            byte[] r1 = com.facebook.ads.redexgen.X.X3.A07
            int r0 = r4 + r5
            byte[] r3 = java.util.Arrays.copyOfRange(r1, r4, r0)
            r4 = 0
        L9:
            int r5 = r3.length
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.X3.A08
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L22
        L1c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L22:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.X3.A08
            java.lang.String r1 = "Hv2WK1fJh7GnXaP"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "jwUFRNkRPBL5IaL"
            r0 = 7
            r2[r0] = r1
            if (r4 >= r5) goto L5c
            r5 = r3[r4]
            int r5 = r5 - r6
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.X3.A08
            r0 = 4
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L48
            goto L1c
        L48:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.X3.A08
            java.lang.String r1 = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw"
            r0 = 3
            r2[r0] = r1
            int r0 = r5 + (-98)
            byte r0 = (byte) r0
            r3[r4] = r0
            int r4 = r4 + 1
            goto L9
        L5c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.X3.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A07 = new byte[]{-60, -11, -64, -57, -63, -64, -13, -59, -16, 2, 16, 16, 6, 12, 11, -67, 1, -2, 17, -2, -67, 6, 11, 6, 17, 6, -2, 9, 6, 23, 2, 1, 33, 20, 31, 30, 33, 35, 2, 20, 34, 34, 24, 30, 29, -13, 16, 35, 16, -8, 29, 24, 35, 24, 16, 27, 24, 41, 20, 19};
        if (A08[1].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
        strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
    }

    static {
        A07();
    }

    @Nullable
    public static C5Z A00(XS xs, @Nullable GC gc) {
        if (!JD.A18(xs) || gc == null) {
            return null;
        }
        return AbstractC06005a.A00().A01(gc);
    }

    public static C8Y A01(XS xs) {
        return C8Z.A00().A01(xs);
    }

    public static synchronized X3 A02() {
        X3 x3;
        String[] strArr = A08;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "yNOYv8BJbeG1jc93xecDuC4SV0M6ZsAO";
        strArr2[3] = "rgM7W1LhEjhuRpvAxAxTebmxK2ArHzjw";
        synchronized (X3.class) {
            if (A06 == null) {
                A06 = new X3();
            }
            x3 = A06;
        }
        return x3;
    }

    @Nullable
    public static InterfaceC1116Qf A03(XS xs) {
        if (!JD.A14(xs)) {
            return null;
        }
        return C1134Qx.A01(xs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C8L
    @Nullable
    /* renamed from: A04 */
    public final synchronized GC A7W() {
        return this.A05;
    }

    @Nullable
    public static GC A05(XS xs, C8Y c8y, @Nullable InterfaceC1116Qf interfaceC1116Qf) {
        if (!JD.A1l(xs) || interfaceC1116Qf == null) {
            return null;
        }
        return RK.A00().A01(xs, c8y, interfaceC1116Qf, C0963Kb.A04(xs), new X4(new KU(xs, A06(0, 0, 122), null, K9.A07, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, 0, AdSettings.isTestMode(xs), AdSettings.isMixedAudience(), new KE(), C0999Lp.A01(JD.A0H(xs)), null, null), xs), RI.A00().A00());
    }

    public static void A08() {
        String A062 = A06(32, 28, 77);
        if (A08[5].length() == 20) {
            throw new RuntimeException();
        }
        A08[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        KI.A05(A062, A06(8, 24, 59), A06(0, 8, 46));
    }

    public static void A09(XS xs, @Nullable C5Z c5z) {
        if (!JD.A18(xs) || c5z == null) {
            return;
        }
        C5X.A00().A01(c5z, xs);
    }

    public static void A0A(XS xs, @Nullable GC gc) {
        if (!JD.A0h(xs) || gc == null) {
            return;
        }
        new C06195u(xs, gc, new C06205v(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(XS xs, @Nullable GC gc) {
        if (gc == null) {
            return;
        }
        JG.A00(xs, gc);
    }

    public final synchronized void A0C(XS xs) {
        if (this.A05 != null) {
            return;
        }
        this.A02 = A01(xs);
        this.A05 = A05(xs, this.A02, A03(xs));
        A09(xs, A00(xs, this.A05));
        A0A(xs, this.A05);
        A0B(xs, this.A05);
        if (this.A05 != null) {
            this.A05.A5R();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final JT A5Z(XS xs) {
        return U4.A01(xs);
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized C8K A5n(C8J c8j) {
        if (this.A01 == null) {
            this.A01 = new X5(this);
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized C8Y A6H(C8J c8j) {
        if (this.A02 == null) {
            this.A02 = A01(c8j.A00());
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized InterfaceC06798l A6I(C8J c8j) {
        return new XJ(c8j);
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized C8M A6R(C8J c8j) {
        X6 x6;
        x6 = new X6(this, c8j);
        String[] strArr = A08;
        if (strArr[4].charAt(26) != strArr[0].charAt(26)) {
            throw new RuntimeException();
        }
        A08[1] = "2Vt1OUprKjNjnyD3";
        return x6;
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    @Nullable
    public final synchronized C0U A6e(C8J c8j) {
        if (!JD.A0r(c8j)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = C0V.A00().A01(new X9(c8j));
        }
        C0U c0u = this.A00;
        if (A08[5].length() != 20) {
            String[] strArr = A08;
            strArr[4] = "VIV2EvMRfEPiWlvmDKty9fFKFHJul9Yn";
            strArr[0] = "0wfCQdIt8NwFYvPKQ0QtM4LE4vJ9WdpV";
            return c0u;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized C8O A7F(C8J c8j) {
        return new X7(c8j);
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final XS A7G(Context context) {
        XS A00 = C8I.A00();
        if (A00 == null) {
            XS xs = new XS(context, this);
            C8I.A01(xs);
            return xs;
        }
        return A00;
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized InterfaceC0941Jf A7H(XS xs) {
        if (this.A04 == null) {
            this.A04 = new UB(xs);
        }
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.C8L
    public final synchronized C9C A7N() {
        if (this.A03 == null) {
            this.A03 = new C9C();
            A08();
        }
        return this.A03;
    }
}
