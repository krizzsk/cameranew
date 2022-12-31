package us.pinguo.facedetector;

import android.graphics.PointF;
import android.graphics.Rect;
import kotlin.Pair;
import kotlin.jvm.internal.s;
/* compiled from: FaceInfo.kt */
/* loaded from: classes4.dex */
public final class b {
    private final int a;
    private final float[] b;
    private final float[] c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10968d;

    /* renamed from: e  reason: collision with root package name */
    private final float f10969e;

    /* renamed from: f  reason: collision with root package name */
    private final float f10970f;

    /* renamed from: g  reason: collision with root package name */
    private final float f10971g;

    public b(int i2, Rect rect, float[] points, float f2, float f3, float f4) {
        s.i(rect, "rect");
        s.i(points, "points");
        this.a = i2;
        this.f10968d = rect;
        this.b = points;
        this.f10969e = f2;
        this.f10970f = f3;
        this.f10971g = f4;
        this.c = j();
    }

    private final PointF a(PointF pointF, PointF pointF2) {
        float f2 = 2;
        return new PointF((pointF.x + pointF2.x) / f2, (pointF.y + pointF2.y) / f2);
    }

    private final float b(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    private final float[] j() {
        float l2 = l(79);
        float m = m(79);
        float f2 = 3;
        Pair pair = new Pair(Float.valueOf((l2 - l(78)) * f2), Float.valueOf((m - m(78)) * f2));
        float b = b(l(43), m(43), l(49), m(49));
        PointF k2 = k(l(46), m(46), l(43), m(43), b * 1.59f);
        PointF pointF = new PointF(k2.x + (((Number) pair.getFirst()).floatValue() * 0.91f), k2.y + (((Number) pair.getSecond()).floatValue() * 0.91f));
        PointF pointF2 = new PointF(k2.x - (((Number) pair.getFirst()).floatValue() * 0.91f), k2.y - (((Number) pair.getSecond()).floatValue() * 0.91f));
        PointF k3 = k(l(46), m(46), l(43), m(43), b * 2.3f);
        PointF pointF3 = new PointF(k3.x + (((Number) pair.getFirst()).floatValue() * 0.91f), k3.y + (((Number) pair.getSecond()).floatValue() * 0.91f));
        PointF pointF4 = new PointF(k3.x - (((Number) pair.getFirst()).floatValue() * 0.91f), k3.y - (((Number) pair.getSecond()).floatValue() * 0.91f));
        PointF a = a(new PointF(l(37), m(37)), new PointF(l(38), m(38)));
        return new float[]{pointF.x, pointF.y, pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y, k3.x, k3.y, a.x, a.y};
    }

    private final PointF k(float f2, float f3, float f4, float f5, float f6) {
        float b = b(f2, f3, f4, f5);
        return new PointF(f2 - (((f2 - f4) / b) * f6), f3 - (((f3 - f5) / b) * f6));
    }

    public final float[] c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final float e() {
        return this.f10969e;
    }

    public final float[] f() {
        return this.b;
    }

    public final Rect g() {
        return this.f10968d;
    }

    public final float h() {
        return this.f10971g;
    }

    public final float i() {
        return this.f10970f;
    }

    public final float l(int i2) {
        if (i2 < 106) {
            return this.b[i2 * 2];
        }
        return this.c[(i2 - 106) * 2];
    }

    public final float m(int i2) {
        if (i2 < 106) {
            return this.b[(i2 * 2) + 1];
        }
        return this.c[((i2 - 106) * 2) + 1];
    }
}
