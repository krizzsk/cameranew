package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.6e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06296e extends AbstractC1020Mk {
    public final Paint A00;
    public final XT A01;
    @Nullable
    public final C0937Jb A02;
    public final AbstractC1018Mi A03;
    public final L3 A04;
    public final AbstractC0976Kq A05;
    public final Q4 A06;

    public C06296e(XT xt, boolean z, @Nullable C0937Jb c0937Jb) {
        super(xt);
        this.A04 = new L3() { // from class: com.facebook.ads.redexgen.X.7Q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06677u c06677u) {
                Q4 q4;
                q4 = C06296e.this.A06;
                q4.setChecked(true);
            }
        };
        this.A05 = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.7P
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                Q4 q4;
                q4 = C06296e.this.A06;
                q4.setChecked(false);
            }
        };
        this.A03 = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.7D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                Q4 q4;
                q4 = C06296e.this.A06;
                q4.setChecked(true);
            }
        };
        this.A02 = c0937Jb;
        this.A01 = xt;
        this.A06 = new Q4(xt, z);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 23.76d), (int) (displayMetrics.density * 23.76d));
        layoutParams.addRule(13);
        this.A06.setLayoutParams(layoutParams);
        this.A06.setChecked(true);
        this.A06.setClickable(false);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        if (z) {
            this.A00.setColor(-1728053248);
        } else {
            this.A00.setColor(-1);
            this.A00.setAlpha(204);
        }
        M5.A0M(this, 0);
        addView(this.A06);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 72.0d), (int) (displayMetrics.density * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A04, this.A05, this.A03);
        }
        setOnClickListener(new Q1(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A08() {
        setOnClickListener(null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A05, this.A04);
        }
        super.A08();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int centerX = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i2 = centerX / 2;
        canvas.drawCircle(getPaddingLeft() + i2, getPaddingTop() + (centerX / 2), i2, this.A00);
        super.onDraw(canvas);
    }
}
