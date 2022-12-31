package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: OrientedDrawable.java */
/* loaded from: classes.dex */
public class i extends g {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final Matrix f2530d;

    /* renamed from: e  reason: collision with root package name */
    private int f2531e;

    /* renamed from: f  reason: collision with root package name */
    private int f2532f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f2533g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f2534h;

    public i(Drawable drawable, int i2, int i3) {
        super(drawable);
        this.f2533g = new Matrix();
        this.f2534h = new RectF();
        this.f2530d = new Matrix();
        this.f2531e = i2 - (i2 % 90);
        this.f2532f = (i3 < 0 || i3 > 8) ? 0 : 0;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2;
        if (this.f2531e <= 0 && ((i2 = this.f2532f) == 0 || i2 == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.f2530d);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void e(Matrix matrix) {
        n(matrix);
        if (this.f2530d.isIdentity()) {
            return;
        }
        matrix.preConcat(this.f2530d);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i2 = this.f2532f;
        if (i2 != 5 && i2 != 7 && this.f2531e % BaseBlurEffect.ROTATION_180 == 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i2 = this.f2532f;
        if (i2 != 5 && i2 != 7 && this.f2531e % BaseBlurEffect.ROTATION_180 == 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i2;
        Drawable current = getCurrent();
        int i3 = this.f2531e;
        if (i3 <= 0 && ((i2 = this.f2532f) == 0 || i2 == 1)) {
            current.setBounds(rect);
            return;
        }
        int i4 = this.f2532f;
        if (i4 == 2) {
            this.f2530d.setScale(-1.0f, 1.0f);
        } else if (i4 == 7) {
            this.f2530d.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f2530d.postScale(-1.0f, 1.0f);
        } else if (i4 == 4) {
            this.f2530d.setScale(1.0f, -1.0f);
        } else if (i4 != 5) {
            this.f2530d.setRotate(i3, rect.centerX(), rect.centerY());
        } else {
            this.f2530d.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f2530d.postScale(1.0f, -1.0f);
        }
        this.f2533g.reset();
        this.f2530d.invert(this.f2533g);
        this.f2534h.set(rect);
        this.f2533g.mapRect(this.f2534h);
        RectF rectF = this.f2534h;
        current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
