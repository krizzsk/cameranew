package com.unity3d.splash.services.c.b;

import android.app.Application;
import android.content.Context;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes3.dex */
public class a {
    private static Context a;
    private static Application b;
    private static String c;

    static {
        new X500Principal("CN=Android Debug,O=Android,C=US");
    }

    public static Application a() {
        return b;
    }

    public static Context b() {
        return a;
    }

    public static String c() {
        return c;
    }

    public static void d(Application application) {
        b = application;
    }

    public static void e(Context context) {
        a = context;
    }

    public static void f(String str) {
        c = str;
    }
}
