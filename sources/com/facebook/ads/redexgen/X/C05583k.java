package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.3k  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05583k {
    public static byte[] A03;
    public static String[] A04 = {"QoGKHhEqLDc7cPbroRD", "LQzzwNJ4o6QHlfYkxXGOUA5ejYw8qpDj", "6ipC3ASGLl4rMOedI", "OPBJh0aCf", "l4bQelOwEyQeTpTSi", "DWBJmVB67PV4ItRyT2e9caL16z1NK91I", "0G1mJvoVA", "nRnK55wdJbrp31Rh0MWe0TNMbF4aeg8Y"};
    public final InterfaceC05573j A01;
    public final C05563i A00 = new C05563i();
    public final List<View> A02 = new ArrayList();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        A04[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        A03 = new byte[]{-81, -93, -21, -20, -25, -25, -24, -15, -93, -17, -20, -10, -9, -67, -23, -25, -18, -34, -29, -36, -107, -23, -28, -107, -22, -29, -35, -34, -39, -38, -107, -42, -107, -21, -34, -38, -20, -107, -23, -35, -42, -23, -107, -20, -42, -24, -107, -29, -28, -23, -107, -35, -34, -39, -39, -38, -29, -35, -48, -52, -34, -121, -48, -38, -121, -43, -42, -37, -121, -56, -121, -54, -49, -48, -45, -53, -109, -121, -54, -56, -43, -43, -42, -37, -121, -49, -48, -53, -52, -121};
    }

    static {
        A02();
    }

    public C05583k(InterfaceC05573j interfaceC05573j) {
        this.A01 = interfaceC05573j;
    }

    private int A00(int limit) {
        if (limit < 0) {
            return -1;
        }
        int A5w = this.A01.A5w();
        int i2 = limit;
        while (i2 < A5w) {
            int removedBefore = limit - (i2 - this.A00.A03(i2));
            if (removedBefore == 0) {
                while (this.A00.A08(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += removedBefore;
        }
        return -1;
    }

    private void A03(View view) {
        this.A02.add(view);
        this.A01.AAU(view);
    }

    private boolean A04(View view) {
        if (this.A02.remove(view)) {
            this.A01.AAy(view);
            return true;
        }
        return false;
    }

    public final int A05() {
        return this.A01.A5w() - this.A02.size();
    }

    public final int A06() {
        return this.A01.A5w();
    }

    public final int A07(View view) {
        int A89 = this.A01.A89(view);
        if (A89 == -1 || this.A00.A08(A89)) {
            return -1;
        }
        return A89 - this.A00.A03(A89);
    }

    public final View A08(int i2) {
        int size = this.A02.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.A02.get(i3);
            AbstractC05784e A5z = this.A01.A5z(view);
            if (A5z.A0I() == i2 && !A5z.A0b() && !A5z.A0c()) {
                return view;
            }
        }
        return null;
    }

    public final View A09(int i2) {
        return this.A01.A5v(A00(i2));
    }

    public final View A0A(int i2) {
        return this.A01.A5v(i2);
    }

    public final void A0B() {
        this.A00.A04();
        for (int size = this.A02.size() - 1; size >= 0; size--) {
            this.A01.AAy(this.A02.get(size));
            this.A02.remove(size);
        }
        this.A01.ADa();
    }

    public final void A0C(int i2) {
        int A00 = A00(i2);
        this.A00.A09(A00);
        this.A01.A4k(A00);
    }

    public final void A0D(int i2) {
        int A00 = A00(i2);
        View A5v = this.A01.A5v(A00);
        if (A5v == null) {
            return;
        }
        if (this.A00.A09(A00)) {
            A04(A5v);
        }
        this.A01.ADe(A00);
        if (A04[4].length() == 16) {
            throw new RuntimeException();
        }
        A04[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
    }

    public final void A0E(View view) {
        int A89 = this.A01.A89(view);
        if (A89 >= 0) {
            this.A00.A06(A89);
            A03(view);
            return;
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0F(View view) {
        int A89 = this.A01.A89(view);
        if (A89 < 0) {
            return;
        }
        if (this.A00.A09(A89)) {
            A04(view);
        }
        this.A01.ADe(A89);
    }

    public final void A0G(View view) {
        int A89 = this.A01.A89(view);
        if (A89 >= 0) {
            if (this.A00.A08(A89)) {
                this.A00.A05(A89);
                A04(view);
                return;
            }
            throw new RuntimeException(A01(14, 43, 39) + view);
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0H(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int A00;
        if (i2 < 0) {
            A00 = this.A01.A5w();
        } else {
            A00 = A00(i2);
        }
        C05563i c05563i = this.A00;
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        A04[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        c05563i.A07(A00, z);
        if (z) {
            A03(view);
        }
        this.A01.A3R(view, A00, layoutParams);
    }

    public final void A0I(View view, int i2, boolean z) {
        int A00;
        if (i2 < 0) {
            A00 = this.A01.A5w();
        } else {
            A00 = A00(i2);
        }
        this.A00.A07(A00, z);
        if (z) {
            A03(view);
        }
        this.A01.addView(view, A00);
    }

    public final void A0J(View view, boolean z) {
        A0I(view, -1, z);
    }

    public final boolean A0K(View view) {
        return this.A02.contains(view);
    }

    public final boolean A0L(View view) {
        int A89 = this.A01.A89(view);
        if (A89 == -1) {
            A04(view);
            if (A04[5].charAt(2) != 'B') {
                throw new RuntimeException();
            }
            A04[0] = "HipCYWSrBpzIS13Odtj";
            return true;
        } else if (this.A00.A08(A89)) {
            this.A00.A09(A89);
            A04(view);
            this.A01.ADe(A89);
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 53) + this.A02.size();
    }
}
