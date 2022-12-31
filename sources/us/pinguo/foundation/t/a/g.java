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
/* compiled from: CenterCropRoundedDrawable.java */
/* loaded from: classes4.dex */
public class g extends Drawable implements h {
    protected final float a;
    protected final int b;
    protected final RectF c;

    /* renamed from: d  reason: collision with root package name */
    protected final RectF f11068d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f11069e;

    /* renamed from: f  reason: collision with root package name */
    protected final BitmapShader f11070f;

    /* renamed from: g  reason: collision with root package name */
    protected final Paint f11071g;

    /* renamed from: h  reason: collision with root package name */
    private float f11072h;

    /* renamed from: i  reason: collision with root package name */
    private float f11073i;

    /* renamed from: j  reason: collision with root package name */
    private float f11074j;

    /* renamed from: k  reason: collision with root package name */
    private float f11075k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f11076l;

    public g(Bitmap bitmap, int i2, int i3) {
        this(bitmap, i2, i3, 0);
    }

    @Override // us.pinguo.foundation.t.a.h
    public Bitmap a() {
        return this.f11076l;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.c;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, this.f11071g);
    }

    @Override // android.graphics.drawable.Drawable, us.pinguo.foundation.t.a.h
    public int getAlpha() {
        return this.f11071g.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.f11076l;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.f11076l;
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
        super.onBoundsChange(rect);
        us.pinguo.foundation.t.b.b.b(this.f11069e, this.f11076l.getWidth(), this.f11076l.getHeight(), rect.width() - (this.b * 2), rect.height() - (this.b * 2));
        this.f11068d.set(this.f11069e);
        RectF rectF = this.c;
        int i2 = rect.left;
        int i3 = this.b;
        rectF.set(i2 + i3, rect.top + i3, rect.right - i3, rect.bottom - i3);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(this.f11068d, this.c, Matrix.ScaleToFit.FILL);
        this.f11070f.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f11071g.getAlpha()) {
            this.f11071g.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f11071g.getColorFilter()) {
            this.f11071g.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public g(Bitmap bitmap, int i2, int i3, int i4) {
        this.c = new RectF();
        this.f11069e = new Rect();
        this.a = i2;
        this.b = i3;
        this.f11076l = bitmap;
        if (bitmap.getWidth() < bitmap.getHeight()) {
            this.f11072h = 0.0f;
            this.f11074j = bitmap.getWidth();
            this.f11073i = (bitmap.getHeight() / 2.0f) - (bitmap.getWidth() / 2);
            this.f11075k = (bitmap.getHeight() / 2.0f) + (bitmap.getWidth() / 2);
        } else {
            this.f11072h = (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2);
            this.f11074j = (bitmap.getWidth() / 2) + (bitmap.getHeight() / 2);
            this.f11073i = 0.0f;
            this.f11075k = bitmap.getHeight();
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f11070f = bitmapShader;
        float f2 = i3;
        this.f11068d = new RectF(this.f11072h + f2, this.f11073i + f2, this.f11074j - f2, this.f11075k - f2);
        Paint paint = new Paint();
        this.f11071g = paint;
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
    }
}
