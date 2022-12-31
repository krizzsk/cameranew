package us.pinguo.ui.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: Rotate3dAnimation.java */
/* loaded from: classes6.dex */
public class i extends Animation {
    private final float a;
    private final float b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f12293d;

    /* renamed from: e  reason: collision with root package name */
    private final float f12294e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12295f;

    /* renamed from: g  reason: collision with root package name */
    private Camera f12296g;

    public i(float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.f12293d = f5;
        this.f12294e = f6;
        this.f12295f = z;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.a;
        float f4 = f3 + ((this.b - f3) * f2);
        float f5 = this.c;
        float f6 = this.f12293d;
        Camera camera = this.f12296g;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f12295f) {
            camera.translate(0.0f, 0.0f, this.f12294e * f2);
        } else {
            camera.translate(0.0f, 0.0f, this.f12294e * (1.0f - f2));
        }
        camera.rotateY(f4);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        this.f12296g = new Camera();
    }
}
