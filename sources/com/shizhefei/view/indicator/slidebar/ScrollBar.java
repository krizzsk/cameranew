package com.shizhefei.view.indicator.slidebar;

import android.view.View;
/* loaded from: classes3.dex */
public interface ScrollBar {

    /* loaded from: classes3.dex */
    public enum Gravity {
        TOP,
        TOP_FLOAT,
        BOTTOM,
        BOTTOM_FLOAT,
        CENTENT,
        CENTENT_BACKGROUND
    }

    View a();

    int b(int i2);

    Gravity c();

    int d(int i2);

    void onPageScrolled(int i2, float f2, int i3);
}
