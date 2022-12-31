package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Region.kt */
/* loaded from: classes.dex */
public final class RegionKt {
    public static final Region and(Region region, Rect r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point p) {
        s.h(region, "<this>");
        s.h(p, "p");
        return region.contains(p.x, p.y);
    }

    public static final void forEach(Region region, l<? super Rect, u> action) {
        s.h(region, "<this>");
        s.h(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            action.invoke(rect);
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        s.h(region, "<this>");
        return new RegionKt$iterator$1(region);
    }

    public static final Region minus(Region region, Rect r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        s.h(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region plus(Region region, Rect r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        s.h(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }

    public static final Region and(Region region, Region r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final Region minus(Region region, Region r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Region r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region plus(Region region, Region r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region xor(Region region, Region r) {
        s.h(region, "<this>");
        s.h(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }
}
