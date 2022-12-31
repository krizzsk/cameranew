package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5v  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06205v {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{45, 59, 16, 42, 55, 59, 61, 46, 60, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 33, 38, 60, 45, 58, 38, 41, 36, 102, 42, 60, 45, 48, 60, 58, 41, 59};
    }

    public static SharedPreferences A00(C8J c8j) {
        return c8j.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 105), c8j), 0);
    }

    @Nullable
    public final String A03(C8J c8j) {
        return A00(c8j).getString(A01(0, 9, 110), null);
    }

    public final void A04(C8J c8j, String str) {
        A00(c8j).edit().putString(A01(0, 9, 110), str).apply();
    }
}
