package us.pinguo.edit2020.bean;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public final class h0 {
    private final String a;
    private int b;

    public h0(String name, int i2) {
        kotlin.jvm.internal.s.h(name, "name");
        this.a = name;
        this.b = i2;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void c(int i2) {
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            h0 h0Var = (h0) obj;
            return kotlin.jvm.internal.s.c(this.a, h0Var.a) && this.b == h0Var.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "OptionalColorVector(name=" + this.a + ", value=" + this.b + ')';
    }
}
