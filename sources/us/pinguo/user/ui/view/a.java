package us.pinguo.user.ui.view;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* compiled from: CropImageView.java */
/* loaded from: classes6.dex */
class a implements TypeEvaluator<Matrix> {
    private float[] a = new float[9];
    private float[] b = new float[9];
    private float[] c = new float[9];

    /* renamed from: d  reason: collision with root package name */
    private Matrix f12464d = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        if (matrix == null || matrix2 == null) {
            return matrix2;
        }
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        int i2 = 0;
        while (true) {
            float[] fArr = this.c;
            if (i2 < fArr.length) {
                float[] fArr2 = this.a;
                fArr[i2] = fArr2[i2] + ((this.b[i2] - fArr2[i2]) * f2);
                i2++;
            } else {
                this.f12464d.setValues(fArr);
                return this.f12464d;
            }
        }
    }
}
