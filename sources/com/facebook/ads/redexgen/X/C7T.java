package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.7T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7T extends AbstractC1020Mk implements View.OnClickListener {
    public static String[] A05 = {"dj2bca5KMhic7lU7SNdjndSTQwmssf52", "TPlcacN2BRfqpmqqou3eGj4ypEirHC", "lK1i5T", "LDnNwGMA5Xj1Rc4RK", "9vPtQslMJEvaRYxyY6ZiMi1q6kn3NQTo", "pbwCeIFhJ07zfEQSECI2TdcOW", "Wj7W52", "ztBFgo3EeJBil6N8wes8zN"};
    public final AbstractC1018Mi A00;
    public final L3 A01;
    public final AbstractC0976Kq A02;
    public final AbstractC0971Kk A03;
    public final Q4 A04;

    public C7T(XT xt) {
        this(xt, null);
    }

    public C7T(XT xt, AttributeSet attributeSet) {
        this(xt, attributeSet, 0);
    }

    public C7T(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A03 = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.7a
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                C7T.this.setVisibility(0);
            }
        };
        this.A01 = new L3() { // from class: com.facebook.ads.redexgen.X.7Z
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06677u c06677u) {
                Q4 q4;
                q4 = C7T.this.A04;
                q4.setChecked(true);
            }
        };
        this.A02 = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.7V
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                Q4 q4;
                q4 = C7T.this.A04;
                q4.setChecked(false);
            }
        };
        this.A00 = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.7U
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                Q4 q4;
                q4 = C7T.this.A04;
                q4.setChecked(true);
            }
        };
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A04 = new Q4(xt);
        this.A04.setChecked(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.A04, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A07() {
        super.A07();
        setOnClickListener(this);
        this.A04.setOnClickListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A00, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A01, this.A00, this.A03);
        }
        setOnClickListener(null);
        this.A04.setOnClickListener(null);
        super.A08();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            C1099Po videoView = getVideoView();
            if (videoView == null) {
                return;
            }
            if (videoView.getState() == QW.A07 || videoView.getState() == QW.A05 || videoView.getState() == QW.A06) {
                videoView.A0b(EnumC1094Pj.A05, 11);
            } else if (videoView.getState() == QW.A0A) {
                videoView.A0e(true, 7);
            }
        } catch (Throwable th) {
            if (A05[5].length() != 25) {
                throw new RuntimeException();
            }
            A05[7] = "YsoDkb8mAWGLBYzRGBa3i8";
            C0974Kn.A00(th, this);
        }
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        this.A04.setPauseAccessibilityLabel(str);
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        this.A04.setPlayAccessibilityLabel(str);
    }
}
