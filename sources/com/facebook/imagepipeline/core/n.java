package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.Nullable;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.a0;
import com.facebook.imagepipeline.producers.a1;
import com.facebook.imagepipeline.producers.b0;
import com.facebook.imagepipeline.producers.b1;
import com.facebook.imagepipeline.producers.c0;
import com.facebook.imagepipeline.producers.c1;
import com.facebook.imagepipeline.producers.e0;
import com.facebook.imagepipeline.producers.e1;
import com.facebook.imagepipeline.producers.f0;
import com.facebook.imagepipeline.producers.g0;
import com.facebook.imagepipeline.producers.i0;
import com.facebook.imagepipeline.producers.j0;
import com.facebook.imagepipeline.producers.k0;
import com.facebook.imagepipeline.producers.l0;
import com.facebook.imagepipeline.producers.m0;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.q;
import com.facebook.imagepipeline.producers.s;
import com.facebook.imagepipeline.producers.s0;
import com.facebook.imagepipeline.producers.t;
import com.facebook.imagepipeline.producers.t0;
import com.facebook.imagepipeline.producers.u;
import com.facebook.imagepipeline.producers.w0;
import com.facebook.imagepipeline.producers.x0;
import com.facebook.imagepipeline.producers.y0;
/* compiled from: ProducerFactory.java */
/* loaded from: classes.dex */
public class n {
    protected ContentResolver a;
    protected Resources b;
    protected AssetManager c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.facebook.common.memory.a f2777d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.facebook.imagepipeline.decoder.b f2778e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.facebook.imagepipeline.decoder.d f2779f;

    /* renamed from: g  reason: collision with root package name */
    protected final boolean f2780g;

    /* renamed from: h  reason: collision with root package name */
    protected final boolean f2781h;

    /* renamed from: i  reason: collision with root package name */
    protected final boolean f2782i;

    /* renamed from: j  reason: collision with root package name */
    protected final f f2783j;

    /* renamed from: k  reason: collision with root package name */
    protected final com.facebook.common.memory.f f2784k;

    /* renamed from: l  reason: collision with root package name */
    protected final com.facebook.imagepipeline.cache.e f2785l;
    protected final com.facebook.imagepipeline.cache.e m;
    protected final r<com.facebook.cache.common.b, PooledByteBuffer> n;
    protected final r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> o;
    protected final com.facebook.imagepipeline.cache.f p;
    protected final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> q;
    protected final com.facebook.imagepipeline.cache.d<com.facebook.cache.common.b> r;
    protected final com.facebook.imagepipeline.bitmaps.f s;
    protected final int t;
    protected final int u;
    protected boolean v;
    protected final a w;
    protected final int x;
    protected final boolean y;

    public n(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.f fVar2, r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, r<com.facebook.cache.common.b, PooledByteBuffer> rVar2, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar3, com.facebook.imagepipeline.bitmaps.f fVar4, int i2, int i3, boolean z4, int i4, a aVar2, boolean z5, int i5) {
        this.a = context.getApplicationContext().getContentResolver();
        this.b = context.getApplicationContext().getResources();
        this.c = context.getApplicationContext().getAssets();
        this.f2777d = aVar;
        this.f2778e = bVar;
        this.f2779f = dVar;
        this.f2780g = z;
        this.f2781h = z2;
        this.f2782i = z3;
        this.f2783j = fVar;
        this.f2784k = fVar2;
        this.o = rVar;
        this.n = rVar2;
        this.f2785l = eVar;
        this.m = eVar2;
        this.p = fVar3;
        this.s = fVar4;
        this.q = new com.facebook.imagepipeline.cache.d<>(i5);
        this.r = new com.facebook.imagepipeline.cache.d<>(i5);
        this.t = i2;
        this.u = i3;
        this.v = z4;
        this.x = i4;
        this.w = aVar2;
        this.y = z5;
    }

    public static com.facebook.imagepipeline.producers.a a(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new com.facebook.imagepipeline.producers.a(n0Var);
    }

    public static com.facebook.imagepipeline.producers.k h(n0<com.facebook.imagepipeline.image.e> n0Var, n0<com.facebook.imagepipeline.image.e> n0Var2) {
        return new com.facebook.imagepipeline.producers.k(n0Var, n0Var2);
    }

    public l0 A(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new l0(this.o, this.p, n0Var);
    }

    public m0 B(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new m0(n0Var, this.s, this.f2783j.e());
    }

    public s0 C() {
        return new s0(this.f2783j.f(), this.f2784k, this.a);
    }

    public t0 D(n0<com.facebook.imagepipeline.image.e> n0Var, boolean z, com.facebook.imagepipeline.g.d dVar) {
        return new t0(this.f2783j.e(), this.f2784k, n0Var, z, dVar);
    }

    public <T> w0<T> E(n0<T> n0Var) {
        return new w0<>(n0Var);
    }

    public <T> a1<T> F(n0<T> n0Var) {
        return new a1<>(5, this.f2783j.a(), n0Var);
    }

    public b1 G(c1<com.facebook.imagepipeline.image.e>[] c1VarArr) {
        return new b1(c1VarArr);
    }

    public e1 H(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new e1(this.f2783j.e(), this.f2784k, n0Var);
    }

    public <T> n0<T> b(n0<T> n0Var, y0 y0Var) {
        return new x0(n0Var, y0Var);
    }

    public com.facebook.imagepipeline.producers.f c(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.f(this.o, this.p, n0Var);
    }

    public com.facebook.imagepipeline.producers.g d(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.g(this.p, n0Var);
    }

    public com.facebook.imagepipeline.producers.h e(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.h(this.o, this.p, n0Var);
    }

    public com.facebook.imagepipeline.producers.i f(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.i(n0Var, this.t, this.u, this.v);
    }

    public com.facebook.imagepipeline.producers.j g(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.j(this.n, this.f2785l, this.m, this.p, this.q, this.r, n0Var);
    }

    @Nullable
    public n0<com.facebook.imagepipeline.image.e> i(j0 j0Var) {
        return null;
    }

    public com.facebook.imagepipeline.producers.m j() {
        return new com.facebook.imagepipeline.producers.m(this.f2784k);
    }

    public com.facebook.imagepipeline.producers.n k(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new com.facebook.imagepipeline.producers.n(this.f2777d, this.f2783j.d(), this.f2778e, this.f2779f, this.f2780g, this.f2781h, this.f2782i, n0Var, this.x, this.w, null, com.facebook.common.internal.l.a);
    }

    public com.facebook.imagepipeline.producers.o l(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return new com.facebook.imagepipeline.producers.o(n0Var, this.f2783j.c());
    }

    public q m(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new q(this.f2785l, this.m, this.p, n0Var);
    }

    public com.facebook.imagepipeline.producers.r n(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new com.facebook.imagepipeline.producers.r(this.f2785l, this.m, this.p, n0Var);
    }

    public s o(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new s(this.p, this.y, n0Var);
    }

    public t p(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new t(this.n, this.p, n0Var);
    }

    public u q(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new u(this.f2785l, this.m, this.p, this.q, this.r, n0Var);
    }

    public a0 r() {
        return new a0(this.f2783j.f(), this.f2784k, this.c);
    }

    public b0 s() {
        return new b0(this.f2783j.f(), this.f2784k, this.a);
    }

    public c0 t() {
        return new c0(this.f2783j.f(), this.f2784k, this.a);
    }

    public LocalExifThumbnailProducer u() {
        return new LocalExifThumbnailProducer(this.f2783j.g(), this.f2784k, this.a);
    }

    public e0 v() {
        return new e0(this.f2783j.f(), this.f2784k);
    }

    public f0 w() {
        return new f0(this.f2783j.f(), this.f2784k, this.b);
    }

    public g0 x() {
        return new g0(this.f2783j.f(), this.a);
    }

    public n0<com.facebook.imagepipeline.image.e> y(j0 j0Var) {
        return new i0(this.f2784k, this.f2777d, j0Var);
    }

    public k0 z(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return new k0(this.f2785l, this.p, this.f2784k, this.f2777d, n0Var);
    }
}
