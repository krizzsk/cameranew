package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
/* compiled from: PoolConfig.java */
@Immutable
/* loaded from: classes.dex */
public class a0 {
    private final c0 a;
    private final d0 b;
    private final c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.c f2826d;

    /* renamed from: e  reason: collision with root package name */
    private final c0 f2827e;

    /* renamed from: f  reason: collision with root package name */
    private final d0 f2828f;

    /* renamed from: g  reason: collision with root package name */
    private final c0 f2829g;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f2830h;

    /* renamed from: i  reason: collision with root package name */
    private final String f2831i;

    /* renamed from: j  reason: collision with root package name */
    private final int f2832j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2833k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2834l;
    private final boolean m;

    /* compiled from: PoolConfig.java */
    /* loaded from: classes.dex */
    public static class b {
        @Nullable
        private c0 a;
        @Nullable
        private d0 b;
        @Nullable
        private c0 c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.memory.c f2835d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private c0 f2836e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private d0 f2837f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private c0 f2838g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private d0 f2839h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private String f2840i;

        /* renamed from: j  reason: collision with root package name */
        private int f2841j;

        /* renamed from: k  reason: collision with root package name */
        private int f2842k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2843l;
        public boolean m;

        public a0 m() {
            return new a0(this);
        }

        private b() {
        }
    }

    public static b n() {
        return new b();
    }

    public int a() {
        return this.f2833k;
    }

    public int b() {
        return this.f2832j;
    }

    public c0 c() {
        return this.a;
    }

    public d0 d() {
        return this.b;
    }

    public String e() {
        return this.f2831i;
    }

    public c0 f() {
        return this.c;
    }

    public c0 g() {
        return this.f2827e;
    }

    public d0 h() {
        return this.f2828f;
    }

    public com.facebook.common.memory.c i() {
        return this.f2826d;
    }

    public c0 j() {
        return this.f2829g;
    }

    public d0 k() {
        return this.f2830h;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.f2834l;
    }

    private a0(b bVar) {
        c0 c0Var;
        d0 d0Var;
        c0 c0Var2;
        com.facebook.common.memory.c cVar;
        c0 c0Var3;
        d0 d0Var2;
        c0 c0Var4;
        d0 d0Var3;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("PoolConfig()");
        }
        if (bVar.a != null) {
            c0Var = bVar.a;
        } else {
            c0Var = j.a();
        }
        this.a = c0Var;
        if (bVar.b != null) {
            d0Var = bVar.b;
        } else {
            d0Var = NoOpPoolStatsTracker.getInstance();
        }
        this.b = d0Var;
        if (bVar.c != null) {
            c0Var2 = bVar.c;
        } else {
            c0Var2 = l.b();
        }
        this.c = c0Var2;
        if (bVar.f2835d != null) {
            cVar = bVar.f2835d;
        } else {
            cVar = NoOpMemoryTrimmableRegistry.getInstance();
        }
        this.f2826d = cVar;
        if (bVar.f2836e != null) {
            c0Var3 = bVar.f2836e;
        } else {
            c0Var3 = m.a();
        }
        this.f2827e = c0Var3;
        if (bVar.f2837f != null) {
            d0Var2 = bVar.f2837f;
        } else {
            d0Var2 = NoOpPoolStatsTracker.getInstance();
        }
        this.f2828f = d0Var2;
        if (bVar.f2838g != null) {
            c0Var4 = bVar.f2838g;
        } else {
            c0Var4 = k.a();
        }
        this.f2829g = c0Var4;
        if (bVar.f2839h != null) {
            d0Var3 = bVar.f2839h;
        } else {
            d0Var3 = NoOpPoolStatsTracker.getInstance();
        }
        this.f2830h = d0Var3;
        this.f2831i = bVar.f2840i == null ? "legacy" : bVar.f2840i;
        this.f2832j = bVar.f2841j;
        this.f2833k = bVar.f2842k > 0 ? bVar.f2842k : 4194304;
        this.f2834l = bVar.f2843l;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        this.m = bVar.m;
    }
}
