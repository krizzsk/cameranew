package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: assets/audience_network.dex */
public final class P8 {
    public final int[] A00(View view, int i2, int i3) {
        C4N c4n = (C4N) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, view.getPaddingLeft() + view.getPaddingRight(), c4n.width), ViewGroup.getChildMeasureSpec(i3, view.getPaddingTop() + view.getPaddingBottom(), c4n.height));
        return new int[]{view.getMeasuredWidth() + c4n.leftMargin + c4n.rightMargin, view.getMeasuredHeight() + c4n.bottomMargin + c4n.topMargin};
    }
}
