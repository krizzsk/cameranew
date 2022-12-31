package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;
/* renamed from: com.facebook.ads.redexgen.X.Ma  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1010Ma extends AdNativeComponentView {
    public static final int A01 = (int) (LY.A00 * 1.0f);
    public final ImageView A00;

    public C1010Ma(XT xt) {
        super(xt);
        this.A00 = new C1022Mm(xt);
        this.A00.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Ld.A04(this.A00, Ld.A0A);
        addView(this.A00, new ViewGroup.LayoutParams(-1, -1));
        M5.A0M(this.A00, -2130706433);
        int i2 = A01;
        setPadding(i2, i2, i2, i2);
    }

    @Override // com.facebook.ads.internal.api.AdNativeComponentView
    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
