package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.6D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6D {
    public static C6C A00;
    public static byte[] A01;
    public static String[] A02 = {"sp1TByEGG7e0GADwDzlASPV0aap3ieHh", "uzFI86KB8SuPvllmns5EhrThmrxeiZB", "WffZMJDQYz5YPWrNy4ctgABXEOCgIES3", "xNvoCKy4p7HAo2gXsjU", "die", "gYyZIkzjV9FAWz0BtKI", "Id5RyLkBfkqUUkVvBGvirNkAkhkz8uh0", "U7WQUa4wbg5Ag319WkF2HwzvOv4zz"};
    public static final String A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {20, 71, 50, 52, 63, 67, 56, 62, 61, -17, 51, 68, 65, 56, 61, 54, -17, 52, 71, 52, 50, 68, 67, 56, 62, 61, -3};
        String[] strArr = A02;
        if (strArr[3].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A02[0] = "lreKiDhdf1OAP";
        A01 = bArr;
    }

    static {
        A01();
        A03 = C6D.class.getSimpleName();
    }

    public static void A02(C6C c6c) {
        A00 = c6c;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static void A03(Throwable th) {
        C6C c6c = A00;
        if (c6c != null) {
            c6c.ADj(th);
        } else {
            Log.e(A03, A00(0, 27, 89), th);
        }
    }
}
