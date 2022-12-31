package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.8r  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06858r {
    public static byte[] A00;
    public static String[] A01 = {"a6IxlCkVmcf1QOD6ZYjDV7INHBfwC5pE", "pjHGmgbtiOqji60ouNqSwKm8iDwdL2il", "jT1wBn6CKnjHaXeX1", "64rNhN6ZFhDWGxpIQ", "ze8vByysvbBiliYVuotBM6Di85tpEUzv", "oRRmyqjSmqskFAvbDRZ10d57ZrKFDjEI", "44vbl6FfanMIMy7ytQNCDD1eXfOrnFTF", "rkbwsxy0OcV7GrP7ELmdkRDeQR2uGuGh"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] - i4;
            if (A01[1].charAt(1) == 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "1M2Y98BwTvEPUGLlCwxj254fliWahs1n";
            strArr[0] = "azYACSqPfJkxfvivKERNz1YXvsYHtm8K";
            copyOfRange[i5] = (byte) (i6 - 68);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-47, -12, -20, -20, -18, -13, -20, -91, -45, -22, -7, -4, -12, -9, -16, -91, -54, -5, -22, -13, -7, -52, -35, -38, -55, -36, -47, -41, -42, 28, 41, 41, 38, 41, -9, 3, 3, -1, -18, 2, 3, -16, 3, 4, 2, -18, -14, -2, -13, -12, 22, Draft_75.CR, 28, 31, 23, 26, 19, -38, -53, -29, -42, -39, -53, -50, -55, -35, -45, -28, -49, 15, 16, -3, 14, 16, -5, 16, 5, 9, 1, -40, -45, -49, -46, -60, -57, -62, -42, -52, -35, -56};
    }

    static {
        A02();
    }

    public static JSONObject A01(C8J c8j, long j2, long j3, long j4, long j5, int i2, @Nullable Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 88), j2);
                try {
                    jSONObject.put(A00(21, 8, 36), j3 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 38), j4);
                        try {
                            jSONObject.put(A00(79, 11, 31), j5);
                            try {
                                jSONObject.put(A00(34, 16, 75), i2);
                                if (exc != null) {
                                    jSONObject.put(A00(29, 5, 115), exc.getMessage());
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                c8j.A06().A3P(e);
                                return jSONObject;
                            }
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                    }
                } catch (JSONException e5) {
                    e = e5;
                }
            } catch (JSONException e6) {
                e = e6;
            }
        } catch (JSONException e7) {
            e = e7;
        }
        return jSONObject;
    }

    public static void A03(C8J c8j, long j2, long j3, long j4, long j5, int i2, @Nullable Exception exc) {
        C06818n c06818n = new C06818n(A00(0, 21, 65));
        c06818n.A03(1);
        c06818n.A05(A01(c8j, j2, j3, j4, j5, i2, exc));
        c8j.A06().A9G(A00(50, 7, 100), C06808m.A1n, c06818n);
    }
}
