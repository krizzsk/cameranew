package com.facebook.imagepipeline.g;

import android.graphics.Matrix;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.ImmutableList;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import javax.annotation.Nullable;
/* compiled from: JpegTranscoderUtils.java */
/* loaded from: classes.dex */
public class e {
    public static final ImmutableList<Integer> a = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});

    @VisibleForTesting
    public static int a(int i2) {
        return Math.max(1, 8 / i2);
    }

    @VisibleForTesting
    public static float b(com.facebook.imagepipeline.common.d dVar, int i2, int i3) {
        if (dVar == null) {
            return 1.0f;
        }
        float f2 = i2;
        float f3 = i3;
        float max = Math.max(dVar.a / f2, dVar.b / f3);
        float f4 = dVar.c;
        if (f2 * max > f4) {
            max = f4 / f2;
        }
        return f3 * max > f4 ? f4 / f3 : max;
    }

    private static int c(com.facebook.imagepipeline.image.e eVar) {
        int Q = eVar.Q();
        if (Q == 90 || Q == 180 || Q == 270) {
            return eVar.Q();
        }
        return 0;
    }

    public static int d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.image.e eVar2) {
        int x = eVar2.x();
        ImmutableList<Integer> immutableList = a;
        int indexOf = immutableList.indexOf(Integer.valueOf(x));
        if (indexOf >= 0) {
            return immutableList.get((indexOf + ((eVar.f() ? 0 : eVar.d()) / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int e(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.image.e eVar2) {
        if (eVar.e()) {
            int c = c(eVar2);
            return eVar.f() ? c : (c + eVar.d()) % BaseBlurEffect.ROTATION_360;
        }
        return 0;
    }

    public static int f(com.facebook.imagepipeline.common.e eVar, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.image.e eVar2, boolean z) {
        if (z && dVar != null) {
            int e2 = e(eVar, eVar2);
            boolean z2 = false;
            int d2 = a.contains(Integer.valueOf(eVar2.x())) ? d(eVar, eVar2) : 0;
            z2 = (e2 == 90 || e2 == 270 || d2 == 5 || d2 == 7) ? true : true;
            int k2 = k(b(dVar, z2 ? eVar2.z() : eVar2.T(), z2 ? eVar2.T() : eVar2.z()), dVar.f2718d);
            if (k2 > 8) {
                return 8;
            }
            if (k2 < 1) {
                return 1;
            }
            return k2;
        }
        return 8;
    }

    @Nullable
    public static Matrix g(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.common.e eVar2) {
        if (a.contains(Integer.valueOf(eVar.x()))) {
            return h(d(eVar2, eVar));
        }
        int e2 = e(eVar2, eVar);
        if (e2 != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(e2);
            return matrix;
        }
        return null;
    }

    @Nullable
    private static Matrix h(int i2) {
        Matrix matrix = new Matrix();
        if (i2 == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i2 == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 != 5) {
            return null;
        } else {
            matrix.setRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    public static boolean i(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static boolean j(int i2) {
        return i2 >= 0 && i2 <= 270 && i2 % 90 == 0;
    }

    @VisibleForTesting
    public static int k(float f2, float f3) {
        return (int) (f3 + (f2 * 8.0f));
    }
}
