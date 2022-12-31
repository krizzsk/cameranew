package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.n1;
/* loaded from: classes2.dex */
public final class o0 implements n1<n0> {
    private final n1<av> a;
    private final n1<k0> b;
    private final n1<p> c;

    /* renamed from: d  reason: collision with root package name */
    private final n1<q> f4909d;

    public o0(n1<av> n1Var, n1<k0> n1Var2, n1<p> n1Var3, n1<q> n1Var4) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4909d = n1Var4;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ n0 a() {
        return new n0(this.a.a(), this.b.a(), this.c.a(), this.f4909d.a());
    }
}
