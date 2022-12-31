package com.google.android.play.core.assetpacks;

import android.content.Context;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class f0 implements com.google.android.play.core.internal.n1<e0> {
    private final com.google.android.play.core.internal.n1<Context> a;
    private final com.google.android.play.core.internal.n1<w1> b;
    private final com.google.android.play.core.internal.n1<c1> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<x3> f4728d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<f1> f4729e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<u0> f4730f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> f4731g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4732h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4733i;

    public f0(com.google.android.play.core.internal.n1<Context> n1Var, com.google.android.play.core.internal.n1<w1> n1Var2, com.google.android.play.core.internal.n1<c1> n1Var3, com.google.android.play.core.internal.n1<x3> n1Var4, com.google.android.play.core.internal.n1<f1> n1Var5, com.google.android.play.core.internal.n1<u0> n1Var6, com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> n1Var7, com.google.android.play.core.internal.n1<Executor> n1Var8, com.google.android.play.core.internal.n1<Executor> n1Var9) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4728d = n1Var4;
        this.f4729e = n1Var5;
        this.f4730f = n1Var6;
        this.f4731g = n1Var7;
        this.f4732h = n1Var8;
        this.f4733i = n1Var9;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ e0 a() {
        return new e0(((t3) this.a).a(), this.b.a(), this.c.a(), com.google.android.play.core.internal.m1.b(this.f4728d), this.f4729e.a(), this.f4730f.a(), this.f4731g.a(), com.google.android.play.core.internal.m1.b(this.f4732h), com.google.android.play.core.internal.m1.b(this.f4733i));
    }
}
