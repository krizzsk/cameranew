package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes3.dex */
public final class af extends Animation {
    private final boolean a;
    private final float b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7297d;

    /* renamed from: e  reason: collision with root package name */
    private final float f7298e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7299f;

    /* renamed from: g  reason: collision with root package name */
    private final float f7300g;

    /* renamed from: h  reason: collision with root package name */
    private float f7301h;

    /* renamed from: i  reason: collision with root package name */
    private float f7302i;

    /* renamed from: j  reason: collision with root package name */
    private Camera f7303j;

    public af(boolean z, float f2, float f3, int i2, float f4, int i3, float f5) {
        this.a = z;
        this.b = f2;
        this.c = f3;
        this.f7297d = i2;
        this.f7298e = f4;
        this.f7299f = i3;
        this.f7300g = f5;
    }

    @Override // android.view.animation.Animation
    protected final void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.b;
        float f4 = f3 + ((this.c - f3) * f2);
        Matrix matrix = transformation.getMatrix();
        Camera camera = this.f7303j;
        camera.save();
        if (this.a) {
            camera.rotateX(f4);
        } else {
            camera.rotateY(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float f5 = this.f7301h;
        float f6 = this.f7302i;
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
    }

    @Override // android.view.animation.Animation
    public final void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        this.f7301h = resolveSize(this.f7297d, this.f7298e, i2, i4);
        this.f7302i = resolveSize(this.f7299f, this.f7300g, i3, i5);
        this.f7303j = new Camera();
    }
}
