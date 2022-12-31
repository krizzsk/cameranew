package com.facebook.common.logging;
/* compiled from: FLog.java */
/* loaded from: classes.dex */
public class a {
    private static b a = FLogDefaultLoggingDelegate.getInstance();

    public static void A(Class<?> cls, String str, Throwable th) {
        if (a.f(6)) {
            a.c(l(cls), str, th);
        }
    }

    public static void B(String str, String str2) {
        if (a.f(6)) {
            a.a(str, str2);
        }
    }

    public static void C(String str, String str2, Object... objArr) {
        if (a.f(6)) {
            a.a(str, k(str2, objArr));
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        if (a.f(3)) {
            a.d(l(cls), k(str, obj));
        }
    }

    public static void b(String str, String str2) {
        if (a.f(3)) {
            a.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (a.f(3)) {
            a.b(str, str2, th);
        }
    }

    public static void d(Class<?> cls, String str) {
        if (a.f(6)) {
            a.e(l(cls), str);
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        if (a.f(6)) {
            a.e(l(cls), str, th);
        }
    }

    public static void f(Class<?> cls, String str, Object... objArr) {
        if (a.f(6)) {
            a.e(l(cls), k(str, objArr));
        }
    }

    public static void g(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (a.f(6)) {
            a.e(l(cls), k(str, objArr), th);
        }
    }

    public static void h(String str, String str2) {
        if (a.f(6)) {
            a.e(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (a.f(6)) {
            a.e(str, str2, th);
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (a.f(6)) {
            a.e(str, k(str2, objArr));
        }
    }

    private static String k(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String l(Class<?> cls) {
        return cls.getSimpleName();
    }

    public static boolean m(int i2) {
        return a.f(i2);
    }

    public static void n(int i2) {
        a.g(i2);
    }

    public static void o(Class<?> cls, String str) {
        if (a.f(2)) {
            a.v(l(cls), str);
        }
    }

    public static void p(Class<?> cls, String str, Object obj) {
        if (a.f(2)) {
            a.v(l(cls), k(str, obj));
        }
    }

    public static void q(Class<?> cls, String str, Object obj, Object obj2) {
        if (a.f(2)) {
            a.v(l(cls), k(str, obj, obj2));
        }
    }

    public static void r(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (m(2)) {
            o(cls, k(str, obj, obj2, obj3));
        }
    }

    public static void s(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.f(2)) {
            a.v(l(cls), k(str, obj, obj2, obj3, obj4));
        }
    }

    public static void t(Class<?> cls, String str, Object... objArr) {
        if (a.f(2)) {
            a.v(l(cls), k(str, objArr));
        }
    }

    public static void u(String str, String str2, Object... objArr) {
        if (a.f(2)) {
            a.v(str, k(str2, objArr));
        }
    }

    public static void v(Class<?> cls, String str) {
        if (a.f(5)) {
            a.w(l(cls), str);
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        if (a.f(5)) {
            a.d(l(cls), str, th);
        }
    }

    public static void x(Class<?> cls, String str, Object... objArr) {
        if (a.f(5)) {
            a.w(l(cls), k(str, objArr));
        }
    }

    public static void y(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (m(5)) {
            w(cls, k(str, objArr), th);
        }
    }

    public static void z(String str, String str2, Object... objArr) {
        if (a.f(5)) {
            a.w(str, k(str2, objArr));
        }
    }
}
