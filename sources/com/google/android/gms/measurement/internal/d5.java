package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class d5 {
    private long A;
    private long B;
    @Nullable
    private String C;
    private boolean D;
    private long E;
    private long F;
    private final o4 a;
    private final String b;
    private String c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f3769d;

    /* renamed from: e  reason: collision with root package name */
    private String f3770e;

    /* renamed from: f  reason: collision with root package name */
    private String f3771f;

    /* renamed from: g  reason: collision with root package name */
    private long f3772g;

    /* renamed from: h  reason: collision with root package name */
    private long f3773h;

    /* renamed from: i  reason: collision with root package name */
    private long f3774i;

    /* renamed from: j  reason: collision with root package name */
    private String f3775j;

    /* renamed from: k  reason: collision with root package name */
    private long f3776k;

    /* renamed from: l  reason: collision with root package name */
    private String f3777l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    @Nullable
    private String r;
    private Boolean s;
    private long t;
    @Nullable
    private List<String> u;
    @Nullable
    private String v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public d5(o4 o4Var, String str) {
        com.google.android.gms.common.internal.q.j(o4Var);
        com.google.android.gms.common.internal.q.f(str);
        this.a = o4Var;
        this.b = str;
        o4Var.c().f();
    }

    @WorkerThread
    public final boolean A() {
        this.a.c().f();
        return this.D;
    }

    @Nullable
    @WorkerThread
    public final String B() {
        this.a.c().f();
        return this.C;
    }

    @Nullable
    @WorkerThread
    public final String C() {
        this.a.c().f();
        String str = this.C;
        D(null);
        return str;
    }

    @WorkerThread
    public final void D(@Nullable String str) {
        this.a.c().f();
        this.D |= !n9.E(this.C, str);
        this.C = str;
    }

    @WorkerThread
    public final long E() {
        this.a.c().f();
        return this.p;
    }

    @WorkerThread
    public final void F(long j2) {
        this.a.c().f();
        this.D |= this.p != j2;
        this.p = j2;
    }

    @WorkerThread
    public final boolean G() {
        this.a.c().f();
        return this.q;
    }

    @WorkerThread
    public final void H(boolean z) {
        this.a.c().f();
        this.D |= this.q != z;
        this.q = z;
    }

    @WorkerThread
    public final Boolean I() {
        this.a.c().f();
        return this.s;
    }

    @WorkerThread
    public final void J(Boolean bool) {
        boolean equals;
        this.a.c().f();
        boolean z = this.D;
        Boolean bool2 = this.s;
        int i2 = n9.f3885i;
        if (bool2 == null && bool == null) {
            equals = true;
        } else {
            equals = bool2 == null ? false : bool2.equals(bool);
        }
        this.D = z | (!equals);
        this.s = bool;
    }

    @Nullable
    @WorkerThread
    public final List<String> K() {
        this.a.c().f();
        return this.u;
    }

    @WorkerThread
    public final void L(@Nullable List<String> list) {
        this.a.c().f();
        List<String> list2 = this.u;
        int i2 = n9.f3885i;
        if (list2 == null && list == null) {
            return;
        }
        if (list2 != null && list2.equals(list)) {
            return;
        }
        this.D = true;
        this.u = list != null ? new ArrayList(list) : null;
    }

    @WorkerThread
    public final void M() {
        this.a.c().f();
        this.D = false;
    }

    @Nullable
    @WorkerThread
    public final String N() {
        this.a.c().f();
        return this.b;
    }

    @WorkerThread
    public final String O() {
        this.a.c().f();
        return this.c;
    }

    @WorkerThread
    public final void P(String str) {
        this.a.c().f();
        this.D |= !n9.E(this.c, str);
        this.c = str;
    }

    @Nullable
    @WorkerThread
    public final String Q() {
        this.a.c().f();
        return this.f3769d;
    }

    @WorkerThread
    public final void R(@Nullable String str) {
        this.a.c().f();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= true ^ n9.E(this.f3769d, str);
        this.f3769d = str;
    }

    @Nullable
    @WorkerThread
    public final String S() {
        this.a.c().f();
        return this.r;
    }

    @WorkerThread
    public final void T(@Nullable String str) {
        this.a.c().f();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= true ^ n9.E(this.r, str);
        this.r = str;
    }

    @Nullable
    @WorkerThread
    public final String U() {
        this.a.c().f();
        return this.v;
    }

    @WorkerThread
    public final void V(@Nullable String str) {
        this.a.c().f();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= true ^ n9.E(this.v, str);
        this.v = str;
    }

    @WorkerThread
    public final String W() {
        this.a.c().f();
        return this.f3770e;
    }

    @WorkerThread
    public final void X(String str) {
        this.a.c().f();
        this.D |= !n9.E(this.f3770e, str);
        this.f3770e = str;
    }

    @WorkerThread
    public final String Y() {
        this.a.c().f();
        return this.f3771f;
    }

    @WorkerThread
    public final void Z(String str) {
        this.a.c().f();
        this.D |= !n9.E(this.f3771f, str);
        this.f3771f = str;
    }

    @WorkerThread
    public final void a(long j2) {
        this.a.c().f();
        this.D |= this.m != j2;
        this.m = j2;
    }

    @WorkerThread
    public final long a0() {
        this.a.c().f();
        return this.f3773h;
    }

    @WorkerThread
    public final long b() {
        this.a.c().f();
        return this.n;
    }

    @WorkerThread
    public final void b0(long j2) {
        this.a.c().f();
        this.D |= this.f3773h != j2;
        this.f3773h = j2;
    }

    @WorkerThread
    public final void c(long j2) {
        this.a.c().f();
        this.D |= this.n != j2;
        this.n = j2;
    }

    @WorkerThread
    public final long c0() {
        this.a.c().f();
        return this.f3774i;
    }

    @WorkerThread
    public final long d() {
        this.a.c().f();
        return this.t;
    }

    @WorkerThread
    public final void d0(long j2) {
        this.a.c().f();
        this.D |= this.f3774i != j2;
        this.f3774i = j2;
    }

    @WorkerThread
    public final void e(long j2) {
        this.a.c().f();
        this.D |= this.t != j2;
        this.t = j2;
    }

    @WorkerThread
    public final String e0() {
        this.a.c().f();
        return this.f3775j;
    }

    @WorkerThread
    public final boolean f() {
        this.a.c().f();
        return this.o;
    }

    @WorkerThread
    public final void f0(String str) {
        this.a.c().f();
        this.D |= !n9.E(this.f3775j, str);
        this.f3775j = str;
    }

    @WorkerThread
    public final void g(boolean z) {
        this.a.c().f();
        this.D |= this.o != z;
        this.o = z;
    }

    @WorkerThread
    public final long g0() {
        this.a.c().f();
        return this.f3776k;
    }

    @WorkerThread
    public final void h(long j2) {
        com.google.android.gms.common.internal.q.a(j2 >= 0);
        this.a.c().f();
        this.D = (this.f3772g != j2) | this.D;
        this.f3772g = j2;
    }

    @WorkerThread
    public final void h0(long j2) {
        this.a.c().f();
        this.D |= this.f3776k != j2;
        this.f3776k = j2;
    }

    @WorkerThread
    public final long i() {
        this.a.c().f();
        return this.f3772g;
    }

    @WorkerThread
    public final String i0() {
        this.a.c().f();
        return this.f3777l;
    }

    @WorkerThread
    public final long j() {
        this.a.c().f();
        return this.E;
    }

    @WorkerThread
    public final void j0(String str) {
        this.a.c().f();
        this.D |= !n9.E(this.f3777l, str);
        this.f3777l = str;
    }

    @WorkerThread
    public final void k(long j2) {
        this.a.c().f();
        this.D |= this.E != j2;
        this.E = j2;
    }

    @WorkerThread
    public final long k0() {
        this.a.c().f();
        return this.m;
    }

    @WorkerThread
    public final long l() {
        this.a.c().f();
        return this.F;
    }

    @WorkerThread
    public final void m(long j2) {
        this.a.c().f();
        this.D |= this.F != j2;
        this.F = j2;
    }

    @WorkerThread
    public final void n() {
        this.a.c().f();
        long j2 = this.f3772g + 1;
        if (j2 > 2147483647L) {
            this.a.a().p().b("Bundle index overflow. appId", k3.v(this.b));
            j2 = 0;
        }
        this.D = true;
        this.f3772g = j2;
    }

    @WorkerThread
    public final long o() {
        this.a.c().f();
        return this.w;
    }

    @WorkerThread
    public final void p(long j2) {
        this.a.c().f();
        this.D |= this.w != j2;
        this.w = j2;
    }

    @WorkerThread
    public final long q() {
        this.a.c().f();
        return this.x;
    }

    @WorkerThread
    public final void r(long j2) {
        this.a.c().f();
        this.D |= this.x != j2;
        this.x = j2;
    }

    @WorkerThread
    public final long s() {
        this.a.c().f();
        return this.y;
    }

    @WorkerThread
    public final void t(long j2) {
        this.a.c().f();
        this.D |= this.y != j2;
        this.y = j2;
    }

    @WorkerThread
    public final long u() {
        this.a.c().f();
        return this.z;
    }

    @WorkerThread
    public final void v(long j2) {
        this.a.c().f();
        this.D |= this.z != j2;
        this.z = j2;
    }

    @WorkerThread
    public final long w() {
        this.a.c().f();
        return this.B;
    }

    @WorkerThread
    public final void x(long j2) {
        this.a.c().f();
        this.D |= this.B != j2;
        this.B = j2;
    }

    @WorkerThread
    public final long y() {
        this.a.c().f();
        return this.A;
    }

    @WorkerThread
    public final void z(long j2) {
        this.a.c().f();
        this.D |= this.A != j2;
        this.A = j2;
    }
}
