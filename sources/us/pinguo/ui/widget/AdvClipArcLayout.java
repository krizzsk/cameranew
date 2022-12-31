package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class AdvClipArcLayout extends RelativeLayout {
    private float[] a;
    private Path b;
    private RectF c;

    public AdvClipArcLayout(Context context) {
        this(context, null);
    }

    private void a() {
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        this.b.addRoundRect(this.c, this.a, Path.Direction.CCW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a();
        canvas.save();
        canvas.clipPath(this.b);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public AdvClipArcLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdvClipArcLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Path();
        this.c = new RectF();
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdvClipArcLayout, i2, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AdvClipArcLayout_advallRadius, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AdvClipArcLayout_advtopLeftRadius, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AdvClipArcLayout_advtopRightRadius, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AdvClipArcLayout_advbottomLeftRadius, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AdvClipArcLayout_advbottomRightRadius, 0);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize == 0) {
            float f2 = dimensionPixelSize2;
            float f3 = dimensionPixelSize3;
            float f4 = dimensionPixelSize5;
            float f5 = dimensionPixelSize4;
            this.a = new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
            return;
        }
        float f6 = dimensionPixelSize;
        this.a = new float[]{f6, f6, f6, f6, f6, f6, f6, f6};
    }
}
