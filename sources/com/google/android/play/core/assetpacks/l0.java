package com.google.android.play.core.assetpacks;

import android.content.Context;
/* loaded from: classes2.dex */
public final class l0 implements com.google.android.play.core.internal.n1<k0> {
    private final com.google.android.play.core.internal.n1<Context> a;
    private final com.google.android.play.core.internal.n1<t2> b;

    public l0(com.google.android.play.core.internal.n1<Context> n1Var, com.google.android.play.core.internal.n1<t2> n1Var2) {
        this.a = n1Var;
        this.b = n1Var2;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ k0 a() {
        return new k0(((t3) this.a).a(), this.b.a());
    }
}
