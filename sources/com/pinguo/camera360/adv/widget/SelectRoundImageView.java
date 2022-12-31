package com.pinguo.camera360.adv.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SelectRoundImageView extends ImageLoaderView {
    private static final ImageView.ScaleType[] p = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d  reason: collision with root package name */
    private int f6168d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView.ScaleType f6169e;

    /* renamed from: f  reason: collision with root package name */
    private float f6170f;

    /* renamed from: g  reason: collision with root package name */
    private float f6171g;

    /* renamed from: h  reason: collision with root package name */
    private float f6172h;

    /* renamed from: i  reason: collision with root package name */
    private float f6173i;

    /* renamed from: j  reason: collision with root package name */
    private float f6174j;

    /* renamed from: k  reason: collision with root package name */
    private float f6175k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f6176l;
    private boolean m;
    private Drawable n;
    private float[] o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends Drawable {
        private RectF a = new RectF();
        private RectF b = new RectF();
        private final RectF c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6177d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6178e;

        /* renamed from: f  reason: collision with root package name */
        private final Paint f6179f;

        /* renamed from: g  reason: collision with root package name */
        private final Paint f6180g;

        /* renamed from: h  reason: collision with root package name */
        private BitmapShader f6181h;

        /* renamed from: i  reason: collision with root package name */
        private float[] f6182i;

        /* renamed from: j  reason: collision with root package name */
        private float[] f6183j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f6184k;

        /* renamed from: l  reason: collision with root package name */
        private float f6185l;
        private ColorStateList m;
        private ImageView.ScaleType n;
        private Path o;
        private Bitmap p;
        private boolean q;

        public a(Bitmap bitmap, Resources resources) {
            RectF rectF = new RectF();
            this.c = rectF;
            this.f6182i = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f6183j = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f6184k = false;
            this.f6185l = 0.0f;
            this.m = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            this.n = ImageView.ScaleType.FIT_CENTER;
            this.o = new Path();
            this.q = false;
            this.p = bitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f6181h = new BitmapShader(bitmap, tileMode, tileMode);
            if (bitmap != null) {
                this.f6177d = bitmap.getScaledWidth(resources.getDisplayMetrics());
                this.f6178e = bitmap.getScaledHeight(resources.getDisplayMetrics());
            } else {
                this.f6178e = -1;
                this.f6177d = -1;
            }
            rectF.set(0.0f, 0.0f, this.f6177d, this.f6178e);
            Paint paint = new Paint(1);
            this.f6179f = paint;
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(this.f6181h);
            Paint paint2 = new Paint(1);
            this.f6180g = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(this.m.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
            paint2.setStrokeWidth(this.f6185l);
        }

        private void a(Canvas canvas) {
            float[] fArr = new float[9];
            canvas.getMatrix().getValues(fArr);
            float width = (this.f6185l * this.a.width()) / ((this.a.width() * fArr[0]) - (this.f6185l * 2.0f));
            this.f6185l = width;
            this.f6180g.setStrokeWidth(width);
            this.b.set(this.a);
            RectF rectF = this.b;
            float f2 = this.f6185l;
            rectF.inset((-f2) / 2.0f, (-f2) / 2.0f);
        }

        private void b(Canvas canvas) {
            float[] fArr = new float[9];
            canvas.getMatrix().getValues(fArr);
            float f2 = fArr[0];
            float f3 = fArr[4];
            float f4 = fArr[2];
            float f5 = fArr[5];
            float width = this.a.width();
            float width2 = this.a.width();
            float f6 = this.f6185l;
            float f7 = width / ((width2 + f6) + f6);
            float height = this.a.height();
            float height2 = this.a.height();
            float f8 = this.f6185l;
            float f9 = height / ((height2 + f8) + f8);
            canvas.scale(f7, f9);
            ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_START;
            ImageView.ScaleType scaleType2 = this.n;
            if (scaleType != scaleType2 && ImageView.ScaleType.FIT_END != scaleType2 && ImageView.ScaleType.FIT_XY != scaleType2 && ImageView.ScaleType.FIT_CENTER != scaleType2 && ImageView.ScaleType.CENTER_INSIDE != scaleType2 && ImageView.ScaleType.MATRIX != scaleType2) {
                if (ImageView.ScaleType.CENTER == scaleType2 || ImageView.ScaleType.CENTER_CROP == scaleType2) {
                    canvas.translate((-f4) / (f7 * f2), (-f5) / (f9 * f3));
                    RectF rectF = this.a;
                    float f10 = rectF.left;
                    float f11 = this.f6185l;
                    canvas.translate(-(f10 - f11), -(rectF.top - f11));
                    return;
                }
                return;
            }
            float f12 = this.f6185l;
            canvas.translate(f12, f12);
        }

        private void c(Matrix matrix) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.f6182i;
                if (i2 >= fArr2.length) {
                    return;
                }
                fArr2[i2] = fArr2[i2] / fArr[0];
                i2++;
            }
        }

        private void d(Canvas canvas) {
            Rect clipBounds = canvas.getClipBounds();
            Matrix matrix = canvas.getMatrix();
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
            ImageView.ScaleType scaleType2 = this.n;
            if (scaleType == scaleType2) {
                this.a.set(clipBounds);
            } else if (ImageView.ScaleType.CENTER_CROP == scaleType2) {
                c(matrix);
                this.a.set(clipBounds);
            } else if (ImageView.ScaleType.FIT_XY == scaleType2) {
                Matrix matrix2 = new Matrix();
                matrix2.setRectToRect(this.c, new RectF(clipBounds), Matrix.ScaleToFit.FILL);
                this.f6181h.setLocalMatrix(matrix2);
                this.a.set(clipBounds);
            } else if (ImageView.ScaleType.FIT_START != scaleType2 && ImageView.ScaleType.FIT_END != scaleType2 && ImageView.ScaleType.FIT_CENTER != scaleType2 && ImageView.ScaleType.CENTER_INSIDE != scaleType2) {
                if (ImageView.ScaleType.MATRIX == scaleType2) {
                    c(matrix);
                    this.a.set(this.c);
                }
            } else {
                c(matrix);
                this.a.set(this.c);
            }
        }

        public static Bitmap e(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public static a f(Bitmap bitmap, Resources resources) {
            if (bitmap != null) {
                return new a(bitmap, resources);
            }
            return null;
        }

        public static Drawable g(Drawable drawable, Resources resources) {
            if (drawable == null || (drawable instanceof a)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), g(layerDrawable.getDrawable(i2), resources));
                }
                return layerDrawable;
            }
            Bitmap e2 = e(drawable);
            return e2 != null ? new a(e2, resources) : drawable;
        }

        private void i() {
            int i2 = 0;
            while (true) {
                float[] fArr = this.f6182i;
                if (i2 >= fArr.length) {
                    return;
                }
                if (fArr[i2] > 0.0f) {
                    this.f6183j[i2] = fArr[i2];
                    fArr[i2] = fArr[i2] - this.f6185l;
                }
                i2++;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            if (!this.q) {
                d(canvas);
                if (this.f6185l > 0.0f) {
                    a(canvas);
                    i();
                }
                this.q = true;
            }
            if (this.f6184k) {
                if (this.f6185l > 0.0f) {
                    b(canvas);
                    this.o.addOval(this.a, Path.Direction.CW);
                    canvas.drawPath(this.o, this.f6179f);
                    this.o.reset();
                    this.o.addOval(this.b, Path.Direction.CW);
                    canvas.drawPath(this.o, this.f6180g);
                } else {
                    this.o.addOval(this.a, Path.Direction.CW);
                    canvas.drawPath(this.o, this.f6179f);
                }
            } else if (this.f6185l > 0.0f) {
                b(canvas);
                this.o.addRoundRect(this.a, this.f6182i, Path.Direction.CW);
                canvas.drawPath(this.o, this.f6179f);
                this.o.reset();
                this.o.addRoundRect(this.b, this.f6183j, Path.Direction.CW);
                canvas.drawPath(this.o, this.f6180g);
            } else {
                this.o.addRoundRect(this.a, this.f6182i, Path.Direction.CW);
                canvas.drawPath(this.o, this.f6179f);
            }
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f6178e;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f6177d;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Bitmap bitmap = this.p;
            return (bitmap == null || bitmap.hasAlpha() || this.f6179f.getAlpha() < 255) ? -3 : -1;
        }

        public void h(ColorStateList colorStateList) {
            if (colorStateList == null) {
                this.f6185l = 0.0f;
                this.m = ColorStateList.valueOf(0);
                this.f6180g.setColor(0);
                return;
            }
            this.m = colorStateList;
            this.f6180g.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return this.m.isStateful();
        }

        public void j(float f2) {
            this.f6185l = f2;
            this.f6180g.setStrokeWidth(f2);
        }

        public void k(float[] fArr) {
            if (fArr == null) {
                return;
            }
            if (fArr.length == 8) {
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    this.f6182i[i2] = fArr[i2];
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }

        public void l(boolean z) {
            this.f6184k = z;
        }

        public void m(ImageView.ScaleType scaleType) {
            if (scaleType == null) {
                return;
            }
            this.n = scaleType;
        }

        @Override // android.graphics.drawable.Drawable
        protected boolean onStateChange(int[] iArr) {
            int colorForState = this.m.getColorForState(iArr, 0);
            if (this.f6180g.getColor() != colorForState) {
                this.f6180g.setColor(colorForState);
                return true;
            }
            return super.onStateChange(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            this.f6179f.setAlpha(i2);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f6179f.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            this.f6179f.setDither(z);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            this.f6179f.setFilterBitmap(z);
            invalidateSelf();
        }
    }

    public SelectRoundImageView(Context context) {
        super(context);
        this.f6168d = 0;
        this.f6169e = ImageView.ScaleType.FIT_CENTER;
        this.f6170f = 0.0f;
        this.f6171g = 0.0f;
        this.f6172h = 0.0f;
        this.f6173i = 0.0f;
        this.f6174j = 0.0f;
        this.f6175k = 0.0f;
        this.f6176l = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.m = false;
        this.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private Drawable b() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.f6168d;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Resources.NotFoundException unused) {
                this.f6168d = 0;
            }
        }
        return a.g(drawable, getResources());
    }

    private void c() {
        Drawable drawable = this.n;
        if (drawable == null) {
            return;
        }
        ((a) drawable).m(this.f6169e);
        ((a) this.n).k(this.o);
        ((a) this.n).j(this.f6175k);
        ((a) this.n).h(this.f6176l);
        ((a) this.n).l(this.m);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f6169e;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f6174j != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, (int) (size / this.f6174j));
        }
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidthDP(float f2) {
        float f3 = getResources().getDisplayMetrics().density * f2;
        if (this.f6175k == f3) {
            return;
        }
        this.f6175k = f3;
        c();
        invalidate();
    }

    public void setCornerRadiiDP(float f2, float f3, float f4, float f5) {
        float f6 = getResources().getDisplayMetrics().density;
        float f7 = f2 * f6;
        float f8 = f3 * f6;
        float f9 = f4 * f6;
        float f10 = f5 * f6;
        this.o = new float[]{f7, f7, f8, f8, f10, f10, f9, f9};
        c();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f6168d = 0;
        a f2 = a.f(bitmap, getResources());
        this.n = f2;
        super.setImageDrawable(f2);
        c();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f6168d = 0;
        Drawable g2 = a.g(drawable, getResources());
        this.n = g2;
        super.setImageDrawable(g2);
        c();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.f6168d != i2) {
            this.f6168d = i2;
            Drawable b = b();
            this.n = b;
            super.setImageDrawable(b);
            c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.m = z;
        c();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.f6169e = scaleType;
        c();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f6176l.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.f6176l = colorStateList;
        c();
        if (this.f6175k > 0.0f) {
            invalidate();
        }
    }

    public SelectRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6168d = 0;
        this.f6169e = ImageView.ScaleType.FIT_CENTER;
        this.f6170f = 0.0f;
        this.f6171g = 0.0f;
        this.f6172h = 0.0f;
        this.f6173i = 0.0f;
        this.f6174j = 0.0f;
        this.f6175k = 0.0f;
        this.f6176l = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.m = false;
        this.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SelectableRoundedImageView, i2, 0);
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setScaleType(p[i3]);
        }
        this.f6170f = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f6171g = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f6172h = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f6173i = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f6174j = obtainStyledAttributes.getFloat(9, 0.0f);
        float f2 = this.f6170f;
        if (f2 >= 0.0f) {
            float f3 = this.f6171g;
            if (f3 >= 0.0f) {
                float f4 = this.f6172h;
                if (f4 >= 0.0f) {
                    float f5 = this.f6173i;
                    if (f5 >= 0.0f) {
                        this.o = new float[]{f2, f2, f3, f3, f5, f5, f4, f4};
                        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
                        this.f6175k = dimensionPixelSize;
                        if (dimensionPixelSize >= 0.0f) {
                            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
                            this.f6176l = colorStateList;
                            if (colorStateList == null) {
                                this.f6176l = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
                            }
                            this.m = obtainStyledAttributes.getBoolean(5, false);
                            obtainStyledAttributes.recycle();
                            c();
                            return;
                        }
                        throw new IllegalArgumentException("border width cannot be negative.");
                    }
                }
            }
        }
        throw new IllegalArgumentException("radius values cannot be negative.");
    }
}
