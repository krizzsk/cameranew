package com.bumptech.glide.load.h;

import com.bumptech.glide.load.engine.i;
import java.util.Objects;
/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class c<T> implements i<T> {
    protected final T a;

    public c(T t) {
        Objects.requireNonNull(t, "Data must not be null");
        this.a = t;
    }

    @Override // com.bumptech.glide.load.engine.i
    public final T get() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.i
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
    }
}
