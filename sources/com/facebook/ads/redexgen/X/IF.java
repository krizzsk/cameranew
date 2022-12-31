package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public final class IF implements Q6 {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public Q5 A02 = Q5.A05;

    public IF(View view, int i2, Drawable drawable, Drawable drawable2) {
        this.A03 = i2;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        M5.A0S(this.A07, this.A01);
    }

    private void A04(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = Q5.A06;
            M5.A0S(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new IH(this), this.A03);
            return;
        }
        M5.A0S(this.A07, this.A05);
        this.A02 = Q5.A05;
    }

    private void A05(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = Q5.A04;
            M5.A0S(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new IK(this), this.A03);
            return;
        }
        M5.A0S(this.A07, this.A04);
        this.A02 = Q5.A03;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void A3L(boolean z, boolean z2) {
        if (z2) {
            A04(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final Q5 A7R() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void cancel() {
        Q5 q5;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == Q5.A04) {
            q5 = Q5.A05;
        } else {
            q5 = Q5.A03;
        }
        this.A02 = q5;
    }
}
