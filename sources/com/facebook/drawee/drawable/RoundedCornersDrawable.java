package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class RoundedCornersDrawable extends g implements j {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    Type f2502d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f2503e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RectF f2504f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Matrix f2505g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f2506h;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    final float[] f2507i;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    final Paint f2508j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2509k;

    /* renamed from: l  reason: collision with root package name */
    private float f2510l;
    private int m;
    private int n;
    private float o;
    private boolean p;
    private boolean q;
    private final Path r;
    private final Path s;
    private final RectF t;

    /* loaded from: classes.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            try {
                iArr[Type.CLIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.OVERLAY_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornersDrawable(Drawable drawable) {
        super(drawable);
        com.facebook.common.internal.h.g(drawable);
        this.f2502d = Type.OVERLAY_COLOR;
        this.f2503e = new RectF();
        this.f2506h = new float[8];
        this.f2507i = new float[8];
        this.f2508j = new Paint(1);
        this.f2509k = false;
        this.f2510l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.o = 0.0f;
        this.p = false;
        this.q = false;
        this.r = new Path();
        this.s = new Path();
        this.t = new RectF();
    }

    private void s() {
        float[] fArr;
        this.r.reset();
        this.s.reset();
        this.t.set(getBounds());
        RectF rectF = this.t;
        float f2 = this.o;
        rectF.inset(f2, f2);
        if (this.f2502d == Type.OVERLAY_COLOR) {
            this.r.addRect(this.t, Path.Direction.CW);
        }
        if (this.f2509k) {
            this.r.addCircle(this.t.centerX(), this.t.centerY(), Math.min(this.t.width(), this.t.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.r.addRoundRect(this.t, this.f2506h, Path.Direction.CW);
        }
        RectF rectF2 = this.t;
        float f3 = this.o;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.t;
        float f4 = this.f2510l;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.f2509k) {
            this.s.addCircle(this.t.centerX(), this.t.centerY(), Math.min(this.t.width(), this.t.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f2507i;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.f2506h[i2] + this.o) - (this.f2510l / 2.0f);
                i2++;
            }
            this.s.addRoundRect(this.t, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.t;
        float f5 = this.f2510l;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.j
    public void c(int i2, float f2) {
        this.m = i2;
        this.f2510l = f2;
        s();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void d(boolean z) {
        this.f2509k = z;
        s();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2503e.set(getBounds());
        int i2 = a.a[this.f2502d.ordinal()];
        if (i2 == 1) {
            int save = canvas.save();
            canvas.clipPath(this.r);
            super.draw(canvas);
            canvas.restoreToCount(save);
        } else if (i2 == 2) {
            if (this.p) {
                RectF rectF = this.f2504f;
                if (rectF == null) {
                    this.f2504f = new RectF(this.f2503e);
                    this.f2505g = new Matrix();
                } else {
                    rectF.set(this.f2503e);
                }
                RectF rectF2 = this.f2504f;
                float f2 = this.f2510l;
                rectF2.inset(f2, f2);
                this.f2505g.setRectToRect(this.f2503e, this.f2504f, Matrix.ScaleToFit.FILL);
                int save2 = canvas.save();
                canvas.clipRect(this.f2503e);
                canvas.concat(this.f2505g);
                super.draw(canvas);
                canvas.restoreToCount(save2);
            } else {
                super.draw(canvas);
            }
            this.f2508j.setStyle(Paint.Style.FILL);
            this.f2508j.setColor(this.n);
            this.f2508j.setStrokeWidth(0.0f);
            this.f2508j.setFilterBitmap(q());
            this.r.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.r, this.f2508j);
            if (this.f2509k) {
                float width = ((this.f2503e.width() - this.f2503e.height()) + this.f2510l) / 2.0f;
                float height = ((this.f2503e.height() - this.f2503e.width()) + this.f2510l) / 2.0f;
                if (width > 0.0f) {
                    RectF rectF3 = this.f2503e;
                    float f3 = rectF3.left;
                    canvas.drawRect(f3, rectF3.top, f3 + width, rectF3.bottom, this.f2508j);
                    RectF rectF4 = this.f2503e;
                    float f4 = rectF4.right;
                    canvas.drawRect(f4 - width, rectF4.top, f4, rectF4.bottom, this.f2508j);
                }
                if (height > 0.0f) {
                    RectF rectF5 = this.f2503e;
                    float f5 = rectF5.left;
                    float f6 = rectF5.top;
                    canvas.drawRect(f5, f6, rectF5.right, f6 + height, this.f2508j);
                    RectF rectF6 = this.f2503e;
                    float f7 = rectF6.left;
                    float f8 = rectF6.bottom;
                    canvas.drawRect(f7, f8 - height, rectF6.right, f8, this.f2508j);
                }
            }
        }
        if (this.m != 0) {
            this.f2508j.setStyle(Paint.Style.STROKE);
            this.f2508j.setColor(this.m);
            this.f2508j.setStrokeWidth(this.f2510l);
            this.r.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.s, this.f2508j);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float f2) {
        this.o = f2;
        s();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void g(float f2) {
        Arrays.fill(this.f2506h, f2);
        s();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void i(boolean z) {
        if (this.q != z) {
            this.q = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(boolean z) {
        this.p = z;
        s();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f2506h, 0.0f);
        } else {
            com.facebook.common.internal.h.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f2506h, 0, 8);
        }
        s();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        s();
    }

    public boolean q() {
        return this.q;
    }

    public void r(int i2) {
        this.n = i2;
        invalidateSelf();
    }
}
