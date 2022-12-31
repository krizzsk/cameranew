package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class FixedRateImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private float f12144d;

    public FixedRateImageLoaderView(Context context) {
        this(context, null);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRateImageLoaderView);
        this.f12144d = obtainStyledAttributes.getFloat(R.styleable.FixedRateImageLoaderView_ratio, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, (int) (size / this.f12144d));
    }

    public void setRate(float f2) {
        this.f12144d = f2;
    }

    public FixedRateImageLoaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(attributeSet);
    }

    public FixedRateImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12144d = 1.0f;
        b(attributeSet);
    }
}
