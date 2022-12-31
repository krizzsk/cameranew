package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* compiled from: MatrixDrawable.java */
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: d  reason: collision with root package name */
    private Matrix f2526d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Matrix f2527e;

    /* renamed from: f  reason: collision with root package name */
    private int f2528f;

    /* renamed from: g  reason: collision with root package name */
    private int f2529g;

    private void q() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f2528f = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.f2529g = intrinsicHeight;
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.f2527e = this.f2526d;
            return;
        }
        current.setBounds(bounds);
        this.f2527e = null;
    }

    private void r() {
        if (this.f2528f == getCurrent().getIntrinsicWidth() && this.f2529g == getCurrent().getIntrinsicHeight()) {
            return;
        }
        q();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        r();
        if (this.f2527e != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f2527e);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void e(Matrix matrix) {
        super.e(matrix);
        Matrix matrix2 = this.f2527e;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        q();
    }
}
