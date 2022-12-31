package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.File;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* renamed from: com.facebook.ads.redexgen.X.9B  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9B {
    public static byte[] A00;
    public static String[] A01 = {"Zl9Gy", "71kQi3IibsstuH4HIc9NqplK3KKhyeB5", "mg3crekamZV3aPoxR2E4kv0bqU3kjrTA", "tDWcsuqYwEAdFujtzhVkOh2ka7NI4A0", "PNHzgcYnRnalJ1JX3eWvzB80MfZWvl", "qlQSSPcQAlkQmsVxSKI5q3x7hOoP3mTT", "zrCnzE5ZwKYUMsAQc774FEfNlTnoEqKy", "Bh9hDulTgnsRRUxUYqeR6BXC7"};
    public static final String A02;
    public static final AtomicBoolean A03;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{19, 39, 90, 78, 81, 73, 40, 84, 83, 75, 78, 76, 40, 85, 75, 89, 86, 80, 75, 7, 58, 43, 50, 7, 73, 92, 80, 83, 91, 7, 77, 86, 89, 7, 95, 31, 29, 14, 33, 21, 24, 16, 43, 32, 37, 28, 17, -34, 10, 16, 7, -1, -69, 9, 10, 15, -69, -4, -1, -1, -69, 11, -4, Draft_75.CR, -4, 8, 0, 15, 0, Draft_75.CR, -43, -82, -81, -84, -65, -79, 41, 81, 89, 80, 69, 88, 83, 86, -3, 27, 36, 47, 35, 37, 42, 31, 37, 36, 7, -24, -6, -2, Draft_75.CR, 8, -4, 16, 6, 23, 2, 59, 74, 74, 57, 77, 78, 59, 76, 78, 63, 62, 57, 76, 63, 59, 77, 73, 72, 43, 62, 50, 53, 45, 40, 61, 66, 57, 46, 10, 11, 8, 27, Draft_75.CR, 5, 28, 7, 18, 27, 11, 69, 67, 76, 67, 80, 71, 65, 52, 60, 60, 52, 57, 50, 44, 64, 49, 56, 65, 75, 55, 60, 61, 58, 77, 63, 63, 57, 58, 68, 61, 81, 91, 71, 77, 85, 93, 38, 27, 31, 23, 44, 33, 32, 23, 17, 33, 24, 24, 37, 23, 38, 59, 52, 49, 52, 53, 61, 52};
    }

    static {
        A06();
        A02 = C9B.class.getSimpleName();
        A03 = new AtomicBoolean();
    }

    public static int A00() {
        return TimeZone.getDefault().getRawOffset();
    }

    public static long A01(C8J c8j) {
        try {
            PackageManager packageManager = c8j.getPackageManager();
            if (packageManager == null) {
                return -1L;
            }
            return new File(packageManager.getApplicationInfo(c8j.getPackageName(), 0).publicSourceDir).length();
        } catch (Exception e2) {
            if (A03.compareAndSet(false, true)) {
                c8j.A06().A8q(A02(IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 7, 117), C06808m.A13, new C06818n(e2));
            }
            return -1L;
        }
    }

    @Nullable
    public static String A03(Context context) {
        try {
            return (String) Class.forName(context.getPackageName() + A02(0, 12, 124)).getDeclaredField(A02(37, 10, 99)).get(null);
        } catch (Exception unused) {
            return A02(94, 3, 80);
        }
    }

    public static String A04(Context context) {
        try {
            return String.valueOf(Class.forName(context.getPackageName() + A02(0, 12, 124)).getDeclaredField(A02(71, 5, 1)).getBoolean(null));
        } catch (Exception unused) {
            return A02(94, 3, 80);
        }
    }

    public static String A05(C8J c8j) {
        JSONObject jSONObject = new JSONObject();
        A07(c8j, jSONObject, A02(174, 6, 127), String.valueOf(A08()));
        A07(c8j, jSONObject, A02(97, 8, 52), String.valueOf(A01(c8j)));
        A07(c8j, jSONObject, A02(BaseBlurEffect.ROTATION_180, 15, 73), String.valueOf(A00()));
        A07(c8j, jSONObject, A02(105, 18, 113), String.valueOf(L5.A01(c8j)));
        A07(c8j, jSONObject, A02(161, 13, 111), String.valueOf(A09(c8j)));
        A07(c8j, jSONObject, A02(133, 11, 61), A04(c8j));
        A07(c8j, jSONObject, A02(123, 10, 96), A03(c8j));
        return jSONObject.toString();
    }

    public static void A07(C8J c8j, JSONObject jSONObject, String str, @Nullable String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            if (c8j.A03().A8H()) {
                Log.e(A02, A02(47, 24, 50), e2);
            }
        }
    }

    public static boolean A08() {
        String str = Build.FINGERPRINT;
        String A022 = A02(IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 7, 117);
        if (!str.contains(A022) && !Build.FINGERPRINT.startsWith(A02(195, 7, 93))) {
            String str2 = Build.MODEL;
            String A023 = A02(151, 10, 100);
            boolean contains = str2.contains(A023);
            String[] strArr = A01;
            if (strArr[2].charAt(18) != strArr[1].charAt(18)) {
                String[] strArr2 = A01;
                strArr2[2] = "pyp5tHHiNqtWEHhOUDcaxWXpzbT8klnO";
                strArr2[1] = "oLUMgMxReJrH8Y2AxnJ9tXY49GWGMSpB";
                if (!contains) {
                    String str3 = Build.MODEL;
                    if (A01[3].length() == 31) {
                        A01[3] = "kPRAmUopJCVKL3kgnj9rN6E7NTwJXhY";
                        if (!str3.contains(A02(76, 8, 123)) && !Build.MODEL.contains(A02(12, 25, 126)) && !Build.MANUFACTURER.contains(A02(84, 10, 77)) && ((!Build.BRAND.startsWith(A022) || !Build.DEVICE.startsWith(A022)) && !A023.equals(Build.PRODUCT))) {
                            return false;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return true;
    }

    public static boolean A09(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
