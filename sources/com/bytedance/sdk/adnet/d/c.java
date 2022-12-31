package com.bytedance.sdk.adnet.d;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class c {
    private a a;
    private b b;

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* compiled from: Logger.java */
    /* renamed from: com.bytedance.sdk.adnet.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0043c {
        private static final c a = new c();
    }

    public static void a(a aVar) {
        synchronized (c.class) {
            C0043c.a.a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0043c.a.a.compareTo(a.DEBUG) <= 0) {
            C0043c.a.b.b(str, str2);
        }
    }

    private c() {
        this.a = a.OFF;
        this.b = new com.bytedance.sdk.adnet.d.a();
    }

    public static void a(String str, String str2) {
        if (C0043c.a.a.compareTo(a.ERROR) <= 0) {
            C0043c.a.b.a(str, str2);
        }
    }
}
