package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.NativeAdImageApi;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Jr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0953Jr implements NativeAdImageApi {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final String A02;

    static {
        A02();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 26);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{85, 88, 84, 90, 85, 73, 92, 91, 69, 12, 18, 31, 15, 19};
    }

    public C0953Jr(String str, int i2, int i3) {
        this.A02 = str;
        this.A01 = i2;
        this.A00 = i3;
    }

    @Nullable
    public static C0953Jr A00(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString(A01(6, 3, 51))) == null) {
            return null;
        }
        return new C0953Jr(optString, jSONObject.optInt(A01(9, 5, 97), 0), jSONObject.optInt(A01(0, 6, 39), 0));
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final int getHeight() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final String getUrl() {
        return this.A02;
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final int getWidth() {
        return this.A01;
    }
}
