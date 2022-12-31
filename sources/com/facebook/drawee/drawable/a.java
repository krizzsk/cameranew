package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* compiled from: ArrayDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback, r, q {
    @Nullable
    private r a;
    private final Drawable[] c;

    /* renamed from: d  reason: collision with root package name */
    private final c[] f2511d;
    private final d b = new d();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f2512e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private boolean f2513f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2514g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2515h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayDrawable.java */
    /* renamed from: com.facebook.drawee.drawable.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0094a implements c {
        final /* synthetic */ int a;

        C0094a(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.drawee.drawable.c
        public Drawable a(Drawable drawable) {
            return a.this.f(this.a, drawable);
        }

        @Override // com.facebook.drawee.drawable.c
        public Drawable b() {
            return a.this.b(this.a);
        }
    }

    public a(Drawable[] drawableArr) {
        int i2 = 0;
        com.facebook.common.internal.h.g(drawableArr);
        this.c = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.c;
            if (i2 < drawableArr2.length) {
                e.d(drawableArr2[i2], this, this);
                i2++;
            } else {
                this.f2511d = new c[drawableArr2.length];
                return;
            }
        }
    }

    private c a(int i2) {
        return new C0094a(i2);
    }

    @Nullable
    public Drawable b(int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 < this.c.length));
        return this.c[i2];
    }

    public c c(int i2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 < this.f2511d.length));
        c[] cVarArr = this.f2511d;
        if (cVarArr[i2] == null) {
            cVarArr[i2] = a(i2);
        }
        return this.f2511d[i2];
    }

    public int d() {
        return this.c.length;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i2++;
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void e(Matrix matrix) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Nullable
    public Drawable f(int i2, @Nullable Drawable drawable) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 >= 0));
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 < this.c.length));
        Drawable drawable2 = this.c[i2];
        if (drawable != drawable2) {
            if (drawable != null && this.f2515h) {
                drawable.mutate();
            }
            e.d(this.c[i2], null, null);
            e.d(drawable, null, null);
            e.e(drawable, this.b);
            e.a(drawable, this);
            e.d(drawable, this, this);
            this.f2514g = false;
            this.c[i2] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.c.length == 0) {
            return -2;
        }
        int i2 = -1;
        int i3 = 1;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i3 >= drawableArr.length) {
                return i2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                i2 = Drawable.resolveOpacity(i2, drawable.getOpacity());
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f2512e;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void h(r rVar) {
        this.a = rVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.f2514g) {
            this.f2513f = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.c;
                boolean z = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z2 = this.f2513f;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.f2513f = z2 | z;
                i2++;
            }
            this.f2514g = true;
        }
        return this.f2513f;
    }

    @Override // com.facebook.drawee.drawable.r
    public void k(RectF rectF) {
        r rVar = this.a;
        if (rVar != null) {
            rVar.k(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.f2515h = true;
                return this;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i3 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z = true;
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.b(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i3 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.c(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.b.d(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.b.e(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.c;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
