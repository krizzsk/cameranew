package com.pinguo.album.views.utils;

import android.graphics.Rect;
import android.opengl.Matrix;
/* compiled from: ViewPaper.java */
/* loaded from: classes3.dex */
public class e {
    private int c;
    private b a = new b();
    private b b = new b();

    /* renamed from: d  reason: collision with root package name */
    private float[] f6140d = new float[16];

    public boolean a() {
        return this.a.g() | this.b.g();
    }

    public void b(float f2) {
        float f3 = f2 / this.c;
        if (f3 < 0.0f) {
            this.b.c(-f3);
        } else {
            this.a.c(f3);
        }
    }

    public float[] c(boolean z, Rect rect, float f2) {
        int i2;
        float a = this.a.a();
        float a2 = this.b.a();
        float centerY = !z ? rect.centerY() : rect.centerX() - f2;
        float f3 = centerY + (i2 / 4);
        float f4 = (this.c * 3) / 2;
        float exp = ((1.0f / (((float) Math.exp((-((((f4 - f3) * a) - (f3 * a2)) / f4)) * 4.0f)) + 1.0f)) - 0.5f) * 2.0f * (-45.0f);
        Matrix.setIdentityM(this.f6140d, 0);
        float[] fArr = this.f6140d;
        Matrix.translateM(fArr, 0, fArr, 0, rect.centerX(), rect.centerY(), 0.0f);
        if (!z) {
            Matrix.rotateM(this.f6140d, 0, exp, 1.0f, 0.0f, 0.0f);
        } else {
            Matrix.rotateM(this.f6140d, 0, exp, 0.0f, 1.0f, 0.0f);
        }
        float[] fArr2 = this.f6140d;
        Matrix.translateM(fArr2, 0, fArr2, 0, (-rect.width()) / 2, (-rect.height()) / 2, 0.0f);
        return this.f6140d;
    }

    public void d() {
        this.a.e();
        this.b.e();
    }

    public void e(float f2) {
        float f3 = f2 / this.c;
        if (f3 < 0.0f) {
            this.a.d(-f3);
        } else {
            this.b.d(f3);
        }
    }

    public void f(int i2, int i3) {
        this.c = i2;
    }
}
