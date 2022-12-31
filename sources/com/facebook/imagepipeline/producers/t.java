package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: EncodedMemoryCacheProducer.java */
/* loaded from: classes.dex */
public class t implements n0<com.facebook.imagepipeline.image.e> {
    private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> a;
    private final com.facebook.imagepipeline.cache.f b;
    private final n0<com.facebook.imagepipeline.image.e> c;

    /* compiled from: EncodedMemoryCacheProducer.java */
    /* loaded from: classes.dex */
    private static class a extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.cache.common.b f2972d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2973e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f2974f;

        public a(l<com.facebook.imagepipeline.image.e> lVar, com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> rVar, com.facebook.cache.common.b bVar, boolean z, boolean z2) {
            super(lVar);
            this.c = rVar;
            this.f2972d = bVar;
            this.f2973e = z;
            this.f2974f = z2;
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            boolean d2;
            try {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.a("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!b.e(i2) && eVar != null && !b.l(i2, 10) && eVar.A() != com.facebook.imageformat.c.b) {
                    com.facebook.common.references.a<PooledByteBuffer> t = eVar.t();
                    if (t != null) {
                        com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                        if (this.f2974f && this.f2973e) {
                            aVar = this.c.b(this.f2972d, t);
                        }
                        com.facebook.common.references.a.y(t);
                        if (aVar != null) {
                            com.facebook.imagepipeline.image.e eVar2 = new com.facebook.imagepipeline.image.e(aVar);
                            eVar2.i(eVar);
                            com.facebook.common.references.a.y(aVar);
                            o().b(1.0f);
                            o().c(eVar2, i2);
                            com.facebook.imagepipeline.image.e.h(eVar2);
                            if (d2) {
                                return;
                            }
                            return;
                        }
                    }
                    o().c(eVar, i2);
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                        return;
                    }
                    return;
                }
                o().c(eVar, i2);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            } finally {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            }
        }
    }

    public t(com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> rVar, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = rVar;
        this.b = fVar;
        this.c = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("EncodedMemoryCacheProducer#produceResults");
            }
            q0 h2 = o0Var.h();
            h2.d(o0Var, "EncodedMemoryCacheProducer");
            com.facebook.cache.common.b d2 = this.b.d(o0Var.j(), o0Var.a());
            com.facebook.common.references.a<PooledByteBuffer> aVar = this.a.get(d2);
            if (aVar != null) {
                com.facebook.imagepipeline.image.e eVar = new com.facebook.imagepipeline.image.e(aVar);
                h2.j(o0Var, "EncodedMemoryCacheProducer", h2.f(o0Var, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "true") : null);
                h2.b(o0Var, "EncodedMemoryCacheProducer", true);
                o0Var.g("memory_encoded");
                lVar.b(1.0f);
                lVar.c(eVar, 1);
                com.facebook.imagepipeline.image.e.h(eVar);
                com.facebook.common.references.a.y(aVar);
            } else if (o0Var.o().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                h2.j(o0Var, "EncodedMemoryCacheProducer", h2.f(o0Var, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                h2.b(o0Var, "EncodedMemoryCacheProducer", false);
                o0Var.e("memory_encoded", "nil-result");
                lVar.c(null, 1);
                com.facebook.common.references.a.y(aVar);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            } else {
                a aVar2 = new a(lVar, this.a, d2, o0Var.j().w(), o0Var.d().D().q());
                h2.j(o0Var, "EncodedMemoryCacheProducer", h2.f(o0Var, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                this.c.b(aVar2, o0Var);
                com.facebook.common.references.a.y(aVar);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }
}
