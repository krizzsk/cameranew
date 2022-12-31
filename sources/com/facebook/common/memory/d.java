package com.facebook.common.memory;
/* compiled from: Pool.java */
/* loaded from: classes.dex */
public interface d<V> extends com.facebook.common.references.h<V>, b {
    V get(int i2);

    @Override // com.facebook.common.references.h
    void release(V v);
}
