package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* compiled from: RoundedColorDrawable.java */
/* loaded from: classes.dex */
public class l extends Drawable implements j {
    @Nullable
    @VisibleForTesting
    float[] c;
    private final float[] a = new float[8];
    @VisibleForTesting
    final float[] b = new float[8];
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final Paint f2535d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private boolean f2536e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f2537f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f2538g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f2539h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2540i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2541j = false;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    final Path f2542k = new Path();
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    final Path f2543l = new Path();
    private int m = 0;
    private final RectF n = new RectF();
    private int o = 255;

    public l(int i2) {
        e(i2);
    }

    @TargetApi(11)
    public static l a(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    private void h() {
        float[] fArr;
        float[] fArr2;
        this.f2542k.reset();
        this.f2543l.reset();
        this.n.set(getBounds());
        RectF rectF = this.n;
        float f2 = this.f2537f;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
        int i2 = 0;
        if (this.f2536e) {
            this.f2543l.addCircle(this.n.centerX(), this.n.centerY(), Math.min(this.n.width(), this.n.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i3 = 0;
            while (true) {
                fArr = this.b;
                if (i3 >= fArr.length) {
                    break;
                }
                fArr[i3] = (this.a[i3] + this.f2538g) - (this.f2537f / 2.0f);
                i3++;
            }
            this.f2543l.addRoundRect(this.n, fArr, Path.Direction.CW);
        }
        RectF rectF2 = this.n;
        float f3 = this.f2537f;
        rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
        float f4 = this.f2538g + (this.f2540i ? this.f2537f : 0.0f);
        this.n.inset(f4, f4);
        if (this.f2536e) {
            this.f2542k.addCircle(this.n.centerX(), this.n.centerY(), Math.min(this.n.width(), this.n.height()) / 2.0f, Path.Direction.CW);
        } else if (this.f2540i) {
            if (this.c == null) {
                this.c = new float[8];
            }
            while (true) {
                fArr2 = this.c;
                if (i2 >= fArr2.length) {
                    break;
                }
                fArr2[i2] = this.a[i2] - this.f2537f;
                i2++;
            }
            this.f2542k.addRoundRect(this.n, fArr2, Path.Direction.CW);
        } else {
            this.f2542k.addRoundRect(this.n, this.a, Path.Direction.CW);
        }
        float f5 = -f4;
        this.n.inset(f5, f5);
    }

    public boolean b() {
        return this.f2541j;
    }

    @Override // com.facebook.drawee.drawable.j
    public void c(int i2, float f2) {
        if (this.f2539h != i2) {
            this.f2539h = i2;
            invalidateSelf();
        }
        if (this.f2537f != f2) {
            this.f2537f = f2;
            h();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void d(boolean z) {
        this.f2536e = z;
        h();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2535d.setColor(e.c(this.m, this.o));
        this.f2535d.setStyle(Paint.Style.FILL);
        this.f2535d.setFilterBitmap(b());
        canvas.drawPath(this.f2542k, this.f2535d);
        if (this.f2537f != 0.0f) {
            this.f2535d.setColor(e.c(this.f2539h, this.o));
            this.f2535d.setStyle(Paint.Style.STROKE);
            this.f2535d.setStrokeWidth(this.f2537f);
            canvas.drawPath(this.f2543l, this.f2535d);
        }
    }

    public void e(int i2) {
        if (this.m != i2) {
            this.m = i2;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float f2) {
        if (this.f2538g != f2) {
            this.f2538g = f2;
            h();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void g(float f2) {
        com.facebook.common.internal.h.c(f2 >= 0.0f, "radius should be non negative");
        Arrays.fill(this.a, f2);
        h();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.b(e.c(this.m, this.o));
    }

    @Override // com.facebook.drawee.drawable.j
    public void i(boolean z) {
        if (this.f2541j != z) {
            this.f2541j = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(boolean z) {
        if (this.f2540i != z) {
            this.f2540i = z;
            h();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.a, 0.0f);
        } else {
            com.facebook.common.internal.h.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.a, 0, 8);
        }
        h();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
