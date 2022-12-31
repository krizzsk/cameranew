package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class U4 implements JT {
    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    public static JT A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final XS A00;
    public final C9T A01;
    public final JS A02;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 79);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-90, -21, -4, -21, -12, -6, -76, -88, -37, -37, -52, -44, -41, -37, -48, -43, -50, -121, -37, -42, -121, -45, -42, -50, -121, -56, -43, -121, -48, -43, -35, -56, -45, -48, -53, -121, -43, -13, -30, -28, -26, -24, -26, -17, -26, -13, -22, -28, 46, 51, 42, 31};
    }

    static {
        A03();
        A05 = U4.class.getSimpleName();
        A06 = false;
    }

    public U4(XS xs) {
        JR A00;
        this.A00 = xs;
        if (JF.A0T(xs)) {
            this.A01 = C9R.A00(xs);
            A00 = JY.A01(xs, this.A01);
        } else {
            C0800Do A01 = C9R.A01(xs);
            A00 = JY.A00(xs, A01);
            this.A01 = A01;
        }
        this.A02 = new U7(xs, A00);
        MA.A08.execute(new U6(this));
        A04(xs);
    }

    public static synchronized JT A01(XS xs) {
        JT jt;
        synchronized (U4.class) {
            if (A03 == null) {
                A03 = new U4(xs);
            }
            jt = A03;
        }
        return jt;
    }

    public static synchronized void A04(XS xs) {
        synchronized (U4.class) {
            if (A06) {
                return;
            }
            DynamicLoaderFactory.makeLoader(xs).getInitApi().onAdEventManagerCreated(xs);
            A06 = true;
        }
    }

    private void A05(JQ jq) {
        if (!jq.A0A()) {
            String str = A05;
            Log.e(str, A02(7, 29, 24) + jq.A06() + A02(0, 7, 55));
            return;
        }
        A06(jq);
        this.A01.AFV(jq, new U5(this, jq));
    }

    @SuppressLint({"ThrowException"})
    private void A06(JQ jq) {
        switch (jq.A06()) {
            case A0N:
            case A0I:
            case A07:
            case A0H:
            case A0O:
            case A0Q:
            case A0R:
                C06818n c06818n = new C06818n(new Exception(A02(36, 5, 50)));
                c06818n.A03(1);
                try {
                    c06818n.A05(new JSONObject().put(A02(48, 4, 107), jq.A06().toString()));
                } catch (JSONException unused) {
                }
                this.A00.A06().A8r(A02(41, 7, 50), C06808m.A16, c06818n);
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8i(String str, Map<String, String> map) {
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A04).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8l(String str, Map<String, String> map) {
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A06).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8m(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A07).A06(C0939Jd.A0A(str, EnumC0936Ja.A0I)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8n(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A08).A06(C0939Jd.A0A(str, EnumC0936Ja.A06)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8p(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8t(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0C).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8v(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0D).A06(C0939Jd.A0A(str, EnumC0936Ja.A0T)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8w(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8x(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0F).A06(C0939Jd.A0A(str, EnumC0936Ja.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A8y(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0I).A06(C0939Jd.A0A(str, EnumC0936Ja.A0W)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A90(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0H).A06(C0939Jd.A0A(str, EnumC0936Ja.A0X)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A92(String str, Map<String, String> map, String str2, JV jv) {
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(jv).A02(JW.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A93(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0J).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A97(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0L).A06(C0939Jd.A0A(str, EnumC0936Ja.A0Z)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A99(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A01(JV.A04).A02(JW.A0M).A06(C0939Jd.A0A(str, EnumC0936Ja.A0a)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9B(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0G).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9C(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0N).A06(C0939Jd.A0A(str, EnumC0936Ja.A0e)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9D(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0R).A06(C0939Jd.A0A(str, EnumC0936Ja.A0g)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9E(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A04).A02(JW.A0Q).A06(C0939Jd.A0A(str, EnumC0936Ja.A0h)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9F(String str, Map<String, String> map) {
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0S).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void A9H(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new JP().A04(str).A00(this.A00.A07().A01()).A03(this.A00.A07().A02()).A05(map).A01(JV.A05).A02(JW.A0T).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.JT
    public final void ACv(String str) {
        new AsyncTaskC1136Qz(this.A00).execute(str);
    }
}
