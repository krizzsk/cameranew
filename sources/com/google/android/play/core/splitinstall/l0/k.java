package com.google.android.play.core.splitinstall.l0;

import android.content.Context;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.splitinstall.q0;
import java.io.File;
/* loaded from: classes2.dex */
public final class k implements n1<a> {
    private final n1<Context> a;
    private final n1<File> b;
    private final n1<p> c;

    public k(n1<Context> n1Var, n1<File> n1Var2, n1<p> n1Var3) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ a a() {
        return new a(((q0) this.a).a(), this.b.a(), this.c.a());
    }
}
