package vStudio.Android.Camera360.home.view;

import android.content.res.ColorStateList;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: CircleDrawable.java */
/* loaded from: classes7.dex */
public class a extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    private BitmapShader f12664d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f12665e;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f12667g;
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f12666f = new RectF();

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f12668h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    private float f12669i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12670j = false;

    /* renamed from: k  reason: collision with root package name */
    private float f12671k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f12672l = ColorStateList.valueOf(-1);
    private ImageView.ScaleType m = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircleDrawable.java */
    /* renamed from: vStudio.Android.Camera360.home.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0471a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(int i2) {
        Paint paint = new Paint();
        this.f12665e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        Paint paint2 = new Paint();
        this.f12667g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f12672l.getColorForState(getState(), -1));
        paint2.setStrokeWidth(this.f12671k);
    }

    private boolean a() {
        return (this.c == null || this.f12664d == null) ? false : true;
    }

    private void c() {
        float width;
        float height;
        if (!a()) {
            this.f12666f.set(this.a);
            RectF rectF = this.f12666f;
            float f2 = this.f12671k;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.b.set(this.f12666f);
            return;
        }
        float width2 = this.c.width();
        float height2 = this.c.height();
        int i2 = C0471a.a[this.m.ordinal()];
        if (i2 == 1) {
            this.f12666f.set(this.a);
            RectF rectF2 = this.f12666f;
            float f3 = this.f12671k;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.f12668h.set(null);
            this.f12668h.setTranslate((int) (((this.f12666f.width() - width2) * 0.5f) + 0.5f), (int) (((this.f12666f.height() - height2) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f12666f.set(this.a);
            RectF rectF3 = this.f12666f;
            float f4 = this.f12671k;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.f12668h.set(null);
            float f5 = 0.0f;
            if (this.f12666f.height() * width2 > this.f12666f.width() * height2) {
                width = this.f12666f.height() / height2;
                f5 = (this.f12666f.width() - (width2 * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f12666f.width() / width2;
                height = (this.f12666f.height() - (height2 * width)) * 0.5f;
            }
            this.f12668h.setScale(width, width);
            Matrix matrix = this.f12668h;
            float f6 = this.f12671k;
            matrix.postTranslate(((int) (f5 + 0.5f)) + f6, ((int) (height + 0.5f)) + f6);
        } else if (i2 == 3) {
            this.f12668h.set(null);
            float min = (width2 > this.a.width() || height2 > this.a.height()) ? Math.min(this.a.width() / width2, this.a.height() / height2) : 1.0f;
            this.f12668h.setScale(min, min);
            this.f12668h.postTranslate((int) (((this.a.width() - (width2 * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (height2 * min)) * 0.5f) + 0.5f));
            this.f12666f.set(this.c);
            this.f12668h.mapRect(this.f12666f);
            RectF rectF4 = this.f12666f;
            float f7 = this.f12671k;
            rectF4.inset(f7 / 2.0f, f7 / 2.0f);
            this.f12668h.setRectToRect(this.c, this.f12666f, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f12666f.set(this.c);
            this.f12668h.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.f12668h.mapRect(this.f12666f);
            RectF rectF5 = this.f12666f;
            float f8 = this.f12671k;
            rectF5.inset(f8 / 2.0f, f8 / 2.0f);
            this.f12668h.setRectToRect(this.c, this.f12666f, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f12666f.set(this.c);
            this.f12668h.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.f12668h.mapRect(this.f12666f);
            RectF rectF6 = this.f12666f;
            float f9 = this.f12671k;
            rectF6.inset(f9 / 2.0f, f9 / 2.0f);
            this.f12668h.setRectToRect(this.c, this.f12666f, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f12666f.set(this.c);
            this.f12668h.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
            this.f12668h.mapRect(this.f12666f);
            RectF rectF7 = this.f12666f;
            float f10 = this.f12671k;
            rectF7.inset(f10 / 2.0f, f10 / 2.0f);
            this.f12668h.setRectToRect(this.c, this.f12666f, Matrix.ScaleToFit.FILL);
        } else {
            this.f12666f.set(this.a);
            RectF rectF8 = this.f12666f;
            float f11 = this.f12671k;
            rectF8.inset(f11 / 2.0f, f11 / 2.0f);
            this.f12668h.set(null);
            this.f12668h.setRectToRect(this.c, this.f12666f, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.f12666f);
        this.f12664d.setLocalMatrix(this.f12668h);
    }

    public a b(boolean z) {
        this.f12670j = z;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f12670j) {
            if (this.f12671k > 0.0f) {
                canvas.drawOval(this.b, this.f12665e);
                canvas.drawOval(this.f12666f, this.f12667g);
                return;
            }
            canvas.drawOval(this.b, this.f12665e);
        } else if (this.f12671k > 0.0f) {
            canvas.drawRoundRect(this.b, Math.max(this.f12669i, 0.0f), Math.max(this.f12669i, 0.0f), this.f12665e);
            RectF rectF = this.f12666f;
            float f2 = this.f12669i;
            canvas.drawRoundRect(rectF, f2, f2, this.f12667g);
        } else {
            RectF rectF2 = this.b;
            float f3 = this.f12669i;
            canvas.drawRoundRect(rectF2, f3, f3, this.f12665e);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (a()) {
            return (int) this.c.height();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (a()) {
            return (int) this.c.width();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f12672l.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        c();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f12672l.getColorForState(iArr, 0);
        if (this.f12667g.getColor() != colorForState) {
            this.f12667g.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12665e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f12665e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f12665e.setFilterBitmap(z);
        invalidateSelf();
    }
}
