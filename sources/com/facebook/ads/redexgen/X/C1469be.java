package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.be  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1469be extends C4M implements C4Y {
    public static byte[] A0F;
    public static String[] A0G = {"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AnonymousClass46 A04;
    public boolean A05;
    public int A06;
    public AnonymousClass41 A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C05733z A0D;
    public final AnonymousClass40 A0E;

    public static String A0T(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A0V() {
        A0F = new byte[]{30, 25, 1, 22, 27, 30, 19, 87, 24, 5, 30, 18, 25, 3, 22, 3, 30, 24, 25, 77};
    }

    static {
        A0V();
    }

    public C1469be(Context context) {
        this(context, 1, false);
    }

    public C1469be(Context context, int i2, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C05733z(this);
        this.A0E = new AnonymousClass40();
        this.A06 = 2;
        A2E(i2);
        A0h(z);
        A1V(true);
    }

    private final int A04(int scrolled, C4U c4u, C05754b c05754b) {
        if (A0W() == 0 || scrolled == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2D();
        int i2 = scrolled > 0 ? 1 : -1;
        int abs = Math.abs(scrolled);
        A0Y(i2, abs, true, c05754b);
        int A08 = this.A07.A07 + A08(c4u, this.A07, c05754b, false);
        if (A08 < 0) {
            return 0;
        }
        int i3 = abs > A08 ? i2 * A08 : scrolled;
        this.A04.A0J(-i3);
        this.A07.A04 = i3;
        return i3;
    }

    private int A05(int fixOffset, C4U c4u, C05754b c05754b, boolean z) {
        int A07 = this.A04.A07() - fixOffset;
        if (A07 > 0) {
            int i2 = -A04(-A07, c4u, c05754b);
            int fixOffset2 = fixOffset + i2;
            if (z) {
                int A072 = this.A04.A07();
                if (A0G[0].length() == 7) {
                    throw new RuntimeException();
                }
                A0G[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                int i3 = A072 - fixOffset2;
                if (i3 > 0) {
                    this.A04.A0J(i3);
                    return i3 + i2;
                }
            }
            return i2;
        }
        return 0;
    }

    private int A06(int fixOffset, C4U c4u, C05754b c05754b, boolean z) {
        int fixOffset2;
        int A0A = fixOffset - this.A04.A0A();
        if (A0A > 0) {
            int i2 = -A04(A0A, c4u, c05754b);
            int fixOffset3 = fixOffset + i2;
            if (z && (fixOffset2 = fixOffset3 - this.A04.A0A()) > 0) {
                this.A04.A0J(-fixOffset2);
                return i2 - fixOffset2;
            }
            return i2;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        return r7 - r11.A00;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int A08(com.facebook.ads.redexgen.X.C4U r10, com.facebook.ads.redexgen.X.AnonymousClass41 r11, com.facebook.ads.redexgen.X.C05754b r12, boolean r13) {
        /*
            r9 = this;
            int r7 = r11.A00
            int r0 = r11.A07
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r6) goto L16
            int r0 = r11.A00
            if (r0 >= 0) goto L13
            int r1 = r11.A07
            int r0 = r11.A00
            int r1 = r1 + r0
            r11.A07 = r1
        L13:
            r9.A0e(r10, r11)
        L16:
            int r5 = r11.A00
            int r0 = r11.A02
            int r5 = r5 + r0
            com.facebook.ads.redexgen.X.40 r4 = r9.A0E
        L1d:
            boolean r0 = r11.A09
            if (r0 != 0) goto L23
            if (r5 <= 0) goto L33
        L23:
            boolean r0 = r11.A05(r12)
            if (r0 == 0) goto L33
            r4.A00()
            r9.A2H(r10, r12, r11, r4)
            boolean r0 = r4.A01
            if (r0 == 0) goto L37
        L33:
            int r0 = r11.A00
            int r7 = r7 - r0
            return r7
        L37:
            int r2 = r11.A06
            int r1 = r4.A00
            int r0 = r11.A05
            int r1 = r1 * r0
            int r2 = r2 + r1
            r11.A06 = r2
            boolean r0 = r4.A03
            if (r0 == 0) goto L51
            com.facebook.ads.redexgen.X.41 r0 = r9.A07
            java.util.List<com.facebook.ads.redexgen.X.4e> r0 = r0.A08
            if (r0 != 0) goto L51
            boolean r0 = r12.A07()
            if (r0 != 0) goto L5b
        L51:
            int r1 = r11.A00
            int r0 = r4.A00
            int r1 = r1 - r0
            r11.A00 = r1
            int r0 = r4.A00
            int r5 = r5 - r0
        L5b:
            int r0 = r11.A07
            if (r0 == r6) goto L87
            int r1 = r11.A07
            int r0 = r4.A00
            int r1 = r1 + r0
            r11.A07 = r1
            int r0 = r11.A00
            if (r0 >= 0) goto L84
            int r8 = r11.A07
            int r3 = r11.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1469be.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1469be.A0G
            java.lang.String r1 = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf"
            r0 = 5
            r2[r0] = r1
            int r8 = r8 + r3
            r11.A07 = r8
        L84:
            r9.A0e(r10, r11)
        L87:
            if (r13 == 0) goto L1d
            boolean r3 = r4.A02
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1469be.A0G
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1469be.A0G
            java.lang.String r1 = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov"
            r0 = 1
            r2[r0] = r1
            if (r3 == 0) goto L1d
            goto L33
        La1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1469be.A08(com.facebook.ads.redexgen.X.4U, com.facebook.ads.redexgen.X.41, com.facebook.ads.redexgen.X.4b, boolean):int");
    }

    private int A09(C05754b c05754b) {
        if (A0W() != 0) {
            A2D();
            return C05794f.A00(c05754b, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        } else if (A0G[5].length() != 31) {
            throw new RuntimeException();
        } else {
            A0G[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
            return 0;
        }
    }

    private int A0A(C05754b c05754b) {
        if (A0W() == 0) {
            return 0;
        }
        A2D();
        return C05794f.A02(c05754b, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0B(C05754b c05754b) {
        if (A0W() != 0) {
            A2D();
            return C05794f.A01(c05754b, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
            String[] strArr2 = A0G;
            strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
            strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
            return 0;
        }
        throw new RuntimeException();
    }

    private final int A0C(C05754b c05754b) {
        if (c05754b.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0W());
    }

    private View A0E() {
        return A0H(A0W() - 1, -1);
    }

    private View A0F() {
        return A0t(this.A05 ? 0 : A0W() - 1);
    }

    private View A0G() {
        return A0t(this.A05 ? A0W() - 1 : 0);
    }

    private final View A0H(int preferredBoundsFlag, int acceptableBoundsFlag) {
        char c;
        int i2;
        int i3;
        A2D();
        if (acceptableBoundsFlag > preferredBoundsFlag) {
            c = 1;
        } else {
            c = acceptableBoundsFlag < preferredBoundsFlag ? (char) 65535 : (char) 0;
        }
        if (c == 0) {
            View A0t = A0t(preferredBoundsFlag);
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0G[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return A0t;
        }
        if (this.A04.A0F(A0t(preferredBoundsFlag)) < this.A04.A0A()) {
            i2 = 16644;
            i3 = 16388;
        } else {
            i2 = 4161;
            i3 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.A00 == 0) {
            return super.A04.A00(preferredBoundsFlag, acceptableBoundsFlag, i2, i3);
        }
        return super.A05.A00(preferredBoundsFlag, acceptableBoundsFlag, i2, i3);
    }

    private final View A0J(int acceptableBoundsFlag, int i2, boolean z, boolean z2) {
        int i3;
        A2D();
        int i4 = 0;
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (z2) {
            i4 = 320;
        }
        int i5 = this.A00;
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        if (i5 == 0) {
            return super.A04.A00(acceptableBoundsFlag, i2, i3, i4);
        }
        return super.A05.A00(acceptableBoundsFlag, i2, i3, i4);
    }

    private View A0K(C4U c4u, C05754b c05754b) {
        return A2C(c4u, c05754b, 0, A0W(), c05754b.A03());
    }

    private View A0L(C4U c4u, C05754b c05754b) {
        return A2C(c4u, c05754b, A0W() - 1, -1, c05754b.A03());
    }

    private View A0M(C4U c4u, C05754b c05754b) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(C4U c4u, C05754b c05754b) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(C4U c4u, C05754b c05754b) {
        return this.A05 ? A0K(c4u, c05754b) : A0L(c4u, c05754b);
    }

    private View A0P(C4U c4u, C05754b c05754b) {
        return this.A05 ? A0L(c4u, c05754b) : A0K(c4u, c05754b);
    }

    private View A0Q(boolean z, boolean z2) {
        if (this.A05) {
            return A0J(0, A0W(), z, z2);
        }
        return A0J(A0W() - 1, -1, z, z2);
    }

    private View A0R(boolean z, boolean z2) {
        if (this.A05) {
            return A0J(A0W() - 1, -1, z, z2);
        }
        return A0J(0, A0W(), z, z2);
    }

    private final AnonymousClass41 A0S() {
        return new AnonymousClass41();
    }

    private void A0U() {
        if (this.A00 == 1 || !A2J()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[6] = "rvopS3hSB7itRsuyG";
        strArr2[7] = "9RTUShXs4ZXrU4n03";
        this.A05 = z;
    }

    private void A0W(int i2, int i3) {
        this.A07.A00 = this.A04.A07() - i3;
        this.A07.A03 = this.A05 ? -1 : 1;
        AnonymousClass41 anonymousClass41 = this.A07;
        anonymousClass41.A01 = i2;
        anonymousClass41.A05 = 1;
        anonymousClass41.A06 = i3;
        anonymousClass41.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i2, int i3) {
        this.A07.A00 = i3 - this.A04.A0A();
        AnonymousClass41 anonymousClass41 = this.A07;
        anonymousClass41.A01 = i2;
        anonymousClass41.A03 = this.A05 ? 1 : -1;
        AnonymousClass41 anonymousClass412 = this.A07;
        anonymousClass412.A05 = -1;
        anonymousClass412.A06 = i3;
        anonymousClass412.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i2, int i3, boolean z, C05754b c05754b) {
        int A0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(c05754b);
        AnonymousClass41 anonymousClass41 = this.A07;
        anonymousClass41.A05 = i2;
        if (i2 == 1) {
            anonymousClass41.A02 += this.A04.A08();
            View A0F2 = A0F();
            AnonymousClass41 anonymousClass412 = this.A07;
            if (!this.A05) {
                r4 = 1;
            }
            anonymousClass412.A03 = r4;
            this.A07.A01 = A0p(A0F2) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(A0F2);
            A0A = this.A04.A0C(A0F2) - this.A04.A07();
        } else {
            View A0G2 = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0p(A0G2) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(A0G2);
            A0A = (-this.A04.A0F(A0G2)) + this.A04.A0A();
        }
        AnonymousClass41 anonymousClass413 = this.A07;
        anonymousClass413.A00 = i3;
        if (z) {
            anonymousClass413.A00 -= A0A;
        }
        this.A07.A07 = A0A;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        A0G[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
    }

    private void A0Z(C05733z c05733z) {
        A0W(c05733z.A01, c05733z.A00);
    }

    private void A0a(C05733z c05733z) {
        A0X(c05733z.A01, c05733z.A00);
    }

    private void A0b(C4U c4u, int i2) {
        int A0W = A0W();
        if (i2 < 0) {
            return;
        }
        int A06 = this.A04.A06() - i2;
        if (this.A05) {
            for (int i3 = 0; i3 < A0W; i3++) {
                View A0t = A0t(i3);
                if (this.A04.A0F(A0t) < A06 || this.A04.A0H(A0t) < A06) {
                    A0d(c4u, 0, i3);
                    return;
                }
            }
            return;
        }
        for (int i4 = A0W - 1; i4 >= 0; i4--) {
            View A0t2 = A0t(i4);
            if (this.A04.A0F(A0t2) < A06 || this.A04.A0H(A0t2) < A06) {
                A0d(c4u, A0W - 1, i4);
                return;
            }
        }
    }

    private void A0c(C4U c4u, int i2) {
        if (i2 < 0) {
            return;
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[0] = "66";
        int A0W = A0W();
        if (this.A05) {
            for (int i3 = A0W - 1; i3 >= 0; i3--) {
                View A0t = A0t(i3);
                if (this.A04.A0C(A0t) <= i2) {
                    AnonymousClass46 anonymousClass46 = this.A04;
                    String[] strArr2 = A0G;
                    if (strArr2[6].length() != strArr2[7].length()) {
                        if (anonymousClass46.A0G(A0t) <= i2) {
                        }
                    } else {
                        A0G[3] = "uDZbJl3GZvnd0";
                        if (anonymousClass46.A0G(A0t) <= i2) {
                        }
                    }
                }
                A0d(c4u, A0W - 1, i3);
                return;
            }
            return;
        }
        for (int i4 = 0; i4 < A0W; i4++) {
            View A0t2 = A0t(i4);
            int A0C = this.A04.A0C(A0t2);
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
            if (A0C > i2 || this.A04.A0G(A0t2) > i2) {
                A0d(c4u, 0, i4);
                return;
            }
        }
    }

    private void A0d(C4U c4u, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 > i2) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                A14(i4, c4u);
            }
            return;
        }
        while (i2 > i3) {
            A14(i2, c4u);
            i2--;
        }
    }

    private void A0e(C4U c4u, AnonymousClass41 anonymousClass41) {
        if (!anonymousClass41.A0B || anonymousClass41.A09) {
            return;
        }
        int i2 = anonymousClass41.A05;
        String[] strArr = A0G;
        if (strArr[6].length() == strArr[7].length()) {
            String[] strArr2 = A0G;
            strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
            strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
            if (i2 == -1) {
                int i3 = anonymousClass41.A07;
                if (A0G[1].charAt(30) == 'o') {
                    A0G[3] = "CiNTyTfZO3PW6tP";
                    A0b(c4u, i3);
                    return;
                }
            } else {
                A0c(c4u, anonymousClass41.A07);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0f(C4U c4u, C05754b c05754b, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!c05754b.A08() || A0W() == 0 || c05754b.A07() || !A26()) {
            return;
        }
        int direction = 0;
        int i2 = 0;
        List<AbstractC05784e> A0J = c4u.A0J();
        int size = A0J.size();
        int A0p = A0p(A0t(0));
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC05784e abstractC05784e = A0J.get(i3);
            if (!abstractC05784e.A0c()) {
                int position = abstractC05784e.A0I();
                char c = 1;
                if ((position < A0p) != this.A05) {
                    c = 65535;
                }
                if (c == 65535) {
                    int position2 = this.A04.A0D(abstractC05784e.A0H);
                    direction += position2;
                } else {
                    int position3 = this.A04.A0D(abstractC05784e.A0H);
                    i2 += position3;
                }
            }
        }
        this.A07.A08 = A0J;
        if (direction > 0) {
            View anchor = A0G();
            A0X(A0p(anchor), scrapExtraEnd);
            AnonymousClass41 anonymousClass41 = this.A07;
            anonymousClass41.A02 = direction;
            anonymousClass41.A00 = 0;
            anonymousClass41.A04();
            A08(c4u, this.A07, c05754b, false);
        }
        if (i2 > 0) {
            View anchor2 = A0F();
            A0W(A0p(anchor2), scrapExtraEnd2);
            AnonymousClass41 anonymousClass412 = this.A07;
            anonymousClass412.A02 = i2;
            anonymousClass412.A00 = 0;
            anonymousClass412.A04();
            A08(c4u, this.A07, c05754b, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(C4U c4u, C05754b c05754b, C05733z c05733z) {
        if (A0k(c05754b, c05733z)) {
            return;
        }
        boolean A0j = A0j(c4u, c05754b, c05733z);
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[3] = "XDJ2jDWhUW9a7iN";
        if (A0j) {
            return;
        }
        c05733z.A02();
        c05733z.A01 = this.A0C ? c05754b.A03() - 1 : 0;
    }

    private final void A0h(boolean z) {
        A22(null);
        if (z == this.A0A) {
            return;
        }
        this.A0A = z;
        A0y();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(C4U c4u, C05754b c05754b, C05733z c05733z) {
        View A0P;
        int A0A;
        boolean z = false;
        if (A0W() == 0) {
            return false;
        }
        View A0s = A0s();
        if (A0s != null && c05733z.A06(A0s, c05754b)) {
            c05733z.A05(A0s);
            return true;
        } else if (this.A08 != this.A0C) {
            return false;
        } else {
            if (c05733z.A02) {
                A0P = A0O(c4u, c05754b);
            } else {
                A0P = A0P(c4u, c05754b);
            }
            if (A0P != null) {
                c05733z.A04(A0P);
                if (!c05754b.A07() && A26()) {
                    if ((this.A04.A0F(A0P) >= this.A04.A07() || this.A04.A0C(A0P) < this.A04.A0A()) ? true : true) {
                        if (c05733z.A02) {
                            A0A = this.A04.A07();
                        } else {
                            A0A = this.A04.A0A();
                        }
                        c05733z.A00 = A0A;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean A0k(C05754b c05754b, C05733z c05733z) {
        int i2;
        int A0F2;
        if (c05754b.A07() || (i2 = this.A01) == -1) {
            return false;
        }
        if (i2 < 0 || i2 >= c05754b.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c05733z.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            if (this.A02 == Integer.MIN_VALUE) {
                View A1q = A1q(this.A01);
                if (A1q != null) {
                    int A0D = this.A04.A0D(A1q);
                    int childSize = this.A04.A0B();
                    if (A0D > childSize) {
                        c05733z.A02();
                        return true;
                    }
                    int A0F3 = this.A04.A0F(A1q);
                    int childSize2 = this.A04.A0A();
                    if (A0F3 - childSize2 < 0) {
                        int childSize3 = this.A04.A0A();
                        c05733z.A00 = childSize3;
                        c05733z.A02 = false;
                        return true;
                    }
                    int A07 = this.A04.A07();
                    int childSize4 = this.A04.A0C(A1q);
                    if (A07 - childSize4 < 0) {
                        int childSize5 = this.A04.A07();
                        c05733z.A00 = childSize5;
                        c05733z.A02 = true;
                        return true;
                    }
                    if (c05733z.A02) {
                        int A0C = this.A04.A0C(A1q);
                        AnonymousClass46 anonymousClass46 = this.A04;
                        String[] strArr = A0G;
                        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
                            throw new RuntimeException();
                        }
                        A0G[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        A0F2 = A0C + anonymousClass46.A05();
                    } else {
                        A0F2 = this.A04.A0F(A1q);
                    }
                    c05733z.A00 = A0F2;
                } else {
                    int childSize6 = A0W();
                    if (childSize6 > 0) {
                        int A0p = A0p(A0t(0));
                        int pos = this.A01;
                        boolean z = pos < A0p;
                        boolean z2 = this.A05;
                        if (A0G[1].charAt(30) != 'o') {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0G;
                        strArr2[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                        strArr2[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                        c05733z.A02 = z == z2;
                    }
                    c05733z.A02();
                }
                return true;
            }
            boolean z3 = this.A05;
            c05733z.A02 = z3;
            if (z3) {
                c05733z.A00 = this.A04.A07() - this.A02;
            } else {
                c05733z.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
        c05733z.A02 = this.A03.A02;
        if (c05733z.A02) {
            c05733z.A00 = this.A04.A07() - this.A03.A00;
        } else {
            c05733z.A00 = this.A04.A0A() + this.A03.A00;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public int A1h(int i2, C4U c4u, C05754b c05754b) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i2, c4u, c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public int A1i(int i2, C4U c4u, C05754b c05754b) {
        if (this.A00 == 0) {
            return 0;
        }
        int A04 = A04(i2, c4u, c05754b);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A0G[3] = "CDnF1shpb";
        return A04;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1j(C05754b c05754b) {
        return A09(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1k(C05754b c05754b) {
        return A0A(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1l(C05754b c05754b) {
        return A0B(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1m(C05754b c05754b) {
        return A09(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1n(C05754b c05754b) {
        return A0A(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final int A1o(C05754b c05754b) {
        return A0B(c05754b);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final Parcelable A1p() {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(linearLayoutManager$SavedState));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState2 = new LinearLayoutManager$SavedState();
        if (A0W() > 0) {
            A2D();
            boolean z = this.A08 ^ this.A05;
            linearLayoutManager$SavedState2.A02 = z;
            if (z) {
                View A0F2 = A0F();
                linearLayoutManager$SavedState2.A00 = this.A04.A07() - this.A04.A0C(A0F2);
                linearLayoutManager$SavedState2.A01 = A0p(A0F2);
            } else {
                View refChild = A0G();
                linearLayoutManager$SavedState2.A01 = A0p(refChild);
                linearLayoutManager$SavedState2.A00 = this.A04.A0F(refChild) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState2.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState2);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    @Nullable
    public final View A1q(int firstChild) {
        int viewPosition = A0W();
        if (viewPosition == 0) {
            return null;
        }
        int A0p = firstChild - A0p(A0t(0));
        if (A0p >= 0 && A0p < viewPosition) {
            View A0t = A0t(A0p);
            if (A0p(A0t) == firstChild) {
                return A0t;
            }
        }
        View child = super.A1q(firstChild);
        return child;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public View A1r(View view, int i2, C4U c4u, C05754b c05754b) {
        int A2B;
        View A0M;
        View A0F2;
        A0U();
        if (A0W() == 0 || (A2B = A2B(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        A2D();
        A2D();
        A0Y(A2B, (int) (this.A04.A0B() * 0.33333334f), false, c05754b);
        AnonymousClass41 anonymousClass41 = this.A07;
        anonymousClass41.A07 = Integer.MIN_VALUE;
        anonymousClass41.A0B = false;
        A08(c4u, anonymousClass41, c05754b, true);
        if (A2B == -1) {
            A0M = A0N(c4u, c05754b);
        } else {
            A0M = A0M(c4u, c05754b);
        }
        if (A2B == -1) {
            A0F2 = A0G();
        } else {
            A0F2 = A0F();
        }
        boolean hasFocusable = A0F2.hasFocusable();
        if (A0G[0].length() != 7) {
            String[] strArr = A0G;
            strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
            strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
            if (hasFocusable) {
                if (A0M == null) {
                    return null;
                }
                return A0F2;
            }
            return A0M;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public C4N A1s() {
        return new C4N(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public void A1t(int i2) {
        this.A01 = i2;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final void A1u(int i2, int i3, C05754b c05754b, C4K c4k) {
        if (this.A00 != 0) {
            i2 = i3;
        }
        if (A0W() == 0 || i2 == 0) {
            return;
        }
        A2D();
        A0Y(i2 > 0 ? 1 : -1, Math.abs(i2), true, c05754b);
        A2I(c05754b, this.A07, c4k);
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0019 */
    @Override // com.facebook.ads.redexgen.X.C4M
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1v(int r8, com.facebook.ads.redexgen.X.C4K r9) {
        /*
            r7 = this;
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            r6 = 0
            r5 = -1
            if (r0 == 0) goto L28
            boolean r0 = r0.A01()
            if (r0 == 0) goto L28
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            boolean r4 = r0.A02
            com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState r0 = r7.A03
            int r2 = r0.A01
        L14:
            if (r4 == 0) goto L26
        L16:
            r1 = 0
        L17:
            int r0 = r7.A06
            if (r1 >= r0) goto L5a
            if (r2 < 0) goto L5a
            if (r2 >= r8) goto L5a
            r9.A3F(r2, r6)
            int r2 = r2 + r5
            int r1 = r1 + 1
            goto L17
        L26:
            r5 = 1
            goto L16
        L28:
            r7.A0U()
            boolean r4 = r7.A05
            int r3 = r7.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1469be.A0G
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L47
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L47:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1469be.A0G
            java.lang.String r1 = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM"
            r0 = 1
            r2[r0] = r1
            if (r3 != r5) goto L57
            if (r4 == 0) goto L55
            int r2 = r8 + (-1)
            goto L14
        L55:
            r2 = 0
            goto L14
        L57:
            int r2 = r7.A01
            goto L14
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1469be.A1v(int, com.facebook.ads.redexgen.X.4K):void");
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final void A1w(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (A0G[1].charAt(30) == 'o') {
            A0G[1] = "tHEWx5U9TGfOm0s3U2zrO5nR7UMaVIoI";
            if (classLoader == null) {
                return;
            }
            if (A0G[5].length() == 31) {
                A0G[3] = "tm";
                Parcelable unwrap = ((WrappedParcelable) parcelable).unwrap(classLoader);
                if (unwrap instanceof LinearLayoutManager$SavedState) {
                    this.A03 = (LinearLayoutManager$SavedState) unwrap;
                    A0y();
                    return;
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final void A1x(AccessibilityEvent accessibilityEvent) {
        super.A1x(accessibilityEvent);
        if (A0W() > 0) {
            accessibilityEvent.setFromIndex(A28());
            int A29 = A29();
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[3] = "9E5bhv9RVKulu";
            accessibilityEvent.setToIndex(A29);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
        if (r8 != (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
        if (r9.A02 == Integer.MIN_VALUE) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r1 = A1q(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r9.A05 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r8 = r9.A04.A07() - r9.A04.A0C(r1);
        r5 = com.facebook.ads.redexgen.X.C1469be.A0G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r5[2].charAt(4) == r5[4].charAt(4)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d6, code lost:
        com.facebook.ads.redexgen.X.C1469be.A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
        r0 = r9.A02;
        r8 = r8 - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
        if (r8 <= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
        r6 = r6 + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01fa, code lost:
        r7 = r7 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01fd, code lost:
        r5 = com.facebook.ads.redexgen.X.C1469be.A0G;
        r5[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
        r5[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
        r0 = r9.A02;
        r8 = r8 - r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x020e, code lost:
        r8 = r9.A02 - (r9.A04.A0F(r1) - r9.A04.A0A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x022c, code lost:
        if (r8 != (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0250, code lost:
        if (r1 <= r0) goto L82;
     */
    @Override // com.facebook.ads.redexgen.X.C4M
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A1y(com.facebook.ads.redexgen.X.C4U r10, com.facebook.ads.redexgen.X.C05754b r11) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1469be.A1y(com.facebook.ads.redexgen.X.4U, com.facebook.ads.redexgen.X.4b):void");
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public void A1z(C05754b c05754b) {
        super.A1z(c05754b);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final void A20(C0828Eq c0828Eq, C4U c4u) {
        super.A20(c0828Eq, c4u);
        if (this.A09) {
            A1I(c4u);
            c4u.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public void A21(C0828Eq c0828Eq, C05754b c05754b, int i2) {
        C1468bd c1468bd = new C1468bd(c0828Eq.getContext());
        c1468bd.A0A(i2);
        A1L(c1468bd);
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final void A22(String str) {
        if (this.A03 == null) {
            super.A22(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final boolean A23() {
        if (A0Y() != 1073741824 && A0i() != 1073741824) {
            boolean A1W = A1W();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            A0G[0] = "ZYU5Lu8KJdo1W8";
            if (A1W) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final boolean A24() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public final boolean A25() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.X.C4M
    public boolean A26() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A27() {
        View A0J = A0J(0, A0W(), true, false);
        if (A0J == null) {
            return -1;
        }
        return A0p(A0J);
    }

    public final int A28() {
        View A0J = A0J(0, A0W(), false, true);
        if (A0J == null) {
            return -1;
        }
        return A0p(A0J);
    }

    public final int A29() {
        View A0J = A0J(A0W() - 1, -1, false, true);
        if (A0J == null) {
            return -1;
        }
        return A0p(A0J);
    }

    public final int A2A() {
        return this.A00;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A2B(int r8) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1469be.A2B(int):int");
    }

    public View A2C(C4U c4u, C05754b c05754b, int boundsEnd, int i2, int i3) {
        A2D();
        View view = null;
        View view2 = null;
        int A0A = this.A04.A0A();
        int A07 = this.A04.A07();
        int i4 = i2 > boundsEnd ? 1 : -1;
        while (boundsEnd != i2) {
            View A0t = A0t(boundsEnd);
            int A0p = A0p(A0t);
            if (A0p >= 0 && A0p < i3) {
                if (((C4N) A0t.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = A0t;
                    }
                } else if (this.A04.A0F(A0t) >= A07 || this.A04.A0C(A0t) < A0A) {
                    if (view2 == null) {
                        view2 = A0t;
                    }
                } else {
                    return A0t;
                }
            }
            boundsEnd += i4;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2D() {
        if (this.A07 == null) {
            this.A07 = A0S();
        }
        if (this.A04 == null) {
            this.A04 = AnonymousClass46.A02(this, this.A00);
        }
    }

    public final void A2E(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(A0T(0, 20, 1) + i2);
        } else if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        } else {
            A0G[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
            A22(null);
            if (i2 == this.A00) {
                return;
            }
            this.A00 = i2;
            this.A04 = null;
            A0y();
        }
    }

    public final void A2F(int i2, int i3) {
        this.A01 = i2;
        this.A02 = i3;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[3] = "tDl3kZGUKMTs";
    }

    public void A2G(C4U c4u, C05754b c05754b, C05733z c05733z, int i2) {
    }

    public void A2H(C4U c4u, C05754b c05754b, AnonymousClass41 anonymousClass41, AnonymousClass40 anonymousClass40) {
        int A0g;
        int A0E;
        int i2;
        int i3;
        View A03 = anonymousClass41.A03(c4u);
        if (A03 == null) {
            anonymousClass40.A01 = true;
            return;
        }
        C4N c4n = (C4N) A03.getLayoutParams();
        if (anonymousClass41.A08 == null) {
            boolean z = this.A05;
            int top = anonymousClass41.A05 == -1 ? 1 : 0;
            if (z == top) {
                A17(A03);
            } else {
                A19(A03, 0);
            }
        } else {
            boolean z2 = this.A05;
            int top2 = anonymousClass41.A05;
            int top3 = top2 == -1 ? 1 : 0;
            if (z2 == top3) {
                A16(A03);
            } else {
                A18(A03, 0);
            }
        }
        A1A(A03, 0, 0);
        anonymousClass40.A00 = this.A04.A0D(A03);
        if (this.A00 == 1) {
            if (A2J()) {
                i3 = A0h() - A0f();
                i2 = i3 - this.A04.A0E(A03);
            } else {
                i2 = A0e();
                i3 = this.A04.A0E(A03) + i2;
            }
            if (anonymousClass41.A05 == -1) {
                A0E = anonymousClass41.A06;
                A0g = anonymousClass41.A06 - anonymousClass40.A00;
            } else {
                A0g = anonymousClass41.A06;
                int i4 = anonymousClass41.A06;
                int top4 = anonymousClass40.A00;
                A0E = i4 + top4;
            }
        } else {
            A0g = A0g();
            A0E = this.A04.A0E(A03) + A0g;
            int top5 = anonymousClass41.A05;
            if (top5 == -1) {
                i3 = anonymousClass41.A06;
                int i5 = anonymousClass41.A06;
                int top6 = anonymousClass40.A00;
                i2 = i5 - top6;
            } else {
                i2 = anonymousClass41.A06;
                int i6 = anonymousClass41.A06;
                int top7 = anonymousClass40.A00;
                i3 = i6 + top7;
            }
        }
        A1B(A03, i2, A0g, i3, A0E);
        if (c4n.A02() || c4n.A01()) {
            anonymousClass40.A03 = true;
        }
        anonymousClass40.A02 = A03.hasFocusable();
    }

    public void A2I(C05754b c05754b, AnonymousClass41 anonymousClass41, C4K c4k) {
        int i2 = anonymousClass41.A01;
        if (i2 >= 0 && i2 < c05754b.A03()) {
            c4k.A3F(i2, Math.max(0, anonymousClass41.A07));
        }
    }

    public final boolean A2J() {
        return A0a() == 1;
    }

    @Override // com.facebook.ads.redexgen.X.C4Y
    public final PointF A43(int firstChildPos) {
        if (A0W() == 0) {
            return null;
        }
        int i2 = (firstChildPos < A0p(A0t(0))) != this.A05 ? -1 : 1;
        int i3 = this.A00;
        if (A0G[0].length() != 7) {
            A0G[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
            if (i3 == 0) {
                return new PointF(i2, 0.0f);
            }
            return new PointF(0.0f, i2);
        }
        throw new RuntimeException();
    }
}
