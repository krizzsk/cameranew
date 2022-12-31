package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
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
        this.a = obtainStyledAttributes.getFloat(R.styleable.FixedRateRelativeLayout_frrl_ratio, 1.0f);
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
