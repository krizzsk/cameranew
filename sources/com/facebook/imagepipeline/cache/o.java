package com.facebook.imagepipeline.cache;

import javax.annotation.Nullable;
/* compiled from: InstrumentedMemoryCache.java */
/* loaded from: classes.dex */
public class o<K, V> implements r<K, V> {
    private final r<K, V> a;
    private final t b;

    public o(r<K, V> rVar, t tVar) {
        this.a = rVar;
        this.b = tVar;
    }

    @Override // com.facebook.imagepipeline.cache.r
    public void a(K k2) {
        this.a.a(k2);
    }

    @Override // com.facebook.imagepipeline.cache.r
    @Nullable
    public com.facebook.common.references.a<V> b(K k2, com.facebook.common.references.a<V> aVar) {
        this.b.c(k2);
        return this.a.b(k2, aVar);
    }

    @Override // com.facebook.imagepipeline.cache.r
    public int d(com.facebook.common.internal.i<K> iVar) {
        return this.a.d(iVar);
    }

    @Override // com.facebook.imagepipeline.cache.r
    @Nullable
    public com.facebook.common.references.a<V> get(K k2) {
        com.facebook.common.references.a<V> aVar = this.a.get(k2);
        if (aVar == null) {
            this.b.b(k2);
        } else {
            this.b.a(k2);
        }
        return aVar;
    }
}
