package vStudio.Android.Camera360.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.BaseMediaPlayerView;
/* loaded from: classes7.dex */
public class GuideVideoView extends BaseMediaPlayerView {
    protected float F;

    public GuideVideoView(Context context) {
        super(context);
        this.F = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.widget.BaseMediaPlayerView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        float f2 = size2;
        float f3 = size;
        float f4 = f2 / f3;
        float f5 = 1.0f / this.F;
        if (Math.abs(f4 - f5) <= 0.001f) {
            setMeasuredDimension(i2, i3);
        } else if (f4 > f5) {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) ((f2 / f5) + 0.5f), 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        } else {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((f3 * f5) + 0.5f), 1073741824));
        }
    }

    @Override // us.pinguo.ui.widget.BaseMediaPlayerView
    protected void q(int i2, int i3) {
        this.v = true;
    }

    public void setRate(float f2) {
        this.F = f2;
    }

    public GuideVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.F = 1.0f;
    }

    public GuideVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = 1.0f;
    }
}
