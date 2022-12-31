package vStudio.Android.Camera360.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class AdvFullWidthFrameLayout extends FrameLayout {
    public AdvFullWidthFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), getMeasuredHeight());
    }

    public AdvFullWidthFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdvFullWidthFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
