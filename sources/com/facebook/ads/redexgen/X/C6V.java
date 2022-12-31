package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6V  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6V {
    public static byte[] A07;
    public static String[] A08 = {"Ri7kjkDT8eD7oXZRfiWmTVhv1RjvdWrO", "cxDqg6Vwj60LwY1YIKiyT4H3eIxAUSyl", "eaEWTtVE1fja", "mvH1Awv1nxYu8upPSugfMtSiNjBS99Ai", "3uMupHsAkG9zmQtrmqj", "34ahGknslOLL", "L7UqFynmPX3bSDpWCs3", "GT67L7E4GYLk"};
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final float[] A06;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 3);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-42, -57, -61, -21, -32, -39, -47, 124, 119, -120, -124, -90, -91, -99, -99, -12, -124, -95};
    }

    static {
        A07();
    }

    public C6V(int i2, int i3, int i4, float[] fArr, float f2, float f3, float f4) {
        this.A05 = i2;
        this.A03 = i3;
        this.A04 = i4;
        this.A06 = fArr;
        this.A02 = f2;
        this.A01 = f3;
        this.A00 = f4;
    }

    private final float A00() {
        return this.A00;
    }

    private final float A01() {
        return this.A01;
    }

    private final float A02() {
        return this.A02;
    }

    private final int A03() {
        return this.A03;
    }

    private final int A04() {
        return this.A04;
    }

    private final int A05() {
        return this.A05;
    }

    private final float[] A08() {
        return this.A06;
    }

    public final int A09() {
        return 32;
    }

    public final JSONObject A0A(JSONObject pointerLocObject) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A06(0, 3, 95), this.A05);
        jSONObject.put(A06(3, 2, 116), this.A03);
        jSONObject.put(A06(13, 2, 38), this.A04);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A06(16, 1, 9), AnonymousClass78.A00(this.A06[0]));
        jSONObject2.put(A06(17, 1, 37), AnonymousClass78.A00(this.A06[1]));
        jSONObject.put(A06(5, 2, 98), jSONObject2);
        jSONObject.put(A06(11, 2, 47), AnonymousClass78.A00(this.A02));
        jSONObject.put(A06(9, 2, 17), AnonymousClass78.A00(this.A01));
        jSONObject.put(A06(7, 2, 5), AnonymousClass78.A00(this.A00));
        pointerLocObject.put(A06(15, 1, 123), jSONObject);
        return pointerLocObject;
    }

    public final boolean A0B(C6V c6v) {
        if (A05() == c6v.A05() && A03() == c6v.A03() && A04() == c6v.A04()) {
            float abs = Math.abs(A08()[0] - c6v.A08()[0]);
            String[] strArr = A08;
            if (strArr[0].charAt(29) != strArr[3].charAt(29)) {
                String[] strArr2 = A08;
                strArr2[6] = "Q56kdX7pfJkTmJKAWug";
                strArr2[4] = "SmNIYc6TXNif2amUYYL";
                if (abs < AnonymousClass61.A01() && Math.abs(A08()[1] - c6v.A08()[1]) < AnonymousClass61.A01()) {
                    int i2 = (Math.abs(A02() - c6v.A02()) > AnonymousClass61.A01() ? 1 : (Math.abs(A02() - c6v.A02()) == AnonymousClass61.A01() ? 0 : -1));
                    String[] strArr3 = A08;
                    if (strArr3[7].length() != strArr3[2].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A08;
                    strArr4[6] = "PKTdm45ZSsz2a1wWaXr";
                    strArr4[4] = "Kjnff0uul5Scqwkbf9l";
                    if (i2 < 0 && Math.abs(A01() - c6v.A01()) < AnonymousClass61.A01() && Math.abs(A00() - c6v.A00()) < AnonymousClass61.A01()) {
                        return true;
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }
}
