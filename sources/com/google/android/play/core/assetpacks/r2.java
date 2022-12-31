package com.google.android.play.core.assetpacks;

import java.io.File;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r2 {
    private final k0 a;
    private final com.google.android.play.core.internal.k1<x3> b;
    private final w1 c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<Executor> f4797d;

    /* renamed from: e  reason: collision with root package name */
    private final f1 f4798e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r2(k0 k0Var, com.google.android.play.core.internal.k1<x3> k1Var, w1 w1Var, com.google.android.play.core.internal.k1<Executor> k1Var2, f1 f1Var) {
        this.a = k0Var;
        this.b = k1Var;
        this.c = w1Var;
        this.f4797d = k1Var2;
        this.f4798e = f1Var;
    }

    public final void a(p2 p2Var) {
        File n = this.a.n(p2Var.b, p2Var.c, p2Var.f4792d);
        File x = this.a.x(p2Var.b, p2Var.c, p2Var.f4792d);
        if (!n.exists() || !x.exists()) {
            throw new bv(String.format("Cannot find pack files to move for pack %s.", p2Var.b), p2Var.a);
        }
        File b = this.a.b(p2Var.b, p2Var.c, p2Var.f4792d);
        b.mkdirs();
        if (!n.renameTo(b)) {
            throw new bv("Cannot move merged pack files to final location.", p2Var.a);
        }
        new File(this.a.b(p2Var.b, p2Var.c, p2Var.f4792d), "merge.tmp").delete();
        File k2 = this.a.k(p2Var.b, p2Var.c, p2Var.f4792d);
        k2.mkdirs();
        if (!x.renameTo(k2)) {
            throw new bv("Cannot move metadata files to final location.", p2Var.a);
        }
        k0 k0Var = this.a;
        k0Var.getClass();
        this.f4797d.a().execute(q2.a(k0Var));
        this.c.e(p2Var.b, p2Var.c, p2Var.f4792d);
        this.f4798e.b(p2Var.b);
        this.b.a().a(p2Var.a, p2Var.b);
    }
}
