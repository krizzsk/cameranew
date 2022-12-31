package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.9t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C07139t extends SU implements InterfaceC1021Ml {
    public static byte[] A0D;
    public static String[] A0E = {"QUFYIN7o4MSHfMbcaqgxGqdg8oING", "Qixa92rp7KQSHPhBId3L5m9SXc6gxNRP", "TUKhftCqFUFv9xNbjbPA3CLhBIkdW", "aNiMBj1VMT3xct4Co4hWzqTsg", "QYSCqyZ4CS", "VjIbmM2G6pRRrYhuKIf6SOzC6eQUF7eo", "KFJXOgKoK7JNlCBWMf", "dachHr6cLZKwbIDqTeRsc0FgbmZCJ"};
    @Nullable
    public View A00;
    public View A01;
    public XT A02;
    @Nullable
    public MT A03;
    public PU A04;
    @Nullable
    public C0905Ht A05;
    public boolean A06;
    public final MU A07;
    public final O7 A08;
    public final O8 A09;
    public final C1099Po A0A;
    public final IS A0B;
    public final AtomicBoolean A0C;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 13);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{-53, -60, -39, -56, -30, -42, -41, -60, -43, -41, -52, -47, -54, -30, -60, -47, -52, -48, -60, -41, -52, -46, -47, -42, -30, -45, -49, -60, -36, -56, -57, -51, -48, -44, -58, -32, -45, -58, -40, -62, -45, -59, -32, -44, -60, -45, -58, -58, -49, -32, -44, -55, -48, -40, -49, -53, -75, -57, -45, -71, -62, -72, -45, -73, -75, -58, -72, -45, -57, -68, -61, -53, -62};
    }

    static {
        A07();
    }

    public C07139t(ON on) {
        super(on, false);
        this.A0C = new AtomicBoolean(false);
        this.A06 = false;
        this.A02 = on.A05();
        this.A03 = on.A08();
        this.A01 = new View(this.A02);
        M5.A0K(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.A01, layoutParams);
        A04();
        this.A07 = on.A09();
        OH.A00(on.A05(), this, getAdInfo().A0D().A07());
        this.A0A = A00(on);
        getAdDetailsView().bringToFront();
        this.A0B = A01(on);
        A0f();
        this.A04 = new PU(this.A02, on.A06(), getAdDataBundle());
        this.A08 = new SS(this);
        this.A09 = new O8(on, getAdDataBundle(), this.A0A, this.A0B, getAdDetailsView(), this.A07, this.A08);
    }

    private C1099Po A00(ON on) {
        C1099Po c1099Po = (C1099Po) on.A02();
        int A0e = A0e(on.A08());
        ImageView imageView = (ImageView) on.A03();
        imageView.setPadding(SU.A0D, SU.A0D, SU.A0D, SU.A0D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SU.A0E, SU.A0E);
        layoutParams.setMargins(0, A0e, SU.A0C, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        addView(c1099Po, layoutParams2);
        c1099Po.addView(imageView, layoutParams);
        return c1099Po;
    }

    private IS A01(ON on) {
        IS A0A = on.A0A();
        A0A.A06(-1, SU.A09);
        A0A.setPadding(SU.A0H, SU.A0H, SU.A0H, SU.A0H);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, SU.A0G);
        layoutParams.addRule(12);
        addView(A0A, layoutParams);
        return A0A;
    }

    private void A03() {
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A0E();
            this.A0A.A0d(getAnimationPlugin());
        }
    }

    private void A04() {
        MT mt = this.A03;
        if (mt == null) {
            return;
        }
        this.A05 = new C0905Ht(mt, 400, -mt.getToolbarHeight(), 0);
    }

    private void A05() {
        new C0937Jb(getAdDataBundle().A0Q(), getAdEventManager()).A02(EnumC0936Ja.A0p, null);
        if (!getAdInfo().A0N()) {
            return;
        }
        this.A0C.set(true);
        M5.A0T(this);
        M5.A0H(this.A0A);
        M5.A0Z(this.A0A, this.A0B, this.A09, this.A00);
        M5.A0L(this.A03);
        PU pu = this.A04;
        SZ ctaButton = getCtaButton();
        String[] strArr = A0E;
        if (strArr[2].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A0E[3] = "FxfG3zWETYKhpCEsP1aqGpvXk";
        Pair<PT, View> A03 = pu.A03(ctaButton);
        this.A00 = (View) A03.second;
        int i2 = OO.A00[((PT) A03.first).ordinal()];
        if (i2 == 1) {
            getAdDetailsView().setVisibility(0);
            RelativeLayout.LayoutParams screenshotParams = new RelativeLayout.LayoutParams(-1, -1);
            screenshotParams.setMargins(0, A0e(this.A03), 0, 0);
            screenshotParams.addRule(2, getAdDetailsView().getId());
            addView(this.A00, screenshotParams);
        } else if (i2 != 2) {
        } else {
            M5.A0Z(getAdDetailsView());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(SU.A0F, SU.A0F, SU.A0F, SU.A0F);
            addView(this.A00, layoutParams);
        }
    }

    private void A06() {
        C0905Ht c0905Ht = this.A05;
        if (c0905Ht != null) {
            c0905Ht.A3L(true, false);
        }
        if (getAdDetailsAnimation() != null) {
            getAdDetailsAnimation().A3L(true, false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A09(C06687v c06687v) {
        super.A09(c06687v);
        A05();
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0A(C06667t c06667t) {
        super.A0A(c06667t);
        int duration = this.A0A.getDuration() - c06667t.A00();
        if (getAnimationPlugin() != null) {
            int remainingVideoTimeInMillis = A0E[1].charAt(18);
            if (remainingVideoTimeInMillis != 51) {
                throw new RuntimeException();
            }
            A0E[5] = "xiBnzSw2W6K3rvYkwdUGMYXv5m3ZqRWR";
            if (duration < 3000 && getAnimationPlugin().A0J()) {
                getAnimationPlugin().A0F();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0W() {
        super.A0W();
        A03();
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.X.SU, com.facebook.ads.redexgen.X.OJ
    public final void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        super.A0b(anonymousClass19, str, d2, bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.getBoolean(A02(0, 31, 118), false)) {
            A06();
        }
        if (bundle.getBoolean(A02(55, 18, 103), false)) {
            A05();
        }
        if (bundle.getBoolean(A02(31, 24, 116), false)) {
            O8 o8 = this.A09;
            if (A0E[1].charAt(18) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[2] = "jjtMTZWEM7Dg1szUnnnmuTjwvMhej";
            strArr[0] = "cexdZia4vusGbXInA5fVVHDcQrSB4";
            o8.A07(this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0d(boolean z) {
        if (z && !this.A06) {
            boolean z2 = this.A0C.get();
            String[] strArr = A0E;
            if (strArr[7].length() != strArr[4].length()) {
                String[] strArr2 = A0E;
                strArr2[2] = "IfEmWBIDBUNw5tL7YhS4lNzldGhzw";
                strArr2[0] = "8CoNQoXVMdzgwU1krh95bRLsSKKH4";
                if (!z2) {
                    this.A09.A07(this);
                    return true;
                }
            }
            throw new RuntimeException();
        }
        boolean A0N = getAdInfo().A0N();
        if (A0E[5].charAt(17) != 'k') {
            A0E[1] = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor";
            if (A0N && !this.A0C.get()) {
                this.A0A.A0a(EnumC1090Pf.A08);
                return true;
            }
            return false;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.SU
    public final void A0f() {
        super.A0f();
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A8f(this.A0A);
        }
    }

    public final boolean A0g() {
        return getAdInfo().A0N();
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        if (A0g() && !this.A0C.get()) {
            return 1;
        }
        return super.getCloseButtonStyle();
    }

    @Override // com.facebook.ads.redexgen.X.SU, com.facebook.ads.redexgen.X.OJ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
