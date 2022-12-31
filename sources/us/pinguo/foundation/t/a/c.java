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
import android.view.View;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import us.pinguo.foundation.utils.n0;
/* compiled from: BorderedCircleBitmapDisplayer.java */
/* loaded from: classes4.dex */
public class c extends us.pinguo.foundation.t.a.a {
    protected int a;
    protected int b;
    protected Bitmap c;

    /* compiled from: BorderedCircleBitmapDisplayer.java */
    /* loaded from: classes4.dex */
    public static class a extends Drawable {
        protected final int a;
        protected final RectF b = new RectF();
        protected final RectF c;

        /* renamed from: d  reason: collision with root package name */
        protected final BitmapShader f11047d;

        /* renamed from: e  reason: collision with root package name */
        protected final Paint f11048e;

        /* renamed from: f  reason: collision with root package name */
        protected final Paint f11049f;

        /* renamed from: g  reason: collision with root package name */
        private float f11050g;

        /* renamed from: h  reason: collision with root package name */
        private float f11051h;

        /* renamed from: i  reason: collision with root package name */
        private float f11052i;

        /* renamed from: j  reason: collision with root package name */
        private float f11053j;

        public a(Bitmap bitmap, int i2, int i3) {
            this.a = i2;
            if (bitmap.getWidth() < bitmap.getHeight()) {
                this.f11050g = 0.0f;
                this.f11052i = bitmap.getWidth();
                this.f11051h = (bitmap.getHeight() / 2.0f) - (bitmap.getWidth() / 2);
                this.f11053j = (bitmap.getHeight() / 2.0f) + (bitmap.getWidth() / 2);
            } else {
                this.f11050g = (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2);
                this.f11052i = (bitmap.getWidth() / 2) + (bitmap.getHeight() / 2);
                this.f11051h = 0.0f;
                this.f11053j = bitmap.getHeight();
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f11047d = bitmapShader;
            this.c = new RectF(this.f11050g + i2, this.f11051h + i2, this.f11052i - i2, this.f11053j - i2);
            Paint paint = new Paint();
            this.f11048e = paint;
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setShader(bitmapShader);
            Paint paint2 = new Paint();
            this.f11049f = paint2;
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(i2);
            paint2.setColor(i3);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.b.width() / 2.0f, this.f11048e);
            if (this.a > 0) {
                canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.b.width() / 2.0f, this.f11049f);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            if (rect.width() < rect.height()) {
                this.f11050g = 0.0f;
                this.f11052i = rect.width();
                this.f11051h = (rect.height() / 2.0f) - (rect.width() / 2);
                this.f11053j = (rect.height() / 2.0f) + (rect.width() / 2);
            } else {
                this.f11050g = (rect.width() / 2) - (rect.height() / 2);
                this.f11052i = (rect.width() / 2) + (rect.height() / 2);
                this.f11051h = 0.0f;
                this.f11053j = rect.height();
            }
            RectF rectF = this.b;
            float f2 = this.f11050g;
            int i2 = this.a;
            rectF.set(f2 + i2, this.f11051h + i2, this.f11052i - i2, this.f11053j - i2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
            this.f11047d.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            if (i2 != this.f11048e.getAlpha()) {
                this.f11048e.setAlpha(i2);
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            if (colorFilter != this.f11048e.getColorFilter()) {
                this.f11048e.setColorFilter(colorFilter);
                invalidateSelf();
            }
        }
    }

    /* compiled from: BorderedCircleBitmapDisplayer.java */
    /* loaded from: classes4.dex */
    public static class b extends Drawable {
        protected final int a;
        protected final RectF b = new RectF();
        protected final RectF c;

        /* renamed from: d  reason: collision with root package name */
        protected final BitmapShader f11054d;

        /* renamed from: e  reason: collision with root package name */
        protected final Paint f11055e;

        /* renamed from: f  reason: collision with root package name */
        protected final Paint f11056f;

        /* renamed from: g  reason: collision with root package name */
        private float f11057g;

        /* renamed from: h  reason: collision with root package name */
        private float f11058h;

        /* renamed from: i  reason: collision with root package name */
        private float f11059i;

        /* renamed from: j  reason: collision with root package name */
        private float f11060j;

        public b(Bitmap bitmap, int i2, int i3) {
            this.a = i2;
            if (bitmap.getWidth() < bitmap.getHeight()) {
                this.f11057g = 0.0f;
                this.f11059i = bitmap.getWidth();
                this.f11058h = (bitmap.getHeight() / 2.0f) - (bitmap.getWidth() / 2);
                this.f11060j = (bitmap.getHeight() / 2.0f) + (bitmap.getWidth() / 2);
            } else {
                this.f11057g = (bitmap.getWidth() / 2) - (bitmap.getHeight() / 2);
                this.f11059i = (bitmap.getWidth() / 2) + (bitmap.getHeight() / 2);
                this.f11058h = 0.0f;
                this.f11060j = bitmap.getHeight();
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f11054d = bitmapShader;
            this.c = new RectF(this.f11057g + i2, this.f11058h + i2, this.f11059i - i2, this.f11060j - i2);
            Paint paint = new Paint();
            this.f11055e = paint;
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setShader(bitmapShader);
            Paint paint2 = new Paint();
            this.f11056f = paint2;
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(i2);
            paint2.setColor(i3);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawRoundRect(this.b, n0.c(4), n0.c(4), this.f11055e);
            if (this.a > 0) {
                canvas.drawRoundRect(this.b, n0.c(4), n0.c(4), this.f11056f);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            if (rect.width() < rect.height()) {
                this.f11057g = 0.0f;
                this.f11059i = rect.width();
                this.f11058h = (rect.height() / 2.0f) - (rect.width() / 2);
                this.f11060j = (rect.height() / 2.0f) + (rect.width() / 2);
            } else {
                this.f11057g = (rect.width() / 2) - (rect.height() / 2);
                this.f11059i = (rect.width() / 2) + (rect.height() / 2);
                this.f11058h = 0.0f;
                this.f11060j = rect.height();
            }
            RectF rectF = this.b;
            float f2 = this.f11057g;
            int i2 = this.a;
            rectF.set(f2 + i2, this.f11058h + i2, this.f11059i - i2, this.f11060j - i2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
            this.f11054d.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            if (i2 != this.f11055e.getAlpha()) {
                this.f11055e.setAlpha(i2);
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            if (colorFilter != this.f11055e.getColorFilter()) {
                this.f11055e.setColorFilter(colorFilter);
                invalidateSelf();
            }
        }
    }

    public c(int i2, int i3) {
        this(i2, i3, 0, false, false, false);
    }

    public static void animate(View view, int i2) {
    }

    public static void d(Bitmap bitmap, com.nostra13.universalimageloader.core.j.b bVar, int i2, int i3) {
        if (bVar != null) {
            bVar.setImageDrawable(new a(bitmap, i2, i3));
        }
    }

    public static void e(Bitmap bitmap, com.nostra13.universalimageloader.core.j.b bVar, int i2, int i3) {
        if (bVar != null) {
            bVar.setImageDrawable(new b(bitmap, i2, i3));
        }
    }

    public Bitmap a() {
        return this.c;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public void c(int i2) {
        this.a = i2;
    }

    @Override // us.pinguo.foundation.t.a.a, com.nostra13.universalimageloader.core.i.a
    public void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
        if ((aVar instanceof com.nostra13.universalimageloader.core.j.c) || bitmap == null) {
            return;
        }
        if (aVar instanceof com.nostra13.universalimageloader.core.j.b) {
            this.c = bitmap;
            d(bitmap, (com.nostra13.universalimageloader.core.j.b) aVar, this.a, this.b);
            if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
                animate(aVar.getWrappedView(), this.durationMillis);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public c(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        super(i4, z, z2, z3);
        this.b = i3;
        this.a = i2;
    }
}
