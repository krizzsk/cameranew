package com.facebook.imagepipeline.cache;
/* compiled from: InstrumentedMemoryCacheBitmapMemoryCacheFactory.java */
/* loaded from: classes.dex */
public class p {

    /* compiled from: InstrumentedMemoryCacheBitmapMemoryCacheFactory.java */
    /* loaded from: classes.dex */
    static class a implements t<com.facebook.cache.common.b> {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: d */
        public void a(com.facebook.cache.common.b bVar) {
            this.a.h(bVar);
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: e */
        public void b(com.facebook.cache.common.b bVar) {
            this.a.b(bVar);
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: f */
        public void c(com.facebook.cache.common.b bVar) {
            this.a.m(bVar);
        }
    }

    public static o<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> a(r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, n nVar) {
        nVar.k(rVar);
        return new o<>(rVar, new a(nVar));
    }
}
