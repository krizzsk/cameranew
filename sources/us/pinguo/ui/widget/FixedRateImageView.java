package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class FixedRateImageView extends AppCompatImageView {
    private float a;

    public FixedRateImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        float f2 = this.a;
        int i4 = (int) ((size / f2) + 0.5f);
        if (i4 <= size2) {
            size2 = i4;
        } else {
            size = (int) ((size2 * f2) + 0.5f);
        }
        setMeasuredDimension(size, size2);
    }

    public void setRate(float f2) {
        this.a = f2;
    }

    public FixedRateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedRateImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 1.0f;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRateImageLoaderView);
        this.a = obtainStyledAttributes.getFloat(R.styleable.FixedRateImageLoaderView_ratio, 1.0f);
        obtainStyledAttributes.recycle();
    }
}
