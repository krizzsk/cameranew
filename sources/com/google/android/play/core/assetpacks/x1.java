package com.google.android.play.core.assetpacks;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class x1 implements com.google.android.play.core.internal.n1<w1> {
    private final com.google.android.play.core.internal.n1<k0> a;
    private final com.google.android.play.core.internal.n1<x3> b;
    private final com.google.android.play.core.internal.n1<f1> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4824d;

    public x1(com.google.android.play.core.internal.n1<k0> n1Var, com.google.android.play.core.internal.n1<x3> n1Var2, com.google.android.play.core.internal.n1<f1> n1Var3, com.google.android.play.core.internal.n1<Executor> n1Var4) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4824d = n1Var4;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ w1 a() {
        k0 a = this.a.a();
        return new w1(a, com.google.android.play.core.internal.m1.b(this.b), this.c.a(), com.google.android.play.core.internal.m1.b(this.f4824d));
    }
}
