package kotlin.random;

import kotlin.jvm.internal.s;
/* compiled from: Random.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final String a(Object from, Object until) {
        s.h(from, "from");
        s.h(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(a(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    public static final void c(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final void d(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(a(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    public static final int e(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int f(Random random, kotlin.z.d range) {
        s.h(random, "<this>");
        s.h(range, "range");
        if (!range.isEmpty()) {
            return range.b() < Integer.MAX_VALUE ? random.nextInt(range.a(), range.b() + 1) : range.a() > Integer.MIN_VALUE ? random.nextInt(range.a() - 1, range.b()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int g(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
