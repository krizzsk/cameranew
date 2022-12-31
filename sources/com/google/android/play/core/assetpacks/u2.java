package com.google.android.play.core.assetpacks;

import android.content.Context;
/* loaded from: classes2.dex */
public final class u2 implements com.google.android.play.core.internal.n1<t2> {
    private final com.google.android.play.core.internal.n1<Context> a;

    public u2(com.google.android.play.core.internal.n1<Context> n1Var) {
        this.a = n1Var;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ t2 a() {
        return new t2(((t3) this.a).a());
    }
}
