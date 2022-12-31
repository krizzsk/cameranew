package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.p;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.y0;
import com.facebook.imagepipeline.producers.z0;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
public class ImagePipelineFactory {
    private static final Class<?> t = ImagePipelineFactory.class;
    private static ImagePipelineFactory u;
    private static boolean v;
    private static h w;
    private final y0 a;
    private final j b;
    private final a c;

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.imagepipeline.cache.i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> f2720d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.cache.o<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> f2721e;

    /* renamed from: f  reason: collision with root package name */
    private com.facebook.imagepipeline.cache.i<com.facebook.cache.common.b, PooledByteBuffer> f2722f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.imagepipeline.cache.o<com.facebook.cache.common.b, PooledByteBuffer> f2723g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.imagepipeline.cache.e f2724h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.cache.disk.h f2725i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.facebook.imagepipeline.decoder.b f2726j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private h f2727k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private com.facebook.imagepipeline.g.d f2728l;
    @Nullable
    private n m;
    @Nullable
    private o n;
    @Nullable
    private com.facebook.imagepipeline.cache.e o;
    @Nullable
    private com.facebook.cache.disk.h p;
    @Nullable
    private com.facebook.imagepipeline.bitmaps.f q;
    @Nullable
    private com.facebook.imagepipeline.platform.d r;
    @Nullable
    private com.facebook.imagepipeline.animated.a.a s;

    public ImagePipelineFactory(j jVar) {
        y0 z0Var;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ImagePipelineConfig()");
        }
        com.facebook.common.internal.h.g(jVar);
        j jVar2 = jVar;
        this.b = jVar2;
        if (jVar2.D().t()) {
            z0Var = new v(jVar.E().a());
        } else {
            z0Var = new z0(jVar.E().a());
        }
        this.a = z0Var;
        com.facebook.common.references.a.W(jVar.D().b());
        this.c = new a(jVar.w());
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    private h a() {
        return new h(q(), this.b.f(), this.b.a(), this.b.b(), e(), h(), l(), r(), this.b.y(), this.a, this.b.D().i(), this.b.D().v(), this.b.C(), this.b);
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a c() {
        if (this.s == null) {
            this.s = com.facebook.imagepipeline.animated.a.b.a(n(), this.b.E(), d(), this.b.D().A(), this.b.l());
        }
        return this.s;
    }

    public static ImagePipelineFactory getInstance() {
        ImagePipelineFactory imagePipelineFactory = u;
        com.facebook.common.internal.h.h(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        return imagePipelineFactory;
    }

    private com.facebook.imagepipeline.decoder.b i() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.f2726j == null) {
            if (this.b.r() != null) {
                this.f2726j = this.b.r();
            } else {
                com.facebook.imagepipeline.animated.a.a c = c();
                if (c != null) {
                    bVar2 = c.c();
                    bVar = c.b();
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.b.o() == null) {
                    this.f2726j = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, o());
                } else {
                    o();
                    this.b.o().a();
                    throw null;
                }
            }
        }
        return this.f2726j;
    }

    private com.facebook.imagepipeline.g.d k() {
        if (this.f2728l == null) {
            if (this.b.n() == null && this.b.m() == null && this.b.D().w()) {
                this.f2728l = new com.facebook.imagepipeline.g.h(this.b.D().f());
            } else {
                this.f2728l = new com.facebook.imagepipeline.g.f(this.b.D().f(), this.b.D().l(), this.b.n(), this.b.m(), this.b.D().s());
            }
        }
        return this.f2728l;
    }

    private n p() {
        if (this.m == null) {
            this.m = this.b.D().h().a(this.b.getContext(), this.b.t().k(), i(), this.b.h(), this.b.k(), this.b.z(), this.b.D().o(), this.b.E(), this.b.t().i(this.b.u()), this.b.t().j(), e(), h(), l(), r(), this.b.y(), n(), this.b.D().e(), this.b.D().d(), this.b.D().c(), this.b.D().f(), f(), this.b.D().B(), this.b.D().j());
        }
        return this.m;
    }

    private o q() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.b.D().k();
        if (this.n == null) {
            this.n = new o(this.b.getContext().getApplicationContext().getContentResolver(), p(), this.b.c(), this.b.z(), this.b.D().y(), this.a, this.b.k(), z, this.b.D().x(), this.b.p(), k(), this.b.D().r(), this.b.D().p(), this.b.D().C(), this.b.D().a());
        }
        return this.n;
    }

    private com.facebook.imagepipeline.cache.e r() {
        if (this.o == null) {
            this.o = new com.facebook.imagepipeline.cache.e(s(), this.b.t().i(this.b.u()), this.b.t().j(), this.b.E().f(), this.b.E().b(), this.b.A());
        }
        return this.o;
    }

    public static synchronized void t(Context context) {
        synchronized (ImagePipelineFactory.class) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ImagePipelineFactory#initialize");
            }
            u(i.J(context).K());
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    public static synchronized void u(j jVar) {
        synchronized (ImagePipelineFactory.class) {
            if (u != null) {
                com.facebook.common.logging.a.v(t, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            u = new ImagePipelineFactory(jVar);
        }
    }

    @Nullable
    public com.facebook.imagepipeline.c.a b(@Nullable Context context) {
        com.facebook.imagepipeline.animated.a.a c = c();
        if (c == null) {
            return null;
        }
        return c.a(context);
    }

    public com.facebook.imagepipeline.cache.i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> d() {
        if (this.f2720d == null) {
            this.f2720d = this.b.x().a(this.b.q(), this.b.B(), this.b.g(), this.b.j());
        }
        return this.f2720d;
    }

    public com.facebook.imagepipeline.cache.o<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> e() {
        if (this.f2721e == null) {
            this.f2721e = p.a(d(), this.b.A());
        }
        return this.f2721e;
    }

    public a f() {
        return this.c;
    }

    public com.facebook.imagepipeline.cache.i<com.facebook.cache.common.b, PooledByteBuffer> g() {
        if (this.f2722f == null) {
            this.f2722f = com.facebook.imagepipeline.cache.l.a(this.b.s(), this.b.B());
        }
        return this.f2722f;
    }

    public com.facebook.imagepipeline.cache.o<com.facebook.cache.common.b, PooledByteBuffer> h() {
        r<com.facebook.cache.common.b, PooledByteBuffer> g2;
        if (this.f2723g == null) {
            if (this.b.d() != null) {
                g2 = this.b.d();
            } else {
                g2 = g();
            }
            this.f2723g = com.facebook.imagepipeline.cache.m.a(g2, this.b.A());
        }
        return this.f2723g;
    }

    public h j() {
        if (v) {
            if (w == null) {
                h a = a();
                w = a;
                this.f2727k = a;
            }
            return w;
        }
        if (this.f2727k == null) {
            this.f2727k = a();
        }
        return this.f2727k;
    }

    public com.facebook.imagepipeline.cache.e l() {
        if (this.f2724h == null) {
            this.f2724h = new com.facebook.imagepipeline.cache.e(m(), this.b.t().i(this.b.u()), this.b.t().j(), this.b.E().f(), this.b.E().b(), this.b.A());
        }
        return this.f2724h;
    }

    public com.facebook.cache.disk.h m() {
        if (this.f2725i == null) {
            this.f2725i = this.b.v().a(this.b.e());
        }
        return this.f2725i;
    }

    public com.facebook.imagepipeline.bitmaps.f n() {
        if (this.q == null) {
            this.q = com.facebook.imagepipeline.bitmaps.g.a(this.b.t(), o(), f());
        }
        return this.q;
    }

    public com.facebook.imagepipeline.platform.d o() {
        if (this.r == null) {
            this.r = com.facebook.imagepipeline.platform.e.a(this.b.t(), this.b.D().u());
        }
        return this.r;
    }

    public com.facebook.cache.disk.h s() {
        if (this.p == null) {
            this.p = this.b.v().a(this.b.i());
        }
        return this.p;
    }
}
