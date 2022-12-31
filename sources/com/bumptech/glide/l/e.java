package com.bumptech.glide.l;

import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<T, Y> {
    private int b;
    private final LinkedHashMap<T, Y> a = new LinkedHashMap<>(100, 0.75f, true);
    private int c = 0;

    public e(int i2) {
        this.b = i2;
    }

    private void f() {
        m(this.b);
    }

    public void c() {
        m(0);
    }

    public Y g(T t) {
        return this.a.get(t);
    }

    public int h() {
        return this.c;
    }

    protected int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y) {
    }

    public Y k(T t, Y y) {
        if (i(y) >= this.b) {
            j(t, y);
            return null;
        }
        Y put = this.a.put(t, y);
        if (y != null) {
            this.c += i(y);
        }
        if (put != null) {
            this.c -= i(put);
        }
        f();
        return put;
    }

    public Y l(T t) {
        Y remove = this.a.remove(t);
        if (remove != null) {
            this.c -= i(remove);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i2) {
        while (this.c > i2) {
            Map.Entry<T, Y> next = this.a.entrySet().iterator().next();
            Y value = next.getValue();
            this.c -= i(value);
            T key = next.getKey();
            this.a.remove(key);
            j(key, value);
        }
    }
}
