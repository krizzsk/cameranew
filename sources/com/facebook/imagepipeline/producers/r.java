package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: DiskCacheWriteProducer.java */
/* loaded from: classes.dex */
public class r implements n0<com.facebook.imagepipeline.image.e> {
    private final com.facebook.imagepipeline.cache.e a;
    private final com.facebook.imagepipeline.cache.e b;
    private final com.facebook.imagepipeline.cache.f c;

    /* renamed from: d  reason: collision with root package name */
    private final n0<com.facebook.imagepipeline.image.e> f2967d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteProducer.java */
    /* loaded from: classes.dex */
    public static class b extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2968d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2969e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.f f2970f;

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            this.c.h().d(this.c, "DiskCacheWriteProducer");
            if (!com.facebook.imagepipeline.producers.b.e(i2) && eVar != null && !com.facebook.imagepipeline.producers.b.l(i2, 10) && eVar.A() != com.facebook.imageformat.c.b) {
                ImageRequest j2 = this.c.j();
                com.facebook.cache.common.b d2 = this.f2970f.d(j2, this.c.a());
                if (j2.d() == ImageRequest.CacheChoice.SMALL) {
                    this.f2969e.m(d2, eVar);
                } else {
                    this.f2968d.m(d2, eVar);
                }
                this.c.h().j(this.c, "DiskCacheWriteProducer", null);
                o().c(eVar, i2);
                return;
            }
            this.c.h().j(this.c, "DiskCacheWriteProducer", null);
            o().c(eVar, i2);
        }

        private b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar) {
            super(lVar);
            this.c = o0Var;
            this.f2968d = eVar;
            this.f2969e = eVar2;
            this.f2970f = fVar;
        }
    }

    public r(com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = eVar;
        this.b = eVar2;
        this.c = fVar;
        this.f2967d = n0Var;
    }

    private void c(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        if (o0Var.o().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            o0Var.e("disk", "nil-result_write");
            lVar.c(null, 1);
            return;
        }
        if (o0Var.j().v()) {
            lVar = new b(lVar, o0Var, this.a, this.b, this.c);
        }
        this.f2967d.b(lVar, o0Var);
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        c(lVar, o0Var);
    }
}
