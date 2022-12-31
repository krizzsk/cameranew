package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.cache.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: AnimatedFrameCache.java */
/* loaded from: classes.dex */
public class c {
    private final com.facebook.cache.common.b a;
    private final i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> b;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<com.facebook.cache.common.b> f2676d = new LinkedHashSet<>();
    private final i.b<com.facebook.cache.common.b> c = new a();

    /* compiled from: AnimatedFrameCache.java */
    /* loaded from: classes.dex */
    class a implements i.b<com.facebook.cache.common.b> {
        a() {
        }

        @Override // com.facebook.imagepipeline.cache.i.b
        /* renamed from: b */
        public void a(com.facebook.cache.common.b bVar, boolean z) {
            c.this.f(bVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedFrameCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b implements com.facebook.cache.common.b {
        private final com.facebook.cache.common.b a;
        private final int b;

        public b(com.facebook.cache.common.b bVar, int i2) {
            this.a = bVar;
            this.b = i2;
        }

        @Override // com.facebook.cache.common.b
        @Nullable
        public String a() {
            return null;
        }

        @Override // com.facebook.cache.common.b
        public boolean b(Uri uri) {
            return this.a.b(uri);
        }

        @Override // com.facebook.cache.common.b
        public boolean c() {
            return false;
        }

        @Override // com.facebook.cache.common.b
        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && this.a.equals(bVar.a);
            }
            return false;
        }

        @Override // com.facebook.cache.common.b
        public int hashCode() {
            return (this.a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.b;
        }

        public String toString() {
            g.b c = g.c(this);
            c.b("imageCacheKey", this.a);
            c.a("frameIndex", this.b);
            return c.toString();
        }
    }

    public c(com.facebook.cache.common.b bVar, i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> iVar) {
        this.a = bVar;
        this.b = iVar;
    }

    private b e(int i2) {
        return new b(this.a, i2);
    }

    @Nullable
    private synchronized com.facebook.cache.common.b g() {
        com.facebook.cache.common.b bVar;
        bVar = null;
        Iterator<com.facebook.cache.common.b> it = this.f2676d.iterator();
        if (it.hasNext()) {
            bVar = it.next();
            it.remove();
        }
        return bVar;
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> a(int i2, com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        return this.b.c(e(i2), aVar, this.c);
    }

    public boolean b(int i2) {
        return this.b.contains(e(i2));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> c(int i2) {
        return this.b.get(e(i2));
    }

    @Nullable
    public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> d() {
        com.facebook.common.references.a<com.facebook.imagepipeline.image.c> e2;
        do {
            com.facebook.cache.common.b g2 = g();
            if (g2 == null) {
                return null;
            }
            e2 = this.b.e(g2);
        } while (e2 == null);
        return e2;
    }

    public synchronized void f(com.facebook.cache.common.b bVar, boolean z) {
        if (z) {
            this.f2676d.add(bVar);
        } else {
            this.f2676d.remove(bVar);
        }
    }
}
