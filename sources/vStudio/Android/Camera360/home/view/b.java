package vStudio.Android.Camera360.home.view;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
/* compiled from: RoundedDrawable.java */
/* loaded from: classes7.dex */
public class b extends Drawable {
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c;

    /* renamed from: d  reason: collision with root package name */
    private final BitmapShader f12673d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f12674e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12675f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12676g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f12677h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f12678i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f12679j;

    /* renamed from: k  reason: collision with root package name */
    private float f12680k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12681l;
    private float m;
    private ColorStateList n;
    private ImageView.ScaleType o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundedDrawable.java */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
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

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.f12677h = new RectF();
        Matrix matrix = new Matrix();
        this.f12679j = matrix;
        this.f12680k = 0.0f;
        this.f12681l = false;
        this.m = 0.0f;
        this.n = ColorStateList.valueOf(-1);
        this.o = ImageView.ScaleType.FIT_CENTER;
        int width = bitmap.getWidth();
        this.f12675f = width;
        int height = bitmap.getHeight();
        this.f12676g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f12673d = bitmapShader;
        bitmapShader.setLocalMatrix(matrix);
        Paint paint = new Paint();
        this.f12674e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Paint paint2 = new Paint();
        this.f12678i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.n.getColorForState(getState(), -1));
        paint2.setStrokeWidth(this.m);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 1), Math.max(drawable.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static b b(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public static Drawable c(Drawable drawable) {
        if (drawable == null || (drawable instanceof b)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), c(layerDrawable.getDrawable(i2)));
            }
            return layerDrawable;
        }
        Bitmap a2 = a(drawable);
        if (a2 != null) {
            return new b(a2);
        }
        Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        return drawable;
    }

    private void i() {
        float width;
        float height;
        int i2 = a.a[this.o.ordinal()];
        if (i2 == 1) {
            this.f12677h.set(this.a);
            RectF rectF = this.f12677h;
            float f2 = this.m;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            this.f12679j.set(null);
            this.f12679j.setTranslate((int) (((this.f12677h.width() - this.f12675f) * 0.5f) + 0.5f), (int) (((this.f12677h.height() - this.f12676g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f12677h.set(this.a);
            RectF rectF2 = this.f12677h;
            float f3 = this.m;
            rectF2.inset(f3 / 2.0f, f3 / 2.0f);
            this.f12679j.set(null);
            float f4 = 0.0f;
            if (this.f12675f * this.f12677h.height() > this.f12677h.width() * this.f12676g) {
                width = this.f12677h.height() / this.f12676g;
                f4 = (this.f12677h.width() - (this.f12675f * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f12677h.width() / this.f12675f;
                height = (this.f12677h.height() - (this.f12676g * width)) * 0.5f;
            }
            this.f12679j.setScale(width, width);
            Matrix matrix = this.f12679j;
            float f5 = this.m;
            matrix.postTranslate(((int) (f4 + 0.5f)) + f5, ((int) (height + 0.5f)) + f5);
        } else if (i2 == 3) {
            this.f12679j.set(null);
            float min = (((float) this.f12675f) > this.a.width() || ((float) this.f12676g) > this.a.height()) ? Math.min(this.a.width() / this.f12675f, this.a.height() / this.f12676g) : 1.0f;
            this.f12679j.setScale(min, min);
            this.f12679j.postTranslate((int) (((this.a.width() - (this.f12675f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.f12676g * min)) * 0.5f) + 0.5f));
            this.f12677h.set(this.c);
            this.f12679j.mapRect(this.f12677h);
            RectF rectF3 = this.f12677h;
            float f6 = this.m;
            rectF3.inset(f6 / 2.0f, f6 / 2.0f);
            this.f12679j.setRectToRect(this.c, this.f12677h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f12677h.set(this.c);
            this.f12679j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.f12679j.mapRect(this.f12677h);
            RectF rectF4 = this.f12677h;
            float f7 = this.m;
            rectF4.inset(f7 / 2.0f, f7 / 2.0f);
            this.f12679j.setRectToRect(this.c, this.f12677h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f12677h.set(this.c);
            this.f12679j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.f12679j.mapRect(this.f12677h);
            RectF rectF5 = this.f12677h;
            float f8 = this.m;
            rectF5.inset(f8 / 2.0f, f8 / 2.0f);
            this.f12679j.setRectToRect(this.c, this.f12677h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f12677h.set(this.c);
            this.f12679j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
            this.f12679j.mapRect(this.f12677h);
            RectF rectF6 = this.f12677h;
            float f9 = this.m;
            rectF6.inset(f9 / 2.0f, f9 / 2.0f);
            this.f12679j.setRectToRect(this.c, this.f12677h, Matrix.ScaleToFit.FILL);
        } else {
            this.f12677h.set(this.a);
            RectF rectF7 = this.f12677h;
            float f10 = this.m;
            rectF7.inset(f10 / 2.0f, f10 / 2.0f);
            this.f12679j.set(null);
            this.f12679j.setRectToRect(this.c, this.f12677h, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.f12677h);
        this.f12673d.setLocalMatrix(this.f12679j);
    }

    public b d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.n = colorStateList;
        this.f12678i.setColor(colorStateList.getColorForState(getState(), -1));
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f12681l) {
            if (this.m > 0.0f) {
                canvas.drawOval(this.b, this.f12674e);
                canvas.drawOval(this.f12677h, this.f12678i);
                return;
            }
            canvas.drawOval(this.b, this.f12674e);
        } else if (this.m > 0.0f) {
            canvas.drawRoundRect(this.b, Math.max(this.f12680k, 0.0f), Math.max(this.f12680k, 0.0f), this.f12674e);
            RectF rectF = this.f12677h;
            float f2 = this.f12680k;
            canvas.drawRoundRect(rectF, f2, f2, this.f12678i);
        } else {
            RectF rectF2 = this.b;
            float f3 = this.f12680k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f12674e);
        }
    }

    public b e(float f2) {
        this.m = f2;
        this.f12678i.setStrokeWidth(f2);
        return this;
    }

    public b f(float f2) {
        this.f12680k = f2;
        return this;
    }

    public b g(boolean z) {
        this.f12681l = z;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f12676g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f12675f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b h(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.o != scaleType) {
            this.o = scaleType;
            i();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.n.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        i();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.n.getColorForState(iArr, 0);
        if (this.f12678i.getColor() != colorForState) {
            this.f12678i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12674e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12674e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f12674e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f12674e.setFilterBitmap(z);
        invalidateSelf();
    }
}
