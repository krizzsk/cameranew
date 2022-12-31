package us.pinguo.camerasdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
/* loaded from: classes4.dex */
public class AutoFitSurfaceView extends SurfaceView {
    private int a;
    private int b;

    public AutoFitSurfaceView(Context context) {
        this(context, null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.a;
        if (i5 != 0 && (i4 = this.b) != 0) {
            if (size < (size2 * i5) / i4) {
                setMeasuredDimension(size, (i4 * size) / i5);
                return;
            } else {
                setMeasuredDimension((i5 * size2) / i4, size2);
                return;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setAspectRatio(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            this.a = i2;
            this.b = i3;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Size cannot be negative.");
    }

    public AutoFitSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFitSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 0;
        this.b = 0;
    }
}
