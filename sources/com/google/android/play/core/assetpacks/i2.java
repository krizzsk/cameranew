package com.google.android.play.core.assetpacks;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class i2 implements com.google.android.play.core.internal.n1<g2> {
    private final com.google.android.play.core.internal.n1<String> a;
    private final com.google.android.play.core.internal.n1<e0> b;
    private final com.google.android.play.core.internal.n1<f1> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Context> f4748d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<t2> f4749e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.play.core.internal.n1<Executor> f4750f;

    public i2(com.google.android.play.core.internal.n1<String> n1Var, com.google.android.play.core.internal.n1<e0> n1Var2, com.google.android.play.core.internal.n1<f1> n1Var3, com.google.android.play.core.internal.n1<Context> n1Var4, com.google.android.play.core.internal.n1<t2> n1Var5, com.google.android.play.core.internal.n1<Executor> n1Var6) {
        this.a = n1Var;
        this.b = n1Var2;
        this.c = n1Var3;
        this.f4748d = n1Var4;
        this.f4749e = n1Var5;
        this.f4750f = n1Var6;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ g2 a() {
        String a = this.a.a();
        e0 a2 = this.b.a();
        f1 a3 = this.c.a();
        Context a4 = ((t3) this.f4748d).a();
        t2 a5 = this.f4749e.a();
        return new g2(a != null ? new File(a4.getExternalFilesDir(null), a) : a4.getExternalFilesDir(null), a2, a3, a4, a5, com.google.android.play.core.internal.m1.b(this.f4750f));
    }
}
