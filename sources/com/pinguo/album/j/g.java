package com.pinguo.album.j;
/* compiled from: RangeArray.java */
/* loaded from: classes3.dex */
public class g<T> {
    private T[] a;
    private int b;

    public g(int i2, int i3) {
        this.a = (T[]) new Object[(i3 - i2) + 1];
        this.b = i2;
    }

    public T a(int i2) {
        return this.a[i2 - this.b];
    }

    public void b(int i2, T t) {
        this.a[i2 - this.b] = t;
    }
}
