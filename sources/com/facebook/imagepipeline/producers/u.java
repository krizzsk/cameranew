package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.Nullable;
/* compiled from: EncodedProbeProducer.java */
/* loaded from: classes.dex */
public class u implements n0<com.facebook.imagepipeline.image.e> {
    private final com.facebook.imagepipeline.cache.e a;
    private final com.facebook.imagepipeline.cache.e b;
    private final com.facebook.imagepipeline.cache.f c;

    /* renamed from: d  reason: collision with root package name */
    private final n0<com.facebook.imagepipeline.image.e> f2982d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2983e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2984f;

    /* compiled from: EncodedProbeProducer.java */
    /* loaded from: classes.dex */
    private static class a extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2985d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2986e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.f f2987f;

        /* renamed from: g  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2988g;

        /* renamed from: h  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2989h;

        public a(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar2) {
            super(lVar);
            this.c = o0Var;
            this.f2985d = eVar;
            this.f2986e = eVar2;
            this.f2987f = fVar;
            this.f2988g = dVar;
            this.f2989h = dVar2;
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            boolean d2;
            try {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.a("EncodedProbeProducer#onNewResultImpl");
                }
                if (!b.e(i2) && eVar != null && !b.l(i2, 10) && eVar.A() != com.facebook.imageformat.c.b) {
                    ImageRequest j2 = this.c.j();
                    com.facebook.cache.common.b d3 = this.f2987f.d(j2, this.c.a());
                    this.f2988g.a(d3);
                    if ("memory_encoded".equals(this.c.n(FirebaseAnalytics.Param.ORIGIN))) {
                        if (!this.f2989h.b(d3)) {
                            (j2.d() == ImageRequest.CacheChoice.SMALL ? this.f2986e : this.f2985d).h(d3);
                            this.f2989h.a(d3);
                        }
                    } else if ("disk".equals(this.c.n(FirebaseAnalytics.Param.ORIGIN))) {
                        this.f2989h.a(d3);
                    }
                    o().c(eVar, i2);
                    if (d2) {
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

    public u(com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, com.facebook.imagepipeline.cache.d dVar, com.facebook.imagepipeline.cache.d dVar2, n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = eVar;
        this.b = eVar2;
        this.c = fVar;
        this.f2983e = dVar;
        this.f2984f = dVar2;
        this.f2982d = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("EncodedProbeProducer#produceResults");
            }
            q0 h2 = o0Var.h();
            h2.d(o0Var, c());
            a aVar = new a(lVar, o0Var, this.a, this.b, this.c, this.f2983e, this.f2984f);
            h2.j(o0Var, "EncodedProbeProducer", null);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("mInputProducer.produceResult");
            }
            this.f2982d.b(aVar, o0Var);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    protected String c() {
        return "EncodedProbeProducer";
    }
}
