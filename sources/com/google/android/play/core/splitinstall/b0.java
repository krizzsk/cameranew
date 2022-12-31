package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.m1;
import com.google.android.play.core.internal.n1;
import java.io.File;
/* loaded from: classes2.dex */
public final class b0 implements n1<a0> {
    private final n1<n0> a;
    private final n1<com.google.android.play.core.splitinstall.l0.a> b;
    private final n1<File> c;

    public b0(n1<n0> n1Var, n1<com.google.android.play.core.splitinstall.l0.a> n1Var2, n1<File> n1Var3) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ a0 a() {
        return new a0(m1.b(this.a), m1.b(this.b), m1.b(this.c));
    }
}
