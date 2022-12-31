package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: BitmapMemoryCacheProducer.java */
/* loaded from: classes.dex */
public class h implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> a;
    private final com.facebook.imagepipeline.cache.f b;
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapMemoryCacheProducer.java */
    /* loaded from: classes.dex */
    public class a extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        final /* synthetic */ com.facebook.cache.common.b c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f2906d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, com.facebook.cache.common.b bVar, boolean z) {
            super(lVar);
            this.c = bVar;
            this.f2906d = z;
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar2;
            boolean d2;
            try {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.a("BitmapMemoryCacheProducer#onNewResultImpl");
                }
                boolean d3 = b.d(i2);
                if (aVar == null) {
                    if (d3) {
                        o().c(null, i2);
                    }
                    if (d2) {
                        return;
                    }
                    return;
                }
                if (!aVar.A().v() && !b.m(i2, 8)) {
                    if (!d3 && (aVar2 = h.this.a.get(this.c)) != null) {
                        com.facebook.imagepipeline.image.i d4 = aVar.A().d();
                        com.facebook.imagepipeline.image.i d5 = aVar2.A().d();
                        if (!d5.a() && d5.c() < d4.c()) {
                            com.facebook.common.references.a.y(aVar2);
                        } else {
                            o().c(aVar2, i2);
                            com.facebook.common.references.a.y(aVar2);
                            if (com.facebook.imagepipeline.f.b.d()) {
                                com.facebook.imagepipeline.f.b.b();
                                return;
                            }
                            return;
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.image.c> b = this.f2906d ? h.this.a.b(this.c, aVar) : null;
                    if (d3) {
                        o().b(1.0f);
                    }
                    l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> o = o();
                    if (b != null) {
                        aVar = b;
                    }
                    o.c(aVar, i2);
                    com.facebook.common.references.a.y(b);
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
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

    public h(com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        this.a = rVar;
        this.b = fVar;
        this.c = n0Var;
    }

    private static void f(com.facebook.imagepipeline.image.f fVar, o0 o0Var) {
        o0Var.l(fVar.getExtras());
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        boolean d2;
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("BitmapMemoryCacheProducer#produceResults");
            }
            q0 h2 = o0Var.h();
            h2.d(o0Var, e());
            com.facebook.cache.common.b a2 = this.b.a(o0Var.j(), o0Var.a());
            com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = this.a.get(a2);
            if (aVar != null) {
                f(aVar.A(), o0Var);
                boolean a3 = aVar.A().d().a();
                if (a3) {
                    h2.j(o0Var, e(), h2.f(o0Var, e()) ? ImmutableMap.of("cached_value_found", "true") : null);
                    h2.b(o0Var, e(), true);
                    o0Var.e("memory_bitmap", d());
                    lVar.b(1.0f);
                }
                b.k(a3);
                lVar.c(aVar, a3 ? 1 : 0);
                aVar.close();
                if (a3) {
                    if (d2) {
                        return;
                    }
                    return;
                }
            }
            if (o0Var.o().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                h2.j(o0Var, e(), h2.f(o0Var, e()) ? ImmutableMap.of("cached_value_found", "false") : null);
                h2.b(o0Var, e(), false);
                o0Var.e("memory_bitmap", d());
                lVar.c(null, 1);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                    return;
                }
                return;
            }
            l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> g2 = g(lVar, a2, o0Var.j().w());
            h2.j(o0Var, e(), h2.f(o0Var, e()) ? ImmutableMap.of("cached_value_found", "false") : null);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("mInputProducer.produceResult");
            }
            this.c.b(g2, o0Var);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    protected String d() {
        return "pipe_bg";
    }

    protected String e() {
        return "BitmapMemoryCacheProducer";
    }

    protected l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> g(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, com.facebook.cache.common.b bVar, boolean z) {
        return new a(lVar, bVar, z);
    }
}
