package us.pinguo.common.filter.guide;
/* compiled from: GuideUtil.kt */
/* loaded from: classes4.dex */
public final class f {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9875d;

    public f(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f9875d = i5;
    }

    public final int a() {
        return this.f9875d;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.a == fVar.a && this.b == fVar.b && this.c == fVar.c && this.f9875d == fVar.f9875d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.f9875d;
    }

    public String toString() {
        return "RelativePadding(start=" + this.a + ", top=" + this.b + ", end=" + this.c + ", bottom=" + this.f9875d + ')';
    }
}
