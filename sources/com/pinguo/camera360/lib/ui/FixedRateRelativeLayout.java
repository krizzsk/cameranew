package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class FixedRateRelativeLayout extends RelativeLayout {
    private float a;

    public FixedRateRelativeLayout(Context context) {
        this(context, null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRateRelativeLayout);
        this.a = obtainStyledAttributes.getFloat(0, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (size / this.a), 1073741824);
        setMeasuredDimension(makeMeasureSpec, makeMeasureSpec2);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public void setRate(float f2) {
        this.a = f2;
        if (f2 == 0.95f) {
            setBackgroundResource(R.drawable.store_pkg_details_card_shadow1x1);
        } else {
            setBackgroundResource(R.drawable.store_pkg_details_card_shadow3x4);
        }
        if (isInLayout()) {
            return;
        }
        requestLayout();
    }

    public FixedRateRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(attributeSet);
    }

    public FixedRateRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 2.34f;
        a(attributeSet);
    }
}
