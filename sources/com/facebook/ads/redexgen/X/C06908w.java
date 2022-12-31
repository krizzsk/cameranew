package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.8w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06908w {
    public static byte[] A01;
    public static String[] A02 = {"4UXivJ9bWzVmUKEORuimcsc25E9yHKjM", "eA36e27H2SQKTgfHA43cU1z3ajsDp04A", "C0QLMKXu1JepGMQqxbYq5t6gzwkqhJGP", "Vxu4w1TEkVm1YGegZeLuyUzWRGhVVehU", "9DWEeZJi13noDyT5Fh2XUwX4KzxcmXKd", "eTzqs10iSeQQ2KrnCOv26Mt4rNMbsJLV", "s8UczS0FAxqS0Axd9J", "JShALZiYLlnObKc6igiSgdntorMevFdl"};
    public static final String A03;
    public final C8J A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-17, -4, -14, 0, -3, -9, -14, -68, -2, -13, 0, -5, -9, 1, 1, -9, -3, -4, -68, -48, -41, -36, -46, -19, -49, -47, -47, -45, -31, -31, -41, -48, -41, -38, -41, -30, -25, -19, -31, -45, -32, -28, -41, -47, -45, -47, -49, -40, -49, -36, -45, -51, -13, -21, -14, -15, -24};
    }

    static {
        A01();
        A03 = Build.VERSION.RELEASE;
    }

    public C06908w(C8J c8j) {
        this.A00 = c8j;
    }

    public final int A02() {
        return LP.A01(this.A00);
    }

    @SuppressLint({"CatchGeneralException"})
    public final int A03() {
        try {
            return this.A00.getPackageManager().getPackageInfo(A06(), 0).versionCode;
        } catch (Throwable th) {
            this.A00.A06().A8q(A00(45, 7, 22), C06808m.A1A, new C06818n(th));
            return 0;
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final String A04() {
        try {
            CharSequence applicationLabel = this.A00.getPackageManager().getApplicationLabel(this.A00.getPackageManager().getApplicationInfo(A06(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            this.A00.A06().A8q(A00(45, 7, 22), C06808m.A1A, new C06818n(th));
        }
        if (A02[6].length() != 18) {
            throw new RuntimeException();
        }
        A02[6] = "1fZ6UIp0jk3A9Vyxip";
        return A00(0, 0, 80);
    }

    @SuppressLint({"CatchGeneralException"})
    public final String A05() {
        String str = null;
        try {
            str = this.A00.getPackageManager().getPackageInfo(A06(), 0).versionName;
        } catch (Throwable th) {
            this.A00.A06().A98(A00(45, 7, 22), C06808m.A1A, new C06818n(th));
        }
        return !TextUtils.isEmpty(str) ? str : A00(0, 0, 80);
    }

    public final String A06() {
        int i2;
        if (Build.VERSION.SDK_INT >= 23) {
            i2 = 67108864;
        } else {
            i2 = 0;
        }
        PendingIntent activity = PendingIntent.getActivity(this.A00, 0, new Intent(), i2);
        if (activity == null) {
            return A00(0, 0, 80);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.getCreatorPackage();
        }
        return activity.getTargetPackage();
    }

    public final String A07() {
        String networkOperatorName;
        TelephonyManager telephonyManager = (TelephonyManager) this.A00.getSystemService(A00(52, 5, 47));
        if (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null || networkOperatorName.length() <= 0) {
            String[] strArr = A02;
            if (strArr[5].charAt(29) != strArr[2].charAt(29)) {
                throw new RuntimeException();
            }
            A02[0] = "4uAFXpJjJNyMuVCL4IR188dhDRybrTml";
            return A00(0, 0, 80);
        }
        return networkOperatorName;
    }

    public final String A08() {
        if (Build.MANUFACTURER != null) {
            int length = Build.MANUFACTURER.length();
            String[] strArr = A02;
            if (strArr[5].charAt(29) != strArr[2].charAt(29)) {
                throw new RuntimeException();
            }
            A02[0] = "4KWcrXNI2CiMu5mhxtQIP5VVZPBJmlLQ";
            if (length > 0) {
                return Build.MANUFACTURER;
            }
        }
        return A00(0, 0, 80);
    }

    public final String A09() {
        return (Build.MODEL == null || Build.MODEL.length() <= 0) ? A00(0, 0, 80) : Build.MODEL;
    }

    @SuppressLint({"CatchGeneralException"})
    public final String A0A() {
        String installer_name;
        try {
            String A06 = A06();
            if (A06 != null && A06.length() >= 0 && (installer_name = this.A00.getPackageManager().getInstallerPackageName(A06)) != null) {
                if (installer_name.length() > 0) {
                    return installer_name;
                }
            }
        } catch (Throwable th) {
            this.A00.A06().A98(A00(45, 7, 22), C06808m.A1A, new C06818n(th));
        }
        return A00(0, 0, 80);
    }

    public final boolean A0B() {
        return this.A00.checkCallingOrSelfPermission(A00(0, 45, 58)) == 0;
    }
}
