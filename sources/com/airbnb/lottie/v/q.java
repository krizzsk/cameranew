package com.airbnb.lottie.v;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {
    private static SparseArrayCompat<WeakReference<Interpolator>> b;
    private static final Interpolator a = new LinearInterpolator();
    static JsonReader.a c = JsonReader.a.a("t", "s", "e", "o", ContextChain.TAG_INFRA, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, "to", "ti");

    q() {
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = e().get(i2);
        }
        return weakReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.airbnb.lottie.x.a<T> b(JsonReader jsonReader, com.airbnb.lottie.e eVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        if (z) {
            return c(eVar, jsonReader, f2, j0Var);
        }
        return d(jsonReader, f2, j0Var);
    }

    private static <T> com.airbnb.lottie.x.a<T> c(com.airbnb.lottie.e eVar, JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator linearInterpolator;
        jsonReader.t();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (jsonReader.x()) {
            switch (jsonReader.T(c)) {
                case 0:
                    f3 = (float) jsonReader.z();
                    break;
                case 1:
                    t3 = j0Var.a(jsonReader, f2);
                    break;
                case 2:
                    t2 = j0Var.a(jsonReader, f2);
                    break;
                case 3:
                    pointF = p.e(jsonReader, f2);
                    break;
                case 4:
                    pointF2 = p.e(jsonReader, f2);
                    break;
                case 5:
                    if (jsonReader.A() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF4 = p.e(jsonReader, f2);
                    break;
                case 7:
                    pointF3 = p.e(jsonReader, f2);
                    break;
                default:
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.w();
        if (z) {
            interpolator = a;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                float f4 = -f2;
                pointF.x = com.airbnb.lottie.w.g.b(pointF.x, f4, f2);
                pointF.y = com.airbnb.lottie.w.g.b(pointF.y, -100.0f, 100.0f);
                pointF2.x = com.airbnb.lottie.w.g.b(pointF2.x, f4, f2);
                float b2 = com.airbnb.lottie.w.g.b(pointF2.y, -100.0f, 100.0f);
                pointF2.y = b2;
                int i2 = com.airbnb.lottie.w.h.i(pointF.x, pointF.y, pointF2.x, b2);
                WeakReference<Interpolator> a2 = a(i2);
                Interpolator interpolator2 = a2 != null ? a2.get() : null;
                if (a2 == null || interpolator2 == null) {
                    pointF.x /= f2;
                    pointF.y /= f2;
                    float f5 = pointF2.x / f2;
                    pointF2.x = f5;
                    float f6 = pointF2.y / f2;
                    pointF2.y = f6;
                    try {
                        linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, f5, f6);
                    } catch (IllegalArgumentException e2) {
                        if (e2.getMessage().equals("The Path cannot loop back on itself.")) {
                            linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                        } else {
                            linearInterpolator = new LinearInterpolator();
                        }
                    }
                    interpolator2 = linearInterpolator;
                    try {
                        f(i2, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            } else {
                interpolator = a;
            }
            t = t2;
        }
        com.airbnb.lottie.x.a<T> aVar = new com.airbnb.lottie.x.a<>(eVar, t3, t, interpolator, f3, null);
        aVar.m = pointF4;
        aVar.n = pointF3;
        return aVar;
    }

    private static <T> com.airbnb.lottie.x.a<T> d(JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        return new com.airbnb.lottie.x.a<>(j0Var.a(jsonReader, f2));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> e() {
        if (b == null) {
            b = new SparseArrayCompat<>();
        }
        return b;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            b.put(i2, weakReference);
        }
    }
}
