package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Ht  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0905Ht implements Q6 {
    public static String[] A06 = {"Zp1jBMTXyTngXAjRlLP1q6RZbaUI", "nHljDkT3i8Wirocu51jroGsoJHOhv1cR", "sP6X6aS", "KZL6M4", "KoOjzqZIxieUbLbPf8D", "B1jmqrSafv9jI6Lw73IRSYcL6IlnF6YH", "FLN3m70EKIfdw8", "ppmNyXlbfQKy53gkSU0tUatt7Y3PBdXb"};
    @Nullable
    public ValueAnimator A00;
    public Q5 A01 = Q5.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public C0905Ht(View view, int i2, int i3, int i4) {
        this.A05 = view;
        this.A02 = i2;
        this.A04 = i3;
        this.A03 = i4;
    }

    private ValueAnimator A00(View view, int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(this.A02);
        ofInt.addUpdateListener(new QF(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            if (A06[1].charAt(28) != 'v') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "75AaLozsvbqC7RPKNa9MBDOQqsQ1eQ5U";
            strArr[5] = "oWQ9IgFva7oIaP1s8z2NxAvwjcynmKEe";
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z) {
        if (z) {
            this.A01 = Q5.A06;
            this.A00 = A00(this.A05, this.A03, this.A04);
            this.A00.addListener(new QE(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        M5.A0H(this.A05);
        this.A01 = Q5.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z) {
        M5.A0L(this.A05);
        if (z) {
            this.A01 = Q5.A04;
            this.A00 = A00(this.A05, this.A04, this.A03);
            this.A00.addListener(new QD(this));
            this.A00.start();
            return;
        }
        View view = this.A05;
        if (A06[1].charAt(28) != 'v') {
            throw new RuntimeException();
        }
        A06[4] = "CRQ3If4kF9c";
        view.setTranslationY(this.A03);
        this.A01 = Q5.A03;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void A3L(boolean z, boolean z2) {
        if (z2) {
            A08(z);
        } else {
            A09(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final Q5 A7R() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void cancel() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
