package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Je  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0940Je {
    public static byte[] A00;
    public static String[] A01 = {"8rCQ87LDNJC1DhxZ6fCr2sl9z", "5Hodpo98FOR", "IALBcgKUANLjYRQ96HtZ7fzkbeR9jBcx", "zTQAh3vDqOojvZYlgAqVeqBvFcLoF4J3", "z7HIEgV6NC3", "WxYOl0mgWg7jzfrY8MiYRxzCEbOVsE5E", "Fx", "GTrmlcJrnfi84XLQulxC5fcTBIr6OicG"};
    public static final String A02;
    public static final Map<String, Integer> A03;
    public static final AtomicInteger A04;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{57, 43, 89, 112, -126, 43, -127, 108, 119, Byte.MIN_VALUE, 112, 69, 43, 96, 111, 87, 124, -122, -125, 116, -121, 118, 123, 124, -127, 122, 51, Byte.MAX_VALUE, -126, 118, 116, Byte.MAX_VALUE, 51, 118, -126, -120, -127, -121, 120, -123, -122, 77, 51, 122, -97, -108, -93, -106, -98, -106, -97, -91, -102, -97, -104, 81, -108, -96, -90, -97, -91, -106, -93, 107, 81, -56, -21, -33, -35, -24, -65, -21, -15, -22, -16, -31, -18, -17, 116, 119, 119, 124, -121, 124, -126, -127, 116, Byte.MAX_VALUE, 114, 124, -127, 121, -126, -43, -24, -24, -39, -31, -28, -24, -111, -113, -93, -107, -106, -94, -115, -109, -90, -111, -109, -98, -94, -105, -99, -100, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -69, -66, -78, -80, -69, -50, -78, -66, -60, -67, -61, -76, -63, -62, -103, -106, -87, -106, -42, -25, -42, -33, -27, -28, -49, -46, -58, -60, -49, -62, -58, -46, -40, -47, -41, -56, -43, -42, -121, 120, -112, -125, -122, 120, 123, -95, -94, -113, -111, -103, -94, -96, -113, -111, -109, -124, -122, 115, -123, -118, -127, 118, -37, -35, -54, -36, -31, -40, -51, -57, -53, -41, -52, -51};
    }

    static {
        A04();
        A02 = C0940Je.class.getSimpleName();
        A04 = new AtomicInteger(0);
        A03 = new HashMap();
    }

    public static /* synthetic */ String A00() {
        String str = A02;
        if (A01[0].length() != 25) {
            throw new RuntimeException();
        }
        A01[5] = "AE0Gj58Mw00GT5T1b1OvPEW6lBfcUrG3";
        return str;
    }

    public static /* synthetic */ Map A02() {
        Map<String, Integer> map = A03;
        if (A01[2].charAt(23) != '7') {
            String[] strArr = A01;
            strArr[1] = "kE3yWNDHHw7";
            strArr[4] = "pIXzG0En7nL";
            return map;
        }
        throw new RuntimeException();
    }

    public static void A05(C8J c8j) {
        if (A0B(c8j)) {
            return;
        }
        synchronized (C0940Je.class) {
            if (A04.get() != 0) {
                return;
            }
            A04.set(1);
            MA.A06.execute(new U2(c8j));
        }
    }

    public static void A06(C8J c8j, InterfaceC1116Qf interfaceC1116Qf, Map<String, ?> map) throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(93, 7, 109), A01(13, 1, 41));
        A09(c8j, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A01(188, 7, 10), A01(157, 14, 92));
        hashMap2.put(A01(195, 12, 97), String.valueOf(3501));
        hashMap2.put(A01(100, 16, 39), A01(14, 1, 55));
        hashMap2.put(A01(178, 10, 39), A01(65, 13, 117));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (BuildConfigApi.isDebug()) {
            String str = A01(15, 28, 12) + jSONObject.toString(2);
        }
        hashMap2.put(A01(78, 15, 12), jSONObject.toString());
        A09(c8j, hashMap2);
        C9C A07 = c8j.A07();
        JSONObject A05 = C06828o.A05(new C06848q(A07.A01(), A07.A02(), hashMap2));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(A05);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject eventsJSON = new JSONObject(hashMap);
        jSONObject2.put(A01(147, 4, 46), eventsJSON);
        jSONObject2.put(A01(151, 6, 106), jSONArray);
        C1130Qt c1130Qt = new C1130Qt();
        c1130Qt.put(A01(171, 7, 16), jSONObject2.toString());
        interfaceC1116Qf.ACu(c8j.A03().A6a(), c1130Qt.A08(), new U1());
    }

    public static void A08(C8J c8j, String str) {
        int i2;
        if (A0B(c8j)) {
            return;
        }
        synchronized (C0940Je.class) {
            if (A04.get() != 2) {
                i2 = (A03.containsKey(str) ? A03.get(str).intValue() : 0) + 1;
                A03.put(str, Integer.valueOf(i2));
            } else {
                SharedPreferences sharedPreferences = c8j.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(116, 31, 104), c8j), 0);
                i2 = sharedPreferences.getInt(str, 0) + 1;
                sharedPreferences.edit().putInt(str, i2).apply();
            }
            if (BuildConfigApi.isDebug()) {
                String str2 = A01(43, 22, 42) + str + A01(0, 13, 4) + i2;
            }
        }
    }

    public static void A09(C8J c8j, Map<String, String> map) {
        Map<String, String> dataMap = c8j.A02().A4R();
        map.putAll(dataMap);
    }

    @VisibleForTesting
    public static boolean A0A(double d2, int i2) {
        return i2 <= 0 || d2 >= 1.0d / ((double) i2);
    }

    public static boolean A0B(C8J c8j) {
        if (BuildConfigApi.isDebug()) {
            return false;
        }
        if (!JF.A0U(c8j)) {
            return true;
        }
        return A0A(c8j.A07().A00(), JF.A0C(c8j));
    }
}
