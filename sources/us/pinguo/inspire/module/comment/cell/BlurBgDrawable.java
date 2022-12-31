package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* compiled from: BaseInfoCell.kt */
/* loaded from: classes9.dex */
public final class BlurBgDrawable extends Drawable {
    private final Paint bgPaint;
    private final Bitmap bitmap;
    private final Paint paint;

    public BlurBgDrawable(Bitmap bitmap) {
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.paint = new Paint();
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setColor(Color.argb(120, 0, 0, 0));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        Rect bounds = getBounds();
        kotlin.jvm.internal.s.g(bounds, "bounds");
        float centerX = bounds.centerX();
        float height = ((bounds.height() * this.bitmap.getWidth()) / this.bitmap.getHeight()) / 2;
        RectF rectF = new RectF(centerX - height, bounds.top, centerX + height, bounds.bottom);
        canvas.drawBitmap(this.bitmap, new Rect(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight()), rectF, this.paint);
        canvas.drawRect(rectF, this.bgPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.paint.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
