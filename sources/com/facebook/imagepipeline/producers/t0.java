package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: ResizeAndRotateProducer.java */
/* loaded from: classes.dex */
public class t0 implements n0<com.facebook.imagepipeline.image.e> {
    private final Executor a;
    private final com.facebook.common.memory.f b;
    private final n0<com.facebook.imagepipeline.image.e> c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2975d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.imagepipeline.g.d f2976e;

    /* compiled from: ResizeAndRotateProducer.java */
    /* loaded from: classes.dex */
    private class a extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final boolean c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.imagepipeline.g.d f2977d;

        /* renamed from: e  reason: collision with root package name */
        private final o0 f2978e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2979f;

        /* renamed from: g  reason: collision with root package name */
        private final JobScheduler f2980g;

        /* compiled from: ResizeAndRotateProducer.java */
        /* renamed from: com.facebook.imagepipeline.producers.t0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0104a implements JobScheduler.d {
            C0104a(t0 t0Var) {
            }

            @Override // com.facebook.imagepipeline.producers.JobScheduler.d
            public void a(com.facebook.imagepipeline.image.e eVar, int i2) {
                a aVar = a.this;
                com.facebook.imagepipeline.g.c createImageTranscoder = aVar.f2977d.createImageTranscoder(eVar.A(), a.this.c);
                com.facebook.common.internal.h.g(createImageTranscoder);
                aVar.v(eVar, i2, createImageTranscoder);
            }
        }

        /* compiled from: ResizeAndRotateProducer.java */
        /* loaded from: classes.dex */
        class b extends e {
            final /* synthetic */ l a;

            b(t0 t0Var, l lVar) {
                this.a = lVar;
            }

            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.p0
            public void a() {
                if (a.this.f2978e.i()) {
                    a.this.f2980g.h();
                }
            }

            @Override // com.facebook.imagepipeline.producers.p0
            public void b() {
                a.this.f2980g.c();
                a.this.f2979f = true;
                this.a.a();
            }
        }

        a(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, boolean z, com.facebook.imagepipeline.g.d dVar) {
            super(lVar);
            this.f2979f = false;
            this.f2978e = o0Var;
            Boolean p = o0Var.j().p();
            this.c = p != null ? p.booleanValue() : z;
            this.f2977d = dVar;
            this.f2980g = new JobScheduler(t0.this.a, new C0104a(t0.this), 100);
            o0Var.c(new b(t0.this, lVar));
        }

        @Nullable
        private com.facebook.imagepipeline.image.e A(com.facebook.imagepipeline.image.e eVar) {
            return (this.f2978e.j().q().c() || eVar.Q() == 0 || eVar.Q() == -1) ? eVar : x(eVar, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(com.facebook.imagepipeline.image.e eVar, int i2, com.facebook.imagepipeline.g.c cVar) {
            this.f2978e.h().d(this.f2978e, "ResizeAndRotateProducer");
            ImageRequest j2 = this.f2978e.j();
            com.facebook.common.memory.h c = t0.this.b.c();
            try {
                com.facebook.imagepipeline.g.b c2 = cVar.c(eVar, c, j2.q(), j2.o(), null, 85);
                if (c2.a() != 2) {
                    Map<String, String> y = y(eVar, j2.o(), c2, cVar.a());
                    com.facebook.common.references.a R = com.facebook.common.references.a.R(c.d());
                    try {
                        com.facebook.imagepipeline.image.e eVar2 = new com.facebook.imagepipeline.image.e(R);
                        eVar2.h0(com.facebook.imageformat.b.a);
                        eVar2.a0();
                        this.f2978e.h().j(this.f2978e, "ResizeAndRotateProducer", y);
                        if (c2.a() != 1) {
                            i2 |= 16;
                        }
                        o().c(eVar2, i2);
                        com.facebook.imagepipeline.image.e.h(eVar2);
                        return;
                    } finally {
                        com.facebook.common.references.a.y(R);
                    }
                }
                throw new RuntimeException("Error while transcoding the image");
            } catch (Exception e2) {
                this.f2978e.h().k(this.f2978e, "ResizeAndRotateProducer", e2, null);
                if (com.facebook.imagepipeline.producers.b.d(i2)) {
                    o().onFailure(e2);
                }
            } finally {
                c.close();
            }
        }

        private void w(com.facebook.imagepipeline.image.e eVar, int i2, com.facebook.imageformat.c cVar) {
            com.facebook.imagepipeline.image.e A;
            if (cVar != com.facebook.imageformat.b.a && cVar != com.facebook.imageformat.b.f2658k) {
                A = z(eVar);
            } else {
                A = A(eVar);
            }
            o().c(A, i2);
        }

        @Nullable
        private com.facebook.imagepipeline.image.e x(com.facebook.imagepipeline.image.e eVar, int i2) {
            com.facebook.imagepipeline.image.e e2 = com.facebook.imagepipeline.image.e.e(eVar);
            if (e2 != null) {
                e2.i0(i2);
            }
            return e2;
        }

        @Nullable
        private Map<String, String> y(com.facebook.imagepipeline.image.e eVar, @Nullable com.facebook.imagepipeline.common.d dVar, @Nullable com.facebook.imagepipeline.g.b bVar, @Nullable String str) {
            String str2;
            if (this.f2978e.h().f(this.f2978e, "ResizeAndRotateProducer")) {
                String str3 = eVar.T() + "x" + eVar.z();
                if (dVar != null) {
                    str2 = dVar.a + "x" + dVar.b;
                } else {
                    str2 = "Unspecified";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Image format", String.valueOf(eVar.A()));
                hashMap.put("Original size", str3);
                hashMap.put("Requested size", str2);
                hashMap.put("queueTime", String.valueOf(this.f2980g.f()));
                hashMap.put("Transcoder id", str);
                hashMap.put("Transcoding result", String.valueOf(bVar));
                return ImmutableMap.copyOf((Map) hashMap);
            }
            return null;
        }

        @Nullable
        private com.facebook.imagepipeline.image.e z(com.facebook.imagepipeline.image.e eVar) {
            com.facebook.imagepipeline.common.e q = this.f2978e.j().q();
            return (q.f() || !q.e()) ? eVar : x(eVar, q.d());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: B */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (this.f2979f) {
                return;
            }
            boolean d2 = com.facebook.imagepipeline.producers.b.d(i2);
            if (eVar == null) {
                if (d2) {
                    o().c(null, 1);
                    return;
                }
                return;
            }
            com.facebook.imageformat.c A = eVar.A();
            ImageRequest j2 = this.f2978e.j();
            com.facebook.imagepipeline.g.c createImageTranscoder = this.f2977d.createImageTranscoder(A, this.c);
            com.facebook.common.internal.h.g(createImageTranscoder);
            TriState h2 = t0.h(j2, eVar, createImageTranscoder);
            if (d2 || h2 != TriState.UNSET) {
                if (h2 != TriState.YES) {
                    w(eVar, i2, A);
                } else if (this.f2980g.k(eVar, i2)) {
                    if (d2 || this.f2978e.i()) {
                        this.f2980g.h();
                    }
                }
            }
        }
    }

    public t0(Executor executor, com.facebook.common.memory.f fVar, n0<com.facebook.imagepipeline.image.e> n0Var, boolean z, com.facebook.imagepipeline.g.d dVar) {
        com.facebook.common.internal.h.g(executor);
        this.a = executor;
        com.facebook.common.internal.h.g(fVar);
        this.b = fVar;
        com.facebook.common.internal.h.g(n0Var);
        this.c = n0Var;
        com.facebook.common.internal.h.g(dVar);
        this.f2976e = dVar;
        this.f2975d = z;
    }

    private static boolean f(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.image.e eVar2) {
        return !eVar.c() && (com.facebook.imagepipeline.g.e.e(eVar, eVar2) != 0 || g(eVar, eVar2));
    }

    private static boolean g(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.image.e eVar2) {
        if (eVar.e() && !eVar.c()) {
            return com.facebook.imagepipeline.g.e.a.contains(Integer.valueOf(eVar2.x()));
        }
        eVar2.f0(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState h(ImageRequest imageRequest, com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.g.c cVar) {
        if (eVar != null && eVar.A() != com.facebook.imageformat.c.b) {
            if (!cVar.d(eVar.A())) {
                return TriState.NO;
            }
            return TriState.valueOf(f(imageRequest.q(), eVar) || cVar.b(eVar, imageRequest.q(), imageRequest.o()));
        }
        return TriState.UNSET;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        this.c.b(new a(lVar, o0Var, this.f2975d, this.f2976e), o0Var);
    }
}
