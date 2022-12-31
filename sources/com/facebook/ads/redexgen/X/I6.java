package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* loaded from: assets/audience_network.dex */
public final class I6 {
    public static int A00(int i2, int i3, int i4) {
        if (i2 >= i3 && i2 < i4) {
            return i2;
        }
        throw new IndexOutOfBoundsException();
    }

    @EnsuresNonNull({"#1"})
    public static <T> T A01(@Nullable T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    @EnsuresNonNull({"#1"})
    public static String A02(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static void A03(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void A04(boolean z) {
        if (z) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void A05(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void A06(boolean z, Object obj) {
        if (z) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }
}
