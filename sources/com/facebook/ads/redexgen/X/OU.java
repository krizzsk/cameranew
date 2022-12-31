package com.facebook.ads.redexgen.X;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: assets/audience_network.dex */
public final class OU extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final SZ A02;
    public final ON A03;
    public static final int A06 = (int) (LY.A00 * 36.0f);
    public static final int A07 = (int) (LY.A00 * 36.0f);
    public static final int A04 = (int) (LY.A00 * 23.0f);
    public static final int A05 = (int) (LY.A00 * 3.0f);
    public static final int A08 = (int) (LY.A00 * 4.0f);

    public OU(ON on, String str, C1I c1i, O0 o0) {
        super(on.A05());
        this.A03 = on;
        this.A00 = c1i.A08(true);
        this.A01 = new RelativeLayout(on.A05());
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(str);
        this.A02 = new SZ(on.A05(), on.A04().A0P(), null, on.A06(), on.A09(), on.A0B(), on.A07());
        this.A02.setCta(on.A04().A0K().A0F(), on.A04().A0Q(), new HashMap(), o0);
        this.A02.setIsInAppBrowser(true);
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A00(View view) {
        ImageView imageView = new ImageView(this.A03.A05());
        imageView.setImageBitmap(ME.A01(MD.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        int i2 = A04;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        int i3 = A05;
        imageView.setPadding(i3, i3, i3, i3);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(String str) {
        Button button = new Button(this.A03.A05());
        M5.A0K(button);
        int i2 = A07;
        button.setPadding(i2, 0, i2, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        M5.A0O(button, this.A00, A08);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, A06);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.A01.addView(button, layoutParams);
        A00(button);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }
}
