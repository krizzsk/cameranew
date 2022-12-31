package com.facebook.s.a.b.d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.facebook.imagepipeline.image.h;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: FrescoFrameCache.java */
/* loaded from: classes.dex */
public class b implements com.facebook.s.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    private static final Class<?> f3171e = b.class;
    private final com.facebook.imagepipeline.animated.impl.c a;
    private final boolean b;
    @GuardedBy("this")
    private final SparseArray<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c = new SparseArray<>();
    @GuardedBy("this")
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.common.references.a<com.facebook.imagepipeline.image.c> f3172d;

    public b(com.facebook.imagepipeline.animated.impl.c cVar, boolean z) {
        this.a = cVar;
        this.b = z;
    }

    @Nullable
    @VisibleForTesting
    static com.facebook.common.references.a<Bitmap> g(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        com.facebook.imagepipeline.image.d dVar;
        try {
            if (com.facebook.common.references.a.Q(aVar) && (aVar.A() instanceof com.facebook.imagepipeline.image.d) && (dVar = (com.facebook.imagepipeline.image.d) aVar.A()) != null) {
                return dVar.z();
            }
            return null;
        } finally {
            com.facebook.common.references.a.y(aVar);
        }
    }

    @Nullable
    private static com.facebook.common.references.a<com.facebook.imagepipeline.image.c> h(com.facebook.common.references.a<Bitmap> aVar) {
        return com.facebook.common.references.a.R(new com.facebook.imagepipeline.image.d(aVar, h.f2818d, 0));
    }

    private synchronized void i(int i2) {
        com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = this.c.get(i2);
        if (aVar != null) {
            this.c.delete(i2);
            com.facebook.common.references.a.y(aVar);
            com.facebook.common.logging.a.q(f3171e, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i2), this.c);
        }
    }

    @Override // com.facebook.s.a.b.b
    public synchronized void a(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3) {
        com.facebook.common.internal.h.g(aVar);
        com.facebook.common.references.a<com.facebook.imagepipeline.image.c> h2 = h(aVar);
        if (h2 == null) {
            com.facebook.common.references.a.y(h2);
            return;
        }
        com.facebook.common.references.a<com.facebook.imagepipeline.image.c> a = this.a.a(i2, h2);
        if (com.facebook.common.references.a.Q(a)) {
            com.facebook.common.references.a.y(this.c.get(i2));
            this.c.put(i2, a);
            com.facebook.common.logging.a.q(f3171e, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i2), this.c);
        }
        com.facebook.common.references.a.y(h2);
    }

    @Override // com.facebook.s.a.b.b
    public synchronized void b(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3) {
        com.facebook.common.internal.h.g(aVar);
        i(i2);
        com.facebook.common.references.a<com.facebook.imagepipeline.image.c> h2 = h(aVar);
        if (h2 != null) {
            com.facebook.common.references.a.y(this.f3172d);
            this.f3172d = this.a.a(i2, h2);
        }
        com.facebook.common.references.a.y(h2);
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> c(int i2) {
        return g(com.facebook.common.references.a.w(this.f3172d));
    }

    @Override // com.facebook.s.a.b.b
    public synchronized void clear() {
        com.facebook.common.references.a.y(this.f3172d);
        this.f3172d = null;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            com.facebook.common.references.a.y(this.c.valueAt(i2));
        }
        this.c.clear();
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> d(int i2, int i3, int i4) {
        if (this.b) {
            return g(this.a.d());
        }
        return null;
    }

    @Override // com.facebook.s.a.b.b
    public synchronized boolean e(int i2) {
        return this.a.b(i2);
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> f(int i2) {
        return g(this.a.c(i2));
    }
}
