package com.facebook.drawee.backends.pipeline.h;

import android.graphics.Rect;
import com.facebook.common.internal.k;
import com.facebook.common.internal.l;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
/* compiled from: ImagePerfMonitor.java */
/* loaded from: classes.dex */
public class g implements h {
    private final com.facebook.drawee.backends.pipeline.d a;
    private final com.facebook.common.time.b b;
    private final i c = new i();

    /* renamed from: d  reason: collision with root package name */
    private final k<Boolean> f2458d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private c f2459e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private b f2460f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.drawee.backends.pipeline.h.j.c f2461g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.drawee.backends.pipeline.h.j.a f2462h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.imagepipeline.e.c f2463i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private List<f> f2464j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2465k;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.backends.pipeline.d dVar, k<Boolean> kVar) {
        this.b = bVar;
        this.a = dVar;
        this.f2458d = kVar;
    }

    private void h() {
        if (this.f2462h == null) {
            this.f2462h = new com.facebook.drawee.backends.pipeline.h.j.a(this.b, this.c, this, this.f2458d, l.a);
        }
        if (this.f2461g == null) {
            this.f2461g = new com.facebook.drawee.backends.pipeline.h.j.c(this.b, this.c);
        }
        if (this.f2460f == null) {
            this.f2460f = new com.facebook.drawee.backends.pipeline.h.j.b(this.c, this);
        }
        c cVar = this.f2459e;
        if (cVar == null) {
            this.f2459e = new c(this.a.u(), this.f2460f);
        } else {
            cVar.l(this.a.u());
        }
        if (this.f2463i == null) {
            this.f2463i = new com.facebook.imagepipeline.e.c(this.f2461g, this.f2459e);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.h.h
    public void a(i iVar, int i2) {
        List<f> list;
        if (!this.f2465k || (list = this.f2464j) == null || list.isEmpty()) {
            return;
        }
        e B = iVar.B();
        for (f fVar : this.f2464j) {
            fVar.b(B, i2);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.h.h
    public void b(i iVar, int i2) {
        List<f> list;
        iVar.o(i2);
        if (!this.f2465k || (list = this.f2464j) == null || list.isEmpty()) {
            return;
        }
        if (i2 == 3) {
            d();
        }
        e B = iVar.B();
        for (f fVar : this.f2464j) {
            fVar.a(B, i2);
        }
    }

    public void c(@Nullable f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f2464j == null) {
            this.f2464j = new CopyOnWriteArrayList();
        }
        this.f2464j.add(fVar);
    }

    public void d() {
        com.facebook.drawee.b.b d2 = this.a.d();
        if (d2 == null || d2.d() == null) {
            return;
        }
        Rect bounds = d2.d().getBounds();
        this.c.v(bounds.width());
        this.c.u(bounds.height());
    }

    public void e() {
        List<f> list = this.f2464j;
        if (list != null) {
            list.clear();
        }
    }

    public void f() {
        e();
        g(false);
        this.c.b();
    }

    public void g(boolean z) {
        this.f2465k = z;
        if (z) {
            h();
            b bVar = this.f2460f;
            if (bVar != null) {
                this.a.f0(bVar);
            }
            com.facebook.drawee.backends.pipeline.h.j.a aVar = this.f2462h;
            if (aVar != null) {
                this.a.k(aVar);
            }
            com.facebook.imagepipeline.e.c cVar = this.f2463i;
            if (cVar != null) {
                this.a.g0(cVar);
                return;
            }
            return;
        }
        b bVar2 = this.f2460f;
        if (bVar2 != null) {
            this.a.v0(bVar2);
        }
        com.facebook.drawee.backends.pipeline.h.j.a aVar2 = this.f2462h;
        if (aVar2 != null) {
            this.a.P(aVar2);
        }
        com.facebook.imagepipeline.e.c cVar2 = this.f2463i;
        if (cVar2 != null) {
            this.a.w0(cVar2);
        }
    }

    public void i(AbstractDraweeControllerBuilder<com.facebook.drawee.backends.pipeline.e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.imagepipeline.image.g> abstractDraweeControllerBuilder) {
        this.c.i(abstractDraweeControllerBuilder.n(), abstractDraweeControllerBuilder.o(), abstractDraweeControllerBuilder.m());
    }
}
