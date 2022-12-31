package us.pinguo.camera360.shop.view.details;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: FlexibleRoundedDrawable.java */
/* loaded from: classes4.dex */
public class d extends Drawable {
    protected final float a;
    protected final RectF b = new RectF();
    protected final RectF c;

    /* renamed from: d  reason: collision with root package name */
    protected final BitmapShader f9759d;

    /* renamed from: e  reason: collision with root package name */
    protected final Paint f9760e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f9761f;

    /* renamed from: g  reason: collision with root package name */
    private int f9762g;

    public d(Bitmap bitmap, int i2, int i3) {
        this.a = i2;
        this.f9762g = i3;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f9759d = bitmapShader;
        this.c = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        Paint paint = new Paint();
        this.f9760e = paint;
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Paint paint2 = new Paint(1);
        this.f9761f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.b;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, this.f9761f);
        RectF rectF2 = this.b;
        float f3 = this.a;
        canvas.drawRoundRect(rectF2, f3, f3, this.f9760e);
        int i2 = this.f9762g ^ 15;
        if ((i2 & 1) != 0) {
            float f4 = this.a;
            canvas.drawRect(0.0f, 0.0f, f4, f4, this.f9760e);
        }
        if ((i2 & 2) != 0) {
            float f5 = this.b.right;
            float f6 = this.a;
            canvas.drawRect(f5 - f6, 0.0f, f5, f6, this.f9760e);
        }
        if ((i2 & 4) != 0) {
            float f7 = this.b.bottom;
            float f8 = this.a;
            canvas.drawRect(0.0f, f7 - f8, f8, f7, this.f9760e);
        }
        if ((i2 & 8) != 0) {
            RectF rectF3 = this.b;
            float f9 = rectF3.right;
            float f10 = this.a;
            float f11 = rectF3.bottom;
            canvas.drawRect(f9 - f10, f11 - f10, f9, f11, this.f9760e);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.c.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.c.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b.set(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
        this.f9759d.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f9760e.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9760e.setColorFilter(colorFilter);
    }
}
