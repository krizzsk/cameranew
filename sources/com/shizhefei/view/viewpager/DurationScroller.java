package com.shizhefei.view.viewpager;

import android.content.Context;
import android.widget.Scroller;
/* loaded from: classes3.dex */
public class DurationScroller extends Scroller {
    private int a;

    public DurationScroller(Context context) {
        super(context);
        this.a = 800;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, this.a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5, this.a);
    }
}
