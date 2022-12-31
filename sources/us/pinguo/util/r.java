package us.pinguo.util;

import java.util.Objects;
/* compiled from: PGSize.kt */
/* loaded from: classes6.dex */
public final class r implements Comparable<r> {
    private int a;
    private int b;

    public r() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(r other) {
        kotlin.jvm.internal.s.h(other, "other");
        return Long.signum((this.a * this.b) - (other.a * other.b));
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (kotlin.jvm.internal.s.c(r.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.util.PGSize");
            r rVar = (r) obj;
            return this.a == rVar.a && this.b == rVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return this.a + " x " + this.b;
    }

    public r(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }
}
