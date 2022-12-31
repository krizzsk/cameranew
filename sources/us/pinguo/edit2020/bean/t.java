package us.pinguo.edit2020.bean;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public final class t {
    private final int a;
    private final Integer b;
    private final int c;

    public t(int i2, Integer num, int i3) {
        this.a = i2;
        this.b = num;
        this.c = i3;
    }

    public final int a() {
        return this.c;
    }

    public final Integer b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.a == tVar.a && kotlin.jvm.internal.s.c(this.b, tVar.b) && this.c == tVar.c;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        Integer num = this.b;
        return ((i2 + (num == null ? 0 : num.hashCode())) * 31) + this.c;
    }

    public String toString() {
        return "GradientInfo(start=" + this.a + ", mid=" + this.b + ", end=" + this.c + ')';
    }
}
