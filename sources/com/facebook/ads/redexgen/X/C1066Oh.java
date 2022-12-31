package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1066Oh extends FrameLayout {
    public static byte[] A0K;
    public static String[] A0L = {"tg98T7YqorVxljyy5rC9rRviyjZQ3PWt", "vfHBQfbeXMWpx0Lt9J2p4bolhXFdVoUD", "nuD8gLvjahybAxP4K7AI7EnQPexhi40p", "Mle9DIn2BhVQrDGkT0Ym6c4cXgC65WVc", "K7R1lop0AG70QQAdOPTNlaEDkQeUTiOI", "yRh0uKXr8zSd48KJrOgjFYKLFGGCRN1w", "QQOq4rDYvkiUVU0ErOwgNbjJJCuazTiH", "YmsKh0Z7MVbEzdUA2tq2qo4jdnYDOoVM"};
    @Nullable
    public EnumC1094Pj A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final AnonymousClass16 A05;
    public final C7J A06;
    public final XT A07;
    public final C0937Jb A08;
    public final MU A09;
    public final InterfaceC1031Mw A0A;
    public final InterfaceC1065Og A0B;
    public final C1099Po A0C;
    public final C7x A0D;
    public final AbstractC1018Mi A0E;
    public final M3 A0F;
    public final L3 A0G;
    public final AbstractC0976Kq A0H;
    public final AbstractC0971Kk A0I;
    public final AbstractC0968Kh A0J;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0K = new byte[]{5, 19, 20, 20, 3, 8, 18, 50, 15, 11, 3, 78, 95, 88, 75, 94, 67, 69, 68, 95, 71, 70, 87, 86, 98, 115, 103, 97, 119, 118, 80, 107, 71, 97, 119, 96, 38, 36, 57, 49, 36, 51, 37, 37, 88, 71, 74, 75, 65};
    }

    static {
        A0C();
    }

    public C1066Oh(XT xt, JT jt, AnonymousClass16 anonymousClass16, C7J c7j, C0937Jb c0937Jb, MU mu, InterfaceC1031Mw interfaceC1031Mw, InterfaceC1065Og interfaceC1065Og) {
        super(xt);
        this.A0I = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.9M
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 5);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{16, 18, 5, 16, 1, 18, 5, 4};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A02 */
            public final void A03(C0975Ko c0975Ko) {
                InterfaceC1065Og interfaceC1065Og2;
                JSONObject A03;
                C1066Oh.this.A03 = true;
                interfaceC1065Og2 = C1066Oh.this.A0B;
                A03 = C1066Oh.this.A03();
                interfaceC1065Og2.ACS(A00(0, 8, 101), A03);
            }
        };
        this.A0H = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.91
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 15);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{65, 93, 80, 72};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A02 */
            public final void A03(C0977Kr c0977Kr) {
                InterfaceC1065Og interfaceC1065Og2;
                JSONObject A03;
                C1066Oh.this.A04 = true;
                interfaceC1065Og2 = C1066Oh.this.A0B;
                A03 = C1066Oh.this.A03();
                interfaceC1065Og2.ACS(A00(0, 4, 62), A03);
            }
        };
        this.A0G = new L3() { // from class: com.facebook.ads.redexgen.X.90
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 93);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{28, Draft_75.CR, 25, 31, 9};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A02 */
            public final void A03(C06677u c06677u) {
                InterfaceC1065Og interfaceC1065Og2;
                JSONObject A03;
                interfaceC1065Og2 = C1066Oh.this.A0B;
                A03 = C1066Oh.this.A03();
                interfaceC1065Og2.ACS(A00(0, 5, 49), A03);
            }
        };
        this.A0J = new AbstractC0968Kh() { // from class: com.facebook.ads.redexgen.X.8z
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06667t c06667t) {
                C1066Oh.this.A0H(c06667t);
                C1066Oh.this.A0A();
            }
        };
        this.A0E = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.8y
            public static byte[] A01;

            static {
                A01();
            }

            public static String A00(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 77);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{20, 32, 30, 33, 29, 22, 37, 22, 21};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A02 */
            public final void A03(C06687v c06687v) {
                InterfaceC1065Og interfaceC1065Og2;
                C1099Po c1099Po;
                JSONObject A04;
                C1066Oh.this.A07();
                interfaceC1065Og2 = C1066Oh.this.A0B;
                C1066Oh c1066Oh = C1066Oh.this;
                c1099Po = c1066Oh.A0C;
                A04 = c1066Oh.A04(c1099Po.getDuration());
                interfaceC1065Og2.ACS(A00(0, 9, 100), A04);
            }
        };
        this.A0F = new C06918x(this);
        this.A03 = false;
        this.A04 = false;
        this.A02 = false;
        this.A01 = false;
        this.A07 = xt;
        this.A05 = anonymousClass16;
        this.A06 = c7j;
        this.A08 = c0937Jb;
        this.A09 = mu;
        this.A0A = interfaceC1031Mw;
        this.A0C = new C1099Po(xt);
        this.A0B = interfaceC1065Og;
        this.A0C.setFunnelLoggingHandler(c0937Jb);
        this.A0C.getEventBus().A03(this.A0I, this.A0H, this.A0G, this.A0J, this.A0E, this.A0F);
        this.A0D = new C7x(xt, jt, this.A0C, anonymousClass16.A0Q());
        A0B();
        this.A0C.setVideoURI(this.A06.A0Q(this.A05.A0K().A0D().A08()));
        A09();
        M5.A0M(this, this.A05.A0J().A01().A07(true));
        String A07 = anonymousClass16.A0K().A0D().A07();
        if (!TextUtils.isEmpty(A07)) {
            OH.A00(xt, this, A07);
        }
        addView(this.A0C, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A03() {
        return A04(this.A0C.getCurrentPositionInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A04(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(0, 11, 64), i2);
            jSONObject.put(A02(11, 8, 12), this.A0C.getDuration());
            jSONObject.put(A02(19, 5, 20), this.A0C.A0h());
            jSONObject.put(A02(24, 12, 52), this.A0C.A0j());
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A02) {
            return;
        }
        if (A0L[4].charAt(2) == 'n') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[2] = "wYD5NcGpzh0isOAoVzlYli3P4mnoyMgF";
        strArr[3] = "lJUNZHbcIhPOnD8CvxzjDicpi9xwJBJa";
        this.A02 = true;
    }

    private void A08() {
        this.A0C.postDelayed(new S8(this), JD.A0I(this.A07));
    }

    private void A09() {
        this.A0C.postDelayed(new S7(this), JD.A0J(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A0B.ACS(A02(36, 8, 112), A03());
    }

    private void A0B() {
        if (!TextUtils.isEmpty(this.A05.A0K().A0D().A07())) {
            C06527b c06527b = new C06527b(this.A07);
            this.A0C.A0c(c06527b);
            c06527b.setImage(this.A05.A0K().A0D().A07());
        }
        C06296e c06296e = new C06296e(this.A07, true, this.A08);
        this.A0C.A0c(c06296e);
        this.A0C.A0c(new JX(c06296e, EnumC1107Pw.A03, true));
        this.A0C.A0c(new C7R(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(C06667t c06667t) {
        if (this.A0C.getState() == QW.A02 && JD.A0z(this.A07)) {
            this.A0C.postDelayed(new S6(this, c06667t), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(String str) {
        this.A07.A06().A8q(A02(44, 5, 8), C06808m.A2L, new C06818n(str));
        if (JD.A10(this.A07)) {
            A07();
            return;
        }
        MU mu = this.A09;
        InterfaceC1031Mw interfaceC1031Mw = this.A0A;
        String[] strArr = A0L;
        if (strArr[5].charAt(16) != strArr[6].charAt(16)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[2] = "EBONCaOY6he3EVwrjSVJVgPSsddIWnnf";
        strArr2[3] = "quoo3J1Esh1kTLqYeLvwyhMYZuOues3Q";
        mu.A3q(interfaceC1031Mw.A6V());
        this.A09.A3q(this.A0A.A6Q());
    }

    public final void A0N() {
        this.A0C.setVolume(this.A05.A0K().A0D().A09() ? 0.0f : 1.0f);
        this.A0C.A0b(EnumC1094Pj.A03, 26);
        A08();
    }

    public final void A0O() {
        C1099Po c1099Po = this.A0C;
        if (c1099Po != null) {
            if (!this.A02) {
                c1099Po.A0a(EnumC1090Pf.A03);
            }
            this.A0C.getEventBus().A04(this.A0I, this.A0H, this.A0G, this.A0J, this.A0E, this.A0F);
            this.A0C.A0V();
        }
        this.A0D.A0g();
    }

    public final void A0P() {
        this.A0C.A0Z(9);
        M5.A0T(this);
        M5.A0H(this.A0C);
        M5.A0Z(this.A0C);
    }

    public final void A0Q() {
        this.A0C.A0a(EnumC1090Pf.A04);
    }

    public final void A0R(boolean z) {
        if (z) {
            this.A0C.setVolume(0.0f);
        } else {
            this.A0C.setVolume(1.0f);
        }
        A0A();
        if (A0L[7].charAt(5) == 'u') {
            throw new RuntimeException();
        }
        A0L[4] = "yn69DofMHsLSVfdL7HK9OU5c1k1rZYJH";
    }

    public final void A0S(boolean z) {
        if (this.A0C.A0i()) {
            return;
        }
        this.A00 = this.A0C.getVideoStartReason();
        this.A01 = z;
        this.A0C.A0e(false, 19);
    }

    public final void A0T(boolean z) {
        if (this.A0C.A0j() || this.A02 || this.A0C.getState() == QW.A06 || this.A00 == null) {
            return;
        }
        boolean z2 = this.A01;
        if (A0L[7].charAt(5) == 'u') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[1] = "icjW3n8vZZxsaCmttUmjcTI7CQu2m51p";
        strArr[0] = "kS3lp82K2YolC4kFtdcvtTBENFWE8ibh";
        if (!z2 || z) {
            this.A0C.A0b(this.A00, 27);
        }
    }

    public final void A0U(boolean z) {
        this.A0C.A0e(z, 18);
    }

    public final void A0V(boolean z) {
        this.A0C.A0b(EnumC1094Pj.A05, 25);
    }
}
