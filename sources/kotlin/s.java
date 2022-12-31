package kotlin;
/* compiled from: UShort.kt */
/* loaded from: classes3.dex */
public final class s implements Comparable<s> {
    private final short a;

    private /* synthetic */ s(short s) {
        this.a = s;
    }

    public static final /* synthetic */ s a(short s) {
        return new s(s);
    }

    public static short b(short s) {
        return s;
    }

    public static boolean c(short s, Object obj) {
        return (obj instanceof s) && s == ((s) obj).f();
    }

    public static int d(short s) {
        return s;
    }

    public static String e(short s) {
        return String.valueOf(s & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(s sVar) {
        return kotlin.jvm.internal.s.j(f() & 65535, sVar.f() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ short f() {
        return this.a;
    }

    public int hashCode() {
        short s = this.a;
        d(s);
        return s;
    }

    public String toString() {
        return e(this.a);
    }
}
