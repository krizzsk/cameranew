package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class MaskPreviousChildLayout extends LinearLayout {
    private int a;

    public MaskPreviousChildLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        if (isInEditMode()) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaskPreviousChildLayout);
            this.a = obtainStyledAttributes.getDimensionPixelSize(0, getResources().getDimensionPixelSize(R.dimen.incline_mask_width));
            obtainStyledAttributes.recycle();
            return;
        }
        this.a = getResources().getDimensionPixelSize(R.dimen.incline_mask_width);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0) {
                int measuredWidth = childAt.getMeasuredWidth() + i6;
                childAt.layout(i6, 0, measuredWidth, childAt.getMeasuredHeight());
                i6 = measuredWidth - this.a;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5).getVisibility() == 0) {
                i4++;
            }
        }
        int i6 = i4 - 1;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size + (this.a * i6), mode), i3);
        setMeasuredDimension(getMeasuredWidth() - (i6 * this.a), getMeasuredHeight());
    }

    public MaskPreviousChildLayout(Context context) {
        this(context, null);
    }
}
