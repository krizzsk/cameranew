package kotlin;
/* compiled from: UInt.kt */
/* loaded from: classes3.dex */
public final class n implements Comparable<n> {
    private final int a;

    private /* synthetic */ n(int i2) {
        this.a = i2;
    }

    public static final /* synthetic */ n a(int i2) {
        return new n(i2);
    }

    public static int b(int i2) {
        return i2;
    }

    public static boolean c(int i2, Object obj) {
        return (obj instanceof n) && i2 == ((n) obj).f();
    }

    public static int d(int i2) {
        return i2;
    }

    public static String e(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(n nVar) {
        return v.a(f(), nVar.f());
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ int f() {
        return this.a;
    }

    public int hashCode() {
        int i2 = this.a;
        d(i2);
        return i2;
    }

    public String toString() {
        return e(this.a);
    }
}
