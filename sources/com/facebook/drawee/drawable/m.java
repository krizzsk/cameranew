package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
/* compiled from: RoundedDrawable.java */
/* loaded from: classes.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r C;
    private final Drawable a;
    @Nullable
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    float[] f2551k;
    @Nullable
    @VisibleForTesting
    RectF p;
    @Nullable
    @VisibleForTesting
    Matrix v;
    @Nullable
    @VisibleForTesting
    Matrix w;
    protected boolean b = false;
    protected boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f2544d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected final Path f2545e = new Path();

    /* renamed from: f  reason: collision with root package name */
    protected boolean f2546f = true;

    /* renamed from: g  reason: collision with root package name */
    protected int f2547g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected final Path f2548h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private final float[] f2549i = new float[8];
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    final float[] f2550j = new float[8];
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    final RectF f2552l = new RectF();
    @VisibleForTesting
    final RectF m = new RectF();
    @VisibleForTesting
    final RectF n = new RectF();
    @VisibleForTesting
    final RectF o = new RectF();
    @VisibleForTesting
    final Matrix q = new Matrix();
    @VisibleForTesting
    final Matrix r = new Matrix();
    @VisibleForTesting
    final Matrix s = new Matrix();
    @VisibleForTesting
    final Matrix t = new Matrix();
    @VisibleForTesting
    final Matrix u = new Matrix();
    @VisibleForTesting
    final Matrix x = new Matrix();
    private float y = 0.0f;
    private boolean z = false;
    private boolean A = false;
    private boolean B = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.a = drawable;
    }

    public boolean a() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean b() {
        return this.b || this.c || this.f2544d > 0.0f;
    }

    @Override // com.facebook.drawee.drawable.j
    public void c(int i2, float f2) {
        if (this.f2547g == i2 && this.f2544d == f2) {
            return;
        }
        this.f2547g = i2;
        this.f2544d = f2;
        this.B = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    @Override // com.facebook.drawee.drawable.j
    public void d(boolean z) {
        this.b = z;
        this.B = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("RoundedDrawable#draw");
        }
        this.a.draw(canvas);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        float[] fArr;
        if (this.B) {
            this.f2548h.reset();
            RectF rectF = this.f2552l;
            float f2 = this.f2544d;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            if (this.b) {
                this.f2548h.addCircle(this.f2552l.centerX(), this.f2552l.centerY(), Math.min(this.f2552l.width(), this.f2552l.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.f2550j;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.f2549i[i2] + this.y) - (this.f2544d / 2.0f);
                    i2++;
                }
                this.f2548h.addRoundRect(this.f2552l, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.f2552l;
            float f3 = this.f2544d;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            this.f2545e.reset();
            float f4 = this.y + (this.z ? this.f2544d : 0.0f);
            this.f2552l.inset(f4, f4);
            if (this.b) {
                this.f2545e.addCircle(this.f2552l.centerX(), this.f2552l.centerY(), Math.min(this.f2552l.width(), this.f2552l.height()) / 2.0f, Path.Direction.CW);
            } else if (this.z) {
                if (this.f2551k == null) {
                    this.f2551k = new float[8];
                }
                for (int i3 = 0; i3 < this.f2550j.length; i3++) {
                    this.f2551k[i3] = this.f2549i[i3] - this.f2544d;
                }
                this.f2545e.addRoundRect(this.f2552l, this.f2551k, Path.Direction.CW);
            } else {
                this.f2545e.addRoundRect(this.f2552l, this.f2549i, Path.Direction.CW);
            }
            float f5 = -f4;
            this.f2552l.inset(f5, f5);
            this.f2545e.setFillType(Path.FillType.WINDING);
            this.B = false;
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float f2) {
        if (this.y != f2) {
            this.y = f2;
            this.B = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void g(float f2) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        com.facebook.common.internal.h.i(i2 >= 0);
        Arrays.fill(this.f2549i, f2);
        this.c = i2 != 0;
        this.B = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // com.facebook.drawee.drawable.q
    public void h(@Nullable r rVar) {
        this.C = rVar;
    }

    @Override // com.facebook.drawee.drawable.j
    public void i(boolean z) {
        if (this.A != z) {
            this.A = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(boolean z) {
        if (this.z != z) {
            this.z = z;
            this.B = true;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        Matrix matrix;
        r rVar = this.C;
        if (rVar != null) {
            rVar.e(this.s);
            this.C.k(this.f2552l);
        } else {
            this.s.reset();
            this.f2552l.set(getBounds());
        }
        this.n.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.o.set(this.a.getBounds());
        this.q.setRectToRect(this.n, this.o, Matrix.ScaleToFit.FILL);
        if (this.z) {
            RectF rectF = this.p;
            if (rectF == null) {
                this.p = new RectF(this.f2552l);
            } else {
                rectF.set(this.f2552l);
            }
            RectF rectF2 = this.p;
            float f2 = this.f2544d;
            rectF2.inset(f2, f2);
            if (this.v == null) {
                this.v = new Matrix();
            }
            this.v.setRectToRect(this.f2552l, this.p, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.v;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.s.equals(this.t) || !this.q.equals(this.r) || ((matrix = this.v) != null && !matrix.equals(this.w))) {
            this.f2546f = true;
            this.s.invert(this.u);
            this.x.set(this.s);
            if (this.z) {
                this.x.postConcat(this.v);
            }
            this.x.preConcat(this.q);
            this.t.set(this.s);
            this.r.set(this.q);
            if (this.z) {
                Matrix matrix3 = this.w;
                if (matrix3 == null) {
                    this.w = new Matrix(this.v);
                } else {
                    matrix3.set(this.v);
                }
            } else {
                Matrix matrix4 = this.w;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (this.f2552l.equals(this.m)) {
            return;
        }
        this.B = true;
        this.m.set(this.f2552l);
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f2549i, 0.0f);
            this.c = false;
        } else {
            com.facebook.common.internal.h.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f2549i, 0, 8);
            this.c = false;
            for (int i2 = 0; i2 < 8; i2++) {
                this.c |= fArr[i2] > 0.0f;
            }
        }
        this.B = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        this.a.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
