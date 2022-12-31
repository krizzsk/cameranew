package com.bumptech.glide.l;
/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class g {
    private Class<?> a;
    private Class<?> b;

    public g() {
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.a) && this.b.equals(gVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }
}
