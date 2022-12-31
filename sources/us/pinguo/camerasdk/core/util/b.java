package us.pinguo.camerasdk.core.util;
/* compiled from: PGSize.java */
/* loaded from: classes4.dex */
public final class b implements Comparable<b> {
    private final int a;
    private final int b;

    public b(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        return Long.signum((c() * b()) - (bVar.c() * bVar.b()));
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.b;
        int i3 = this.a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
