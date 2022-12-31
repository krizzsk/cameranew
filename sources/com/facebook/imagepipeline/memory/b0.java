package com.facebook.imagepipeline.memory;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: PoolFactory.java */
@NotThreadSafe
/* loaded from: classes.dex */
public class b0 {
    private final a0 a;
    @Nullable
    private u b;
    @Nullable
    private d c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private u f2846d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private p f2847e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private u f2848f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.common.memory.f f2849g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.common.memory.i f2850h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.common.memory.a f2851i;

    public b0(a0 a0Var) {
        com.facebook.common.internal.h.g(a0Var);
        this.a = a0Var;
    }

    @Nullable
    private u a() {
        if (this.b == null) {
            try {
                this.b = (u) Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(com.facebook.common.memory.c.class, c0.class, d0.class).newInstance(this.a.i(), this.a.g(), this.a.h());
            } catch (ClassNotFoundException unused) {
                this.b = null;
            } catch (IllegalAccessException unused2) {
                this.b = null;
            } catch (InstantiationException unused3) {
                this.b = null;
            } catch (NoSuchMethodException unused4) {
                this.b = null;
            } catch (InvocationTargetException unused5) {
                this.b = null;
            }
        }
        return this.b;
    }

    @Nullable
    private u f(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return a();
                }
                throw new IllegalArgumentException("Invalid MemoryChunkType");
            }
            return c();
        }
        return g();
    }

    public d b() {
        if (this.c == null) {
            String e2 = this.a.e();
            char c = 65535;
            switch (e2.hashCode()) {
                case -1868884870:
                    if (e2.equals("legacy_default_params")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1106578487:
                    if (e2.equals("legacy")) {
                        c = 4;
                        break;
                    }
                    break;
                case -404562712:
                    if (e2.equals("experimental")) {
                        c = 2;
                        break;
                    }
                    break;
                case -402149703:
                    if (e2.equals("dummy_with_tracking")) {
                        c = 1;
                        break;
                    }
                    break;
                case 95945896:
                    if (e2.equals("dummy")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.c = new n();
            } else if (c == 1) {
                this.c = new o();
            } else if (c == 2) {
                this.c = new r(this.a.b(), this.a.a(), NoOpPoolStatsTracker.getInstance(), this.a.m() ? this.a.i() : null);
            } else if (c != 3) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.c = new h(this.a.i(), this.a.c(), this.a.d(), this.a.l());
                } else {
                    this.c = new n();
                }
            } else {
                this.c = new h(this.a.i(), j.a(), this.a.d(), this.a.l());
            }
        }
        return this.c;
    }

    @Nullable
    public u c() {
        if (this.f2846d == null) {
            try {
                this.f2846d = (u) Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(com.facebook.common.memory.c.class, c0.class, d0.class).newInstance(this.a.i(), this.a.g(), this.a.h());
            } catch (ClassNotFoundException unused) {
                this.f2846d = null;
            } catch (IllegalAccessException unused2) {
                this.f2846d = null;
            } catch (InstantiationException unused3) {
                this.f2846d = null;
            } catch (NoSuchMethodException unused4) {
                this.f2846d = null;
            } catch (InvocationTargetException unused5) {
                this.f2846d = null;
            }
        }
        return this.f2846d;
    }

    public p d() {
        if (this.f2847e == null) {
            this.f2847e = new p(this.a.i(), this.a.f());
        }
        return this.f2847e;
    }

    public int e() {
        return this.a.f().f2853e;
    }

    @Nullable
    public u g() {
        if (this.f2848f == null) {
            try {
                this.f2848f = (u) Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(com.facebook.common.memory.c.class, c0.class, d0.class).newInstance(this.a.i(), this.a.g(), this.a.h());
            } catch (ClassNotFoundException e2) {
                com.facebook.common.logging.a.i("PoolFactory", "", e2);
                this.f2848f = null;
            } catch (IllegalAccessException e3) {
                com.facebook.common.logging.a.i("PoolFactory", "", e3);
                this.f2848f = null;
            } catch (InstantiationException e4) {
                com.facebook.common.logging.a.i("PoolFactory", "", e4);
                this.f2848f = null;
            } catch (NoSuchMethodException e5) {
                com.facebook.common.logging.a.i("PoolFactory", "", e5);
                this.f2848f = null;
            } catch (InvocationTargetException e6) {
                com.facebook.common.logging.a.i("PoolFactory", "", e6);
                this.f2848f = null;
            }
        }
        return this.f2848f;
    }

    public com.facebook.common.memory.f h() {
        return i(!com.facebook.imagepipeline.core.l.a() ? 1 : 0);
    }

    public com.facebook.common.memory.f i(int i2) {
        if (this.f2849g == null) {
            u f2 = f(i2);
            com.facebook.common.internal.h.h(f2, "failed to get pool for chunk type: " + i2);
            this.f2849g = new x(f2, j());
        }
        return this.f2849g;
    }

    public com.facebook.common.memory.i j() {
        if (this.f2850h == null) {
            this.f2850h = new com.facebook.common.memory.i(k());
        }
        return this.f2850h;
    }

    public com.facebook.common.memory.a k() {
        if (this.f2851i == null) {
            this.f2851i = new q(this.a.i(), this.a.j(), this.a.k());
        }
        return this.f2851i;
    }
}
