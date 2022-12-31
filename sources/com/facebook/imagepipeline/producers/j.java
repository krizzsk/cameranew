package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.Nullable;
/* compiled from: BitmapProbeProducer.java */
/* loaded from: classes.dex */
public class j implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> a;
    private final com.facebook.imagepipeline.cache.e b;
    private final com.facebook.imagepipeline.cache.e c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.f f2917d;

    /* renamed from: e  reason: collision with root package name */
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> f2918e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2919f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2920g;

    /* compiled from: BitmapProbeProducer.java */
    /* loaded from: classes.dex */
    private static class a extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> f2921d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2922e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.e f2923f;

        /* renamed from: g  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.f f2924g;

        /* renamed from: h  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2925h;

        /* renamed from: i  reason: collision with root package name */
        private final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> f2926i;

        public a(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var, com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> rVar, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar2) {
            super(lVar);
            this.c = o0Var;
            this.f2921d = rVar;
            this.f2922e = eVar;
            this.f2923f = eVar2;
            this.f2924g = fVar;
            this.f2925h = dVar;
            this.f2926i = dVar2;
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            boolean d2;
            try {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.a("BitmapProbeProducer#onNewResultImpl");
                }
                if (!b.e(i2) && aVar != null && !b.l(i2, 8)) {
                    ImageRequest j2 = this.c.j();
                    com.facebook.cache.common.b d3 = this.f2924g.d(j2, this.c.a());
                    String str = (String) this.c.n(FirebaseAnalytics.Param.ORIGIN);
                    if (str != null && str.equals("memory_bitmap")) {
                        if (this.c.d().D().r() && !this.f2925h.b(d3)) {
                            this.f2921d.a(d3);
                            this.f2925h.a(d3);
                        }
                        if (this.c.d().D().p() && !this.f2926i.b(d3)) {
                            (j2.d() == ImageRequest.CacheChoice.SMALL ? this.f2923f : this.f2922e).h(d3);
                            this.f2926i.a(d3);
                        }
                    }
                    o().c(aVar, i2);
                    if (d2) {
                        return;
                    }
                    return;
                }
                o().c(aVar, i2);
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

    public j(com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, PooledByteBuffer> rVar, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar, com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> dVar2, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        this.a = rVar;
        this.b = eVar;
        this.c = eVar2;
        this.f2917d = fVar;
        this.f2919f = dVar;
        this.f2920g = dVar2;
        this.f2918e = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("BitmapProbeProducer#produceResults");
            }
            q0 h2 = o0Var.h();
            h2.d(o0Var, c());
            a aVar = new a(lVar, o0Var, this.a, this.b, this.c, this.f2917d, this.f2919f, this.f2920g);
            h2.j(o0Var, "BitmapProbeProducer", null);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("mInputProducer.produceResult");
            }
            this.f2918e.b(aVar, o0Var);
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
        return "BitmapProbeProducer";
    }
}
