package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: assets/audience_network.dex */
public abstract class SU extends OJ {
    public static byte[] A06;
    public static String[] A07 = {"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public KF A00;
    @Nullable
    public I5 A01;
    public C0905Ht A02;
    public final AnonymousClass16 A03;
    public final AnonymousClass19 A04;
    public final AbstractC1058Nx A05;

    public static String A0A(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 22);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A06 = new byte[]{9, 5, 7, 68, 12, 11, 9, 15, 8, 5, 5, 1, 68, 11, 14, 25, 68, 3, 4, 30, 15, 24, 25, 30, 3, 30, 3, 11, 6, 68, 9, 6, 3, 9, 1, 15, 14, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    static {
        A0B();
        A0B = (int) (LY.A00 * 48.0f);
        A0F = (int) (LY.A00 * 16.0f);
        A08 = (int) (LY.A00 * 4.0f);
        A0E = (int) (LY.A00 * 44.0f);
        A0C = (int) (LY.A00 * 8.0f);
        A0D = (int) (LY.A00 * 12.0f);
        A0H = (int) (LY.A00 * 12.0f);
        A0G = (int) (LY.A00 * 26.0f);
        A09 = C2N.A01(-1, 77);
        A0A = C2N.A01(A09, 90);
    }

    public SU(ON on, boolean z) {
        super(on, z);
        this.A03 = on.A04();
        this.A04 = this.A03.A0K();
        this.A05 = A09(on);
        MT A082 = on.A08();
        if (A082 != null) {
            A082.setLayoutParams(new RelativeLayout.LayoutParams(-1, A082.getToolbarHeight()));
            A082.setPageDetailsVisible(false);
        }
    }

    private AbstractC1058Nx A09(ON on) {
        String A0A2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (on.A04().A0U().equals(A0A(37, 14, 56))) {
            A0A2 = EnumC1097Pm.A04.A02();
        } else {
            A0A2 = A0A(0, 37, 124);
        }
        SV sv = new SV(on.A05(), A0B, this.A04.A0E().A00() == C1E.A05, getColors(), this.A04.A0F().A06(), A0A2, on.A06(), on.A09(), on.A0B(), on.A07());
        this.A02 = new C0905Ht(sv, 400, 100, 0);
        M5.A0K(sv);
        sv.A0A(on.A00());
        addView(sv, layoutParams);
        return sv;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        super.A0b(anonymousClass19, str, d2, bundle);
        this.A05.setInfo(anonymousClass19.A0E(), anonymousClass19.A0F(), str, this.A03.A0N().A01(), null);
    }

    public final int A0e(@Nullable MT mt) {
        return mt == null ? MT.A00 : mt.getToolbarHeight();
    }

    public void A0f() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            this.A00 = new KF(true);
            I5 i5 = this.A01;
            if (i5 != null) {
                KF kf = this.A00;
                if (A07[0].charAt(30) == 'l') {
                    throw new RuntimeException();
                }
                A07[7] = "KTvg88bTO6HmKn15GgbH1";
                kf.A0I(i5);
            }
            C1I A01 = this.A03.A0J().A01();
            this.A00.A0I(new C0911Hz(getAdDetailsView().getCTAButton(), IjkMediaCodecInfo.RANK_SECURE, -1, A01.A09(true)));
            this.A00.A0I(new IF(getAdDetailsView().getCTAButton(), IjkMediaCodecInfo.RANK_SECURE, M5.A08(A09, A0A, A08), M5.A05(A01.A08(true), A08)));
            this.A00.A0I(new I4(expandableLayout, 150, false));
            this.A00.A0H(2300);
        }
    }

    public AnonymousClass16 getAdDataBundle() {
        return this.A03;
    }

    public C0905Ht getAdDetailsAnimation() {
        return this.A02;
    }

    public AbstractC1058Nx getAdDetailsView() {
        return this.A05;
    }

    public AnonymousClass19 getAdInfo() {
        return this.A04;
    }

    public KF getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.OJ, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0A(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout == null || !z) {
            return;
        }
        I5 i52 = this.A01;
        if (A07[2].charAt(30) != '4') {
            throw new RuntimeException();
        }
        A07[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        if (i52 == null) {
            this.A01 = new I5(expandableLayout, IjkMediaCodecInfo.RANK_SECURE, expandableLayout.getHeight(), 0);
            this.A00.A0I(this.A01);
            this.A00.A0G();
        }
    }
}
