package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: LruBucketsPoolBackend.java */
/* loaded from: classes.dex */
public abstract class s<T> implements z<T> {
    private final Set<T> a = new HashSet();
    private final g<T> b = new g<>();

    @Nullable
    private T b(@Nullable T t) {
        if (t != null) {
            synchronized (this) {
                this.a.remove(t);
            }
        }
        return t;
    }

    @Override // com.facebook.imagepipeline.memory.z
    @Nullable
    public T get(int i2) {
        T a = this.b.a(i2);
        b(a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.z
    @Nullable
    public T pop() {
        T f2 = this.b.f();
        b(f2);
        return f2;
    }

    @Override // com.facebook.imagepipeline.memory.z
    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.a.add(t);
        }
        if (add) {
            this.b.e(a(t), t);
        }
    }
}
