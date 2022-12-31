package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.image.g;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: PipelineDraweeController.java */
/* loaded from: classes.dex */
public class d extends com.facebook.drawee.controller.a<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, g> {
    private static final Class<?> M = d.class;
    @Nullable
    private final r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> A;
    private com.facebook.cache.common.b B;
    private k<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>> C;
    private boolean D;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.c.a> E;
    @Nullable
    private com.facebook.drawee.backends.pipeline.h.g F;
    @GuardedBy("this")
    @Nullable
    private Set<com.facebook.imagepipeline.e.e> G;
    @GuardedBy("this")
    @Nullable
    private com.facebook.drawee.backends.pipeline.h.b H;
    private com.facebook.drawee.backends.pipeline.g.b I;
    @Nullable
    private ImageRequest J;
    @Nullable
    private ImageRequest[] K;
    @Nullable
    private ImageRequest L;
    private final com.facebook.imagepipeline.c.a y;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.c.a> z;

    public d(Resources resources, DeferredReleaser deferredReleaser, com.facebook.imagepipeline.c.a aVar, Executor executor, @Nullable r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, @Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.y = new a(resources, aVar);
        this.z = immutableList;
        this.A = rVar;
    }

    private void n0(k<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>> kVar) {
        this.C = kVar;
        r0(null);
    }

    @Nullable
    private Drawable q0(@Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList, com.facebook.imagepipeline.image.c cVar) {
        Drawable b;
        if (immutableList == null) {
            return null;
        }
        Iterator<com.facebook.imagepipeline.c.a> it = immutableList.iterator();
        while (it.hasNext()) {
            com.facebook.imagepipeline.c.a next = it.next();
            if (next.a(cVar) && (b = next.b(cVar)) != null) {
                return b;
            }
        }
        return null;
    }

    private void r0(@Nullable com.facebook.imagepipeline.image.c cVar) {
        if (this.D) {
            if (q() == null) {
                com.facebook.drawee.a.a aVar = new com.facebook.drawee.a.a();
                com.facebook.drawee.a.b.a aVar2 = new com.facebook.drawee.a.b.a(aVar);
                this.I = new com.facebook.drawee.backends.pipeline.g.b();
                j(aVar2);
                X(aVar);
            }
            if (this.H == null) {
                f0(this.I);
            }
            if (q() instanceof com.facebook.drawee.a.a) {
                z0(cVar, (com.facebook.drawee.a.a) q());
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    protected void M(@Nullable Drawable drawable) {
        if (drawable instanceof com.facebook.r.a.a) {
            ((com.facebook.r.a.a) drawable).a();
        }
    }

    @Override // com.facebook.drawee.controller.a, com.facebook.drawee.b.a
    public void b(@Nullable com.facebook.drawee.b.b bVar) {
        super.b(bVar);
        r0(null);
    }

    public synchronized void f0(com.facebook.drawee.backends.pipeline.h.b bVar) {
        com.facebook.drawee.backends.pipeline.h.b bVar2 = this.H;
        if (bVar2 instanceof com.facebook.drawee.backends.pipeline.h.a) {
            ((com.facebook.drawee.backends.pipeline.h.a) bVar2).b(bVar);
        } else if (bVar2 != null) {
            this.H = new com.facebook.drawee.backends.pipeline.h.a(bVar2, bVar);
        } else {
            this.H = bVar;
        }
    }

    public synchronized void g0(com.facebook.imagepipeline.e.e eVar) {
        if (this.G == null) {
            this.G = new HashSet();
        }
        this.G.add(eVar);
    }

    protected void h0() {
        synchronized (this) {
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: i0 */
    public Drawable l(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("PipelineDraweeController#createDrawable");
            }
            h.i(com.facebook.common.references.a.Q(aVar));
            com.facebook.imagepipeline.image.c A = aVar.A();
            r0(A);
            Drawable q0 = q0(this.E, A);
            if (q0 != null) {
                return q0;
            }
            Drawable q02 = q0(this.z, A);
            if (q02 != null) {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
                return q02;
            }
            Drawable b = this.y.b(A);
            if (b != null) {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
                return b;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + A);
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    @Nullable
    /* renamed from: j0 */
    public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> m() {
        com.facebook.cache.common.b bVar;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("PipelineDraweeController#getCachedImage");
        }
        try {
            r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar = this.A;
            if (rVar != null && (bVar = this.B) != null) {
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = rVar.get(bVar);
                if (aVar != null && !aVar.A().d().a()) {
                    aVar.close();
                    return null;
                }
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
                return aVar;
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return null;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: k0 */
    public int w(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        if (aVar != null) {
            return aVar.N();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: l0 */
    public g x(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        h.i(com.facebook.common.references.a.Q(aVar));
        return aVar.A();
    }

    @Nullable
    public synchronized com.facebook.imagepipeline.e.e m0() {
        com.facebook.drawee.backends.pipeline.h.c cVar = this.H != null ? new com.facebook.drawee.backends.pipeline.h.c(u(), this.H) : null;
        Set<com.facebook.imagepipeline.e.e> set = this.G;
        if (set != null) {
            com.facebook.imagepipeline.e.c cVar2 = new com.facebook.imagepipeline.e.c(set);
            if (cVar != null) {
                cVar2.l(cVar);
            }
            return cVar2;
        }
        return cVar;
    }

    public void o0(k<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>> kVar, String str, com.facebook.cache.common.b bVar, Object obj, @Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList, @Nullable com.facebook.drawee.backends.pipeline.h.b bVar2) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("PipelineDraweeController#initialize");
        }
        super.B(str, obj);
        n0(kVar);
        this.B = bVar;
        x0(immutableList);
        h0();
        r0(null);
        f0(bVar2);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void p0(@Nullable com.facebook.drawee.backends.pipeline.h.f fVar, AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, g> abstractDraweeControllerBuilder, k<Boolean> kVar) {
        com.facebook.drawee.backends.pipeline.h.g gVar = this.F;
        if (gVar != null) {
            gVar.f();
        }
        if (fVar != null) {
            if (this.F == null) {
                this.F = new com.facebook.drawee.backends.pipeline.h.g(AwakeTimeSinceBootClock.get(), this, kVar);
            }
            this.F.c(fVar);
            this.F.g(true);
            this.F.i(abstractDraweeControllerBuilder);
        }
        this.J = abstractDraweeControllerBuilder.n();
        this.K = abstractDraweeControllerBuilder.m();
        this.L = abstractDraweeControllerBuilder.o();
    }

    @Override // com.facebook.drawee.controller.a
    protected com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> r() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("PipelineDraweeController#getDataSource");
        }
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.p(M, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar = this.C.get();
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return bVar;
    }

    @Override // com.facebook.drawee.controller.a
    @Nullable
    /* renamed from: s0 */
    public Map<String, Object> H(g gVar) {
        if (gVar == null) {
            return null;
        }
        return gVar.getExtras();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: t0 */
    public void J(String str, com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        super.J(str, aVar);
        synchronized (this) {
            com.facebook.drawee.backends.pipeline.h.b bVar = this.H;
            if (bVar != null) {
                bVar.a(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    @Override // com.facebook.drawee.controller.a
    public String toString() {
        g.b c = com.facebook.common.internal.g.c(this);
        c.b("super", super.toString());
        c.b("dataSourceSupplier", this.C);
        return c.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.a
    /* renamed from: u0 */
    public void O(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        com.facebook.common.references.a.y(aVar);
    }

    public synchronized void v0(com.facebook.drawee.backends.pipeline.h.b bVar) {
        com.facebook.drawee.backends.pipeline.h.b bVar2 = this.H;
        if (bVar2 instanceof com.facebook.drawee.backends.pipeline.h.a) {
            ((com.facebook.drawee.backends.pipeline.h.a) bVar2).c(bVar);
            return;
        }
        if (bVar2 == bVar) {
            this.H = null;
        }
    }

    public synchronized void w0(com.facebook.imagepipeline.e.e eVar) {
        Set<com.facebook.imagepipeline.e.e> set = this.G;
        if (set == null) {
            return;
        }
        set.remove(eVar);
    }

    public void x0(@Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList) {
        this.E = immutableList;
    }

    @Override // com.facebook.drawee.controller.a
    @Nullable
    protected Uri y() {
        return com.facebook.fresco.ui.common.f.a(this.J, this.L, this.K, ImageRequest.w);
    }

    public void y0(boolean z) {
        this.D = z;
    }

    protected void z0(@Nullable com.facebook.imagepipeline.image.c cVar, com.facebook.drawee.a.a aVar) {
        o a;
        aVar.i(u());
        com.facebook.drawee.b.b d2 = d();
        p.c cVar2 = null;
        if (d2 != null && (a = p.a(d2.d())) != null) {
            cVar2 = a.t();
        }
        aVar.m(cVar2);
        int b = this.I.b();
        aVar.l(com.facebook.drawee.backends.pipeline.h.d.b(b), com.facebook.drawee.backends.pipeline.g.a.a(b));
        if (cVar != null) {
            aVar.j(cVar.getWidth(), cVar.getHeight());
            aVar.k(cVar.t());
            return;
        }
        aVar.h();
    }
}
