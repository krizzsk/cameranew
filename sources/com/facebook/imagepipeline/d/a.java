package com.facebook.imagepipeline.d;

import androidx.annotation.Nullable;
/* compiled from: FrescoInstrumenter.java */
/* loaded from: classes.dex */
public final class a {
    @Nullable
    private static volatile InterfaceC0099a a;

    /* compiled from: FrescoInstrumenter.java */
    /* renamed from: com.facebook.imagepipeline.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0099a {
        @Nullable
        Runnable a(Runnable runnable, String str);

        boolean b();

        void c(Object obj, Throwable th);

        @Nullable
        Object d(String str);

        @Nullable
        Object e(Object obj, @Nullable String str);

        @Nullable
        void f(Object obj);
    }

    @Nullable
    public static Runnable a(@Nullable Runnable runnable, @Nullable String str) {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null || runnable == null) {
            return runnable;
        }
        if (str == null) {
            str = "";
        }
        return interfaceC0099a.a(runnable, str);
    }

    public static boolean b() {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null) {
            return false;
        }
        return interfaceC0099a.b();
    }

    public static void c(@Nullable Object obj, Throwable th) {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null || obj == null) {
            return;
        }
        interfaceC0099a.c(obj, th);
    }

    @Nullable
    public static Object d(@Nullable String str) {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null || str == null) {
            return null;
        }
        return interfaceC0099a.d(str);
    }

    @Nullable
    public static Object e(@Nullable Object obj, @Nullable String str) {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null || obj == null) {
            return null;
        }
        return interfaceC0099a.e(obj, str);
    }

    public static void f(@Nullable Object obj) {
        InterfaceC0099a interfaceC0099a = a;
        if (interfaceC0099a == null || obj == null) {
            return;
        }
        interfaceC0099a.f(obj);
    }
}
