package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.lang.reflect.Method;
/* compiled from: InternalContainer.java */
/* loaded from: classes.dex */
public class o {
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a;
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> b;
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile p<com.bytedance.sdk.openadsdk.c.a> f1731d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.j.a f1732e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.f.b.a f1733f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    private static volatile Context f1734g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.core.g.i f1735h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.core.g.h f1736i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalContainer.java */
    /* loaded from: classes.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application a;

        static {
            try {
                Object b = b();
                a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.o.e("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (o.class) {
            if (f1734g == null) {
                a(null);
            }
            context = f1734g;
        }
        return context;
    }

    public static void b() {
        a = null;
        f1732e = null;
        f1733f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f1734g), f(), k(), b(f1734g));
                    }
                }
            }
        }
        return a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (c == null) {
            synchronized (o.class) {
                if (c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (b == null) {
            synchronized (o.class) {
                if (b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return b;
    }

    public static p<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f1731d == null) {
            synchronized (o.class) {
                if (f1731d == null) {
                    f1731d = new q(f1734g);
                }
            }
        }
        return f1731d;
    }

    public static com.bytedance.sdk.openadsdk.j.a g() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.j.b.d();
        }
        if (f1732e == null) {
            synchronized (com.bytedance.sdk.openadsdk.j.a.class) {
                if (f1732e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f1732e = new com.bytedance.sdk.openadsdk.j.c();
                    } else {
                        f1732e = new com.bytedance.sdk.openadsdk.j.b(f1734g, new com.bytedance.sdk.openadsdk.j.h(f1734g));
                    }
                }
            }
        }
        return f1732e;
    }

    public static com.bytedance.sdk.openadsdk.core.g.i h() {
        if (f1735h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.g.i.class) {
                if (f1735h == null) {
                    f1735h = new com.bytedance.sdk.openadsdk.core.g.i();
                }
            }
        }
        return f1735h;
    }

    public static com.bytedance.sdk.openadsdk.core.g.h i() {
        if (f1736i == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.g.i.class) {
                if (f1736i == null) {
                    f1736i = new com.bytedance.sdk.openadsdk.core.g.h();
                    f1736i.b();
                }
            }
        }
        return f1736i;
    }

    public static com.bytedance.sdk.openadsdk.f.b.a j() {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return com.bytedance.sdk.openadsdk.f.b.c.c();
        }
        if (f1733f == null) {
            synchronized (com.bytedance.sdk.openadsdk.f.b.c.class) {
                if (f1733f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f1733f = new com.bytedance.sdk.openadsdk.f.b.d();
                    } else {
                        f1733f = new com.bytedance.sdk.openadsdk.f.b.c();
                    }
                }
            }
        }
        return f1733f;
    }

    private static g.b k() {
        return g.b.a();
    }

    public static synchronized void a(Context context) {
        synchronized (o.class) {
            if (f1734g == null) {
                if (a.a() != null) {
                    try {
                        f1734g = a.a();
                        if (f1734g != null) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (context != null) {
                    f1734g = context.getApplicationContext();
                }
            }
        }
    }

    private static g.a b(final Context context) {
        return new g.a() { // from class: com.bytedance.sdk.openadsdk.core.o.1
            @Override // com.bytedance.sdk.openadsdk.c.g.a
            public boolean a() {
                Context context2 = context;
                if (context2 == null) {
                    context2 = o.a();
                }
                return com.bytedance.sdk.openadsdk.utils.q.a(context2);
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
        g.b b2;
        com.bytedance.sdk.openadsdk.c.e lVar;
        if (z) {
            lVar = new com.bytedance.sdk.openadsdk.c.n(f1734g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f1734g);
        }
        g.a b3 = b(f1734g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
