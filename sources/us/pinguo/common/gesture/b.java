package us.pinguo.common.gesture;

import android.graphics.PointF;
import kotlin.jvm.internal.s;
/* compiled from: Vector.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final PointF a(PointF pointF, Vector vector) {
        s.h(pointF, "<this>");
        s.h(vector, "vector");
        return new PointF(pointF.x - ((PointF) vector).x, pointF.y - ((PointF) vector).y);
    }

    public static final PointF b(PointF pointF, Vector vector) {
        s.h(pointF, "<this>");
        s.h(vector, "vector");
        return new PointF(pointF.x + ((PointF) vector).x, pointF.y + ((PointF) vector).y);
    }
}
