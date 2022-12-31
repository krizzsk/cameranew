package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.cache.i;
import com.facebook.imagepipeline.cache.r;
import javax.annotation.Nullable;
/* compiled from: CountingLruBitmapMemoryCacheFactory.java */
/* loaded from: classes.dex */
public class g implements com.facebook.imagepipeline.cache.a {

    /* compiled from: CountingLruBitmapMemoryCacheFactory.java */
    /* loaded from: classes.dex */
    class a implements v<com.facebook.imagepipeline.image.c> {
        a(g gVar) {
        }

        @Override // com.facebook.imagepipeline.cache.v
        /* renamed from: b */
        public int a(com.facebook.imagepipeline.image.c cVar) {
            return cVar.t();
        }
    }

    @Override // com.facebook.imagepipeline.cache.a
    public i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> a(com.facebook.common.internal.k<s> kVar, com.facebook.common.memory.c cVar, r.a aVar, @Nullable i.b<com.facebook.cache.common.b> bVar) {
        q qVar = new q(new a(this), aVar, kVar, bVar);
        cVar.a(qVar);
        return qVar;
    }
}
