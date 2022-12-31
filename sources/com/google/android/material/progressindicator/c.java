package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
/* compiled from: CircularDrawingDelegate.java */
/* loaded from: classes2.dex */
final class c extends g<CircularProgressIndicatorSpec> {
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f4434d;

    /* renamed from: e  reason: collision with root package name */
    private float f4435e;

    /* renamed from: f  reason: collision with root package name */
    private float f4436f;

    public c(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f4436f - f6) + f3, Math.min(0.0f, this.c * f7), (this.f4436f + f6) - f3, Math.max(0.0f, f7 * this.c), paint);
        canvas.translate((this.f4436f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * this.c, true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * this.c, true, paint);
        canvas.restore();
    }

    private int i() {
        S s = this.a;
        return ((CircularProgressIndicatorSpec) s).f4425g + (((CircularProgressIndicatorSpec) s).f4426h * 2);
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        S s;
        S s2 = this.a;
        float f3 = (((CircularProgressIndicatorSpec) s2).f4425g / 2.0f) + ((CircularProgressIndicatorSpec) s2).f4426h;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.c = ((CircularProgressIndicatorSpec) this.a).f4427i == 0 ? 1 : -1;
        this.f4434d = ((CircularProgressIndicatorSpec) s).a * f2;
        this.f4435e = ((CircularProgressIndicatorSpec) s).b * f2;
        this.f4436f = (((CircularProgressIndicatorSpec) s).f4425g - ((CircularProgressIndicatorSpec) s).a) / 2.0f;
        if ((this.b.j() && ((CircularProgressIndicatorSpec) this.a).f4432e == 2) || (this.b.i() && ((CircularProgressIndicatorSpec) this.a).f4433f == 1)) {
            this.f4436f += ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        } else if ((this.b.j() && ((CircularProgressIndicatorSpec) this.a).f4432e == 1) || (this.b.i() && ((CircularProgressIndicatorSpec) this.a).f4433f == 2)) {
            this.f4436f -= ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.f4434d);
        int i3 = this.c;
        float f4 = f2 * 360.0f * i3;
        float f5 = (f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2) * 360.0f * i3;
        float f6 = this.f4436f;
        canvas.drawArc(new RectF(-f6, -f6, f6, f6), f4, f5, false, paint);
        if (this.f4435e <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f7 = this.f4435e;
        RectF rectF = new RectF(-f7, -f7, f7, f7);
        h(canvas, paint, this.f4434d, this.f4435e, f4, true, rectF);
        h(canvas, paint, this.f4434d, this.f4435e, f4 + f5, false, rectF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a = com.google.android.material.b.a.a(((CircularProgressIndicatorSpec) this.a).f4431d, this.b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a);
        paint.setStrokeWidth(this.f4434d);
        float f2 = this.f4436f;
        canvas.drawArc(new RectF(-f2, -f2, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return i();
    }
}
