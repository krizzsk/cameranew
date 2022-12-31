package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.n1;
/* loaded from: classes2.dex */
public final class h0 implements n1<p> {
    private final n1<Context> a;

    public h0(n1<Context> n1Var) {
        this.a = n1Var;
    }

    public static h0 a(n1<Context> n1Var) {
        return new h0(n1Var);
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ p a() {
        return new p(this.a.a());
    }
}
