package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Et  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0831Et extends AbstractC1454bO {
    public static String[] A02 = {"C44Ajl3kvJruV1G0pt7gVRuztfjSJyFq", "J5x5lFquh7whloqA7FngbvBzLsCb", "NWBvU5bW0Pue", "3", "BTAVkHunqM91yRRN2KcoYuZCergWfboL", "2NY5ANPTvwBPWrnTgdotgLNYCmp8", "bg7eF9CjngMlwdFplTojabi", "lLeEucKPPYu6Z0yxrpg2o1MG4v3W39r2"};
    @Nullable
    public AnonymousClass46 A00;
    @Nullable
    public AnonymousClass46 A01;

    private int A00(@NonNull C4M c4m, @NonNull View view, AnonymousClass46 anonymousClass46) {
        int A06;
        int A0F = anonymousClass46.A0F(view) + (anonymousClass46.A0D(view) / 2);
        if (c4m.A1X()) {
            A06 = anonymousClass46.A0A() + (anonymousClass46.A0B() / 2);
        } else {
            A06 = anonymousClass46.A06() / 2;
        }
        return A0F - A06;
    }

    @Nullable
    private View A01(C4M c4m, AnonymousClass46 anonymousClass46) {
        int A06;
        int absClosest = c4m.A0W();
        if (absClosest == 0) {
            return null;
        }
        View child = null;
        if (c4m.A1X()) {
            int A0A = anonymousClass46.A0A();
            int A0B = anonymousClass46.A0B();
            if (A02[3].length() != 1) {
                throw new RuntimeException();
            }
            A02[4] = "QSrTWOl4jyYASaYHeqwJw7nAVlZS9nVf";
            A06 = A0A + (A0B / 2);
        } else {
            A06 = anonymousClass46.A06() / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < absClosest; i3++) {
            View A0t = c4m.A0t(i3);
            int A0F = anonymousClass46.A0F(A0t);
            int i4 = anonymousClass46.A0D(A0t);
            int childCenter = Math.abs((A0F + (i4 / 2)) - A06);
            if (childCenter < i2) {
                i2 = childCenter;
                child = A0t;
            }
        }
        return child;
    }

    @Nullable
    private View A02(C4M c4m, AnonymousClass46 anonymousClass46) {
        int i2 = c4m.A0W();
        if (i2 == 0) {
            return null;
        }
        View view = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < i2; i4++) {
            View A0t = c4m.A0t(i4);
            int A0F = anonymousClass46.A0F(A0t);
            if (A0F < i3) {
                i3 = A0F;
                int childStart = A02[3].length();
                if (childStart != 1) {
                    throw new RuntimeException();
                }
                A02[3] = "0";
                view = A0t;
            }
        }
        return view;
    }

    @NonNull
    private AnonymousClass46 A03(@NonNull C4M c4m) {
        AnonymousClass46 anonymousClass46 = this.A00;
        if (anonymousClass46 == null || anonymousClass46.A02 != c4m) {
            this.A00 = AnonymousClass46.A00(c4m);
        }
        return this.A00;
    }

    @NonNull
    private AnonymousClass46 A04(@NonNull C4M c4m) {
        AnonymousClass46 anonymousClass46 = this.A01;
        if (anonymousClass46 == null || anonymousClass46.A02 != c4m) {
            this.A01 = AnonymousClass46.A01(c4m);
        }
        return this.A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
        if (r4 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
        if (r4.x < 0.0f) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r4.y >= 0.0f) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009c, code lost:
        if (r4 != null) goto L23;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC1454bO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A0C(com.facebook.ads.redexgen.X.C4M r10, int r11, int r12) {
        /*
            r9 = this;
            int r8 = r10.A0Z()
            r4 = -1
            if (r8 != 0) goto L8
            return r4
        L8:
            r1 = 0
            boolean r0 = r10.A25()
            if (r0 == 0) goto L1a
            com.facebook.ads.redexgen.X.46 r0 = r9.A04(r10)
            android.view.View r1 = r9.A02(r10, r0)
        L17:
            if (r1 != 0) goto L42
            return r4
        L1a:
            boolean r0 = r10.A24()
            if (r0 == 0) goto L17
            com.facebook.ads.redexgen.X.46 r3 = r9.A03(r10)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0831Et.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 1
            if (r1 == r0) goto L36
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L36:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0831Et.A02
            java.lang.String r1 = "gb7KateBwDTMhlVKT6fWGE4qrSBelOuo"
            r0 = 4
            r2[r0] = r1
            android.view.View r1 = r9.A02(r10, r3)
            goto L17
        L42:
            int r3 = r10.A0p(r1)
            if (r3 != r4) goto L49
            return r4
        L49:
            boolean r0 = r10.A24()
            r7 = 0
            if (r0 == 0) goto La1
            if (r11 <= 0) goto L9f
            r6 = 1
        L53:
            r5 = 0
            boolean r0 = r10 instanceof com.facebook.ads.redexgen.X.C4Y
            if (r0 == 0) goto L89
            com.facebook.ads.redexgen.X.4Y r10 = (com.facebook.ads.redexgen.X.C4Y) r10
            int r0 = r8 + (-1)
            android.graphics.PointF r4 = r10.A43(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0831Et.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 1
            if (r1 == r0) goto L95
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0831Et.A02
            java.lang.String r1 = "yuw4mNpzW34AqVSRehlxNeo"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "wkUUhZpWZ02e"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L89
        L7a:
            float r0 = r4.x
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L87
            float r0 = r4.y
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L88
        L87:
            r7 = 1
        L88:
            r5 = r7
        L89:
            if (r5 == 0) goto L90
            if (r6 == 0) goto L8f
            int r3 = r3 + (-1)
        L8f:
            return r3
        L90:
            if (r6 == 0) goto L8f
            int r3 = r3 + 1
            goto L8f
        L95:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0831Et.A02
            java.lang.String r1 = "mSLQWLSJnMsLfeZB8hd0gvJZQvTgwPgU"
            r0 = 0
            r2[r0] = r1
            if (r4 == 0) goto L89
            goto L7a
        L9f:
            r6 = 0
            goto L53
        La1:
            if (r12 <= 0) goto La5
            r6 = 1
            goto L53
        La5:
            r6 = 0
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0831Et.A0C(com.facebook.ads.redexgen.X.4M, int, int):int");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1454bO
    @Nullable
    public final View A0D(C4M c4m) {
        if (c4m.A25()) {
            return A01(c4m, A04(c4m));
        }
        if (c4m.A24()) {
            return A01(c4m, A03(c4m));
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1454bO
    public final C1468bd A0E(C4M c4m) {
        if (!(c4m instanceof C4Y)) {
            return null;
        }
        return new Eu(this, super.A00.getContext());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1454bO
    @Nullable
    public final int[] A0H(@NonNull C4M c4m, @NonNull View view) {
        int[] iArr = new int[2];
        if (c4m.A24()) {
            iArr[0] = A00(c4m, view, A03(c4m));
        } else {
            iArr[0] = 0;
        }
        boolean A25 = c4m.A25();
        String[] strArr = A02;
        if (strArr[1].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A02[0] = "E62MX6H1I4NpqQbgkpQnwXfK7jhgOp7C";
        if (A25) {
            iArr[1] = A00(c4m, view, A04(c4m));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
