package com.facebook.imagepipeline.cache;

import javax.annotation.Nullable;
/* compiled from: MemoryCache.java */
/* loaded from: classes.dex */
public interface r<K, V> extends com.facebook.common.memory.b {

    /* compiled from: MemoryCache.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    void a(K k2);

    @Nullable
    com.facebook.common.references.a<V> b(K k2, com.facebook.common.references.a<V> aVar);

    boolean contains(K k2);

    int d(com.facebook.common.internal.i<K> iVar);

    @Nullable
    com.facebook.common.references.a<V> get(K k2);
}
