package com.pinguo.album.j;
/* compiled from: Pools.java */
/* loaded from: classes3.dex */
public class e<T> implements d<T> {
    private final Object[] a;
    private int b;

    public e(int i2) {
        if (i2 > 0) {
            this.a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean a(T t) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // com.pinguo.album.j.d
    public T acquire() {
        int i2 = this.b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = this.a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.b = i2 - 1;
            return t;
        }
        return null;
    }

    @Override // com.pinguo.album.j.d
    public boolean release(T t) {
        if (!a(t)) {
            int i2 = this.b;
            Object[] objArr = this.a;
            if (i2 < objArr.length) {
                objArr[i2] = t;
                this.b = i2 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
