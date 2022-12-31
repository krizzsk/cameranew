package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public class StagingArea {
    private static final Class<?> b = StagingArea.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.image.e> a = new HashMap();

    private StagingArea() {
    }

    private synchronized void c() {
        com.facebook.common.logging.a.p(b, "Count = %d", Integer.valueOf(this.a.size()));
    }

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    public synchronized boolean a(com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.h.g(bVar);
        if (this.a.containsKey(bVar)) {
            com.facebook.imagepipeline.image.e eVar = this.a.get(bVar);
            synchronized (eVar) {
                if (com.facebook.imagepipeline.image.e.Z(eVar)) {
                    return true;
                }
                this.a.remove(bVar);
                com.facebook.common.logging.a.x(b, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.a(), Integer.valueOf(System.identityHashCode(bVar)));
                return false;
            }
        }
        return false;
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.image.e b(com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.h.g(bVar);
        com.facebook.imagepipeline.image.e eVar = this.a.get(bVar);
        if (eVar != null) {
            synchronized (eVar) {
                if (!com.facebook.imagepipeline.image.e.Z(eVar)) {
                    this.a.remove(bVar);
                    com.facebook.common.logging.a.x(b, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.a(), Integer.valueOf(System.identityHashCode(bVar)));
                    return null;
                }
                eVar = com.facebook.imagepipeline.image.e.e(eVar);
            }
        }
        return eVar;
    }

    public synchronized void d(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
        com.facebook.common.internal.h.g(bVar);
        com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.imagepipeline.image.e.Z(eVar)));
        com.facebook.imagepipeline.image.e.h(this.a.put(bVar, com.facebook.imagepipeline.image.e.e(eVar)));
        c();
    }

    public boolean e(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.image.e remove;
        com.facebook.common.internal.h.g(bVar);
        synchronized (this) {
            remove = this.a.remove(bVar);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.Y();
        } finally {
            remove.close();
        }
    }

    public synchronized boolean f(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
        com.facebook.common.internal.h.g(bVar);
        com.facebook.common.internal.h.g(eVar);
        com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.imagepipeline.image.e.Z(eVar)));
        com.facebook.imagepipeline.image.e eVar2 = this.a.get(bVar);
        if (eVar2 == null) {
            return false;
        }
        com.facebook.common.references.a<PooledByteBuffer> t = eVar2.t();
        com.facebook.common.references.a<PooledByteBuffer> t2 = eVar.t();
        if (t != null && t2 != null && t.A() == t2.A()) {
            this.a.remove(bVar);
            com.facebook.common.references.a.y(t2);
            com.facebook.common.references.a.y(t);
            com.facebook.imagepipeline.image.e.h(eVar2);
            c();
            return true;
        }
        com.facebook.common.references.a.y(t2);
        com.facebook.common.references.a.y(t);
        com.facebook.imagepipeline.image.e.h(eVar2);
        return false;
    }
}
