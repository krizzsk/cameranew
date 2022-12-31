package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* compiled from: ForwardingDrawable.java */
/* loaded from: classes.dex */
public class g extends Drawable implements Drawable.Callback, r, q, c {
    @Nullable
    private Drawable a;
    private final d b = new d();
    @Nullable
    protected r c;

    static {
        new Matrix();
    }

    public g(@Nullable Drawable drawable) {
        this.a = drawable;
        e.d(drawable, this, this);
    }

    @Override // com.facebook.drawee.drawable.c
    public Drawable a(@Nullable Drawable drawable) {
        return o(drawable);
    }

    @Override // com.facebook.drawee.drawable.c
    @Nullable
    public Drawable b() {
        return getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void e(Matrix matrix) {
        n(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.getConstantState();
        }
        return drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable getCurrent() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.getIntrinsicHeight();
        }
        return drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.getIntrinsicWidth();
        }
        return drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.getPadding(rect);
        }
        return drawable.getPadding(rect);
    }

    @Override // com.facebook.drawee.drawable.q
    public void h(r rVar) {
        this.c = rVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // com.facebook.drawee.drawable.r
    public void k(RectF rectF) {
        r rVar = this.c;
        if (rVar != null) {
            rVar.k(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Matrix matrix) {
        r rVar = this.c;
        if (rVar != null) {
            rVar.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Nullable
    public Drawable o(@Nullable Drawable drawable) {
        Drawable p = p(drawable);
        invalidateSelf();
        return p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.onLevelChange(i2);
        }
        return drawable.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.a;
        if (drawable == null) {
            return super.onStateChange(iArr);
        }
        return drawable.setState(iArr);
    }

    @Nullable
    protected Drawable p(@Nullable Drawable drawable) {
        Drawable drawable2 = this.a;
        e.d(drawable2, null, null);
        e.d(drawable, null, null);
        e.e(drawable, this.b);
        e.a(drawable, this);
        e.d(drawable, this, this);
        this.a = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.b(i2);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.b.c(colorFilter);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.b.d(z);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setDither(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.b.e(z);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.a;
        return drawable == null ? visible : drawable.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
