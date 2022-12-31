package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class SimpleViewSwitcher extends ViewGroup {
    public SimpleViewSwitcher(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                childAt.layout(0, 0, i4 - i2, i5 - i3);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            measureChild(childAt, i2, i3);
            childAt.getMeasuredWidth();
            int measuredWidth = childAt.getMeasuredWidth();
            i4++;
            i6 = childAt.getMeasuredHeight();
            i5 = measuredWidth;
        }
        setMeasuredDimension(i5, i6);
    }

    public void setView(View view) {
        if (getChildCount() != 0) {
            removeViewAt(0);
        }
        addView(view, 0);
    }

    public SimpleViewSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleViewSwitcher(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
