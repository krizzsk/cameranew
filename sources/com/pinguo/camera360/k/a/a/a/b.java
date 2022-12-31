package com.pinguo.camera360.k.a.a.a;
/* compiled from: SizeInfo.java */
@Deprecated
/* loaded from: classes3.dex */
public class b implements Cloneable {
    protected int a;
    protected int b;

    public b(int i2, int i3) {
        this.a = 0;
        this.b = 0;
        this.a = i2;
        this.b = i3;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
