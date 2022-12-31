package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Mk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1020Mk extends RelativeLayout implements InterfaceC1095Pk {
    @Nullable
    public C1099Po A00;

    public AbstractC1020Mk(XT xt) {
        super(xt);
    }

    public AbstractC1020Mk(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void A8f(C1099Po c1099Po) {
        this.A00 = c1099Po;
        A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void AF4(C1099Po c1099Po) {
        A08();
        this.A00 = null;
    }

    @Nullable
    public C1099Po getVideoView() {
        return this.A00;
    }
}
