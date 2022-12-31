package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import us.pinguo.foundation.t.b.a;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsRowLayout extends LinearLayout {
    private static final float RATE_2 = 1.9222223f;
    private static final float RATE_3 = 1.2444445f;
    private static final float RATE_4 = 0.9f;
    private int mDivider;

    public FeedsRowLayout(Context context) {
        super(context);
        init();
    }

    private int getChildHeight(int i2, int i3) {
        float f2;
        float f3;
        if (i2 == 2) {
            f2 = i3;
            f3 = RATE_2;
        } else if (i2 == 3) {
            f2 = i3;
            f3 = RATE_3;
        } else if (i2 != 4) {
            return 0;
        } else {
            f2 = i3;
            f3 = RATE_4;
        }
        return (int) (f2 / f3);
    }

    private int getChildWidth(int i2, int i3) {
        return (((i2 - getPaddingLeft()) - getPaddingRight()) - ((i3 - 1) * this.mDivider)) / i3;
    }

    private int getVisibleChildCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3).getVisibility() != 8) {
                i2++;
            }
        }
        return i2;
    }

    private void init() {
        this.mDivider = getResources().getDimensionPixelSize(R.dimen.feeds_feature_divider);
    }

    public Pair<Integer, Integer> getChildSize(int i2) {
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = a.j(getContext()) - (getResources().getDimensionPixelSize(R.dimen.feeds_feature_lr_padding) * 2);
        }
        int childWidth = getChildWidth(measuredWidth, i2);
        return new Pair<>(Integer.valueOf(childWidth), Integer.valueOf(getChildHeight(i2, childWidth)));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int visibleChildCount = getVisibleChildCount();
        int childWidth = getChildWidth(View.MeasureSpec.getSize(i2), visibleChildCount);
        int childHeight = getChildHeight(visibleChildCount, childWidth);
        if (childHeight == 0) {
            childHeight = View.MeasureSpec.getSize(i3);
        }
        us.pinguo.common.log.a.k("height:" + childHeight + " width:" + childWidth + " count:" + visibleChildCount, new Object[0]);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(childHeight, 1073741824));
    }

    public FeedsRowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FeedsRowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
