package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.87  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass87 extends AbstractC1158Rv {
    public static byte[] A0K;
    public static String[] A0L = {"Mriq29lS8vjEPztqvg4mnlhqPa1pf4jw", "J0ebGdEZD5oKohgNzUxMA3JiHaSF4bRJ", "IT9tvlYp44pYwsfxgtsksFS", "El43mrOkb3qqMjbYlNbneDDC3riKbt8u", "SsyQgLhJr8BA6K4Jeu0226NIXlotTSUK", "5pKSfcHcmxRzGJ6MCKbxSHPk9j0pnkgf", "vZ9Xs81YGHnjRjGsoTeSsIOHxP", "Y9Sammkz"};
    @Nullable
    public OJ A00;
    public PV A01;
    @Nullable
    public EnumC1094Pj A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final AnonymousClass50 A09;
    public final C1099Po A0A;
    public final C7x A0B;
    public final AbstractC1018Mi A0C;
    public final M3 A0D;
    public final L3 A0E;
    public final AbstractC0976Kq A0F;
    public final AbstractC0971Kk A0G;
    public final AbstractC0968Kh A0H;
    public final C0921Ij A0I;
    public final IS A0J;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0K = new byte[]{-3, 21, 7, 5, 21, -1, -38, -51, -56, -55, -45};
    }

    static {
        A08();
    }

    public AnonymousClass87(XT xt, InterfaceC1031Mw interfaceC1031Mw, JT jt, AnonymousClass16 anonymousClass16, C7J c7j, MU mu) {
        super(xt, interfaceC1031Mw, jt, anonymousClass16, c7j, mu);
        this.A09 = new C1151Ro(this);
        this.A0G = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.8i
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                AnonymousClass87.this.A07 = true;
            }
        };
        this.A0F = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.8F
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                AnonymousClass87.this.A08 = true;
                AnonymousClass87.this.A0P();
            }
        };
        this.A0E = new L3() { // from class: com.facebook.ads.redexgen.X.8C
            @Override // com.facebook.ads.redexgen.X.C9P
            public final /* bridge */ /* synthetic */ void A03(C06677u c06677u) {
            }
        };
        this.A0H = new AbstractC0968Kh() { // from class: com.facebook.ads.redexgen.X.8A
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06667t c06667t) {
                OJ oj;
                AnonymousClass87.this.A0F(c06667t);
                AnonymousClass87.this.A0E(c06667t);
                oj = AnonymousClass87.this.A00;
                oj.A0A(c06667t);
            }
        };
        this.A0C = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.89
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                C1099Po c1099Po;
                AnonymousClass87 anonymousClass87 = AnonymousClass87.this;
                c1099Po = anonymousClass87.A0A;
                anonymousClass87.A0D(c06687v, c1099Po.getState() != QW.A06);
            }
        };
        this.A0D = new AnonymousClass88(this);
        boolean z = false;
        this.A07 = false;
        this.A08 = false;
        this.A06 = false;
        this.A05 = false;
        this.A04 = false;
        this.A0A = new C1099Po(super.A03);
        this.A0A.setFunnelLoggingHandler(super.A05);
        this.A0A.getEventBus().A03(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
        this.A0B = new C7x(super.A03, super.A04, this.A0A, super.A01.A0Q());
        this.A01 = new PV(super.A03, super.A09, super.A01.A0W(), mu);
        this.A0I = new C0921Ij(super.A03, super.A05);
        this.A0J = new IS(super.A03);
        A07();
        this.A0A.setVideoURI(super.A02.A0Q(super.A01.A0K().A0D().A08()));
        A05();
        int A03 = super.A01.A0K().A0D().A03();
        if (JD.A1W(super.A03)) {
            this.A05 = A03 == 0;
        } else {
            this.A05 = A03 <= 0;
        }
        if (super.A01.A0K().A0L() && super.A01.A0K().A0D().A02() > 0) {
            z = true;
        }
        this.A03 = z;
        M5.A0M(this, super.A01.A0J().A01().A07(true));
        if (JD.A1Q(super.A03)) {
            super.A07.setProgressSpinnerInvisible(true);
        }
    }

    private OJ A00(int i2) {
        return OK.A00(new OM(super.A03, super.A04, super.A08, super.A01, this.A0A, super.A0A, super.A06).A0E(super.A07.getToolbarHeight()).A0H(super.A07).A0D(i2).A0F(this.A0I).A0I(this.A0J).A0J(), null, true);
    }

    private void A04() {
        this.A0A.postDelayed(new C1149Rm(this), JD.A0I(super.A03));
    }

    private void A05() {
        this.A0A.postDelayed(new C1148Rl(this), JD.A0J(super.A03));
    }

    private void A06() {
        this.A05 = true;
        OJ oj = this.A00;
        if (oj != null) {
            oj.A0Z();
        }
    }

    private void A07() {
        this.A0A.A0c(this.A0J);
        this.A0A.A0c(this.A0I);
        if (!TextUtils.isEmpty(super.A01.A0K().A0D().A07())) {
            C06527b c06527b = new C06527b(super.A03);
            this.A0A.A0c(c06527b);
            c06527b.setImage(super.A01.A0K().A0D().A07());
        }
        C06296e c06296e = new C06296e(super.A03, true, super.A05);
        this.A0A.A0c(c06296e);
        this.A0A.A0c(new JX(c06296e, EnumC1107Pw.A03, true));
        this.A0A.A0c(new C7R(super.A03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C06687v c06687v, boolean z) {
        if (this.A06) {
            return;
        }
        this.A06 = true;
        if (!this.A05) {
            A06();
        }
        OJ oj = this.A00;
        if (A0L[6].length() != 26) {
            throw new RuntimeException();
        }
        A0L[1] = "skYYV88BTcDGkk1Ge0IaKZH0HqJ76mgM";
        if (oj != null) {
            oj.A09(c06687v);
        }
        super.A07.setToolbarActionMessage(A03(0, 0, 25));
        A0H(z);
        super.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(C06667t c06667t) {
        if (this.A0A.getState() == QW.A02 && JD.A0z(super.A03)) {
            this.A0A.postDelayed(new C1152Rp(this, c06667t), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(C06667t c06667t) {
        int A00 = c06667t.A00();
        if (this.A03) {
            int A02 = super.A01.A0K().A0D().A02() - (A00 / 1000);
            if (A02 > 0) {
                super.A07.setToolbarActionMessage(super.A01.A0O().A00().replace(A03(0, 6, 74), String.valueOf(A02)));
            } else {
                super.A07.setToolbarActionMessage(A03(0, 0, 25));
                A0H(false);
            }
        }
        float min = A00 / Math.min(super.A01.A0K().A0D().A03() * 1000.0f, this.A0A.getDuration());
        super.A07.setProgress(100.0f * min);
        if (min >= 1.0f && !this.A05) {
            A06();
            String[] strArr = A0L;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[0] = "PXM0w4DTcyhv6xVVxlaJPbpxowOdlGPl";
            strArr2[4] = "ZagmJHoPVKqTZKI94Zh80WtjAbW4VeCE";
            super.A07.setToolbarActionMode(getCloseButtonStyle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(String str) {
        int i2 = 0;
        int i3 = 0;
        C1099Po c1099Po = this.A0A;
        if (c1099Po != null) {
            i2 = c1099Po.getCurrentPositionInMillis();
            i3 = this.A0A.getDuration();
        }
        super.A03.A06().A8q(A03(6, 5, 12), C06808m.A2L, new C06818n(str));
        if (JD.A10(super.A03)) {
            A0D(new C06687v(i2, i3), false);
            return;
        }
        MU mu = super.A08;
        if (A0L[3].charAt(0) == 'z') {
            throw new RuntimeException();
        }
        A0L[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
        mu.A3q(super.A09.A6V());
        super.A08.A3q(super.A09.A6Q());
    }

    private synchronized void A0H(boolean z) {
        boolean z2 = this.A03;
        String[] strArr = A0L;
        if (strArr[2].length() != strArr[7].length()) {
            A0L[6] = "RUkVKvLXKou3DkajJbljeqXSK8";
            if (z2 && !z) {
                super.A08.A3q(super.A09.A5X());
                this.A01.A05();
                this.A03 = false;
                if (this.A00 != null) {
                    this.A00.A0X();
                }
                return;
            }
            this.A03 = false;
            String[] strArr2 = A0L;
            if (strArr2[2].length() != strArr2[7].length()) {
                A0L[6] = "pCCqOlrdcXyBK9Nv0jyTBmGbmh";
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final void A0Q() {
        M5.A0L(this.A00);
        M5.A0L(super.A07);
        this.A0A.setVolume(super.A01.A0K().A0D().A09() ? 0.0f : 1.0f);
        this.A0A.A0b(EnumC1094Pj.A03, 20);
        OJ oj = this.A00;
        if (oj != null && this.A03) {
            oj.A0Y();
        }
        OJ oj2 = this.A00;
        if (oj2 != null && !this.A05) {
            oj2.A0a();
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final void A0S(AnonymousClass52 anonymousClass52) {
        anonymousClass52.A0K(this.A09);
        this.A00 = A00(anonymousClass52.A0H().getResources().getConfiguration().orientation);
        addView(this.A00, AbstractC1158Rv.A0D);
        addView(super.A07, new FrameLayout.LayoutParams(-1, super.A07.getToolbarHeight()));
        M5.A0H(this.A00);
        M5.A0H(super.A07);
        OJ oj = this.A00;
        setUpFullscreenMode(oj != null && oj.A0c());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final boolean A0T() {
        OJ oj = this.A00;
        return oj != null && oj.A0d(this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        if (this.A0A.A0i()) {
            return;
        }
        this.A02 = this.A0A.getVideoStartReason();
        this.A04 = z;
        this.A0A.A0e(false, 13);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        if (this.A0A.A0j() || this.A06 || this.A0A.getState() == QW.A06 || this.A02 == null) {
            return;
        }
        if (!this.A04 || z) {
            C1099Po c1099Po = this.A0A;
            EnumC1094Pj enumC1094Pj = this.A02;
            String[] strArr = A0L;
            if (strArr[0].charAt(8) == strArr[4].charAt(8)) {
                throw new RuntimeException();
            }
            A0L[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
            c1099Po.A0b(enumC1094Pj, 19);
        }
    }

    private int getCloseButtonStyle() {
        OJ oj = this.A00;
        if (oj != null) {
            return oj.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv, com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        super.onDestroy();
        if (JD.A1D(super.A03)) {
            super.A03.A09().AF3(this.A0A);
        }
        OJ oj = this.A00;
        if (oj != null) {
            oj.A0W();
        }
        C1099Po c1099Po = this.A0A;
        if (c1099Po != null) {
            if (!this.A06) {
                c1099Po.A0a(EnumC1090Pf.A05);
            }
            this.A0A.getEventBus().A04(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
            this.A0A.A0V();
        }
        this.A0B.A0g();
    }

    @VisibleForTesting
    public void setServerSideRewardHandler(PV pv) {
        this.A01 = pv;
    }
}
