package kotlin.time;

import androidx.core.location.LocationRequestCompat;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z.g;
/* compiled from: Duration.kt */
/* loaded from: classes3.dex */
public final class a implements Comparable<a> {
    public static final C0319a b = new C0319a(null);
    private static final long c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f8687d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f8688e;
    private final long a;

    /* compiled from: Duration.kt */
    /* renamed from: kotlin.time.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0319a {
        private C0319a() {
        }

        public /* synthetic */ C0319a(o oVar) {
            this();
        }

        public final long a() {
            return a.c;
        }
    }

    static {
        long e2;
        long e3;
        e(0L);
        c = 0L;
        e2 = c.e(4611686018427387903L);
        f8687d = e2;
        e3 = c.e(-4611686018427387903L);
        f8688e = e3;
    }

    public static final long A(long j2) {
        long d2;
        d2 = c.d(-r(j2), ((int) j2) & 1);
        return d2;
    }

    private static final void b(long j2, StringBuilder sb, int i2, int i3, int i4, String str, boolean z) {
        String a0;
        sb.append(i2);
        if (i3 != 0) {
            sb.append('.');
            a0 = StringsKt__StringsKt.a0(String.valueOf(i3), i4, '0');
            int i5 = -1;
            int length = a0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (a0.charAt(length) != '0') {
                        i5 = length;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (!z && i7 < 3) {
                sb.append((CharSequence) a0, 0, i7);
                s.g(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) a0, 0, ((i7 + 2) / 3) * 3);
                s.g(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static int d(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 < 0 || (((int) j4) & 1) == 0) {
            return s.k(j2, j3);
        }
        int i2 = (((int) j2) & 1) - (((int) j3) & 1);
        return x(j2) ? -i2 : i2;
    }

    public static long e(long j2) {
        if (b.a()) {
            if (v(j2)) {
                if (!new g(-4611686018426999999L, 4611686018426999999L).d(r(j2))) {
                    throw new AssertionError(r(j2) + " ns is out of nanoseconds range");
                }
            } else if (new g(-4611686018427387903L, 4611686018427387903L).d(r(j2))) {
                if (new g(-4611686018426L, 4611686018426L).d(r(j2))) {
                    throw new AssertionError(r(j2) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(r(j2) + " ms is out of milliseconds range");
            }
        }
        return j2;
    }

    public static boolean f(long j2, Object obj) {
        return (obj instanceof a) && j2 == ((a) obj).B();
    }

    public static final long g(long j2) {
        return x(j2) ? A(j2) : j2;
    }

    public static final int h(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (j(j2) % 24);
    }

    public static final long i(long j2) {
        return y(j2, DurationUnit.DAYS);
    }

    public static final long j(long j2) {
        return y(j2, DurationUnit.HOURS);
    }

    public static final long k(long j2) {
        return (u(j2) && t(j2)) ? r(j2) : y(j2, DurationUnit.MILLISECONDS);
    }

    public static final long l(long j2) {
        return y(j2, DurationUnit.MINUTES);
    }

    public static final long m(long j2) {
        return y(j2, DurationUnit.SECONDS);
    }

    public static final int n(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (l(j2) % 60);
    }

    public static final int o(long j2) {
        long r;
        if (w(j2)) {
            return 0;
        }
        if (u(j2)) {
            r = c.f(r(j2) % 1000);
        } else {
            r = r(j2) % 1000000000;
        }
        return (int) r;
    }

    public static final int p(long j2) {
        if (w(j2)) {
            return 0;
        }
        return (int) (m(j2) % 60);
    }

    private static final DurationUnit q(long j2) {
        return v(j2) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long r(long j2) {
        return j2 >> 1;
    }

    public static int s(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static final boolean t(long j2) {
        return !w(j2);
    }

    private static final boolean u(long j2) {
        return (((int) j2) & 1) == 1;
    }

    private static final boolean v(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static final boolean w(long j2) {
        return j2 == f8687d || j2 == f8688e;
    }

    public static final boolean x(long j2) {
        return j2 < 0;
    }

    public static final long y(long j2, DurationUnit unit) {
        s.h(unit, "unit");
        if (j2 == f8687d) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j2 == f8688e) {
            return Long.MIN_VALUE;
        }
        return d.a(r(j2), q(j2), unit);
    }

    public static String z(long j2) {
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == f8687d) {
            return "Infinity";
        }
        if (j2 == f8688e) {
            return "-Infinity";
        }
        boolean x = x(j2);
        StringBuilder sb = new StringBuilder();
        if (x) {
            sb.append('-');
        }
        long g2 = g(j2);
        long i2 = i(g2);
        int h2 = h(g2);
        int n = n(g2);
        int p = p(g2);
        int o = o(g2);
        int i3 = 0;
        boolean z = i2 != 0;
        boolean z2 = h2 != 0;
        boolean z3 = n != 0;
        boolean z4 = (p == 0 && o == 0) ? false : true;
        if (z) {
            sb.append(i2);
            sb.append('d');
            i3 = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i4 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            sb.append(h2);
            sb.append('h');
            i3 = i4;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i5 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            sb.append(n);
            sb.append('m');
            i3 = i5;
        }
        if (z4) {
            int i6 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            if (p != 0 || z || z2 || z3) {
                b(j2, sb, p, o, 9, "s", false);
            } else if (o >= 1000000) {
                b(j2, sb, o / 1000000, o % 1000000, 6, "ms", false);
            } else if (o >= 1000) {
                b(j2, sb, o / 1000, o % 1000, 3, "us", false);
            } else {
                sb.append(o);
                sb.append("ns");
            }
            i3 = i6;
        }
        if (x && i3 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        s.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final /* synthetic */ long B() {
        return this.a;
    }

    public int c(long j2) {
        return d(this.a, j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return c(aVar.B());
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return s(this.a);
    }

    public String toString() {
        return z(this.a);
    }
}
