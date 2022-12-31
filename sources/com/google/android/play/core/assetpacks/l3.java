package com.google.android.play.core.assetpacks;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class l3 implements com.google.android.play.core.internal.n1<k3> {
    private final com.google.android.play.core.internal.n1<k0> a;
    private final com.google.android.play.core.internal.n1<x3> b;
    private final com.google.android.play.core.internal.n1<e0> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<com.google.android.play.core.splitinstall.p> f4773d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<w1> f4774e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<f1> f4775f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<u0> f4776g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4777h;

    public l3(com.google.android.play.core.internal.n1<k0> n1Var, com.google.android.play.core.internal.n1<x3> n1Var2, com.google.android.play.core.internal.n1<e0> n1Var3, com.google.android.play.core.internal.n1<com.google.android.play.core.splitinstall.p> n1Var4, com.google.android.play.core.internal.n1<w1> n1Var5, com.google.android.play.core.internal.n1<f1> n1Var6, com.google.android.play.core.internal.n1<u0> n1Var7, com.google.android.play.core.internal.n1<Executor> n1Var8) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4773d = n1Var4;
        this.f4774e = n1Var5;
        this.f4775f = n1Var6;
        this.f4776g = n1Var7;
        this.f4777h = n1Var8;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ k3 a() {
        return new k3(this.a.a(), com.google.android.play.core.internal.m1.b(this.b), this.c.a(), this.f4773d.a(), this.f4774e.a(), this.f4775f.a(), this.f4776g.a(), com.google.android.play.core.internal.m1.b(this.f4777h));
    }
}
