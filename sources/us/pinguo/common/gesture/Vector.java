package us.pinguo.common.gesture;

import android.graphics.PointF;
import kotlin.jvm.internal.s;
/* compiled from: Vector.kt */
/* loaded from: classes4.dex */
public final class Vector extends PointF {
    public Vector(float f2, float f3) {
        super(f2, f3);
    }

    public final Vector a(Vector vector) {
        s.h(vector, "vector");
        return new Vector(((PointF) this).x + ((PointF) vector).x, ((PointF) this).y + ((PointF) vector).y);
    }

    public final float b() {
        float f2 = ((PointF) this).x;
        float f3 = ((PointF) this).y;
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }
}
