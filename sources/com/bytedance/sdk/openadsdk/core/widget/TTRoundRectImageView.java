package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class TTRoundRectImageView extends ImageView {
    private Paint a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Matrix f1869d;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a = a(drawable);
            if (a != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(a, tileMode, tileMode);
                float f2 = 1.0f;
                if (a.getWidth() != getWidth() || a.getHeight() != getHeight()) {
                    f2 = Math.max((getWidth() * 1.0f) / a.getWidth(), (getHeight() * 1.0f) / a.getHeight());
                }
                this.f1869d.setScale(f2, f2);
                bitmapShader.setLocalMatrix(this.f1869d);
                this.a.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.b, this.c, this.a);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setXRound(int i2) {
        this.b = i2;
        postInvalidate();
    }

    public void setYRound(int i2) {
        this.c = i2;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = 25;
        this.c = 25;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setFilterBitmap(true);
        this.f1869d = new Matrix();
    }
}
