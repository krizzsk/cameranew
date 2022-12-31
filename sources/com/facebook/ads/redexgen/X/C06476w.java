package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06476w {
    public static byte[] A05;
    public static String[] A06 = {"QeTecly5r3Ba9bHxC0wnpwdEUUrllzAy", "bEKXjPHxcJpa33XPuxx9BYS1WkIWy1gs", "BPs32rsczNPcksI72EKceZ8Ar9gsVFHv", "FBB0uSbaSxXulSlT7i8POlQBv6IvoYbu", "257ROLF87E57WLAlEBuIH5iygOG", "iPGaCxtdoC1kQbSunDLBqq3asDJIWzdx", "WqxRMthVFYlWmP0w7krXRzIuJmv", "wi3XTjuoHO8yYyadkxm6GwkGNAvhEA1y"};
    public static final String A07;
    public final int A00;
    public final EnumC06466v A01;
    @Nullable
    public final String A02;
    @Nullable
    public final String A03;
    @Nullable
    public final String A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A06;
            if (strArr[2].charAt(1) != strArr[5].charAt(1)) {
                throw new RuntimeException();
            }
            A06[3] = "Uh6rCcqYck9NcAhTNlTmwzqgbCEX7K96";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 72);
            i5++;
        }
    }

    public static void A01() {
        A05 = new byte[]{-55, -10, -10, -13, -10, -92, -57, -10, -23, -27, -8, -19, -14, -21, -92, -50, -41, -45, -46, 31, 29, 9, 17, -4, 5, 11, 25};
    }

    static {
        A01();
        A07 = C06476w.class.getSimpleName();
    }

    public C06476w(EnumC06466v enumC06466v) {
        this.A01 = enumC06466v;
        this.A00 = enumC06466v.A02();
        this.A03 = null;
        this.A02 = null;
        this.A04 = null;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public C06476w(Throwable th) {
        String stackTraceElement;
        this.A01 = EnumC06466v.A08;
        this.A00 = th.getClass().getName().hashCode();
        this.A03 = th.getClass().getName();
        this.A02 = th.getMessage();
        if (th.getStackTrace() != null && th.getStackTrace().length > 1 && th.getStackTrace().toString().length() > 500) {
            stackTraceElement = th.getStackTrace()[0].toString().substring(0, 500);
        } else {
            stackTraceElement = th.getStackTrace()[0].toString();
        }
        this.A04 = stackTraceElement;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        String str = this.A03;
        int length = (str != null ? str.getBytes().length : 0) + 4;
        String str2 = this.A02;
        int length2 = length + (str2 != null ? str2.getBytes().length : 0);
        String str3 = this.A04;
        return length2 + (str3 != null ? str3.getBytes().length : 0);
    }

    public final EnumC06466v A04() {
        return this.A01;
    }

    @Nullable
    public final String A05() {
        return this.A02;
    }

    @Nullable
    public final String A06() {
        return this.A03;
    }

    @Nullable
    public final String A07() {
        return this.A04;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public final JSONObject A08() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i2 = C06456u.A00[this.A01.ordinal()];
            String A00 = A00(19, 2, 114);
            if (i2 != 1) {
                jSONObject.put(A00, this.A00);
            } else {
                jSONObject.put(A00, this.A00);
                jSONObject.put(A00(23, 2, 79), this.A03);
                jSONObject.put(A00(21, 2, 92), this.A02);
                jSONObject.put(A00(25, 2, 94), this.A04);
            }
        } catch (JSONException e2) {
            Log.e(A07, A00(0, 19, 60), e2);
        }
        return jSONObject;
    }
}
