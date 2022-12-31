package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nullable;
/* compiled from: OOMSoftReference.java */
/* loaded from: classes.dex */
public class f<T> {
    @Nullable
    SoftReference<T> a = null;
    @Nullable
    SoftReference<T> b = null;
    @Nullable
    SoftReference<T> c = null;

    public void a() {
        SoftReference<T> softReference = this.a;
        if (softReference != null) {
            softReference.clear();
            this.a = null;
        }
        SoftReference<T> softReference2 = this.b;
        if (softReference2 != null) {
            softReference2.clear();
            this.b = null;
        }
        SoftReference<T> softReference3 = this.c;
        if (softReference3 != null) {
            softReference3.clear();
            this.c = null;
        }
    }

    @Nullable
    public T b() {
        SoftReference<T> softReference = this.a;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void c(T t) {
        this.a = new SoftReference<>(t);
        this.b = new SoftReference<>(t);
        this.c = new SoftReference<>(t);
    }
}
