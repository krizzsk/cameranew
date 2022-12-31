package com.facebook.soloader.n;
/* compiled from: NativeLoader.java */
/* loaded from: classes.dex */
public class a {
    private static b a;

    private a() {
    }

    public static synchronized void a(b bVar) {
        synchronized (a.class) {
            if (a == null) {
                a = bVar;
            } else {
                throw new IllegalStateException("Cannot re-initialize NativeLoader.");
            }
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (a.class) {
            if (!c()) {
                a(bVar);
            }
        }
    }

    public static synchronized boolean c() {
        boolean z;
        synchronized (a.class) {
            z = a != null;
        }
        return z;
    }

    public static boolean d(String str) {
        return e(str, 0);
    }

    public static boolean e(String str, int i2) {
        b bVar;
        synchronized (a.class) {
            bVar = a;
            if (bVar == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return bVar.a(str, i2);
    }
}
