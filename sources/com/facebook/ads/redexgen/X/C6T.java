package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6T {
    public static byte[] A01;
    public static String[] A02 = {"GyiBUCkC", "sqowKkdsw23oOctujh4JS", "WS", "sGW2HqLA0299cVeMoAEL9ZXgIk1rlANi", "Ioat5RRD6XPbEJm7hsBEOKFMb", "Zw1v1TMFRqO", "eQUvG0dkOz1", "pYpbsacuB19XJGtGbFCxjlIFedam8DTp"};
    public static final String[] A03;
    public final float[] A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{21, -63, 7, -23, -33};
    }

    static {
        A01();
        A03 = new String[]{A00(2, 1, 93), A00(3, 1, 62), A00(4, 1, 51), A00(1, 1, 24)};
    }

    public C6T(float[] fArr) {
        this.A00 = fArr;
    }

    private final float[] A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A00.length * 4;
    }

    public final JSONObject A04(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        while (true) {
            float[] fArr = this.A00;
            if (i2 >= fArr.length) {
                break;
            }
            String[] strArr = A03;
            if (i2 < strArr.length) {
                jSONObject2.put(strArr[i2], fArr[i2]);
            }
            i2++;
        }
        if (A02[4].length() != 24) {
            A02[5] = "3DgDBkbuSJHHMnWd9lbj3dg5obl1cN";
            jSONObject.put(A00(0, 1, 109), jSONObject2);
            return jSONObject;
        }
        throw new RuntimeException();
    }

    public final boolean A05(C6T c6t) {
        float[] A022 = c6t.A02();
        if (A022.length != this.A00.length) {
            return false;
        }
        for (int i2 = 0; i2 < A022.length; i2++) {
            if (Math.abs(A02()[i2] - A022[i2]) > AnonymousClass61.A01()) {
                return false;
            }
        }
        return true;
    }
}
