package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* compiled from: ScaleTypeDrawable.java */
/* loaded from: classes.dex */
public class o extends g {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    p.c f2553d;
    @Nullable
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    Object f2554e;
    @Nullable
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    PointF f2555f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    int f2556g;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    int f2557h;
    @Nullable
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    Matrix f2558i;

    /* renamed from: j  reason: collision with root package name */
    private Matrix f2559j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Drawable drawable, p.c cVar) {
        super(drawable);
        com.facebook.common.internal.h.g(drawable);
        this.f2555f = null;
        this.f2556g = 0;
        this.f2557h = 0;
        this.f2559j = new Matrix();
        this.f2553d = cVar;
    }

    private void r() {
        boolean z;
        p.c cVar = this.f2553d;
        boolean z2 = true;
        if (cVar instanceof p.o) {
            Object state = ((p.o) cVar).getState();
            z = state == null || !state.equals(this.f2554e);
            this.f2554e = state;
        } else {
            z = false;
        }
        if (this.f2556g == getCurrent().getIntrinsicWidth() && this.f2557h == getCurrent().getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            q();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        r();
        if (this.f2558i != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f2558i);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void e(Matrix matrix) {
        n(matrix);
        r();
        Matrix matrix2 = this.f2558i;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable o(@Nullable Drawable drawable) {
        Drawable o = super.o(drawable);
        q();
        return o;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        q();
    }

    @VisibleForTesting
    void q() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f2556g = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f2557h = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.f2558i = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.f2558i = null;
        } else if (this.f2553d == p.c.a) {
            current.setBounds(bounds);
            this.f2558i = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            p.c cVar = this.f2553d;
            Matrix matrix = this.f2559j;
            PointF pointF = this.f2555f;
            cVar.a(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
            this.f2558i = this.f2559j;
        }
    }

    @Nullable
    public PointF s() {
        return this.f2555f;
    }

    public p.c t() {
        return this.f2553d;
    }

    public void u(@Nullable PointF pointF) {
        if (com.facebook.common.internal.g.a(this.f2555f, pointF)) {
            return;
        }
        if (pointF == null) {
            this.f2555f = null;
        } else {
            if (this.f2555f == null) {
                this.f2555f = new PointF();
            }
            this.f2555f.set(pointF);
        }
        q();
        invalidateSelf();
    }

    public void v(p.c cVar) {
        if (com.facebook.common.internal.g.a(this.f2553d, cVar)) {
            return;
        }
        this.f2553d = cVar;
        this.f2554e = null;
        q();
        invalidateSelf();
    }
}
