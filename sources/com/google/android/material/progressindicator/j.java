package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
/* compiled from: LinearDrawingDelegate.java */
/* loaded from: classes2.dex */
final class j extends g<LinearProgressIndicatorSpec> {
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f4455d;

    /* renamed from: e  reason: collision with root package name */
    private float f4456e;

    public j(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.c = 300.0f;
    }

    private static void h(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        canvas.save();
        canvas.translate(f4, 0.0f);
        if (!z) {
            canvas.rotate(180.0f);
        }
        float f5 = ((-f2) / 2.0f) + f3;
        float f6 = (f2 / 2.0f) - f3;
        canvas.drawRect(-f3, f5, 0.0f, f6, paint);
        canvas.save();
        canvas.translate(0.0f, f5);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f6);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.c = clipBounds.width();
        float f3 = ((LinearProgressIndicatorSpec) this.a).a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.a).a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.a).f4430i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.b.j() && ((LinearProgressIndicatorSpec) this.a).f4432e == 1) || (this.b.i() && ((LinearProgressIndicatorSpec) this.a).f4433f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.b.j() || this.b.i()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.a).a * (f2 - 1.0f)) / 2.0f);
        }
        float f4 = this.c;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        S s = this.a;
        this.f4455d = ((LinearProgressIndicatorSpec) s).a * f2;
        this.f4456e = ((LinearProgressIndicatorSpec) s).b * f2;
    }

    @Override // com.google.android.material.progressindicator.g
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        float f4 = this.c;
        float f5 = this.f4456e;
        float f6 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f2);
        float f7 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f3);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        float f8 = this.f4455d;
        canvas.drawRect(f6, (-f8) / 2.0f, f7, f8 / 2.0f, paint);
        float f9 = this.f4456e;
        RectF rectF = new RectF(-f9, -f9, f9, f9);
        h(canvas, paint, this.f4455d, this.f4456e, f6, true, rectF);
        h(canvas, paint, this.f4455d, this.f4456e, f7, false, rectF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a = com.google.android.material.b.a.a(((LinearProgressIndicatorSpec) this.a).f4431d, this.b.getAlpha());
        float f2 = ((-this.c) / 2.0f) + this.f4456e;
        float f3 = -f2;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(a);
        float f4 = this.f4455d;
        canvas.drawRect(f2, (-f4) / 2.0f, f3, f4 / 2.0f, paint);
        float f5 = this.f4456e;
        RectF rectF = new RectF(-f5, -f5, f5, f5);
        h(canvas, paint, this.f4455d, this.f4456e, f2, true, rectF);
        h(canvas, paint, this.f4455d, this.f4456e, f3, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return ((LinearProgressIndicatorSpec) this.a).a;
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return -1;
    }
}
