package com.timehop.stickyheadersrecyclerview.e;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: DimensionCalculator.java */
/* loaded from: classes3.dex */
public class a {
    private void a(Rect rect, ViewGroup.MarginLayoutParams marginLayoutParams) {
        rect.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    public void b(Rect rect, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            a(rect, (ViewGroup.MarginLayoutParams) layoutParams);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
