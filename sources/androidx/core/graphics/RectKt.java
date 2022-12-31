package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.s;
/* compiled from: Rect.kt */
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    public static final Rect and(Rect rect, Rect r) {
        s.h(rect, "<this>");
        s.h(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.intersect(r);
        return rect2;
    }

    public static final int component1(Rect rect) {
        s.h(rect, "<this>");
        return rect.left;
    }

    public static final int component2(Rect rect) {
        s.h(rect, "<this>");
        return rect.top;
    }

    public static final int component3(Rect rect) {
        s.h(rect, "<this>");
        return rect.right;
    }

    public static final int component4(Rect rect) {
        s.h(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point p) {
        s.h(rect, "<this>");
        s.h(p, "p");
        return rect.contains(p.x, p.y);
    }

    public static final Region minus(Rect rect, Rect r) {
        s.h(rect, "<this>");
        s.h(r, "r");
        Region region = new Region(rect);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect rect, Rect r) {
        s.h(rect, "<this>");
        s.h(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r);
        return rect2;
    }

    public static final Rect plus(Rect rect, Rect r) {
        s.h(rect, "<this>");
        s.h(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r);
        return rect2;
    }

    public static final Rect times(Rect rect, int i2) {
        s.h(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i2;
        rect2.left *= i2;
        rect2.right *= i2;
        rect2.bottom *= i2;
        return rect2;
    }

    public static final Rect toRect(RectF rectF) {
        s.h(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        s.h(rect, "<this>");
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        s.h(rect, "<this>");
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix m) {
        s.h(rectF, "<this>");
        s.h(m, "m");
        m.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect r) {
        s.h(rect, "<this>");
        s.h(r, "r");
        Region region = new Region(rect);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        s.h(rectF, "<this>");
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        s.h(rectF, "<this>");
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        s.h(rectF, "<this>");
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        s.h(rectF, "<this>");
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF p) {
        s.h(rectF, "<this>");
        s.h(p, "p");
        return rectF.contains(p.x, p.y);
    }

    public static final Region toRegion(RectF rectF) {
        s.h(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF r) {
        s.h(rectF, "<this>");
        s.h(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.intersect(r);
        return rectF2;
    }

    public static final Region minus(RectF rectF, RectF r) {
        s.h(rectF, "<this>");
        s.h(r, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF or(RectF rectF, RectF r) {
        s.h(rectF, "<this>");
        s.h(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r);
        return rectF2;
    }

    public static final RectF plus(RectF rectF, RectF r) {
        s.h(rectF, "<this>");
        s.h(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r);
        return rectF2;
    }

    public static final Region xor(RectF rectF, RectF r) {
        s.h(rectF, "<this>");
        s.h(r, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final Rect plus(Rect rect, int i2) {
        s.h(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f2) {
        s.h(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    public static final RectF plus(RectF rectF, float f2) {
        s.h(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final Rect plus(Rect rect, Point xy) {
        s.h(rect, "<this>");
        s.h(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(xy.x, xy.y);
        return rect2;
    }

    public static final Rect minus(Rect rect, int i2) {
        s.h(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    public static final RectF plus(RectF rectF, PointF xy) {
        s.h(rectF, "<this>");
        s.h(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(xy.x, xy.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i2) {
        s.h(rectF, "<this>");
        float f2 = i2;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    public static final RectF minus(RectF rectF, float f2) {
        s.h(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    public static final Rect minus(Rect rect, Point xy) {
        s.h(rect, "<this>");
        s.h(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-xy.x, -xy.y);
        return rect2;
    }

    public static final RectF minus(RectF rectF, PointF xy) {
        s.h(rectF, "<this>");
        s.h(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-xy.x, -xy.y);
        return rectF2;
    }
}
