package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.4T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4T {
    public static String[] A02 = {"hO0SXlIn7n5HXEBLx", "jESNVpuYnHPlnh4DZ", "CDLwN7DwmtArlNd144q1QIOvLDqs4yZF", "JntNhgZ58kYFXbwiJ6hzeVdvPNGn00kF", "yTsWpbzmHeCmcQEDkb0QkT5J3TV6CkfD", "Lh9pded4Clz2", "gnDNjs3GBImfOnnM5uEQWokXBd1c", "C4tnEN178k9sL9bIxtVolUttiI5dEdE5"};
    public SparseArray<C4S> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j2, long j3) {
        if (j2 == 0) {
            return j3;
        }
        long j4 = j2 / 4;
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        A02[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        return (j4 * 3) + (j3 / 4);
    }

    private C4S A01(int i2) {
        C4S c4s = this.A00.get(i2);
        if (c4s == null) {
            C4S c4s2 = new C4S();
            this.A00.put(i2, c4s2);
            return c4s2;
        }
        return c4s;
    }

    private final void A02() {
        for (int i2 = 0; i2 < this.A00.size(); i2++) {
            this.A00.valueAt(i2).A03.clear();
        }
    }

    public final AbstractC05784e A03(int i2) {
        C4S c4s = this.A00.get(i2);
        if (c4s != null && !c4s.A03.isEmpty()) {
            ArrayList<AbstractC05784e> arrayList = c4s.A03;
            if (A02[4].charAt(1) != 'T') {
                throw new RuntimeException();
            }
            A02[6] = "6zOEmNGiTAHU1v9SGa3";
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i2, long j2) {
        C4S A01 = A01(i2);
        A01.A01 = A00(A01.A01, j2);
    }

    public final void A06(int i2, long j2) {
        C4S A01 = A01(i2);
        A01.A02 = A00(A01.A02, j2);
    }

    public final void A07(C4A c4a) {
        this.A01++;
    }

    public final void A08(C4A c4a, C4A c4a2, boolean z) {
        if (c4a != null) {
            A04();
        }
        if (!z && this.A01 == 0) {
            A02();
        }
        if (c4a2 != null) {
            A07(c4a2);
        }
    }

    public final void A09(AbstractC05784e abstractC05784e) {
        int A0H = abstractC05784e.A0H();
        ArrayList<AbstractC05784e> arrayList = A01(A0H).A03;
        if (this.A00.get(A0H).A00 <= arrayList.size()) {
            return;
        }
        abstractC05784e.A0Q();
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "TnDeXYrDbfmyODeGX";
        strArr2[5] = "ziritv0xfrad";
        arrayList.add(abstractC05784e);
    }

    public final boolean A0A(int i2, long j2, long j3) {
        long j4 = A01(i2).A01;
        return j4 == 0 || j2 + j4 < j3;
    }

    public final boolean A0B(int i2, long j2, long j3) {
        long j4 = A01(i2).A02;
        return j4 == 0 || j2 + j4 < j3;
    }
}
