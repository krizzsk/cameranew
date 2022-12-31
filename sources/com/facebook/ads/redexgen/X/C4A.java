package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import com.facebook.ads.redexgen.X.AbstractC05784e;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.4A  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C4A<VH extends AbstractC05784e> {
    public static byte[] A02;
    public static String[] A03 = {"W324oDAhe3QD27ZyNAxx1dE4409WhTwA", "Ikg10MzvREcGgl38", "tAS262iMJzRr57vvpxPoG7SYxewns3xN", "rCt", "3uu7", "cbDGC8uMMSmc1mSYy17nilWnTwttZfvA", "2T", "U5f6pdP97"};
    public final C4B A01 = new C4B();
    public boolean A00 = false;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[2].charAt(21) != '7') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "WHsKZN6zyncpMK6d";
            strArr[4] = "wlW4";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 32);
            i5++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-48, -44, -98, -63, -16, -29, -33, -14, -29, -44, -25, -29, -11, -54, -50, -104, -57, -26, -70, -31, -26, -36, -50, -31, -35, -17};
    }

    public abstract VH A0C(ViewGroup viewGroup, int i2);

    public abstract int A0D();

    public abstract void A0E(VH vh, int i2);

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    private final void A02(VH holder, int i2, List<Object> payloads) {
        A0E(holder, i2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final int A03(int i2) {
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final long A04(int i2) {
        return -1L;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final VH A05(ViewGroup viewGroup, int i2) {
        C2O.A01(A00(0, 13, 94));
        VH A0C = A0C(viewGroup, i2);
        A0C.A00 = i2;
        C2O.A00();
        return A0C;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final void A06() {
        this.A01.A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final void A07(C4C c4c) {
        this.A01.registerObserver(c4c);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final void A08(C4C c4c) {
        this.A01.unregisterObserver(c4c);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final void A09(VH vh, int i2) {
        vh.A03 = i2;
        if (A0A()) {
            long A04 = A04(i2);
            String[] strArr = A03;
            if (strArr[7].length() != strArr[6].length()) {
                String[] strArr2 = A03;
                strArr2[7] = "OgtetI94x";
                strArr2[6] = "QU";
                vh.A05 = A04;
            }
            throw new RuntimeException();
        }
        vh.A0U(1, 519);
        C2O.A01(A00(13, 13, 88));
        A02(vh, i2, vh.A0L());
        vh.A0N();
        ViewGroup.LayoutParams layoutParams = vh.A0H.getLayoutParams();
        if (layoutParams instanceof C4N) {
            ((C4N) layoutParams).A01 = true;
        }
        C2O.A00();
        String[] strArr3 = A03;
        if (strArr3[5].charAt(31) == strArr3[0].charAt(31)) {
            String[] strArr4 = A03;
            strArr4[7] = "GQKIQ0ZEK";
            strArr4[6] = "Zf";
            return;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final boolean A0A() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4A != com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$Adapter<VH extends com.facebook.ads.redexgen.X.4e> */
    public final boolean A0B(VH vh) {
        return false;
    }
}
