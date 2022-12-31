package kotlin.internal;
/* compiled from: progressionUtil.kt */
/* loaded from: classes3.dex */
public final class c {
    private static final int a(int i2, int i3, int i4) {
        return e(e(i2, i4) - e(i3, i4), i4);
    }

    private static final long b(long j2, long j3, long j4) {
        return f(f(j2, j4) - f(j3, j4), j4);
    }

    public static final int c(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - a(i3, i2, i4);
        } else if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + a(i2, i3, -i4);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long d(long j2, long j3, long j4) {
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i2 > 0) {
            return j2 >= j3 ? j3 : j3 - b(j3, j2, j4);
        } else if (i2 < 0) {
            return j2 <= j3 ? j3 : j3 + b(j2, j3, -j4);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int e(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    private static final long f(long j2, long j3) {
        long j4 = j2 % j3;
        return j4 >= 0 ? j4 : j4 + j3;
    }
}
