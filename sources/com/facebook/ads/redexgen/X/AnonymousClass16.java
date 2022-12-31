package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.RewardData;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.16  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class AnonymousClass16 implements Serializable {
    public static JSONObject A0N = null;
    public static byte[] A0O = null;
    public static String[] A0P = {"1gqRR9im7tmNjhPy8NnQpjCX4rd8Ielc", "ZkOx7RNEMabKvQ7fgN15WIbWDw11JZFu", "ifeh8sROmLFDdOYqa0sy0eFfj5RHH1gU", "fnDzwAhU6GMUs0cCq2fTQuWEzv5lBJki", "OVtNfYqIZ80xqW4zrHdkYxbTKYgYXHc", "chIpxbYwiAOd1RIHlv8aEwW7ihQHRwI", "GnSiEcQE", "uApEYGhuY9oy1RN675k2bDQ9FUD4oA7y"};
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A02;
    public RewardData A03;
    public AnonymousClass17 A04;
    public C1P A05;
    public C1S A06;
    public C1Z A07;
    public String A08;
    public String A09;
    @Nullable
    public String A0A;
    @Nullable
    public String A0B;
    public String A0C;
    public String A0E;
    public String A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public final int A0L;
    public final List<AnonymousClass19> A0M;
    public String A0D = A00(0, 0, 70);
    public int A01 = 200;
    public boolean A0J = false;
    public boolean A0K = false;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0O, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 60);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        String[] strArr = A0P;
        if (strArr[2].charAt(14) == strArr[1].charAt(14)) {
            throw new RuntimeException();
        }
        A0P[5] = "bfB1pGz3pHLReaUGKuLSmGsyYLYBAtW";
        A0O = new byte[]{40, 45, 22, 42, 33, 38, 32, 42, 44, 58, 22, 37, 32, 39, 34, 22, 60, 59, 37, 118, 121, 72, 123, 120, 112, 120, 72, 99, 110, 103, 114, 83, 81, 83, 88, 85, 111, 81, 67, 67, 85, 68, 67, 91, 89, 74, 87, 77, 75, 93, 84, 39, 43, 41, 106, 34, 37, 39, 33, 38, 43, 43, 47, 106, 37, 32, 55, 106, 45, 42, 48, 33, 54, 55, 48, 45, 48, 45, 37, 40, 106, 39, 40, 45, 39, 47, 33, 32, 0, 12, 14, 77, 5, 2, 0, 6, 1, 12, 12, 8, 77, 2, 7, 16, 77, 10, Draft_75.CR, 23, 6, 17, 16, 23, 10, 23, 10, 2, 15, 77, 5, 10, Draft_75.CR, 10, 16, 11, 60, 2, 0, 23, 10, 21, 10, 23, 26, 34, 53, 14, 25, 6, 53, 2, 3, 14, 15, 53, 4, 11, 28, 3, Draft_75.CR, 11, 30, 3, 5, 4, 53, 15, 4, 11, 8, 6, 15, 14, 97, 118, 105, 90, 109, 118, 90, 96, 107, 100, 103, 105, 96, 97, 86, 65, 94, 109, 90, 75, 80, 64, 91, 86, 109, 87, 92, 83, 80, 94, 87, 86, 35, 62, 41, 38, 42, 46, 36, 24, 52, 35, 44, 24, 43, 38, 62, 34, 53, 24, 47, 51, 42, 43, 24, 50, 53, 43, 81, 90, 87, 70, 77, 68, 64, 81, 80, 107, 87, 68, 89, 10, 0, 12, Draft_75.CR, 45, 42, 48, 33, 54, 55, 48, 45, 48, 45, 37, 40, 94, 83, 92, 86, 65, 81, 83, 66, 87, 78, 67, 91, 77, 87, 86, 75, 68, 81, 76, 83, 64, 108, 115, 110, 104, 110, 125, 117, 104, 50, 37, 49, 53, 37, 51, 52, 31, 41, 36, 58, 45, 63, 41, 58, 44, 45, 44, 23, 62, 33, 44, 45, 39, 112, 109, 112, 104, 97, 25, 30, 0, 16, 15, 3, 17, 7, 4, 15, 10, 15, 18, 31, 57, 5, 14, 3, 5, Draft_75.CR, 57, 15, 8, 15, 18, 15, 7, 10, 57, 2, 3, 10, 7, 31, 108, 115, Byte.MAX_VALUE, 109, 123, 120, 115, 118, 115, 110, 99, 69, 121, 114, Byte.MAX_VALUE, 121, 113, 69, 115, 116, 110, Byte.MAX_VALUE, 104, 108, 123, 118};
    }

    public abstract int A0G();

    public abstract int A0H();

    static {
        A02();
    }

    public AnonymousClass16(List<AnonymousClass19> list) {
        this.A0M = list;
    }

    public static List<AnonymousClass19> A01(JSONObject jSONObject, XT xt, C1L c1l) {
        JSONArray optJSONArray = jSONObject.optJSONArray(A00(43, 8, 4));
        if (optJSONArray != null && optJSONArray.length() > 0) {
            return C1H.A01(optJSONArray, jSONObject, xt, c1l);
        }
        ArrayList arrayList = new ArrayList();
        AnonymousClass19 A00 = AnonymousClass19.A00(jSONObject);
        c1l.A3A(A00, jSONObject);
        arrayList.add(A00);
        return arrayList;
    }

    private void A03(int i2) {
        this.A00 = i2;
    }

    private void A04(int i2) {
        this.A02 = i2;
    }

    private void A05(AnonymousClass17 anonymousClass17) {
        this.A04 = anonymousClass17;
    }

    private void A06(C1P c1p) {
        this.A05 = c1p;
    }

    private final void A07(C1S c1s) {
        this.A06 = c1s;
    }

    private void A08(C1Z c1z) {
        this.A07 = c1z;
    }

    private void A09(String str) {
        this.A09 = str;
    }

    private void A0A(String str) {
        this.A0E = str;
    }

    private final void A0B(String str) {
        this.A08 = str;
    }

    private void A0C(JSONObject jSONObject) {
        this.A0D = jSONObject.toString();
    }

    public final int A0D() {
        return this.A00;
    }

    public final int A0E() {
        return this.A02;
    }

    public final int A0F() {
        return this.A0L;
    }

    @Nullable
    public final RewardData A0I() {
        return this.A03;
    }

    public final AnonymousClass17 A0J() {
        return this.A04;
    }

    public final AnonymousClass19 A0K() {
        return this.A0M.get(0);
    }

    @Nullable
    public final AnonymousClass19 A0L(int i2) {
        if (i2 < 0 || i2 >= this.A0M.size()) {
            return null;
        }
        return this.A0M.get(i2);
    }

    public final C1P A0M() {
        return this.A05;
    }

    public final C1S A0N() {
        return this.A06;
    }

    public final C1Z A0O() {
        return this.A07;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String A0P() {
        /*
            r6 = this;
            java.lang.String r3 = r6.A0C
            int r1 = r3.hashCode()
            r0 = -1364000502(0xffffffffaeb3010a, float:-8.140162E-11)
            r5 = 2
            r4 = 1
            if (r1 == r0) goto L4a
            r0 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r1 == r0) goto L39
            r0 = 604727084(0x240b672c, float:3.022821E-17)
            if (r1 == r0) goto L27
        L17:
            r0 = -1
        L18:
            if (r0 == 0) goto L85
            if (r0 == r4) goto L7e
            if (r0 == r5) goto L77
            r2 = 0
            r1 = 0
            r0 = 70
            java.lang.String r0 = A00(r2, r1, r0)
            return r0
        L27:
            r2 = 237(0xed, float:3.32E-43)
            r1 = 12
            r0 = 120(0x78, float:1.68E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L17
            r0 = 0
            goto L18
        L39:
            r2 = 264(0x108, float:3.7E-43)
            r1 = 6
            r0 = 25
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L17
            r0 = 2
            goto L18
        L4a:
            r2 = 288(0x120, float:4.04E-43)
            r1 = 14
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r3 = r3.equals(r0)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass16.A0P
            r0 = 2
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L90
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass16.A0P
            java.lang.String r1 = "Jd5WF9li"
            r0 = 6
            r2[r0] = r1
            if (r3 == 0) goto L17
            r0 = 1
            goto L18
        L77:
            com.facebook.ads.redexgen.X.Pl r0 = com.facebook.ads.redexgen.X.EnumC1096Pl.A03
            java.lang.String r0 = r0.A02()
            return r0
        L7e:
            com.facebook.ads.redexgen.X.Pm r0 = com.facebook.ads.redexgen.X.EnumC1097Pm.A04
            java.lang.String r0 = r0.A02()
            return r0
        L85:
            r2 = 51
            r1 = 37
            r0 = 120(0x78, float:1.68E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            return r0
        L90:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass16.A0P():java.lang.String");
    }

    public final String A0Q() {
        return this.A08;
    }

    public final String A0R() {
        return this.A09;
    }

    @Nullable
    public final String A0S() {
        return this.A0A;
    }

    @Nullable
    public final String A0T() {
        return this.A0B;
    }

    public final String A0U() {
        return this.A0C;
    }

    public final String A0V() {
        return this.A0E;
    }

    public final String A0W() {
        return this.A0F;
    }

    public final List<AnonymousClass19> A0X() {
        return Collections.unmodifiableList(this.A0M);
    }

    public final JSONObject A0Y() {
        try {
            return new JSONObject(this.A0D);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final void A0Z(int i2) {
        this.A01 = i2;
    }

    public final void A0a(RewardData rewardData) {
        this.A03 = rewardData;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0b(com.facebook.ads.redexgen.X.MU r9) {
        /*
            r8 = this;
            java.lang.String r4 = r8.A0U()
            int r1 = r4.hashCode()
            r0 = -1364000502(0xffffffffaeb3010a, float:-8.140162E-11)
            r3 = 1
            if (r1 == r0) goto L62
            r0 = 604727084(0x240b672c, float:3.022821E-17)
            if (r1 == r0) goto L30
        L13:
            r0 = -1
        L14:
            if (r0 == 0) goto L19
            if (r0 == r3) goto L26
        L18:
            return
        L19:
            r2 = 88
            r1 = 45
            r0 = 95
            java.lang.String r0 = A00(r2, r1, r0)
            r9.A3q(r0)
        L26:
            com.facebook.ads.redexgen.X.Pm r0 = com.facebook.ads.redexgen.X.EnumC1097Pm.A08
            java.lang.String r0 = r0.A02()
            r9.A3q(r0)
            goto L18
        L30:
            r7 = 237(0xed, float:3.32E-43)
            r6 = 12
            r5 = 120(0x78, float:1.68E-43)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass16.A0P
            r0 = 2
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L74
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass16.A0P
            java.lang.String r1 = "ynfghRupyY8lJ5WDqUPqAC0JO3E4ojqs"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "OEwRxUcpVPGJQFz3LRrAkRkf0LWdVsmf"
            r0 = 0
            r2[r0] = r1
            java.lang.String r0 = A00(r7, r6, r5)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L13
            r0 = 0
            goto L14
        L62:
            r2 = 288(0x120, float:4.04E-43)
            r1 = 14
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L74:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass16.A0b(com.facebook.ads.redexgen.X.MU):void");
    }

    public final void A0c(@Nullable String str) {
        this.A0B = str;
    }

    public final void A0d(String str) {
        this.A0C = str;
    }

    public final void A0e(String str) {
        this.A0F = str;
    }

    public final void A0f(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        A0N = jSONObject.optJSONObject(A00(31, 12, 12));
        C1R A06 = new C1R().A06(jSONObject.optString(A00(302, 5, 56)));
        String A00 = A00(233, 4, 95);
        JSONObject optJSONObject = jSONObject.optJSONObject(A00);
        String A002 = A00(0, 0, 70);
        if (optJSONObject != null) {
            str = jSONObject.optJSONObject(A00).optString(A00(307, 3, 80));
        } else {
            str = A002;
        }
        A07(A06.A05(str).A04(jSONObject.optString(A00(0, 19, 117))).A07(C1T.A03(jSONObject)).A08());
        JSONObject optJSONObject2 = jSONObject.optJSONObject(A00(258, 6, 30));
        if (optJSONObject2 != null) {
            String A003 = A00(BaseBlurEffect.ROTATION_270, 8, 32);
            if (A0P[5].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0P;
            strArr[2] = "L9OC0yGJthGch16tOTqUcqcE9MnsMaz6";
            strArr[1] = "n6CgIEssquLp46jPM2UWfBhL1rINMjIc";
            jSONObject2 = optJSONObject2.optJSONObject(A003);
        } else {
            jSONObject2 = null;
        }
        A05(new AnonymousClass17(C1I.A01(jSONObject2), C1I.A01(optJSONObject2 != null ? optJSONObject2.optJSONObject(A00(249, 9, 14)) : null)));
        A08(C1T.A01(jSONObject));
        A06(C1T.A00(jSONObject));
        A0B(jSONObject.optString(A00(133, 2, 125)));
        A0A(jSONObject.optString(A00(278, 10, 124), A002));
        A09(jSONObject.optString(A00(194, 26, 123), A002));
        this.A0H = jSONObject.optBoolean(A00(162, 14, 57));
        this.A0I = jSONObject.optBoolean(A00(176, 18, 14));
        this.A0G = jSONObject.optBoolean(A00(135, 27, 86), true);
        A03(jSONObject.optInt(A00(19, 12, 43), 0));
        A0C(jSONObject);
        A04(jSONObject.optInt(A00(310, 31, 90), 0));
        A0Z(jSONObject.optInt(A00(341, 26, 38), 1000));
        this.A0A = jSONObject.optString(A00(220, 13, 8));
    }

    public final void A0g(boolean z) {
        this.A0J = z;
    }

    public final void A0h(boolean z) {
        this.A0K = z;
    }

    public final boolean A0i() {
        return this.A0H;
    }

    public final boolean A0j() {
        return this.A0I;
    }

    public final boolean A0k() {
        return this.A0G;
    }

    public final boolean A0l() {
        if (Build.VERSION.SDK_INT >= 21) {
            String A0R = A0R();
            if (A0P[7].charAt(30) != '7') {
                throw new RuntimeException();
            }
            A0P[4] = "Ho9CziPGzu0GN5git9gLyxI3YsNmgO7";
            if (!TextUtils.isEmpty(A0R)) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0m() {
        return this.A0J;
    }

    public final boolean A0n() {
        return this.A0K;
    }
}
