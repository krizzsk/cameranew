package com.airbnb.lottie.w;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.t.b.k;
import java.util.List;
/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static boolean d(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    private static int e(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(float f2, float f3) {
        return g((int) f2, (int) f3);
    }

    private static int g(int i2, int i3) {
        return i2 - (i3 * e(i2, i3));
    }

    public static void h(com.airbnb.lottie.model.content.h hVar, Path path) {
        path.reset();
        PointF b = hVar.b();
        path.moveTo(b.x, b.y);
        a.set(b.x, b.y);
        for (int i2 = 0; i2 < hVar.a().size(); i2++) {
            com.airbnb.lottie.model.a aVar = hVar.a().get(i2);
            PointF a2 = aVar.a();
            PointF b2 = aVar.b();
            PointF c = aVar.c();
            if (a2.equals(a) && b2.equals(c)) {
                path.lineTo(c.x, c.y);
            } else {
                path.cubicTo(a2.x, a2.y, b2.x, b2.y, c.x, c.y);
            }
            a.set(c.x, c.y);
        }
        if (hVar.d()) {
            path.close();
        }
    }

    public static double i(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float j(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int k(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static void l(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2, k kVar) {
        if (dVar.c(kVar.getName(), i2)) {
            list.add(dVar2.a(kVar.getName()).i(kVar));
        }
    }
}
