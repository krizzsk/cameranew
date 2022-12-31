package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
public final class a2 implements com.google.android.play.core.internal.n1<z1> {
    private final com.google.android.play.core.internal.n1<w1> a;
    private final com.google.android.play.core.internal.n1<k0> b;
    private final com.google.android.play.core.internal.n1<r0> c;

    public a2(com.google.android.play.core.internal.n1<w1> n1Var, com.google.android.play.core.internal.n1<k0> n1Var2, com.google.android.play.core.internal.n1<r0> n1Var3) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ z1 a() {
        return new z1(this.a.a(), this.b.a(), this.c.a());
    }
}
