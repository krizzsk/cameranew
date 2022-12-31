package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class RoundRectLayout extends RelativeLayout {
    private Path path;
    private float[] rect;

    public RoundRectLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, width, height), this.rect, Path.Direction.CW);
            }
            canvas.clipPath(this.path);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f2) {
        setRound(f2, f2, f2, f2);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setRound(float f2, float f3, float f4, float f5) {
        this.rect = new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
