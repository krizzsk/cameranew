package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class T4 extends RelativeLayout implements MV {
    public static byte[] A0D;
    public static String[] A0E = {"fqT9snXDZkE2N6bIU2twhbCcrvrF5wQR", "W8MK3buqarkLhDixdfnbfGeXuw3i87xB", "M5iWaw3OwwKxChS5bTa9KUrj63pwu1Od", "QKu8TlGQ3D7NsDDaY", "OUnrWL6BanKvWJF", "644mHU9zQQHAcSiNB", "MqQzuM0GD0HqxOL2854PPJvoiao7nama", "mSpdOD621tCilusEUOf234Jx9LR3KzyX"};
    public View A00;
    @Nullable
    public LS A01;
    @Nullable
    public P5 A02;
    public boolean A03;
    public boolean A04;
    public AnonymousClass17 A05;
    public final View$OnSystemUiVisibilityChangeListenerC1004Lu A06;
    public final MU A07;
    public final C1528cj A08;
    public final XT A09;
    public final JT A0A;
    public final C0937Jb A0B;
    public final MT A0C;

    public static String A0L(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 81);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0D = new byte[]{88, 84, 86, 21, 93, 90, 88, 94, 89, 84, 84, 80, 21, 90, 95, 72, 21, 82, 85, 79, 94, 73, 72, 79, 82, 79, 82, 90, 87, 21, 82, 86, 75, 73, 94, 72, 72, 82, 84, 85, 21, 87, 84, 92, 92, 94, 95};
    }

    public abstract boolean A0a();

    @ToolbarActionView$ToolbarActionMode
    public abstract int getCloseButtonStyle();

    static {
        A0O();
    }

    public T4(XT xt, JT jt, MU mu, C1528cj c1528cj) {
        super(xt);
        this.A04 = false;
        this.A03 = false;
        this.A09 = xt;
        this.A0A = jt;
        this.A07 = mu;
        this.A06 = new View$OnSystemUiVisibilityChangeListenerC1004Lu(this);
        this.A08 = c1528cj;
        this.A0B = new C0937Jb(this.A08.A0Q(), this.A0A);
        this.A0C = new FullScreenAdToolbar(this.A09, getAudienceNetworkListener(), this.A0B, 0, this.A08.A0D());
    }

    private C1I A0K(int i2) {
        if (i2 == 1) {
            return this.A05.A01();
        }
        AnonymousClass17 anonymousClass17 = this.A05;
        if (A0E[2].charAt(7) != 'O') {
            throw new RuntimeException();
        }
        A0E[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        return anonymousClass17.A00();
    }

    private void A0M() {
        removeAllViews();
        M5.A0J(this);
    }

    private void A0N() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (A0X() && this.A02 == null) {
            this.A04 = true;
            this.A02 = new P3(this.A09, this.A08.A0K().A0E(), this.A08.A0N()).A08(this.A08.A0J().A01()).A0B();
            C0939Jd.A04(this.A02, this.A0B, EnumC0936Ja.A0U);
            this.A07.A3G(this, 0, layoutParams);
            this.A07.A3G(this.A02, 1, layoutParams);
            this.A02.A04(new T6(this));
            return;
        }
        this.A07.A3G(this, 0, layoutParams);
    }

    private void A0P(C1I c1i, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0C.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0C.A04(c1i, z);
        addView(this.A0C, layoutParams);
    }

    public final void A0S() {
        View view = this.A00;
        if (view == null || !(view instanceof OJ)) {
            return;
        }
        if (A0Y()) {
            ((OJ) this.A00).A0a();
        } else {
            ((OJ) this.A00).A0Z();
        }
    }

    public final void A0T(int i2) {
        this.A01 = new LS(i2, new T5(this, i2));
        this.A03 = true;
        A0S();
        this.A01.A07();
    }

    public final void A0U(View view, boolean z, int i2) {
        this.A00 = view;
        this.A06.A05(EnumC1003Lt.A03);
        A0M();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z ? 0 : this.A0C.getToolbarHeight(), 0, 0);
        layoutParams.addRule(12);
        addView(view, layoutParams);
        C1I A0K = A0K(i2);
        A0P(A0K, z);
        M5.A0M(this, A0K.A07(false));
        if (this.A07 != null) {
            A0N();
            String[] strArr = A0E;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0E[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            if (z && Build.VERSION.SDK_INT >= 19) {
                View$OnSystemUiVisibilityChangeListenerC1004Lu view$OnSystemUiVisibilityChangeListenerC1004Lu = this.A06;
                if (A0E[0].charAt(10) == 'o') {
                    throw new RuntimeException();
                }
                A0E[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                view$OnSystemUiVisibilityChangeListenerC1004Lu.A05(EnumC1003Lt.A04);
            }
        }
    }

    public final void A0V(AnonymousClass52 anonymousClass52) {
        this.A06.A04(anonymousClass52.A0H().getWindow());
        this.A05 = this.A08.A0J();
        AnonymousClass19 anonymousClass19 = null;
        if (this.A08.A0K() != null && this.A08.A0K() != null) {
            anonymousClass19 = this.A08.A0K();
        }
        this.A0C.setPageDetails(this.A08.A0N(), this.A08.A0Q(), anonymousClass19 != null ? anonymousClass19.A0D().A03() : 0, this.A08.A0O());
        this.A0C.setToolbarListener(new T8(this, anonymousClass52));
    }

    public final void A0W(AnonymousClass52 anonymousClass52) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1011Mb(this, this, anonymousClass52));
        startAnimation(alphaAnimation);
    }

    public final boolean A0X() {
        if (!this.A08.A0X().isEmpty()) {
            boolean A0O = this.A08.A0K().A0O();
            if (A0E[6].charAt(3) != 'z') {
                throw new RuntimeException();
            }
            A0E[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            if (A0O) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0Y() {
        return this.A03;
    }

    public final boolean A0Z() {
        return this.A04;
    }

    public void ABU(boolean z) {
        LS ls = this.A01;
        if (ls != null && ls.A05()) {
            this.A01.A06();
        }
    }

    public void ABt(boolean z) {
        LS ls = this.A01;
        if (ls != null && !ls.A04()) {
            this.A01.A07();
        }
    }

    public JT getAdEventManager() {
        return this.A0A;
    }

    public MU getAudienceNetworkListener() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A06.A03();
        this.A0C.setToolbarListener(null);
        A0M();
    }

    public void setImpressionRecordingFlag(C1009Lz c1009Lz) {
        c1009Lz.A05();
        if (getAudienceNetworkListener() != null) {
            getAudienceNetworkListener().A3q(A0L(0, 47, 106));
        }
    }

    public void setListener(MU mu) {
    }
}
