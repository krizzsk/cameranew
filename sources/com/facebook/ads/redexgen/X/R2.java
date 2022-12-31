package com.facebook.ads.redexgen.X;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum A03 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: assets/audience_network.dex */
public abstract class R2 {
    public static byte[] A00;
    public static String[] A01 = {"nA8fLeyOwVmNwvq6aIqKxCaagHA5eYr", "8Z3ODqLNUnEAqB2P3Amw9Ur1PSsugik5", "YRmdf", "zIg3Ob9eurpeZ06C2uEHUxbrUPW1iO5", "DwODnBhAs5I9lGAPLwBjllp42Gjp41Mv", "6IL6kP5nz", "IHg6IZuYXxuMxytmBHiV", "YXmTZGEBqQ8NuPQvZDB03"};
    public static final /* synthetic */ R2[] A02;
    public static final R2 A03;
    public static final R2 A04;
    public static final R2 A05;
    public static final R2 A06;
    public static final R2 A07;
    public static final R2 A08;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-82, -33, -33, -50, -26, 110, -101, -101, -104, -111, -115, -102, -103, -60, -54, -73, -63, -70, Byte.MAX_VALUE, -92, -86, 101, 120, Byte.MIN_VALUE, 123, 121, -118, 123, -100, -102, -111, -106, -113, -99, -74, -77, -74, -73, -65, -74, 104, -68, -63, -72, -83, 104, -73, -82, 104, -78, -69, -73, -74, 104, -73, -86, -78, -83, -85, -68, 104, -77, -83, -63};
    }

    public abstract boolean A04(JSONArray jSONArray, int i2);

    public abstract boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2);

    public abstract boolean A06(JSONObject jSONObject, String str);

    public abstract boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str);

    static {
        A03();
        final String A022 = A02(0, 5, 105);
        A03 = new R2(A022, 0) { // from class: com.facebook.ads.redexgen.X.Gm
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optJSONArray(i2) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return R3.A01(jSONArray.optJSONArray(i2), jSONArray2.optJSONArray(i2));
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONArray(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return R3.A01(jSONObject.optJSONArray(str), jSONObject2.optJSONArray(str));
            }
        };
        final String A023 = A02(5, 7, 40);
        A04 = new R2(A023, 1) { // from class: com.facebook.ads.redexgen.X.Gl
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optBoolean(i2, true) == jSONArray.optBoolean(i2, false);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return jSONArray.optBoolean(i2) == jSONArray2.optBoolean(i2);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optBoolean(str, true) == jSONObject.optBoolean(str, false);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optBoolean(str) == jSONObject2.optBoolean(str);
            }
        };
        final String A024 = A02(12, 6, 81);
        A05 = new R2(A024, 2) { // from class: com.facebook.ads.redexgen.X.GP
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optInt(i2, 0) == jSONArray.optInt(i2, 1) && jSONArray.optDouble(i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) == jSONArray.optDouble(i2, 1.0d) && ((double) jSONArray.optInt(i2, 0)) != jSONArray.optDouble(i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return jSONArray.optDouble(i2) == jSONArray2.optDouble(i2);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) != jSONObject.optDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optDouble(str) == jSONObject2.optDouble(str);
            }
        };
        final String A025 = A02(18, 3, 50);
        A06 = new R2(A025, 3) { // from class: com.facebook.ads.redexgen.X.GJ
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optInt(i2, 0) == jSONArray.optInt(i2, 1) && jSONArray.optDouble(i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) == jSONArray.optDouble(i2, 1.0d) && ((double) jSONArray.optInt(i2, 0)) == jSONArray.optDouble(i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return jSONArray.optInt(i2) == jSONArray2.optInt(i2);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) == jSONObject.optDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optInt(str) == jSONObject2.optInt(str);
            }
        };
        final String A026 = A02(21, 6, 18);
        A07 = new R2(A026, 4) { // from class: com.facebook.ads.redexgen.X.GI
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optJSONObject(i2) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return R3.A02(jSONArray.optJSONObject(i2), jSONArray2.optJSONObject(i2));
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONObject(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return R3.A02(jSONObject.optJSONObject(str), jSONObject2.optJSONObject(str));
            }
        };
        final String A027 = A02(27, 6, 36);
        A08 = new R2(A027, 5) { // from class: com.facebook.ads.redexgen.X.GH
            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A04(JSONArray jSONArray, int i2) {
                return jSONArray.optString(i2) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
                return jSONArray.optString(i2).equals(jSONArray2.optString(i2));
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optString(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.R2
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optString(str).equals(jSONObject2.optString(str));
            }
        };
        A02 = new R2[]{A03, A04, A05, A06, A07, A08};
    }

    public R2(String str, int i2) {
    }

    public static R2 A00(JSONArray jSONArray, int i2) {
        R2[] values;
        for (R2 r2 : values()) {
            if (A01[1].charAt(14) != '2') {
                throw new RuntimeException();
            }
            A01[4] = "PUsgFaltT51mxPXWqnHKjq6lqfkoVDea";
            if (r2.A04(jSONArray, i2)) {
                return r2;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static R2 A01(JSONObject jSONObject, String str) {
        R2[] values;
        for (R2 r2 : values()) {
            boolean A062 = r2.A06(jSONObject, str);
            if (A01[5].length() != 9) {
                throw new RuntimeException();
            }
            A01[6] = "GmRRmI3tzaTgoS0GQtjO0";
            if (A062) {
                return r2;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static R2 valueOf(String str) {
        return (R2) Enum.valueOf(R2.class, str);
    }

    public static R2[] values() {
        return (R2[]) A02.clone();
    }
}
