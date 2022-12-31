package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;
/* compiled from: PoolBackend.java */
/* loaded from: classes.dex */
interface z<T> {
    int a(T t);

    @Nullable
    T get(int i2);

    @Nullable
    T pop();

    void put(T t);
}
