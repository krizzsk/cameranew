package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.PooledByteBuffer;
/* compiled from: EncodedMemoryCacheFactory.java */
/* loaded from: classes.dex */
public class m {

    /* compiled from: EncodedMemoryCacheFactory.java */
    /* loaded from: classes.dex */
    static class a implements t<com.facebook.cache.common.b> {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: d */
        public void a(com.facebook.cache.common.b bVar) {
            this.a.j(bVar);
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: e */
        public void b(com.facebook.cache.common.b bVar) {
            this.a.g(bVar);
        }

        @Override // com.facebook.imagepipeline.cache.t
        /* renamed from: f */
        public void c(com.facebook.cache.common.b bVar) {
            this.a.e(bVar);
        }
    }

    public static o<com.facebook.cache.common.b, PooledByteBuffer> a(r<com.facebook.cache.common.b, PooledByteBuffer> rVar, n nVar) {
        nVar.a(rVar);
        return new o<>(rVar, new a(nVar));
    }
}
