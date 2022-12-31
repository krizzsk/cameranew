package com.tapjoy.internal;

import android.os.Looper;
/* loaded from: classes3.dex */
public final class gw {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            x.a(4, "Tapjoy", str, (Throwable) null);
        }
    }

    public static void b(String str) {
        if (a) {
            x.a(6, "Tapjoy", str, (Throwable) null);
        }
    }

    public static boolean c(String str) {
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        return a(z, str + ": Must be called on the main/ui thread");
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            x.a(4, "Tapjoy", str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            x.a("Tapjoy", str, objArr);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            x.a("Tapjoy", "{}: {} {}", str, str2, str3);
        }
    }

    public static boolean a(Object obj, String str) {
        if (obj == null) {
            if (a) {
                b(str);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean a(boolean z, String str) {
        if (!a || z) {
            return z;
        }
        b(str);
        throw new IllegalStateException(str);
    }
}
