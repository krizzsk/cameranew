package vStudio.Android.Camera360.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class GuidePicImageView extends ImageView {
    public GuidePicImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, (int) (size / 2.4f));
    }

    public GuidePicImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuidePicImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
