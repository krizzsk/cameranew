package com.facebook.ads.redexgen.X;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Hz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0911Hz implements Q6 {
    public static byte[] A06;
    public static String[] A07 = {"A7BI5", "gKWOMBrJHuMwvM90e1kQxbLVjOWHbC33", "UYN9ptwwhG6kseDSIUjMW4tKOOJXD2Z7", "Ja75eMPfNEu2gmMNMrA6", "IMMQ3U1D8CAOequczoeO", "aOtgKGua3vuGYyvCOzm8c8DJStBVo0w", "j", "V23k2coZlnHKKs"};
    @Nullable
    public ValueAnimator A00;
    public Q5 A01 = Q5.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{40, 25, 44, 40, -9, 35, 32, 35, 38};
    }

    static {
        A05();
    }

    public C0911Hz(View view, int i2, int i3, int i4) {
        this.A02 = i2;
        this.A05 = view;
        this.A04 = i3;
        this.A03 = i4;
    }

    private void A06(int i2, int i3) {
        this.A01 = i2 == this.A04 ? Q5.A04 : Q5.A06;
        this.A00 = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 82), i2, i3);
        this.A00.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new QC(this, i2, i3));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i2, int i3, boolean z) {
        if (z) {
            A06(i2, i3);
            return;
        }
        View view = this.A05;
        if (A07[4].length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "Y4rCa4lywlEdVv";
        strArr[0] = "Hdg5N";
        ((TextView) view).setTextColor(i3);
        this.A01 = i3 == this.A03 ? Q5.A03 : Q5.A05;
    }

    @Override // com.facebook.ads.redexgen.X.Q6
    public final void A3L(boolean z, boolean z2) {
        A07(z2 ? this.A03 : this.A04, z2 ? this.A04 : this.A03, z);
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
