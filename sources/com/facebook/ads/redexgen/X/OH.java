package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: assets/audience_network.dex */
public final class OH {
    public static final int A00 = M5.A00();

    public static void A00(XT xt, ViewGroup viewGroup, String str) {
        new AsyncTaskC1164Sb(viewGroup, xt).A07(str);
        View view = new View(xt);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        M5.A0R(view, xt);
        viewGroup.addView(view, 0);
    }
}
