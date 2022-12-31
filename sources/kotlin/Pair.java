package kotlin;

import java.io.Serializable;
/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = pair.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a, B b) {
        return new Pair<>(a, b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return kotlin.jvm.internal.s.c(this.first, pair.first) && kotlin.jvm.internal.s.c(this.second, pair.second);
        }
        return false;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int hashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b = this.second;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
