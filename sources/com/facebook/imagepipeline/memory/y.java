package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: OOMSoftReferenceBucket.java */
@NotThreadSafe
/* loaded from: classes.dex */
class y<V> extends f<V> {

    /* renamed from: f  reason: collision with root package name */
    private LinkedList<com.facebook.common.references.f<V>> f2861f;

    public y(int i2, int i3, int i4) {
        super(i2, i3, i4, false);
        this.f2861f = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.f
    void a(V v) {
        com.facebook.common.references.f<V> poll = this.f2861f.poll();
        if (poll == null) {
            poll = new com.facebook.common.references.f<>();
        }
        poll.c(v);
        this.c.add(poll);
    }

    @Override // com.facebook.imagepipeline.memory.f
    @Nullable
    public V g() {
        com.facebook.common.references.f<V> fVar = (com.facebook.common.references.f) this.c.poll();
        com.facebook.common.internal.h.g(fVar);
        V b = fVar.b();
        fVar.a();
        this.f2861f.add(fVar);
        return b;
    }
}
