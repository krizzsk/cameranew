package us.pinguo.foundation.t.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* compiled from: CenterCropDrawable.java */
/* loaded from: classes4.dex */
public class e extends Drawable implements h {
    protected final RectF b;

    /* renamed from: d  reason: collision with root package name */
    protected final Paint f11061d;

    /* renamed from: e  reason: collision with root package name */
    private float f11062e;

    /* renamed from: f  reason: collision with root package name */
    private float f11063f;

    /* renamed from: g  reason: collision with root package name */
    private float f11064g;

    /* renamed from: h  reason: collision with root package name */
    private float f11065h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f11066i;
    protected final RectF a = new RectF();
    private final Rect c = new Rect();

    /* renamed from: j  reason: collision with root package name */
    private Matrix f11067j = new Matrix();

    public e(Bitmap bitmap) {
        this.f11066i = bitmap;
        if (bitmap.getWidth() < bitmap.getHeight()) {
            this.f11062e = 0.0f;
            this.f11064g = bitmap.getWidth();
            this.f11063f = (bitmap.getHeight() / 2.0f) - (bitmap.getWidth() / 2);
            this.f11065h = (bitmap.getHeight() / 2.0f) + (bitmap.getWidth() / 2);
        } else {
            this.f11062e = (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2);
            this.f11064g = (bitmap.getWidth() / 2) + (bitmap.getHeight() / 2);
            this.f11063f = 0.0f;
            this.f11065h = bitmap.getHeight();
        }
        this.b = new RectF(this.f11062e, this.f11063f, this.f11064g, this.f11065h);
        Paint paint = new Paint();
        this.f11061d = paint;
        paint.setAntiAlias(true);
    }

    @Override // us.pinguo.foundation.t.a.h
    public Bitmap a() {
        return this.f11066i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f11066i, this.f11067j, this.f11061d);
    }

    @Override // android.graphics.drawable.Drawable, us.pinguo.foundation.t.a.h
    public int getAlpha() {
        return this.f11061d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.f11066i;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.f11066i;
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
        us.pinguo.foundation.t.b.b.b(this.c, this.f11066i.getWidth(), this.f11066i.getHeight(), rect.width(), rect.height());
        this.b.set(this.c);
        this.a.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f11067j.setRectToRect(this.b, this.a, Matrix.ScaleToFit.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.f11061d.getAlpha()) {
            this.f11061d.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f11061d.getColorFilter()) {
            this.f11061d.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }
}
