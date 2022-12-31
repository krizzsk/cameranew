package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.b5  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1435b5 extends C3F {
    public static String[] A01 = {"OZnJYNnF6iNpWafuL0M1gR4fftLtNKLH", "jp3I09eVvza8VUO8I2V9bgD0uqoo2eoT", "o0dN6TNbDPM1OFHwgByg4fes3ij5f0X", "koNydS70AznyGH22QswPXmmCOWqgW7Lp", "FfQJA5dgq067zFURnAgi95yx0TDwU15M", "ldbJEvhnHaVxGyPD7qN3mcBmJCgMtAqs", "ixVhzklDdFphFwHpdcaKVfByjOKIZSaQ", "Bo7wQ6HJBqNsqngGB"};
    public int A00;

    public C1435b5(Context context) {
        super(context);
        this.A00 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00(int i2) {
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.C3F, android.view.View
    public final void onMeasure(int i2, int i3) {
        int measuredHeight;
        int h2 = this.A00;
        int i4 = 0;
        while (true) {
            int childCount = getChildCount();
            String[] strArr = A01;
            if (strArr[4].charAt(3) != strArr[0].charAt(3)) {
                throw new RuntimeException();
            }
            A01[2] = "oQM5as2Hx349sp";
            if (i4 < childCount) {
                View childAt = getChildAt(i4);
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                if (A01[3].charAt(2) != 'N') {
                    measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight <= h2) {
                        i4++;
                    }
                    h2 = measuredHeight;
                    i4++;
                } else {
                    A01[7] = "8uJesuWryF1bocGxs";
                    measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight <= h2) {
                        i4++;
                    }
                    h2 = measuredHeight;
                    i4++;
                }
            } else {
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(h2, 1073741824));
                return;
            }
        }
    }
}
