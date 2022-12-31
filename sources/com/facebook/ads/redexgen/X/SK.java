package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public final class SK extends OJ {
    @Nullable
    public static SK A0S;
    public static byte[] A0T;
    public static String[] A0U = {"E7d9V", "HfiTPdnQE6JsOHdYoOA4lRNnbQ3", "7AVXCU5oRbsgBqmorHmAVCwb6r5tuTQ8", "hoWzaZbN7yXesQFa", "a3ZYa3", "EXUfJIeYYGyfdCGOPOS2l0on83CPH94Z", "MYJwByDzw5bCUSkxw6qgTJ7WJbI", "X3l5ZIwYV4"};
    public static final int A0V;
    public static final int A0W;
    public static final int A0X;
    public static final int A0Y;
    public static final int A0Z;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public View A06;
    public LinearLayout A07;
    public LinearLayout A08;
    public TextView A09;
    public AnonymousClass16 A0A;
    public NW A0B;
    public NX A0C;
    @Nullable
    public C1175Sm A0D;
    public ON A0E;
    public OU A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public final View A0M;
    public final AbstractC04770f A0N;
    public final C0937Jb A0O;
    public final O7 A0P;
    public final O8 A0Q;
    public final IS A0R;

    public static String A0A(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0T, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 122);
        }
        return new String(copyOfRange);
    }

    public static void A0K() {
        A0T = new byte[]{36};
    }

    static {
        A0K();
        A0X = (int) (LY.A00 * 26.0f);
        A0V = (int) (LY.A00 * 4.0f);
        A0Z = (int) (LY.A00 * 8.0f);
        A0W = C2N.A01(-1, 77);
        A0Y = (int) (LY.A00 * 12.0f);
        A0S = null;
    }

    public SK(ON on) {
        super(on, true);
        this.A01 = 0;
        this.A0G = false;
        this.A0I = false;
        this.A0K = false;
        this.A0J = false;
        this.A0L = false;
        this.A0E = on;
        this.A0A = this.A0E.A04();
        this.A0O = new C0937Jb(on.A04().A0Q(), on.A06());
        this.A0R = this.A0E.A0A();
        IS is = this.A0R;
        if (is != null) {
            M5.A0K(is);
        }
        this.A0M = this.A0E.A03();
        this.A0N = C04780g.A01(on.A05(), on.A06(), on.A04().A0Q(), Uri.parse(on.A04().A0K().A0F().A05()), new HashMap(), false, true);
        OH.A00(on.A05(), this, on.A04().A0K().A0D().A07());
        setupLayoutConfiguration(false);
        A0G();
        A0C();
        postDelayed(new SQ(this), 1000L);
        A0J();
        this.A0P = new SP(this);
        this.A0Q = new O8(on, this.A0A, this.A0E.A02() instanceof C1099Po ? (C1099Po) this.A0E.A02() : null, this.A0E.A09(), this.A0P, this.A09, this.A0F, this.A0R, this.A0M);
    }

    private void A0B() {
        M5.A0J(this.A08);
        this.A08 = new LinearLayout(this.A0E.A05());
        M5.A0R(this.A08, getAdContextWrapper());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0G ? this.A02 / 4 : this.A02 / 5);
        layoutParams.addRule(12);
        this.A08.setLayoutParams(layoutParams);
        addView(this.A08, 2);
    }

    private void A0C() {
        M5.A0J(this.A07);
        this.A07 = new LinearLayout(this.A0E.A05());
        this.A07.setOrientation(1);
        M5.A0K(this.A07);
        A0H();
        this.A07.setBackgroundColor(-1);
        addView(this.A07);
    }

    private void A0D() {
        View view = this.A0M;
        if (view != null) {
            M5.A0J(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(OJ.A09, OJ.A09);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(OJ.A08, this.A05, OJ.A08, OJ.A08);
            addView(this.A0M, layoutParams);
        }
    }

    private void A0E() {
        IS is = this.A0R;
        if (is != null) {
            M5.A0J(is);
            IS is2 = this.A0R;
            int i2 = A0Y;
            is2.setPadding(i2, i2, i2, i2);
            this.A0R.A06(-1, A0W);
            this.A0R.setTranslationY(0.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0X);
            if (this.A0H) {
                layoutParams.addRule(8, this.A06.getId());
            } else {
                String[] strArr = A0U;
                if (strArr[3].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0U;
                strArr2[3] = "zjul6o0OG2Ezis8Q";
                strArr2[0] = "LmcEL";
                layoutParams.addRule(12);
            }
            addView(this.A0R, layoutParams);
        }
    }

    private void A0F() {
        MT A08 = this.A0E.A08();
        if (A08 == null) {
            return;
        }
        A08.setPageDetailsVisible((this.A0H || A08.A05()) ? false : true);
    }

    private void A0G() {
        this.A06 = this.A0E.A02();
        M5.A0J(this.A06);
        M5.A0K(this.A06);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        addView(this.A06, 1, layoutParams);
        this.A09 = new TextView(this.A0E.A05());
        M5.A0K(this.A09);
        this.A09.setGravity(17);
        this.A09.setTextColor(getColors().A05(true));
        this.A09.setEllipsize(TextUtils.TruncateAt.END);
        this.A09.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        int i2 = A0Z;
        layoutParams2.setMargins(i2, i2 / 2, i2, this.A0R == null ? i2 : A0X);
        addView(this.A09, layoutParams2);
        M5.A0K(this.A09);
        ON on = this.A0E;
        this.A0F = new OU(on, on.A04().A0K().A0F().A04(), getColors(), new SO(this));
        M5.A0G(1001, this.A0F);
        addView(this.A0F);
        A0I();
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (this.A03 * 4) / 5);
        if (A0e()) {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(12);
            LinearLayout linearLayout = this.A07;
            String[] strArr = A0U;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0U;
            strArr2[7] = "mOqhFUC5R4";
            strArr2[4] = "x2rQdK";
            linearLayout.setLayoutParams(layoutParams);
        } else {
            layoutParams.setMargins(0, this.A03 + 1, 0, 0);
        }
        this.A07.setTranslationY(0.0f);
        this.A07.setLayoutParams(layoutParams);
    }

    private void A0I() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.A0G ? this.A02 / 4 : this.A02 / 5);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.A09.getId());
        layoutParams.setMargins(0, 0, 0, 0);
        this.A0F.setLayoutParams(layoutParams);
    }

    private void A0J() {
        A0E();
        A0D();
        A0F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(String str) {
        C1175Sm c1175Sm;
        M5.A0J(this.A0D);
        SM sm = new SM(this);
        if (this.A0E.A05().A0C() == null) {
            this.A0E.A05().A0D().A80();
        }
        if (JE.A02(this.A0E.A05()) || this.A0E.A05().A0C() == null) {
            c1175Sm = new C1175Sm(this.A0E.A05(), sm);
        } else {
            c1175Sm = new C1175Sm(this.A0E.A05(), this.A0E.A05().A0C(), sm);
        }
        this.A0D = c1175Sm;
        setUpBrowserControls(this.A0D);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 0.9f;
        this.A07.addView(this.A0D, layoutParams);
        this.A0D.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P(boolean z) {
        ObjectAnimator objectAnimator;
        int i2;
        int i3;
        long j2;
        int i4;
        this.A0H = z;
        postDelayed(new SL(this, z), 250L);
        ObjectAnimator ctaTransAnim = null;
        String A0A = A0A(0, 1, 39);
        if (z) {
            OU ou = this.A0F;
            objectAnimator = ObjectAnimator.ofFloat(ou, A0A, ou.getY(), this.A03 / 5);
        } else {
            objectAnimator = null;
        }
        LinearLayout linearLayout = this.A07;
        float[] fArr = new float[2];
        fArr[0] = linearLayout.getY();
        int i5 = this.A03;
        if (z) {
            i5 /= 5;
        }
        fArr[1] = i5;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, A0A, fArr);
        ofFloat.setDuration(500L);
        int i6 = (this.A03 / 2) - (this.A01 / 2);
        View view = this.A06;
        float[] fArr2 = new float[2];
        fArr2[0] = view.getY();
        fArr2[1] = (z || this.A0G) ? 0.0f : i6;
        ObjectAnimator browserTransAnim = ObjectAnimator.ofFloat(view, A0A, fArr2);
        browserTransAnim.setDuration(500L);
        IS is = this.A0R;
        int height = is == null ? 0 : is.getHeight();
        if (z) {
            int i7 = this.A02;
            String[] strArr = A0U;
            if (strArr[6].length() == strArr[1].length()) {
                String[] strArr2 = A0U;
                strArr2[7] = "g83HcTndNM";
                strArr2[4] = "KO02it";
                i2 = (i7 / 5) - height;
            }
            throw new RuntimeException();
        }
        i2 = (this.A03 - A0X) - A0Z;
        IS is2 = this.A0R;
        if (is2 != null) {
            float[] fArr3 = new float[2];
            fArr3[0] = is2.getY();
            String[] strArr3 = A0U;
            if (strArr3[6].length() == strArr3[1].length()) {
                A0U[2] = "uMAfPHErUq8gYLqYGWwvrPw2H7I5hxcd";
                fArr3[1] = i2;
                ctaTransAnim = ObjectAnimator.ofFloat(is2, A0A, fArr3);
            }
            throw new RuntimeException();
        }
        int[] iArr = new int[2];
        iArr[0] = this.A06.getHeight();
        if (z) {
            i3 = this.A03 / 5;
        } else {
            i3 = this.A01;
        }
        iArr[1] = i3;
        ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(500L);
        duration.addUpdateListener(new OQ(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, browserTransAnim, duration);
        if (objectAnimator != null) {
            j2 = 500;
            objectAnimator.setDuration(500L);
            i4 = 1;
            animatorSet.playTogether(objectAnimator);
        } else {
            j2 = 500;
            i4 = 1;
        }
        if (ctaTransAnim != null) {
            ctaTransAnim.setDuration(j2);
            Animator[] animatorArr = new Animator[i4];
            animatorArr[0] = ctaTransAnim;
            animatorSet.playTogether(animatorArr);
        }
        animatorSet.addListener(new OR(this, z));
        animatorSet.start();
    }

    private void A0Q(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        setupLayoutConfiguration(z);
        M5.A0J(this.A06);
        this.A06 = this.A0E.A02();
        M5.A0K(this.A06);
        if (this.A0H) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.A03 / 5);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            A0C();
        }
        this.A06.setTranslationY(0.0f);
        String[] strArr = A0U;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0U;
        strArr2[7] = "FZuJEB1DgE";
        strArr2[4] = "ioAK5D";
        addView(this.A06, 1, layoutParams);
        A0B();
        A0I();
    }

    private boolean A0R() {
        if (this.A0A.A0K().A0D().A0A()) {
            boolean z = this.A0J;
            String[] strArr = A0U;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0U;
            strArr2[7] = "WvW0Ef6T7c";
            strArr2[4] = "9KXIlI";
            if (z && !this.A0L && !this.A0K) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0W() {
        super.A0W();
        A0S = null;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0X() {
        MT A08 = this.A0E.A08();
        if (A08 != null) {
            A08.setPageDetailsVisible((A0e() || A08.A05()) ? false : true);
        }
        this.A0J = false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0Y() {
        if (this.A0E.A08() != null) {
            MT A08 = this.A0E.A08();
            String[] strArr = A0U;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0U;
            strArr2[3] = "MMiJw7TNUivh7iTB";
            strArr2[0] = "GEB80";
            A08.setPageDetailsVisible(false);
        }
        this.A0J = true;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0Z() {
        this.A0K = false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0a() {
        this.A0K = true;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        super.A0b(anonymousClass19, str, d2, bundle);
        String A05 = anonymousClass19.A0E().A05();
        if (A05 == null || A05.trim().length() == 0) {
            M5.A0N(this.A08, 8);
        } else {
            this.A09.setText(A05);
        }
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.A01 = (int) (this.A04 / d2);
        }
        this.A01 = this.A0G ? this.A02 : this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0d(boolean z) {
        if (A0e()) {
            A0P(false);
            return true;
        } else if (A0R()) {
            this.A0Q.A07(this);
            return true;
        } else {
            return false;
        }
    }

    public final boolean A0e() {
        return this.A0H;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        if (A0e()) {
            return 3;
        }
        if (this.A0K) {
            return 2;
        }
        if (this.A0A.A0K().A0D().A0A()) {
            return 1;
        }
        if (this.A0J) {
            if (A0U[5].charAt(10) != 'N') {
                String[] strArr = A0U;
                strArr[6] = "NhzVRhgvHrOwM64xV2PIAOEbNcq";
                strArr[1] = "xEzMNY3CkayGfsMDFyAKLsf22gx";
                return 4;
            }
            throw new RuntimeException();
        }
        return super.getCloseButtonStyle();
    }

    private String getUrl() {
        return this.A0E.A04().A0K().A0F().A05();
    }

    @Override // com.facebook.ads.redexgen.X.OJ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0Q(A0e());
        A0J();
        setupLayoutConfiguration(A0e());
        A0H();
    }

    private void setUpBrowserControls(C1175Sm c1175Sm) {
        M5.A0J(this.A0B);
        this.A0B = new NW(this.A0E.A05(), c1175Sm);
        c1175Sm.setBrowserNavigationListener(this.A0B.getBrowserNavigationListener());
        M5.A0K(this.A0B);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.1f;
        this.A0B.setListener(new SN(this));
        this.A0B.setOnTouchListener(new OP(this));
        this.A07.addView(this.A0B, layoutParams);
        M5.A0J(this.A0C);
        this.A0C = new NX(this.A0E.A05(), null, 16842872);
        this.A07.addView(this.A0C, new LinearLayout.LayoutParams(-1, A0V));
    }

    private void setupLayoutConfiguration(boolean z) {
        this.A0G = getResources().getConfiguration().orientation == 2;
        this.A05 = this.A0E.A08() == null ? 0 : this.A0E.A08().getToolbarHeight();
        this.A0H = z;
        this.A02 = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.A03 = this.A02 + (this.A0G ? 0 : this.A05);
        this.A01 = this.A02;
    }
}
