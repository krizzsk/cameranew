package com.airbnb.lottie.w;

import com.airbnb.lottie.j;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class d {
    private static j a = new c();

    public static void a(String str) {
        a.debug(str);
    }

    public static void b(String str, Throwable th) {
        a.error(str, th);
    }

    public static void c(String str) {
        a.a(str);
    }

    public static void d(String str, Throwable th) {
        a.b(str, th);
    }
}
