package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
@RequiresApi(21)
/* loaded from: assets/audience_network.dex */
public class F0 extends C1478bn {
    public static byte[] A00;
    public static String[] A01 = {"lLTnlT7kdgZgpONat", "d79paUk3eSzGphhSN42PN5Aq8dj9iVyl", "SPt342n", "OIl1JjPDUNYuj0Z8zSbytdcas", "BSu1Ds7nymHwzPjWE4jzwGDd8JkRRJPQ", "PB1eQ9fbEyjMYRd9wV6iR7DUEeVSeCVP", "JUVWQPWt2QIcAEqAV6T0sxDALqwyj", "zKN2MvPWkZddLmlUYuVLkoywXLI"};

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[7].length() == 21) {
                throw new RuntimeException();
            }
            A01[7] = "QKmrPpG47xHIA";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 58);
            i5++;
        }
    }

    public static void A02() {
        A00 = new byte[]{79, 11, 0, 10, 28, 79, 1, 0, 27, 79, 6, 2, 31, 3, 10, 2, 10, 1, 27, 79, 6, 1, 27, 10, 29, 9, 14, 12, 10, 79, 2, 10, 27, 7, 0, 11, 79, 0, 1, 33, 10, 28, 27, 10, 11, 41, 3, 6, 1, 8, 125, 57, 50, 56, 46, 125, 51, 50, 41, 125, 52, 48, 45, 49, 56, 48, 56, 51, 41, 125, 52, 51, 41, 56, 47, 59, 60, 62, 56, 125, 48, 56, 41, 53, 50, 57, 125, 50, 51, 19, 56, 46, 41, 56, 57, Draft_75.CR, 47, 56, 27, 49, 52, 51, 58, 5, 65, 74, 64, 86, 5, 75, 74, 81, 5, 76, 72, 85, 73, 64, 72, 64, 75, 81, 5, 76, 75, 81, 64, 87, 67, 68, 70, 64, 5, 72, 64, 81, 77, 74, 65, 5, 74, 75, 107, 64, 86, 81, 64, 65, 117, 87, 64, 118, 70, 87, 74, 73, 73, 3, 71, 76, 70, 80, 3, 77, 76, 87, 3, 74, 78, 83, 79, 70, 78, 70, 77, 87, 3, 74, 77, 87, 70, 81, 69, 66, 64, 70, 3, 78, 70, 87, 75, 76, 71, 3, 76, 77, 109, 70, 80, 87, 70, 71, 112, 64, 81, 76, 79, 79, 35, 103, 108, 102, 112, 35, 109, 108, 119, 35, 106, 110, 115, 111, 102, 110, 102, 109, 119, 35, 106, 109, 119, 102, 113, 101, 98, 96, 102, 35, 110, 102, 119, 107, 108, 103, 35, 108, 109, 77, 102, 112, 119, 102, 103, 80, 96, 113, 108, 111, 111, 66, 96, 96, 102, 115, 119, 102, 103, 81, 21, 30, 20, 2, 81, 31, 30, 5, 81, 24, 28, 1, 29, 20, 28, 20, 31, 5, 81, 24, 31, 5, 20, 3, 23, 16, 18, 20, 81, 28, 20, 5, 25, 30, 21, 81, 30, 31, 34, 5, 16, 3, 5, 63, 20, 2, 5, 20, 21, 34, 18, 3, 30, 29, 29, 47, 107, 96, 106, 124, 47, 97, 96, 123, 47, 102, 98, Byte.MAX_VALUE, 99, 106, 98, 106, 97, 123, 47, 102, 97, 123, 106, 125, 105, 110, 108, 106, 47, 98, 106, 123, 103, 96, 107, 47, 96, 97, 92, 123, 96, Byte.MAX_VALUE, 65, 106, 124, 123, 106, 107, 92, 108, 125, 96, 99, 99, 75, 116, 120, 106, 77, 124, 111, 120, 115, 105, 61, 80, 111, 99, 113, 86, 103, 116, 99, 104, 114, 69, 105, 107, 118, 103, 114};
    }

    static {
        A02();
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final void A03(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(323, 55, 53), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final void A04(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
        try {
            viewParent.onNestedScroll(view, i2, i3, i4, i5);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(157, 51, 25), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final void A05(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view, i2, i3, iArr);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(103, 54, 31), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final void A06(ViewParent viewParent, View view, View view2, int i2) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i2);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(208, 59, 57), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final boolean A07(ViewParent viewParent, View view, float f2, float f3) {
        try {
            return viewParent.onNestedPreFling(view, f2, f3);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(50, 53, 103), e2);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final boolean A08(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        try {
            return viewParent.onNestedFling(view, f2, f3, z);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(0, 50, 85), e2);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3G
    public final boolean A09(ViewParent viewParent, View view, View view2, int i2) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i2);
        } catch (AbstractMethodError e2) {
            Log.e(A01(389, 16, 60), A01(378, 11, 39) + viewParent + A01(267, 56, 75), e2);
            return false;
        }
    }
}
