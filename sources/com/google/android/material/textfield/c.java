package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.m;
/* compiled from: CutoutDrawable.java */
/* loaded from: classes2.dex */
class c extends com.google.android.material.shape.h {
    private int A;
    @NonNull
    private final Paint y;
    @NonNull
    private final RectF z;

    c() {
        this(null);
    }

    private void n0(@NonNull Canvas canvas) {
        if (u0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.A);
    }

    private void o0(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (u0(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        q0(canvas);
    }

    private void q0(@NonNull Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.A = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.A = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void t0() {
        this.y.setStyle(Paint.Style.FILL_AND_STROKE);
        this.y.setColor(-1);
        this.y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean u0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        o0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.z, this.y);
        n0(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m0() {
        return !this.z.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0() {
        r0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void r0(float f2, float f3, float f4, float f5) {
        RectF rectF = this.z;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s0(@NonNull RectF rectF) {
        r0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@Nullable m mVar) {
        super(mVar == null ? new m() : mVar);
        this.y = new Paint(1);
        t0();
        this.z = new RectF();
    }
}
