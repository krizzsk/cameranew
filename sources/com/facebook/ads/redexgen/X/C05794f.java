package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.4f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05794f {
    public static String[] A00 = {"UqypfisWbLbbWLDfIVvpiaUsz0iS", "wEiCJDeLGzLJebV", "cX", "dRMEhdR7kDOm9Ob", "SmhGT229bW5LAFpAZzaxeRYqKvMDeGhX", "QcSoUKFtoryhyFMFYIfDI81ChPsDlMu7", "SBvSWfqovIH0ljTVzoffsyrdWCNw", "n"};

    public static int A00(C05754b c05754b, AnonymousClass46 anonymousClass46, View view, View view2, C4M c4m, boolean z) {
        if (c4m.A0W() == 0 || c05754b.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c4m.A0p(view) - c4m.A0p(view2)) + 1;
        }
        int A0C = anonymousClass46.A0C(view2);
        int A0F = anonymousClass46.A0F(view);
        String[] strArr = A00;
        if (strArr[4].charAt(28) != strArr[5].charAt(28)) {
            String[] strArr2 = A00;
            strArr2[3] = "xd2oZUwi45Npmqe";
            strArr2[1] = "1k2xoHfklbXXQiR";
            return Math.min(anonymousClass46.A0B(), A0C - A0F);
        }
        throw new RuntimeException();
    }

    public static int A01(C05754b c05754b, AnonymousClass46 anonymousClass46, View view, View view2, C4M c4m, boolean z) {
        if (c4m.A0W() == 0 || c05754b.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c05754b.A03();
        }
        return (int) (((anonymousClass46.A0C(view2) - anonymousClass46.A0F(view)) / (Math.abs(c4m.A0p(view) - c4m.A0p(view2)) + 1)) * c05754b.A03());
    }

    public static int A02(C05754b c05754b, AnonymousClass46 anonymousClass46, View view, View view2, C4M c4m, boolean z, boolean z2) {
        int max;
        if (c4m.A0W() != 0) {
            int A03 = c05754b.A03();
            String[] strArr = A00;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[6] = "xSzU3PMpL9LC7k2G9V08vNIV3nIP";
            strArr2[0] = "UsrmTbcEPDcBULmsiiLKltF5MwgK";
            if (A03 != 0 && view != null && view2 != null) {
                int min = Math.min(c4m.A0p(view), c4m.A0p(view2));
                int max2 = Math.max(c4m.A0p(view), c4m.A0p(view2));
                if (z2) {
                    max = Math.max(0, (c05754b.A03() - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!z) {
                    return max;
                }
                return Math.round((max * (Math.abs(anonymousClass46.A0C(view2) - anonymousClass46.A0F(view)) / (Math.abs(c4m.A0p(view) - c4m.A0p(view2)) + 1))) + (anonymousClass46.A0A() - anonymousClass46.A0F(view)));
            }
        }
        return 0;
    }
}
