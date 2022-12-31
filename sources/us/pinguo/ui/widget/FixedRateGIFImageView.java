package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.R;
import us.pinguo.ui.uilview.GifImageView;
/* loaded from: classes6.dex */
public class FixedRateGIFImageView extends GifImageView {

    /* renamed from: i  reason: collision with root package name */
    private float f12143i;

    public FixedRateGIFImageView(Context context) {
        super(context);
        this.f12143i = 1.0f;
    }

    private void n(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRateImageLoaderView);
        this.f12143i = obtainStyledAttributes.getFloat(R.styleable.FixedRateImageLoaderView_ratio, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (size / this.f12143i), 1073741824);
        setMeasuredDimension(makeMeasureSpec, makeMeasureSpec2);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public void setRate(float f2) {
        this.f12143i = f2;
    }

    public FixedRateGIFImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12143i = 1.0f;
        n(attributeSet);
    }

    public FixedRateGIFImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12143i = 1.0f;
        n(attributeSet);
    }
}
