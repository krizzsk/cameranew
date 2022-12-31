package kotlin.collections;
/* compiled from: IndexedValue.kt */
/* loaded from: classes3.dex */
public final class g0<T> {
    private final int a;
    private final T b;

    public g0(int i2, T t) {
        this.a = i2;
        this.b = t;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            return this.a == g0Var.a && kotlin.jvm.internal.s.c(this.b, g0Var.b);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        T t = this.b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
