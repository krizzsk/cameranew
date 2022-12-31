package com.google.android.play.core.assetpacks;

import android.content.Context;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class y0 implements f {
    private final n a;
    private com.google.android.play.core.internal.n1<Context> b;
    private com.google.android.play.core.internal.n1<t2> c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<k0> f4826d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<f1> f4827e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<z> f4828f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<String> f4829g;

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<x3> f4830h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<Executor> f4831i;

    /* renamed from: j  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<w1> f4832j;

    /* renamed from: k  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<e0> f4833k;

    /* renamed from: l  reason: collision with root package name */
    private com.google.android.play.core.internal.n1<a1> f4834l;
    private com.google.android.play.core.internal.n1<d3> m;
    private com.google.android.play.core.internal.n1<n2> n;
    private com.google.android.play.core.internal.n1<r2> o;
    private com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> p;
    private com.google.android.play.core.internal.n1<w2> q;
    private com.google.android.play.core.internal.n1<r0> r;
    private com.google.android.play.core.internal.n1<z1> s;
    private com.google.android.play.core.internal.n1<c1> t;
    private com.google.android.play.core.internal.n1<u0> u;
    private com.google.android.play.core.internal.n1<Executor> v;
    private com.google.android.play.core.internal.n1<g2> w;
    private com.google.android.play.core.internal.n1<com.google.android.play.core.splitinstall.p> x;
    private com.google.android.play.core.internal.n1<k3> y;
    private com.google.android.play.core.internal.n1<b> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y0(n nVar) {
        i1 i1Var;
        q3 q3Var;
        w0 w0Var;
        w3 w3Var;
        this.a = nVar;
        t3 t3Var = new t3(nVar);
        this.b = t3Var;
        com.google.android.play.core.internal.n1<t2> a = com.google.android.play.core.internal.m1.a(new u2(t3Var));
        this.c = a;
        this.f4826d = com.google.android.play.core.internal.m1.a(new l0(this.b, a));
        i1Var = h1.a;
        com.google.android.play.core.internal.n1<f1> a2 = com.google.android.play.core.internal.m1.a(i1Var);
        this.f4827e = a2;
        this.f4828f = com.google.android.play.core.internal.m1.a(new a0(this.b, a2));
        this.f4829g = com.google.android.play.core.internal.m1.a(new u3(this.b));
        this.f4830h = new com.google.android.play.core.internal.l1();
        q3Var = p3.a;
        com.google.android.play.core.internal.n1<Executor> a3 = com.google.android.play.core.internal.m1.a(q3Var);
        this.f4831i = a3;
        this.f4832j = com.google.android.play.core.internal.m1.a(new x1(this.f4826d, this.f4830h, this.f4827e, a3));
        com.google.android.play.core.internal.l1 l1Var = new com.google.android.play.core.internal.l1();
        this.f4833k = l1Var;
        this.f4834l = com.google.android.play.core.internal.m1.a(new b1(this.f4826d, this.f4830h, l1Var, this.f4827e));
        this.m = com.google.android.play.core.internal.m1.a(new e3(this.f4826d));
        this.n = com.google.android.play.core.internal.m1.a(new o2(this.f4826d));
        this.o = com.google.android.play.core.internal.m1.a(new s2(this.f4826d, this.f4830h, this.f4832j, this.f4831i, this.f4827e));
        com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> a4 = com.google.android.play.core.internal.m1.a(com.google.android.play.core.common.d.b());
        this.p = a4;
        this.q = com.google.android.play.core.internal.m1.a(new x2(this.f4826d, this.f4830h, a4));
        com.google.android.play.core.internal.n1<r0> a5 = com.google.android.play.core.internal.m1.a(new s0(this.f4830h));
        this.r = a5;
        com.google.android.play.core.internal.n1<z1> a6 = com.google.android.play.core.internal.m1.a(new a2(this.f4832j, this.f4826d, a5));
        this.s = a6;
        this.t = com.google.android.play.core.internal.m1.a(new d1(this.f4832j, this.f4830h, this.f4834l, this.m, this.n, this.o, this.q, a6));
        w0Var = v0.a;
        this.u = com.google.android.play.core.internal.m1.a(w0Var);
        w3Var = v3.a;
        com.google.android.play.core.internal.n1<Executor> a7 = com.google.android.play.core.internal.m1.a(w3Var);
        this.v = a7;
        com.google.android.play.core.internal.l1.b(this.f4833k, com.google.android.play.core.internal.m1.a(new f0(this.b, this.f4832j, this.t, this.f4830h, this.f4827e, this.u, this.p, this.f4831i, a7)));
        com.google.android.play.core.internal.n1<g2> a8 = com.google.android.play.core.internal.m1.a(new i2(this.f4829g, this.f4833k, this.f4827e, this.b, this.c, this.f4831i));
        this.w = a8;
        com.google.android.play.core.internal.l1.b(this.f4830h, com.google.android.play.core.internal.m1.a(new s3(this.b, this.f4828f, a8)));
        com.google.android.play.core.internal.n1<com.google.android.play.core.splitinstall.p> a9 = com.google.android.play.core.internal.m1.a(com.google.android.play.core.splitinstall.h0.a(this.b));
        this.x = a9;
        com.google.android.play.core.internal.n1<k3> a10 = com.google.android.play.core.internal.m1.a(new l3(this.f4826d, this.f4830h, this.f4833k, a9, this.f4832j, this.f4827e, this.u, this.f4831i));
        this.y = a10;
        this.z = com.google.android.play.core.internal.m1.a(new r3(a10, this.b));
    }

    @Override // com.google.android.play.core.assetpacks.f
    public final b a() {
        return this.z.a();
    }

    @Override // com.google.android.play.core.assetpacks.f
    public final void a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.b = t3.a(this.a);
        assetPackExtractionService.c = this.y.a();
        assetPackExtractionService.f4694d = this.f4826d.a();
    }
}
