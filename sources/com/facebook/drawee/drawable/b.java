package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
/* compiled from: AutoRotateDrawable.java */
/* loaded from: classes.dex */
public class b extends g implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private int f2516d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2517e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    float f2518f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2519g;

    public b(Drawable drawable, int i2) {
        this(drawable, i2, true);
    }

    private int q() {
        return (int) ((20.0f / this.f2516d) * 360.0f);
    }

    private void r() {
        if (this.f2519g) {
            return;
        }
        this.f2519g = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i2 = bounds.right;
        int i3 = bounds.left;
        int i4 = i2 - i3;
        int i5 = bounds.bottom;
        int i6 = bounds.top;
        int i7 = i5 - i6;
        float f2 = this.f2518f;
        if (!this.f2517e) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, i3 + (i4 / 2), i6 + (i7 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        r();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2519g = false;
        this.f2518f += q();
        invalidateSelf();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Drawable drawable, int i2, boolean z) {
        super(drawable);
        com.facebook.common.internal.h.g(drawable);
        this.f2518f = 0.0f;
        this.f2519g = false;
        this.f2516d = i2;
        this.f2517e = z;
    }
}
