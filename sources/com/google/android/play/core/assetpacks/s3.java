package com.google.android.play.core.assetpacks;

import android.content.Context;
/* loaded from: classes2.dex */
public final class s3 implements com.google.android.play.core.internal.n1<x3> {
    private final com.google.android.play.core.internal.n1<Context> a;
    private final com.google.android.play.core.internal.n1<z> b;
    private final com.google.android.play.core.internal.n1<g2> c;

    public s3(com.google.android.play.core.internal.n1<Context> n1Var, com.google.android.play.core.internal.n1<z> n1Var2, com.google.android.play.core.internal.n1<g2> n1Var3) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ x3 a() {
        x3 x3Var = (x3) (n.b(((t3) this.a).a()) == null ? com.google.android.play.core.internal.m1.b(this.b).a() : com.google.android.play.core.internal.m1.b(this.c).a());
        com.google.android.play.core.internal.t0.p(x3Var);
        return x3Var;
    }
}
