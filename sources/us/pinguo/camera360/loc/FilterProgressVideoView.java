package us.pinguo.camera360.loc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.BaseMediaPlayerView;
/* loaded from: classes3.dex */
public class FilterProgressVideoView extends BaseMediaPlayerView {
    private int F;
    private int G;

    public FilterProgressVideoView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.widget.BaseMediaPlayerView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.G;
        if (i4 > 0 && this.F > 0) {
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setVideoHeight(int i2) {
        this.G = i2;
    }

    public void setVideoWidth(int i2) {
        this.F = i2;
    }

    public FilterProgressVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterProgressVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
