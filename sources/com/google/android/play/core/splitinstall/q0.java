package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.internal.t0;
/* loaded from: classes2.dex */
public final class q0 implements n1<Context> {
    private final p0 a;

    public q0(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // com.google.android.play.core.internal.n1
    /* renamed from: b */
    public final Context a() {
        Context c = this.a.c();
        t0.p(c);
        return c;
    }
}
