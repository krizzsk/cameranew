package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.recyclerview.widget.ItemTouchHelper;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zaf extends Drawable implements Drawable.Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zanf;
    private int zann;
    private long zano;
    private int zanp;
    private int zanq;
    private int zanr;
    private boolean zans;
    private zaj zant;
    private Drawable zanu;
    private Drawable zanv;
    private boolean zanw;
    private boolean zanx;
    private boolean zany;
    private int zanz;

    public zaf(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zah.zaoa : drawable;
        this.zanu = drawable;
        drawable.setCallback(this);
        zaj zajVar = this.zant;
        zajVar.zaoc = drawable.getChangingConfigurations() | zajVar.zaoc;
        drawable2 = drawable2 == null ? zah.zaoa : drawable2;
        this.zanv = drawable2;
        drawable2.setCallback(this);
        zaj zajVar2 = this.zant;
        zajVar2.zaoc = drawable2.getChangingConfigurations() | zajVar2.zaoc;
    }

    private final boolean canConstantState() {
        if (!this.zanw) {
            this.zanx = (this.zanu.getConstantState() == null || this.zanv.getConstantState() == null) ? false : true;
            this.zanw = true;
        }
        return this.zanx;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2 = this.zann;
        boolean z = false;
        if (i2 != 1) {
            if (i2 == 2 && this.zano >= 0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zano)) / this.zanr;
                boolean z2 = uptimeMillis >= 1.0f;
                if (z2) {
                    this.zann = 0;
                }
                this.mAlpha = (int) ((this.zanp * Math.min(uptimeMillis, 1.0f)) + 0.0f);
                z = z2;
            } else {
                z = true;
            }
        } else {
            this.zano = SystemClock.uptimeMillis();
            this.zann = 2;
        }
        int i3 = this.mAlpha;
        boolean z3 = this.zanf;
        Drawable drawable = this.zanu;
        Drawable drawable2 = this.zanv;
        if (z) {
            if (!z3 || i3 == 0) {
                drawable.draw(canvas);
            }
            int i4 = this.zanq;
            if (i3 == i4) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zanq - i3);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zanq);
        }
        if (i3 > 0) {
            drawable2.setAlpha(i3);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zanq);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zaj zajVar = this.zant;
        return changingConfigurations | zajVar.mChangingConfigurations | zajVar.zaoc;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (canConstantState()) {
            this.zant.mChangingConfigurations = getChangingConfigurations();
            return this.zant;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.zanu.getIntrinsicHeight(), this.zanv.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.zanu.getIntrinsicWidth(), this.zanv.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.zany) {
            this.zanz = Drawable.resolveOpacity(this.zanu.getOpacity(), this.zanv.getOpacity());
            this.zany = true;
        }
        return this.zanz;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.zans && super.mutate() == this) {
            if (canConstantState()) {
                this.zanu.mutate();
                this.zanv.mutate();
                this.zans = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.zanu.setBounds(rect);
        this.zanv.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.mAlpha == this.zanq) {
            this.mAlpha = i2;
        }
        this.zanq = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.zanu.setColorFilter(colorFilter);
        this.zanv.setColorFilter(colorFilter);
    }

    public final void startTransition(int i2) {
        this.mFrom = 0;
        this.zanp = this.zanq;
        this.mAlpha = 0;
        this.zanr = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.zann = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zacd() {
        return this.zanv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(zaj zajVar) {
        this.zann = 0;
        this.zanq = 255;
        this.mAlpha = 0;
        this.zanf = true;
        this.zant = new zaj(zajVar);
    }
}
