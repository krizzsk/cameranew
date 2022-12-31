package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: assets/audience_network.dex */
public final class RO extends OB {
    public final ImageView A00;
    public final XT A01;

    public RO(XT xt) {
        super(xt);
        this.A01 = xt;
        this.A00 = new ImageView(xt);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC1164Sb asyncTaskC1164Sb = new AsyncTaskC1164Sb(this.A00, this.A01);
        asyncTaskC1164Sb.A04();
        asyncTaskC1164Sb.A07(str);
    }
}
