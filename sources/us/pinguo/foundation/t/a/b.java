package us.pinguo.foundation.t.a;

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
/* compiled from: BaseCropDrawable.java */
/* loaded from: classes4.dex */
public class b extends Drawable {
    public static final int MODE_CENTER_CROP = 0;
    public static final int MODE_LT_CROP = 1;
    protected Bitmap mBitmap;
    protected final RectF mBitmapRect;
    protected BitmapShader mBitmapShader;
    protected float mCornerRadius;
    private int mCropMode;
    protected int mMargin;
    protected final Paint mPaint;
    protected final RectF mRect;
    private final Rect mTempRect;

    public b() {
        this(null, 0, 0);
    }

    protected void calBitmapRect(RectF rectF) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || this.mBitmapShader == null) {
            return;
        }
        int i2 = this.mCropMode;
        if (i2 == 0) {
            us.pinguo.foundation.t.b.b.b(this.mTempRect, bitmap.getWidth(), this.mBitmap.getHeight(), rectF.width(), rectF.height());
        } else if (i2 == 1) {
            us.pinguo.foundation.t.b.b.c(this.mTempRect, bitmap.getWidth(), this.mBitmap.getHeight(), rectF.width(), rectF.height());
        }
        this.mBitmapRect.set(this.mTempRect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
        this.mBitmapShader.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mPaint.getShader() != null) {
            RectF rectF = this.mRect;
            float f2 = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.mPaint);
        }
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public RectF getBitmapRect() {
        return this.mBitmapRect;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        RectF rectF = this.mRect;
        int i2 = rect.left;
        int i3 = this.mMargin;
        rectF.set(i2 + i3, rect.top + i3, rect.right - i3, rect.bottom - i3);
        calBitmapRect(this.mRect);
    }

    public void release() {
        this.mBitmap = null;
        this.mBitmapShader = null;
        this.mPaint.setShader(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.mBitmap == bitmap) {
            return;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapShader = bitmapShader;
            this.mPaint.setShader(bitmapShader);
            calBitmapRect(this.mRect);
        } else {
            this.mBitmapShader = null;
            this.mPaint.setShader(null);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mPaint.getColorFilter()) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public b(Bitmap bitmap, int i2) {
        this(bitmap, i2, 0);
    }

    public b(Bitmap bitmap, int i2, int i3) {
        this.mRect = new RectF();
        this.mTempRect = new Rect();
        this.mCropMode = 0;
        this.mCornerRadius = i2;
        this.mBitmapRect = new RectF();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        if (bitmap != null) {
            setBitmap(bitmap);
        }
        this.mCropMode = i3;
    }
}
