package com.pinguo.camera360.ui.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* compiled from: RotateBitmap.java */
/* loaded from: classes3.dex */
public class b {
    private Bitmap a;
    private int b = 0;

    public b(Bitmap bitmap) {
        this.a = bitmap;
    }

    public Bitmap a() {
        return this.a;
    }

    public int b() {
        if (f()) {
            return this.a.getWidth();
        }
        return this.a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        if (this.b != 0) {
            matrix.preTranslate(-(this.a.getWidth() / 2), -(this.a.getHeight() / 2));
            matrix.postRotate(this.b);
            matrix.postTranslate(e() / 2, b() / 2);
        }
        return matrix;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        if (f()) {
            return this.a.getHeight();
        }
        return this.a.getWidth();
    }

    public boolean f() {
        return (this.b / 90) % 2 != 0;
    }

    public void g(Bitmap bitmap) {
        this.a = bitmap;
    }

    public void h(int i2) {
        this.b = i2;
    }
}
