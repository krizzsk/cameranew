package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* compiled from: DiskStorageCacheFactory.java */
/* loaded from: classes.dex */
public class c implements g {
    private d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public static com.facebook.cache.disk.d b(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return c(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d c(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.h(), new d.c(bVar.k(), bVar.j(), bVar.f()), bVar.e(), bVar.d(), bVar.g(), executor, bVar.i());
    }

    @Override // com.facebook.imagepipeline.core.g
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return b(bVar, this.a.a(bVar));
    }
}
