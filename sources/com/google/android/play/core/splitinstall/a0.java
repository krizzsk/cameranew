package com.google.android.play.core.splitinstall;

import androidx.annotation.NonNull;
import com.google.android.play.core.internal.k1;
import java.io.File;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a0 implements a {
    private final k1<n0> a;
    private final k1<com.google.android.play.core.splitinstall.l0.a> b;
    private final k1<File> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(k1<n0> k1Var, k1<com.google.android.play.core.splitinstall.l0.a> k1Var2, k1<File> k1Var3) {
        this.a = k1Var;
        this.b = k1Var2;
        this.c = k1Var3;
    }

    private final a d() {
        return (a) (this.c.a() == null ? this.a : this.b).a();
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final com.google.android.play.core.tasks.d<Integer> a(@NonNull c cVar) {
        return d().a(cVar);
    }

    @Override // com.google.android.play.core.splitinstall.a
    @NonNull
    public final Set<String> b() {
        return d().b();
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void c(@NonNull e eVar) {
        d().c(eVar);
    }
}
