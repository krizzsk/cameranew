package com.facebook.imagepipeline.cache;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class NoOpImageCacheStatsTracker implements n {
    @Nullable
    private static NoOpImageCacheStatsTracker a;

    private NoOpImageCacheStatsTracker() {
    }

    public static synchronized NoOpImageCacheStatsTracker getInstance() {
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        synchronized (NoOpImageCacheStatsTracker.class) {
            if (a == null) {
                a = new NoOpImageCacheStatsTracker();
            }
            noOpImageCacheStatsTracker = a;
        }
        return noOpImageCacheStatsTracker;
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void a(r<?, ?> rVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void b(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void c(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void d(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void e(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void f(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void g(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void h(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void i(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void j(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void k(r<?, ?> rVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void l(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void m(com.facebook.cache.common.b bVar) {
    }

    @Override // com.facebook.imagepipeline.cache.n
    public void n(com.facebook.cache.common.b bVar) {
    }
}
