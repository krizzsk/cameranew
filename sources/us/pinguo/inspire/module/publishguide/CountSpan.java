package us.pinguo.inspire.module.publishguide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.DynamicDrawableSpan;
import com.google.android.material.timepicker.TimeModel;
/* loaded from: classes9.dex */
public class CountSpan extends DynamicDrawableSpan {
    private int mCount;
    private final int mDrawableSize;
    private Paint mPaint;
    private TextPaint mTextPaint;

    public CountSpan(Context context, int i2) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-1);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setColor(-12806145);
        this.mTextPaint.setTextSize(us.pinguo.foundation.t.b.a.a(context.getApplicationContext(), 14.0f));
        this.mDrawableSize = us.pinguo.foundation.t.b.a.a(context.getApplicationContext(), 20.0f);
        this.mCount = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = new Drawable() { // from class: us.pinguo.inspire.module.publishguide.CountSpan.1
            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect bounds = getBounds();
                canvas.drawOval(new RectF(bounds), CountSpan.this.mPaint);
                String format = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(CountSpan.this.mCount));
                canvas.drawText(format, bounds.centerX() - (CountSpan.this.mTextPaint.measureText(format) / 2.0f), bounds.top + Math.abs(CountSpan.this.mTextPaint.getFontMetrics().top), CountSpan.this.mTextPaint);
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i2) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        };
        int i2 = this.mDrawableSize;
        drawable.setBounds(0, 0, i2, i2);
        return drawable;
    }

    public void setCount(int i2) {
        this.mCount = i2;
    }
}
