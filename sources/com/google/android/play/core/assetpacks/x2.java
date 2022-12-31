package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
public final class x2 implements com.google.android.play.core.internal.n1<w2> {
    private final com.google.android.play.core.internal.n1<k0> a;
    private final com.google.android.play.core.internal.n1<x3> b;
    private final com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> c;

    public x2(com.google.android.play.core.internal.n1<k0> n1Var, com.google.android.play.core.internal.n1<x3> n1Var2, com.google.android.play.core.internal.n1<com.google.android.play.core.common.b> n1Var3) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ w2 a() {
        return new w2(this.a.a(), com.google.android.play.core.internal.m1.b(this.b), this.c.a());
    }
}
