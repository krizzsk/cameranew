package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.m1;
import com.google.android.play.core.internal.n1;
import java.io.File;
/* loaded from: classes2.dex */
public final class u implements d0 {
    private n1<Context> a;
    private n1<av> b;
    private n1<k0> c;

    /* renamed from: d  reason: collision with root package name */
    private n1<p> f4910d;

    /* renamed from: e  reason: collision with root package name */
    private n1<q> f4911e;

    /* renamed from: f  reason: collision with root package name */
    private n1<n0> f4912f;

    /* renamed from: g  reason: collision with root package name */
    private n1<File> f4913g;

    /* renamed from: h  reason: collision with root package name */
    private n1<com.google.android.play.core.splitinstall.l0.a> f4914h;

    /* renamed from: i  reason: collision with root package name */
    private n1<a0> f4915i;

    /* renamed from: j  reason: collision with root package name */
    private n1<a> f4916j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(p0 p0Var) {
        q0 q0Var = new q0(p0Var);
        this.a = q0Var;
        this.b = m1.a(new o(q0Var));
        this.c = m1.a(new h(p0Var));
        this.f4910d = m1.a(h0.a(this.a));
        n1<q> a = m1.a(new r(this.a));
        this.f4911e = a;
        this.f4912f = m1.a(new o0(this.b, this.c, this.f4910d, a));
        n1<File> a2 = m1.a(new g(this.a));
        this.f4913g = a2;
        n1<com.google.android.play.core.splitinstall.l0.a> a3 = m1.a(new com.google.android.play.core.splitinstall.l0.k(this.a, a2, this.f4910d));
        this.f4914h = a3;
        n1<a0> a4 = m1.a(new b0(this.f4912f, a3, this.f4913g));
        this.f4915i = a4;
        this.f4916j = m1.a(new i(p0Var, a4));
    }

    @Override // com.google.android.play.core.splitinstall.d0
    public final a a() {
        return this.f4916j.a();
    }
}
