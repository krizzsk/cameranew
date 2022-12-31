package kotlin;
/* compiled from: UnsignedUtils.kt */
/* loaded from: classes3.dex */
public final class v {
    public static final int a(int i2, int i3) {
        return kotlin.jvm.internal.s.j(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j2, long j3) {
        return kotlin.jvm.internal.s.k(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
    }

    public static final String c(long j2) {
        return d(j2, 10);
    }

    public static final String d(long j2, int i2) {
        if (j2 >= 0) {
            kotlin.text.b.a(i2);
            String l2 = Long.toString(j2, i2);
            kotlin.jvm.internal.s.g(l2, "toString(this, checkRadix(radix))");
            return l2;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        kotlin.text.b.a(i2);
        String l3 = Long.toString(j4, i2);
        kotlin.jvm.internal.s.g(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        kotlin.text.b.a(i2);
        String l4 = Long.toString(j5, i2);
        kotlin.jvm.internal.s.g(l4, "toString(this, checkRadix(radix))");
        sb.append(l4);
        return sb.toString();
    }
}
