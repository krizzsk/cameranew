package com.facebook.ads.redexgen.X;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: assets/audience_network.dex */
public final class KB {
    public static K9 A00(DisplayMetrics displayMetrics) {
        int i2 = (int) (displayMetrics.widthPixels / displayMetrics.density);
        int i3 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (LZ.A04(i2, i3)) {
            return K9.A0D;
        }
        if (i3 > i2) {
            return K9.A0F;
        }
        return K9.A0C;
    }

    public static void A01(DisplayMetrics displayMetrics, View view, K8 k8) {
        int ceil;
        if (((int) (displayMetrics.widthPixels / displayMetrics.density)) >= k8.A03()) {
            ceil = displayMetrics.widthPixels;
        } else {
            ceil = (int) Math.ceil(k8.A03() * displayMetrics.density);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ceil, (int) Math.ceil(k8.A02() * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
