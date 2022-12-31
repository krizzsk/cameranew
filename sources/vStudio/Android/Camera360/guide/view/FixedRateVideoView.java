package vStudio.Android.Camera360.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.BaseMediaPlayerView;
/* loaded from: classes7.dex */
public class FixedRateVideoView extends BaseMediaPlayerView {
    protected float F;

    public FixedRateVideoView(Context context) {
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
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size2 / this.F), 1073741824));
    }

    public void setRate(float f2) {
        this.F = f2;
    }

    public FixedRateVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.F = 1.0f;
    }

    public FixedRateVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = 1.0f;
    }
}
