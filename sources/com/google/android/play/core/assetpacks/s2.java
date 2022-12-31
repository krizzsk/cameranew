package com.google.android.play.core.assetpacks;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class s2 implements com.google.android.play.core.internal.n1<r2> {
    private final com.google.android.play.core.internal.n1<k0> a;
    private final com.google.android.play.core.internal.n1<x3> b;
    private final com.google.android.play.core.internal.n1<w1> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4801d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<f1> f4802e;

    public s2(com.google.android.play.core.internal.n1<k0> n1Var, com.google.android.play.core.internal.n1<x3> n1Var2, com.google.android.play.core.internal.n1<w1> n1Var3, com.google.android.play.core.internal.n1<Executor> n1Var4, com.google.android.play.core.internal.n1<f1> n1Var5) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4801d = n1Var4;
        this.f4802e = n1Var5;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ r2 a() {
        k0 a = this.a.a();
        return new r2(a, com.google.android.play.core.internal.m1.b(this.b), this.c.a(), com.google.android.play.core.internal.m1.b(this.f4801d), this.f4802e.a());
    }
}
