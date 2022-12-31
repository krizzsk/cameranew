package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class BottomHighlightDrawable extends Drawable {
    private boolean a;
    private int b;
    private Paint c;

    public BottomHighlightDrawable(Context context) {
        this.b = (int) ((context.getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setColor(-12939014);
        this.c.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.a) {
            int i2 = bounds.left;
            int i3 = bounds.bottom;
            canvas.drawRect(new Rect(i2, i3 - this.b, bounds.right, i3), this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == 16842912) {
                this.a = true;
            } else {
                this.a = false;
            }
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.c.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }
}
