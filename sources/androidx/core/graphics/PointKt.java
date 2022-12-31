package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.jvm.internal.s;
/* compiled from: Point.kt */
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(Point point) {
        s.h(point, "<this>");
        return point.x;
    }

    public static final int component2(Point point) {
        s.h(point, "<this>");
        return point.y;
    }

    public static final Point minus(Point point, Point p) {
        s.h(point, "<this>");
        s.h(p, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(-p.x, -p.y);
        return point2;
    }

    public static final Point plus(Point point, Point p) {
        s.h(point, "<this>");
        s.h(p, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(p.x, p.y);
        return point2;
    }

    public static final Point toPoint(PointF pointF) {
        s.h(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(Point point) {
        s.h(point, "<this>");
        return new PointF(point);
    }

    public static final Point unaryMinus(Point point) {
        s.h(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(PointF pointF) {
        s.h(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        s.h(pointF, "<this>");
        return pointF.y;
    }

    public static final PointF unaryMinus(PointF pointF) {
        s.h(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF minus(PointF pointF, PointF p) {
        s.h(pointF, "<this>");
        s.h(p, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(-p.x, -p.y);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, PointF p) {
        s.h(pointF, "<this>");
        s.h(p, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(p.x, p.y);
        return pointF2;
    }

    public static final Point minus(Point point, int i2) {
        s.h(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i3 = -i2;
        point2.offset(i3, i3);
        return point2;
    }

    public static final Point plus(Point point, int i2) {
        s.h(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i2, i2);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f2) {
        s.h(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f3 = -f2;
        pointF2.offset(f3, f3);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, float f2) {
        s.h(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f2, f2);
        return pointF2;
    }
}
