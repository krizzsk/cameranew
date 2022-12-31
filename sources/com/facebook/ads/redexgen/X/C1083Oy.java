package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1083Oy {
    public static byte[] A08;
    public static String[] A09 = {"hIbWNT8G4MjoEpKcmCAiH71tt2UY5WuL", "vgUzcpAvpAsCCZCRSC1b", "Sfqxb6DlRQYvsgOWHhSjg", "C3c3lBEuxcYH", "4kl26afgh1M6MAKE7183tIpE6spY1anG", "pra5BXg8TSfQw4xRWMXJu2Yr8KXKWbnB", "WtHlj7qauylK44K79", "wmYNSpHKqPFT"};
    public WeakReference<C1072On> A00;
    public WeakReference<S3> A01 = new WeakReference<>(null);
    public boolean A02 = false;
    public final XT A03;
    public final C1062Ob A04;
    public final String A05;
    public final String A06;
    public final WeakReference<JT> A07;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A08 = new byte[]{44, 56, 54, 54, 42, 55, 45, 10, 11, 12, 7, 27, 18, 26, 63, 78, 71, 58, -29, -14, -21, -21, -30, -23, -36, -32, -20, -31, -30, 12, 27, 20, 20, 11, 18, 5, 19, 11, 25, 25, 7, Draft_75.CR, 11, -37, -22, -29, -29, -38, -31, -44, -23, -18, -27, -38, -23, -29, -9, 52, 53, 36, 46, 41, 90, 75, 95, 93, 79, 78, 44, 99, 63, 93, 79, 92, 57, 58, 39, 56, 58, 43, 42, 8, 63, 27, 57, 43, 56, 83, 84, 65, 84, 69, 49, 28, 39, 48, 32};
    }

    static {
        A08();
    }

    public C1083Oy(XT xt, C1072On c1072On, JT jt, C1062Ob c1062Ob, String str, String str2) {
        this.A03 = xt;
        this.A00 = new WeakReference<>(c1072On);
        this.A07 = new WeakReference<>(jt);
        this.A04 = c1062Ob;
        this.A05 = str;
        this.A06 = str2;
    }

    public static Map<String, String> A03(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    private void A04() {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        s3.close();
    }

    private void A05() {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        s3.A7s();
    }

    private void A06() {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        s3.A8Z();
    }

    private void A07() {
        this.A03.A0D().A4s();
        this.A02 = true;
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        s3.AEq();
        if (JD.A1D(this.A03)) {
            this.A03.A09().AAH();
        }
    }

    private void A09(C1072On c1072On, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences A00 = C0967Kg.A00(this.A03);
        String A01 = A01(0, 0, 21);
        String optString = jSONObject.optString(A01(57, 5, 81), A01);
        String opId = jSONObject.optString(A01(54, 3, 10), A01(7, 7, 50));
        StringBuilder sb = new StringBuilder();
        String key = A01(14, 4, 103);
        sb.append(key);
        sb.append(opId);
        String key2 = sb.toString();
        String key3 = A00.getString(key2, A01);
        if (key3 != null) {
            A01 = key3;
        }
        c1072On.A0b(optString, A01);
    }

    private void A0A(C1072On c1072On, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String A01 = A01(0, 0, 21);
        String optString = jSONObject.optString(A01(92, 5, 71), A01);
        String optString2 = jSONObject.optString(A01(57, 5, 81), A01);
        String optString3 = jSONObject.optString(A01(54, 3, 10), A01(7, 7, 50));
        SharedPreferences.Editor edit = C0967Kg.A00(this.A03).edit();
        edit.putString(A01(14, 4, 103) + optString3, optString).apply();
        c1072On.A0a(optString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B(EnumC1081Ow enumC1081Ow, String str) throws JSONException {
        switch (enumC1081Ow) {
            case A09:
                A0H(new JSONObject(str));
                break;
            case A0D:
                A06();
                break;
            case A03:
                A04();
                break;
            case A0C:
                A07();
                break;
            case A08:
                A0J(new JSONObject(str));
                break;
            case A0G:
                A0K(new JSONObject(str));
                break;
            case A04:
                boolean isDebug = BuildConfigApi.isDebug();
                String[] strArr = A09;
                if (strArr[0].charAt(27) != strArr[4].charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[0] = "82CtEW90xgTIEKmcKO6cRAhvcJ6YWgt9";
                strArr2[4] = "sNvNVkO7190a6sNSaTVbukGZJruYpBFd";
                if (isDebug) {
                }
                break;
            case A0K:
                A05();
            case A07:
                this.A03.A0D().A54(str);
                break;
            case A0B:
            case A0L:
            case A0I:
            case A0H:
            case A0F:
                A0C(enumC1081Ow, str);
                break;
            case A0A:
                A0I(new JSONObject(str));
                break;
        }
        C1072On c1072On = this.A00.get();
        if (c1072On == null) {
            return;
        }
        switch (enumC1081Ow) {
            case A06:
                c1072On.A0S();
                return;
            case A05:
                c1072On.A0R();
                return;
            case A0N:
                A0A(c1072On, str);
                return;
            case A0J:
                A09(c1072On, str);
                return;
            case A0E:
                c1072On.A0d(A03(new JSONObject(str)));
                return;
            default:
                return;
        }
    }

    private void A0C(EnumC1081Ow enumC1081Ow, String str) throws JSONException {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        switch (enumC1081Ow) {
            case A0B:
                s3.AAf();
                return;
            case A0L:
                s3.AC4();
                return;
            case A0I:
                A0F(s3, str);
                return;
            case A0H:
                A0E(s3, str);
                return;
            case A0F:
                A0D(s3, str);
                return;
            default:
                return;
        }
    }

    private void A0D(S3 s3, String str) throws JSONException {
        s3.ABK(new JSONObject(str).optBoolean(A01(87, 5, 108), false));
    }

    private void A0E(S3 s3, String str) throws JSONException {
        s3.ACW(new JSONObject(str).optBoolean(A01(62, 12, 118), false));
    }

    private void A0F(S3 s3, String str) throws JSONException {
        s3.ACY(new JSONObject(str).optBoolean(A01(74, 13, 82), false));
    }

    private void A0H(JSONObject jSONObject) {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        String optString = jSONObject.optString(A01(0, 7, 85));
        if (TextUtils.isEmpty(optString)) {
            s3.A7n();
        } else {
            s3.A7o(optString);
        }
    }

    private void A0I(JSONObject jSONObject) {
        S3 s3 = this.A01.get();
        if (s3 == null) {
            return;
        }
        s3.A7t(jSONObject.optString(A01(0, 7, 85)));
    }

    private void A0J(JSONObject jSONObject) {
        JT jt = this.A07.get();
        if (jt == null) {
            return;
        }
        String optString = jSONObject.optString(A01(43, 11, 1));
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        new C0937Jb(this.A06, jt).A03(optString, A03(jSONObject));
    }

    private void A0K(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(A01(18, 11, 9), -1);
        if (optInt == -1) {
            return;
        }
        String optString = jSONObject.optString(A01(29, 14, 50));
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.A03.A0D().A8o(optInt, optString);
    }

    public final void A0L(S3 s3) {
        this.A01 = new WeakReference<>(s3);
    }

    public final boolean A0M() {
        return this.A02;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        M1.A00(new RunnableC1079Ou(this, str));
    }
}
