package vStudio.Android.Camera360.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.BaseMediaPlayerView;
/* loaded from: classes7.dex */
public class FixedRateVideoView2 extends BaseMediaPlayerView {
    protected float F;

    public FixedRateVideoView2(Context context) {
        super(context);
        this.F = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.widget.BaseMediaPlayerView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.F < 0.0f) {
            int s = s();
            int r = r();
            int size = View.MeasureSpec.getSize(i2);
            if (r > 0 && r > 0 && size > 0 && View.MeasureSpec.getMode(i2) == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (size * (r / s)), 1073741824);
            }
            super.onMeasure(i2, i3);
            return;
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i3);
        float f2 = size2;
        float f3 = size3;
        float f4 = f2 / f3;
        if (Math.abs(f4 - this.F) < 0.1d) {
            super.onMeasure(i2, i3);
            return;
        }
        float f5 = this.F;
        if (f4 < f5) {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 / f5), 1073741824));
            return;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) ((f3 * f5) + 0.5f), 1073741824), View.MeasureSpec.makeMeasureSpec(size3, 1073741824));
    }

    @Override // us.pinguo.ui.widget.BaseMediaPlayerView
    protected void q(int i2, int i3) {
        this.v = true;
    }

    public void setRate(float f2) {
        this.F = f2;
    }

    public FixedRateVideoView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.F = 1.0f;
    }

    public FixedRateVideoView2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = 1.0f;
    }
}
