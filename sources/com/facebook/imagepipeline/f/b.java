package com.facebook.imagepipeline.f;

import javax.annotation.Nullable;
/* compiled from: FrescoSystrace.java */
/* loaded from: classes.dex */
public class b {
    @Nullable
    private static volatile a a;

    /* compiled from: FrescoSystrace.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        boolean b();

        void c();
    }

    private b() {
    }

    public static void a(String str) {
        c().a(str);
    }

    public static void b() {
        c().c();
    }

    private static a c() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new com.facebook.imagepipeline.f.a();
                }
            }
        }
        return a;
    }

    public static boolean d() {
        return c().b();
    }
}
