package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bZ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1464bZ implements InterfaceC05573j {
    public static byte[] A01;
    public static String[] A02 = {"m0v39bkLL0n2S0xNgN89hz2dGOcTpwho", "Je1TSnUfgjz87J45b10M9zAxXIUpZahJ", "5NPz60Ycb2xlrnlJbjQuqitLPDDjbzHA", "GN4TkK3T6zCNiBjoupvxTPY", "uEyRXI1LEgEguUOEBvXDLSZ", "uM6injuc1j2LJ4wHPsuMaMxVec9yzmkB", "WB5Y9xOLXhFok7BjZ8qu5ygjzkxXvdjS", "QTx8NC78KyDJtqbkFzNokRxLjqTFyIiz"};
    public final /* synthetic */ C0828Eq A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-39, -9, 2, 2, -5, -6, -74, -9, 10, 10, -9, -7, -2, -74, 5, 4, -74, -9, -74, -7, -2, -1, 2, -6, -74, Draft_75.CR, -2, -1, -7, -2, -74, -1, 9, -74, 4, 5, 10, -74, -6, -5, 10, -9, -7, -2, -5, -6, -48, -74, -75, -77, -66, -66, -73, -74, 114, -74, -73, -58, -77, -75, -70, 114, -63, -64, 114, -77, -64, 114, -77, -66, -60, -73, -77, -74, -53, 114, -74, -73, -58, -77, -75, -70, -73, -74, 114, -75, -70, -69, -66, -74, 114};
    }

    static {
        A01();
    }

    public C1464bZ(C0828Eq c0828Eq) {
        this.A00 = c0828Eq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void A3R(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AbstractC05784e A0G = C0828Eq.A0G(view);
        if (A0G != null) {
            if (A0G.A0e() || A0G.A0h()) {
                A0G.A0P();
            } else {
                throw new IllegalArgumentException(A00(0, 48, 113) + A0G + this.A00.A1I());
            }
        }
        this.A00.attachViewToParent(view, i2, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void A4k(int i2) {
        AbstractC05784e A0G;
        View A5v = A5v(i2);
        if (A5v != null && (A0G = C0828Eq.A0G(A5v)) != null) {
            if (!A0G.A0e() || A0G.A0h()) {
                A0G.A0T(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 45) + A0G + this.A00.A1I());
            }
        }
        this.A00.detachViewFromParent(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final View A5v(int i2) {
        return this.A00.getChildAt(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final int A5w() {
        return this.A00.getChildCount();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final AbstractC05784e A5z(View view) {
        return C0828Eq.A0G(view);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final int A89(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void AAU(View view) {
        AbstractC05784e A0G = C0828Eq.A0G(view);
        if (A0G != null) {
            A0G.A07(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void AAy(View view) {
        AbstractC05784e A0G = C0828Eq.A0G(view);
        if (A0G != null) {
            A0G.A08(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void ADa() {
        int i2 = A5w();
        for (int i3 = 0; i3 < i2; i3++) {
            View A5v = A5v(i3);
            this.A00.A1i(A5v);
            A5v.clearAnimation();
        }
        this.A00.removeAllViews();
        String[] strArr = A02;
        if (strArr[3].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A02[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void ADe(int i2) {
        View childAt = this.A00.getChildAt(i2);
        if (childAt != null) {
            this.A00.A1i(childAt);
            childAt.clearAnimation();
        }
        C0828Eq c0828Eq = this.A00;
        if (A02[2].charAt(25) == 'R') {
            throw new RuntimeException();
        }
        A02[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
        c0828Eq.removeViewAt(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05573j
    public final void addView(View view, int i2) {
        this.A00.addView(view, i2);
        this.A00.A1h(view);
    }
}
