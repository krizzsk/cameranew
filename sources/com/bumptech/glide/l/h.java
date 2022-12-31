package com.bumptech.glide.l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class h {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a() {
        if (!i()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static String b(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & Draft_75.END_OF_FRAME;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> c(int i2) {
        return new ArrayDeque(i2);
    }

    public static int d(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * f(config);
    }

    @TargetApi(19)
    public static int e(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    private static int f(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? 2 : 4;
        }
        return 1;
    }

    public static <T> List<T> g(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static boolean h() {
        return !i();
    }

    public static boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean j(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean k(int i2, int i3) {
        return j(i2) && j(i3);
    }

    public static String l(byte[] bArr) {
        String b2;
        char[] cArr = b;
        synchronized (cArr) {
            b2 = b(bArr, cArr);
        }
        return b2;
    }
}
