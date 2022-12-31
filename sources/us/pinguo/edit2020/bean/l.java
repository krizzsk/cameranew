package us.pinguo.edit2020.bean;
/* compiled from: BokehTextureInfo.kt */
/* loaded from: classes4.dex */
public final class l {
    private volatile int a;
    private volatile int b;
    private volatile int c;

    public l() {
        this(0, 0, 0, 7, null);
    }

    public l(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final void d(int i2) {
        this.c = i2;
    }

    public final void e(int i2) {
        this.a = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.a == lVar.a && this.b == lVar.b && this.c == lVar.c;
        }
        return false;
    }

    public final void f(int i2) {
        this.b = i2;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "BokehTextureInfo(textureId=" + this.a + ", width=" + this.b + ", height=" + this.c + ')';
    }

    public /* synthetic */ l(int i2, int i3, int i4, int i5, kotlin.jvm.internal.o oVar) {
        this((i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 0 : i4);
    }
}
