package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3H {
    public static byte[] A00;
    public static final C3G A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{115, 114, 82, 121, 111, 104, 121, 120, 76, 110, 121, 79, Byte.MAX_VALUE, 110, 115, 112, 112, 6, 7, 39, 12, 26, 29, 12, Draft_75.CR, 58, 10, 27, 6, 5, 5, 119, 118, 86, 125, 107, 108, 125, 124, 75, 123, 106, 119, 116, 116, 89, 123, 123, 125, 104, 108, 125, 124, 126, Byte.MAX_VALUE, 66, 101, 126, 97, 95, 116, 98, 101, 116, 117, 66, 114, 99, 126, 125, 125};
    }

    static {
        A01();
        if (Build.VERSION.SDK_INT >= 21) {
            A01 = new F0();
        } else if (Build.VERSION.SDK_INT >= 19) {
            A01 = new C1478bn();
        } else {
            A01 = new C3G();
        }
    }

    public static void A02(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof InterfaceC1482bs) {
            throw new NullPointerException(A00(53, 18, 81));
        }
        if (i2 == 0) {
            A01.A03(viewParent, view);
        }
    }

    public static void A03(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6) {
        if (viewParent instanceof InterfaceC1482bs) {
            throw new NullPointerException(A00(17, 14, 41));
        }
        if (i6 == 0) {
            A01.A04(viewParent, view, i2, i3, i4, i5);
        }
    }

    public static void A04(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof InterfaceC1482bs) {
            throw new NullPointerException(A00(0, 17, 92));
        }
        if (i4 == 0) {
            A01.A05(viewParent, view, i2, i3, iArr);
        }
    }

    public static void A05(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof InterfaceC1482bs) {
            throw new NullPointerException(A00(31, 22, 88));
        }
        if (i3 == 0) {
            A01.A06(viewParent, view, view2, i2);
        }
    }

    public static boolean A06(ViewParent viewParent, View view, float f2, float f3) {
        return A01.A07(viewParent, view, f2, f3);
    }

    public static boolean A07(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        return A01.A08(viewParent, view, f2, f3, z);
    }

    public static boolean A08(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof InterfaceC1482bs) {
            return ((InterfaceC1482bs) viewParent).onStartNestedScroll(view, view2, i2, i3);
        }
        if (i3 == 0) {
            return A01.A09(viewParent, view, view2, i2);
        }
        return false;
    }
}
