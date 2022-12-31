package us.pinguo.facedetector;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import kotlin.jvm.internal.s;
/* compiled from: CoordinateConverter.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final Matrix b(int i2, int i3, int i4, boolean z) {
        Matrix matrix = new Matrix();
        matrix.reset();
        int i5 = i4 % BaseBlurEffect.ROTATION_360;
        if (i5 == 90) {
            matrix.postRotate(90.0f);
            matrix.postTranslate(i3, 0.0f);
        } else if (i5 == 180) {
            matrix.postRotate(180.0f);
            matrix.postTranslate(i2, i3);
        } else if (i5 == 270) {
            matrix.postRotate(270.0f);
            matrix.postTranslate(0.0f, i2);
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (i4 == 0 || i4 == 180) {
                matrix.postTranslate(i2, 0.0f);
            } else if (i4 == 90 || i4 == 270) {
                matrix.postTranslate(i3, 0.0f);
            }
        }
        return matrix;
    }

    private final void e(float[] fArr, int i2, int i3) {
        int i4 = i2 << 1;
        int i5 = i4 + 1;
        float f2 = fArr[i4];
        float f3 = fArr[i5];
        int i6 = i3 << 1;
        int i7 = i6 + 1;
        fArr[i4] = fArr[i6];
        fArr[i5] = fArr[i7];
        fArr[i6] = f2;
        fArr[i7] = f3;
    }

    public final void a(b faceInfo, int i2, int i3, int i4, boolean z) {
        s.i(faceInfo, "faceInfo");
        Matrix b = b(i2, i3, i4, z);
        b.mapPoints(faceInfo.f());
        RectF rectF = new RectF(faceInfo.g());
        b.mapRect(rectF);
        faceInfo.g().set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (z) {
            d(faceInfo.f());
        }
    }

    public final void c(float[] ex) {
        s.i(ex, "ex");
        e(ex, 3, 2);
        e(ex, 1, 0);
    }

    public final void d(float[] src) {
        s.i(src, "src");
        int i2 = 0;
        int i3 = 32;
        while (i2 <= 15) {
            e(src, i2, i3);
            i2++;
            i3--;
        }
        int i4 = 33;
        int i5 = 42;
        while (i4 <= 37) {
            e(src, i4, i5);
            i4++;
            i5--;
        }
        int i6 = 64;
        int i7 = 71;
        while (i6 <= 67) {
            e(src, i6, i7);
            i6++;
            i7--;
        }
        e(src, 52, 61);
        e(src, 53, 60);
        e(src, 72, 75);
        e(src, 54, 59);
        e(src, 55, 58);
        e(src, 56, 63);
        e(src, 73, 76);
        e(src, 57, 62);
        e(src, 78, 79);
        e(src, 104, 105);
        e(src, 74, 77);
        e(src, 80, 81);
        e(src, 82, 83);
        e(src, 47, 51);
        e(src, 48, 50);
        e(src, 84, 90);
        e(src, 85, 89);
        e(src, 86, 88);
        e(src, 96, 100);
        e(src, 97, 99);
        e(src, 103, 101);
        e(src, 95, 91);
        e(src, 94, 92);
    }
}
