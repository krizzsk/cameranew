package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1J  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1J implements Serializable {
    public static byte[] A04 = null;
    public static final long serialVersionUID = -4041915335826065133L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A03();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 66);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{91, 64, 89, 89, 82, 85, 75};
    }

    public C1J(String str, String str2, @Nullable JSONObject jSONObject, String str3) {
        this.A03 = A01(str);
        this.A02 = A01(str2);
        this.A00 = A01(str3);
        this.A01 = A02(jSONObject);
    }

    public static String A01(String str) {
        if (A00(0, 4, 119).equalsIgnoreCase(str)) {
            return A00(0, 0, 68);
        }
        return str;
    }

    private String A02(@Nullable JSONObject jSONObject) {
        String A00 = A00(0, 0, 68);
        if (jSONObject == null) {
            return A00;
        }
        return jSONObject.optString(A00(4, 3, 101), A00);
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final boolean A06() {
        return !TextUtils.isEmpty(this.A01);
    }
}
