package com.facebook.common.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import javax.annotation.Nullable;
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class h {
    private static String a(int i2, int i3, @Nullable String str) {
        if (i2 < 0) {
            return k("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return k("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    public static void b(@Nullable Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void d(boolean z, @Nullable String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(k(str, objArr));
        }
    }

    public static int e(int i2, int i3) {
        f(i2, i3, FirebaseAnalytics.Param.INDEX);
        return i2;
    }

    public static int f(int i2, int i3, @Nullable String str) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException(a(i2, i3, str));
        }
        return i2;
    }

    public static <T> T g(@Nullable T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T h(@Nullable T t, @Nullable Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void i(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void j(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    static String k(@Nullable String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append(valueOf.substring(i3, indexOf));
            sb.append(objArr[i2]);
            i3 = indexOf + 2;
            i2++;
        }
        sb.append(valueOf.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
