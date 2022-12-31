package com.google.android.play.core.assetpacks;

import android.content.Context;
/* loaded from: classes2.dex */
public final class a0 implements com.google.android.play.core.internal.n1<z> {
    private final com.google.android.play.core.internal.n1<Context> a;
    private final com.google.android.play.core.internal.n1<f1> b;

    public a0(com.google.android.play.core.internal.n1<Context> n1Var, com.google.android.play.core.internal.n1<f1> n1Var2) {
        this.a = n1Var;
        this.b = n1Var2;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ z a() {
        return new z(((t3) this.a).a(), this.b.a());
    }
}
