package kotlin;

import java.io.Serializable;
/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = triple.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A a, B b, C c) {
        return new Triple<>(a, b, c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple triple = (Triple) obj;
            return kotlin.jvm.internal.s.c(this.first, triple.first) && kotlin.jvm.internal.s.c(this.second, triple.second) && kotlin.jvm.internal.s.c(this.third, triple.third);
        }
        return false;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int hashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b = this.second;
        int hashCode2 = (hashCode + (b == null ? 0 : b.hashCode())) * 31;
        C c = this.third;
        return hashCode2 + (c != null ? c.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
