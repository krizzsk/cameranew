package com.facebook.imagepipeline.cache;

import androidx.annotation.VisibleForTesting;
import javax.annotation.Nullable;
/* compiled from: CountingMemoryCache.java */
/* loaded from: classes.dex */
public interface i<K, V> extends r<K, V>, com.facebook.common.memory.b {

    /* compiled from: CountingMemoryCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a<K, V> {
        public final K a;
        public final com.facebook.common.references.a<V> b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2691d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final b<K> f2692e;

        private a(K k2, com.facebook.common.references.a<V> aVar, @Nullable b<K> bVar) {
            com.facebook.common.internal.h.g(k2);
            this.a = k2;
            com.facebook.common.references.a<V> w = com.facebook.common.references.a.w(aVar);
            com.facebook.common.internal.h.g(w);
            this.b = w;
            this.c = 0;
            this.f2691d = false;
            this.f2692e = bVar;
        }

        @VisibleForTesting
        public static <K, V> a<K, V> a(K k2, com.facebook.common.references.a<V> aVar, @Nullable b<K> bVar) {
            return new a<>(k2, aVar, bVar);
        }
    }

    /* compiled from: CountingMemoryCache.java */
    /* loaded from: classes.dex */
    public interface b<K> {
        void a(K k2, boolean z);
    }

    @Nullable
    com.facebook.common.references.a<V> c(K k2, com.facebook.common.references.a<V> aVar, b<K> bVar);

    @Nullable
    com.facebook.common.references.a<V> e(K k2);
}
