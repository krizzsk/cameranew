package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Lf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0989Lf {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{38, 42, 40, 107, 35, 36, 38, 32, 39, 42, 42, 46, 107, 46, 36, 49, 36, 43, 36};
    }

    @Nullable
    public static PackageInfo A00(C8J c8j) {
        return A01(c8j, A02(0, 19, 59));
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static PackageInfo A01(C8J c8j, String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = c8j.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    public static boolean A04(C8J c8j, String str) {
        PackageInfo packageInfo = A01(c8j, str);
        return packageInfo != null;
    }
}
