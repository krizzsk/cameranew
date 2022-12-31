package us.pinguo.edit2020.model;
/* compiled from: EditRender.kt */
/* loaded from: classes4.dex */
public final class d {
    private final int a;
    private final int b;
    private final int c;

    public d(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "SpotDetectRet(width=" + this.a + ", height=" + this.b + ", tid=" + this.c + ')';
    }
}
