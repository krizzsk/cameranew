package com.facebook.ads.redexgen.X;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;
/* renamed from: com.facebook.ads.redexgen.X.Pa  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1085Pa extends LinearLayout {
    public static final int A00 = (int) (LY.A00 * 32.0f);
    public static final int A01 = (int) (LY.A00 * 8.0f);

    public C1085Pa(XT xt, NativeAd nativeAd, C0955Jt c0955Jt, OA oa, AdOptionsView adOptionsView) {
        super(xt);
        setOrientation(0);
        oa.setFullCircleCorners(true);
        int i2 = A00;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, A01, 0);
        addView(oa, layoutParams);
        TextView textView = new TextView(xt);
        c0955Jt.A08(textView);
        textView.setMaxLines(1);
        textView.setText(nativeAd.getAdvertiserName());
        TextView textView2 = new TextView(xt);
        c0955Jt.A06(textView2);
        textView2.setMaxLines(1);
        textView2.setText(nativeAd.getSponsoredTranslation());
        LinearLayout linearLayout = new LinearLayout(xt);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout, layoutParams2);
        addView(adOptionsView, new LinearLayout.LayoutParams(-2, -2));
    }
}
