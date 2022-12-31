package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class I5 implements Q6 {
    public int A00;
    @Nullable
    public ValueAnimator A01;
    public Q5 A02 = Q5.A05;
    public final int A03;
    public final int A04;
    public final View A05;

    public I5(View view, int i2, int i3, int i4) {
        this.A05 = view;
        this.A03 = i2;
        this.A00 = i3;
        this.A04 = i4;
    }

    private ValueAnimator A00(int i2, int i3, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(this.A03);
        ofInt.addUpdateListener(new Q9(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z) {
        if (z) {
            this.A02 = Q5.A06;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new Q8(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        M5.A0H(this.A05);
        this.A02 = Q5.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z) {
        M5.A0L(this.A05);
        if (z) {
            this.A02 = Q5.A04;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new Q7(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = Q5.A03;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void A3L(boolean z, boolean z2) {
        if (z2) {
            A07(z);
        } else {
            A08(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final Q5 A7R() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void cancel() {
        ValueAnimator valueAnimator = this.A01;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
