package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.WindowInsets;
/* renamed from: com.facebook.ads.redexgen.X.3I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3I {
    public static String[] A01 = {"el7YtyQobuGYp8qUnEWwGAo9eb5IMR8f", "BjlmtcQqBka41jhChDLZKaESgBphWA9m", "aKAY7r1GVGPP18xn5ioe", "SajdHZC8", "nRs3vifuwuv", "vQYmc1GWKj3CI1v3wMvKFH0VmcpB3A8S", "tuFyi1rHy9z46G0g3HP9J8Pe4WgIo7s9", "jDUjvWDGqsgivCcWfJbzlnhujFfNRoy6"};
    public final Object A00;

    public C3I(Object obj) {
        this.A00 = obj;
    }

    public static C3I A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C3I(obj);
    }

    public static Object A01(C3I c3i) {
        if (c3i == null) {
            return null;
        }
        return c3i.A00;
    }

    public final int A02() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final int A03() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int A05() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final C3I A06(int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C3I(((WindowInsets) this.A00).replaceSystemWindowInsets(i2, i3, i4, i5));
        }
        return null;
    }

    public final boolean A07() {
        if (Build.VERSION.SDK_INT >= 21) {
            Object obj = this.A00;
            if (A01[7].charAt(25) != 'F') {
                throw new RuntimeException();
            }
            A01[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
            return ((WindowInsets) obj).isConsumed();
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3I c3i = (C3I) obj;
        Object obj2 = this.A00;
        return obj2 == null ? c3i.A00 == null : obj2.equals(c3i.A00);
    }

    public final int hashCode() {
        Object obj = this.A00;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
