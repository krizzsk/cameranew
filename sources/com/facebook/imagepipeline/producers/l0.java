package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* loaded from: classes.dex */
public class l0 implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> a;
    private final com.facebook.imagepipeline.cache.f b;
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    /* loaded from: classes.dex */
    public static class a extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        private final com.facebook.cache.common.b c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2936d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> f2937e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f2938f;

        public a(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, boolean z2) {
            super(lVar);
            this.c = bVar;
            this.f2936d = z;
            this.f2937e = rVar;
            this.f2938f = z2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            if (aVar == null) {
                if (b.d(i2)) {
                    o().c(null, i2);
                }
            } else if (!b.e(i2) || this.f2936d) {
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> b = this.f2938f ? this.f2937e.b(this.c, aVar) : null;
                try {
                    o().b(1.0f);
                    l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> o = o();
                    if (b != null) {
                        aVar = b;
                    }
                    o.c(aVar, i2);
                } finally {
                    com.facebook.common.references.a.y(b);
                }
            }
        }
    }

    public l0(com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        this.a = rVar;
        this.b = fVar;
        this.c = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        q0 h2 = o0Var.h();
        ImageRequest j2 = o0Var.j();
        Object a2 = o0Var.a();
        com.facebook.imagepipeline.request.a i2 = j2.i();
        if (i2 != null && i2.a() != null) {
            h2.d(o0Var, c());
            com.facebook.cache.common.b c = this.b.c(j2, a2);
            com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = this.a.get(c);
            if (aVar != null) {
                h2.j(o0Var, c(), h2.f(o0Var, c()) ? ImmutableMap.of("cached_value_found", "true") : null);
                h2.b(o0Var, "PostprocessedBitmapMemoryCacheProducer", true);
                o0Var.e("memory_bitmap", "postprocessed");
                lVar.b(1.0f);
                lVar.c(aVar, 1);
                aVar.close();
                return;
            }
            a aVar2 = new a(lVar, c, i2 instanceof com.facebook.imagepipeline.request.b, this.a, o0Var.j().w());
            h2.j(o0Var, c(), h2.f(o0Var, c()) ? ImmutableMap.of("cached_value_found", "false") : null);
            this.c.b(aVar2, o0Var);
            return;
        }
        this.c.b(lVar, o0Var);
    }

    protected String c() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
