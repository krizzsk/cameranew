package com.pinguo.album.j;
/* compiled from: Pools.java */
/* loaded from: classes3.dex */
public class f<T> extends e<T> {
    private final Object c;

    public f(int i2) {
        super(i2);
        this.c = new Object();
    }

    @Override // com.pinguo.album.j.e, com.pinguo.album.j.d
    public T acquire() {
        T t;
        synchronized (this.c) {
            t = (T) super.acquire();
        }
        return t;
    }

    @Override // com.pinguo.album.j.e, com.pinguo.album.j.d
    public boolean release(T t) {
        boolean release;
        synchronized (this.c) {
            release = super.release(t);
        }
        return release;
    }
}
