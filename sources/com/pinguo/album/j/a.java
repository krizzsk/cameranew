package com.pinguo.album.j;

import android.graphics.Color;
import android.os.Build;
import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
/* compiled from: AlbumUtils.java */
/* loaded from: classes3.dex */
public class a {
    private static long[] a = new long[256];
    private static final boolean b;

    static {
        String str = Build.TYPE;
        b = str.equals("eng") || str.equals("userdebug");
        for (int i2 = 0; i2 < 256; i2++) {
            long j2 = i2;
            for (int i3 = 0; i3 < 8; i3++) {
                j2 = (j2 >> 1) ^ ((((int) j2) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            a[i2] = j2;
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static int b(float f2) {
        int i2 = 0;
        while (i2 < 31 && (1 << i2) < f2) {
            i2++;
        }
        return i2;
    }

    public static <T> T c(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static float d(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public static int e(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static void f(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            us.pinguo.common.log.a.s("close fail ", e2);
        }
    }

    public static int g(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public static final long h(byte[] bArr) {
        long j2 = -1;
        for (byte b2 : bArr) {
            j2 = (j2 >> 8) ^ a[(((int) j2) ^ b2) & 255];
        }
        return j2;
    }

    public static String i(String str) {
        return str == null ? "" : str;
    }

    public static boolean j(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void k(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        throw new AssertionError(str);
    }

    public static int l(float f2) {
        int i2 = 0;
        while (i2 < 31 && (1 << i2) <= f2) {
            i2++;
        }
        return i2 - 1;
    }

    public static float[] m(int i2) {
        return new float[]{Color.alpha(i2) / 255.0f, Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f};
    }

    public static boolean n(int i2) {
        return (i2 >>> 24) == 255;
    }

    public static String o(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        return b ? obj2 : "********************************".substring(0, Math.min(obj2.length(), 32));
    }

    public static int p(int i2) {
        if (i2 <= 0 || i2 > 1073741824) {
            throw new IllegalArgumentException("n is invalid: " + i2);
        }
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >> 16);
        int i5 = i4 | (i4 >> 8);
        int i6 = i5 | (i5 >> 4);
        int i7 = i6 | (i6 >> 2);
        return (i7 | (i7 >> 1)) + 1;
    }

    public static int q(int i2) {
        if (i2 > 0) {
            return Integer.highestOneBit(i2);
        }
        throw new IllegalArgumentException();
    }

    public static void r(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException unused) {
            us.pinguo.common.log.a.s("Utils", "unexpected interrupt: " + obj);
        }
    }
}
