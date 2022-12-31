package com.facebook.ads.redexgen.X;

import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* renamed from: com.facebook.ads.redexgen.X.7R  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7R extends AbstractC1020Mk {
    public static String[] A01 = {"4h8fvEACfo1aNbNL", "KiY64Fil", "L", "TPcthrsJz3ToBiwYAQ4xewU", "cWfSExW1cmjdZd3Ek8eXqqhjC3VFU", "NINEnIjXlG8iO8hrf55I2V2lHb1VufX", "CO", "8GF4DU4RrtKBXlYvExHV9F2Nh74lSozH"};
    public final C9P<C0975Ko> A00;

    public C7R(XT xt) {
        this(xt, null);
    }

    public C7R(XT xt, AttributeSet attributeSet) {
        this(xt, attributeSet, 0);
    }

    public C7R(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A00 = new IT(this);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(progressBar, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A07() {
        super.A07();
        setVisibility(0);
        if (getVideoView() != null) {
            C1099Po videoView = getVideoView();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[7] = "LLc1CvKTLQ71W60sfu5S1t2gX7MmeGtJ";
            videoView.getEventBus().A05(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A08() {
        if (getVideoView() != null) {
            C9O<C9P, C9N> eventBus = getVideoView().getEventBus();
            C9P<C0975Ko> c9p = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "4Zu3PRCBzV1MZjgNBq7KORh";
            strArr2[1] = "VnRIjxfO";
            eventBus.A06(c9p);
        }
        setVisibility(8);
        super.A08();
    }
}
