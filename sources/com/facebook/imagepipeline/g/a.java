package com.facebook.imagepipeline.g;

import androidx.annotation.VisibleForTesting;
import javax.annotation.Nullable;
/* compiled from: DownsampleUtil.java */
/* loaded from: classes.dex */
public class a {
    @VisibleForTesting
    public static float a(com.facebook.imagepipeline.common.e eVar, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.image.e eVar2) {
        com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.imagepipeline.image.e.X(eVar2)));
        if (dVar == null || dVar.b <= 0 || dVar.a <= 0 || eVar2.T() == 0 || eVar2.z() == 0) {
            return 1.0f;
        }
        int d2 = d(eVar, eVar2);
        boolean z = d2 == 90 || d2 == 270;
        int z2 = z ? eVar2.z() : eVar2.T();
        int T = z ? eVar2.T() : eVar2.z();
        float f2 = dVar.a / z2;
        float f3 = dVar.b / T;
        float max = Math.max(f2, f3);
        com.facebook.common.logging.a.u("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(dVar.a), Integer.valueOf(dVar.b), Integer.valueOf(z2), Integer.valueOf(T), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max));
        return max;
    }

    public static int b(com.facebook.imagepipeline.common.e eVar, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.image.e eVar2, int i2) {
        int e2;
        if (com.facebook.imagepipeline.image.e.X(eVar2)) {
            float a = a(eVar, dVar, eVar2);
            if (eVar2.A() == com.facebook.imageformat.b.a) {
                e2 = f(a);
            } else {
                e2 = e(a);
            }
            int max = Math.max(eVar2.z(), eVar2.T());
            float f2 = dVar != null ? dVar.c : i2;
            while (max / e2 > f2) {
                e2 = eVar2.A() == com.facebook.imageformat.b.a ? e2 * 2 : e2 + 1;
            }
            return e2;
        }
        return 1;
    }

    public static int c(com.facebook.imagepipeline.image.e eVar, int i2, int i3) {
        int R = eVar.R();
        while ((((eVar.T() * eVar.z()) * i2) / R) / R > i3) {
            R *= 2;
        }
        return R;
    }

    private static int d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.image.e eVar2) {
        boolean z = false;
        if (eVar.f()) {
            int Q = eVar2.Q();
            com.facebook.common.internal.h.b(Boolean.valueOf((Q == 0 || Q == 90 || Q == 180 || Q == 270) ? true : true));
            return Q;
        }
        return 0;
    }

    @VisibleForTesting
    public static int e(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            double d2 = i2;
            if ((1.0d / d2) + ((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) <= f2) {
                return i2 - 1;
            }
            i2++;
        }
    }

    @VisibleForTesting
    public static int f(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            int i3 = i2 * 2;
            double d2 = 1.0d / i3;
            if (d2 + (0.3333333432674408d * d2) <= f2) {
                return i2;
            }
            i2 = i3;
        }
    }
}
