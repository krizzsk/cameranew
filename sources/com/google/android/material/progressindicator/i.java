package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;
/* compiled from: IndeterminateDrawable.java */
/* loaded from: classes2.dex */
public final class i<S extends b> extends f {
    private g<S> p;
    private h<ObjectAnimator> q;

    i(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar, @NonNull h<ObjectAnimator> hVar) {
        super(context, bVar);
        v(gVar);
        u(hVar);
    }

    @NonNull
    public static i<CircularProgressIndicatorSpec> q(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    @NonNull
    public static i<LinearProgressIndicatorSpec> r(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new i<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f4428g == 0 ? new k(linearProgressIndicatorSpec) : new l(context, linearProgressIndicatorSpec));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.p.g(canvas, g());
        this.p.c(canvas, this.m);
        int i2 = 0;
        while (true) {
            h<ObjectAnimator> hVar = this.q;
            int[] iArr = hVar.c;
            if (i2 < iArr.length) {
                g<S> gVar = this.p;
                Paint paint = this.m;
                float[] fArr = hVar.b;
                int i3 = i2 * 2;
                gVar.b(canvas, paint, fArr[i3], fArr[i3 + 1], iArr[i2]);
                i2++;
            } else {
                canvas.restore();
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.p.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.f
    public boolean p(boolean z, boolean z2, boolean z3) {
        boolean p = super.p(z, z2, z3);
        if (!isRunning()) {
            this.q.a();
        }
        float a = this.c.a(this.a.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && a > 0.0f))) {
            this.q.g();
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public h<ObjectAnimator> s() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g<S> t() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(@NonNull h<ObjectAnimator> hVar) {
        this.q = hVar;
        hVar.e(this);
    }

    void v(@NonNull g<S> gVar) {
        this.p = gVar;
        gVar.f(this);
    }
}
