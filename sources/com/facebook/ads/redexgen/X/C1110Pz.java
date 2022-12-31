package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Pz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1110Pz extends LinearLayout implements PZ {
    public final NativeBannerAd A00;
    public final XT A01;
    public final ArrayList<View> A02;
    public static final int A04 = (int) (LY.A00 * 42.0f);
    public static final int A03 = (int) (LY.A00 * 48.0f);
    public static final int A05 = (int) (LY.A00 * 54.0f);
    public static final int A07 = (int) (LY.A00 * 4.0f);
    public static final int A06 = (int) (LY.A00 * 8.0f);

    public C1110Pz(XT xt, NativeBannerAd nativeBannerAd, C0955Jt c0955Jt, EnumC0956Ju enumC0956Ju, MediaView mediaView, AdOptionsView adOptionsView) {
        super(xt);
        LinearLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        this.A02 = new ArrayList<>();
        this.A00 = nativeBannerAd;
        this.A01 = xt;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int A00 = A00(enumC0956Ju);
        OB ob = new OB(this.A01);
        ob.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(A00, A00);
        layoutParams3.gravity = 16;
        ob.addView(mediaView, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(ob, layoutParams3);
        PW pw = new PW(xt, this.A00, enumC0956Ju, c0955Jt, adOptionsView);
        pw.setPadding(A06, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        linearLayout.addView(pw, layoutParams4);
        if (enumC0956Ju == EnumC0956Ju.A0A) {
            int iconSize = A07;
            setPadding(iconSize, iconSize, iconSize, iconSize);
            setOrientation(0);
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            linearLayout.setPadding(0, 0, A07, 0);
        } else {
            int iconSize2 = A06;
            setPadding(iconSize2, iconSize2, iconSize2, iconSize2);
            setOrientation(1);
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setPadding(0, 0, 0, A06);
        }
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        int i2 = A06;
        int iconSize3 = A07;
        textView.setPadding(i2, iconSize3, i2, iconSize3);
        c0955Jt.A05(textView);
        textView.setText(this.A00.getAdCallToAction());
        addView(textView, layoutParams2);
        this.A02.add(mediaView);
        this.A02.add(textView);
    }

    public static int A00(EnumC0956Ju enumC0956Ju) {
        int i2 = PX.A00[enumC0956Ju.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return A05;
            }
            return A03;
        }
        return A04;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public ArrayList<View> getViewsForInteraction() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void unregisterView() {
        this.A00.unregisterView();
    }
}
