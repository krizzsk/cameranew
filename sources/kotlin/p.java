package kotlin;
/* compiled from: ULong.kt */
/* loaded from: classes3.dex */
public final class p implements Comparable<p> {
    private final long a;

    private /* synthetic */ p(long j2) {
        this.a = j2;
    }

    public static final /* synthetic */ p a(long j2) {
        return new p(j2);
    }

    public static long b(long j2) {
        return j2;
    }

    public static boolean c(long j2, Object obj) {
        return (obj instanceof p) && j2 == ((p) obj).f();
    }

    public static int d(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static String e(long j2) {
        return v.c(j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(p pVar) {
        return v.b(f(), pVar.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }
}
