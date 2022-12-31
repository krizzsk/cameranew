package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.92  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass92 {
    public static byte[] A04;
    public static String[] A05 = {"MRuBx", "tnrUNtkj", "pjyIxrC6Yt5E7Bc8e3CsDS5x0xMg", "2xISKY0hJDtdJSu4Q6JXzE3xpGdbyGij", "ditV1dZQcpc", "LaRPF5Qegj7e827D6k5bX2o3j9w5", "b", "ieJW9hY3GIu"};
    public final String A00;
    public final String A01;
    public final Map<AnonymousClass96, List<String>> A02 = new HashMap();
    public final JSONObject A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23, -18, -27, -38, -69, -72, -78};
        String[] strArr = A05;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[4] = "sekG1ort6wl";
        strArr2[7] = "5zf1LSqUL7z";
        A04 = bArr;
    }

    static {
        A01();
    }

    public AnonymousClass92(String str, String str2, JSONObject jSONObject, @Nullable JSONArray jSONArray) {
        List<String> trackerByType;
        this.A00 = str;
        this.A01 = str2;
        this.A03 = jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (AnonymousClass96 anonymousClass96 : AnonymousClass96.values()) {
            this.A02.put(anonymousClass96, new LinkedList());
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString(A00(0, 4, 108));
                String string2 = jSONObject2.getString(A00(4, 3, 61));
                AnonymousClass96 valueOf = AnonymousClass96.valueOf(string.toUpperCase(Locale.US));
                if (!TextUtils.isEmpty(string2) && (trackerByType = this.A02.get(valueOf)) != null) {
                    trackerByType.add(string2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final String A02() {
        return this.A00;
    }

    @Nullable
    public final List<String> A03(AnonymousClass96 anonymousClass96) {
        return this.A02.get(anonymousClass96);
    }

    public final JSONObject A04() {
        return this.A03;
    }
}
