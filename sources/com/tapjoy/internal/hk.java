package com.tapjoy.internal;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public abstract class hk {
    protected static a a;
    private static hk b;

    /* loaded from: classes3.dex */
    public static class a {
        public final String a;
        public final String b;
        public final long c = SystemClock.elapsedRealtime();

        /* renamed from: d  reason: collision with root package name */
        public final fi f7626d = new fi(60000);

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(hk hkVar) {
        synchronized (hk.class) {
            b = hkVar;
            a aVar = a;
            if (aVar != null) {
                a = null;
                hkVar.a(aVar);
            }
        }
    }

    public static boolean c() {
        hk hkVar = b;
        if (hkVar == null || !hkVar.b()) {
            a aVar = a;
            return (aVar == null || aVar.f7626d.a()) ? false : true;
        }
        return true;
    }

    public abstract void a(a aVar);

    public abstract boolean b();

    public static void a(String str, String str2) {
        synchronized (hk.class) {
            a aVar = new a(str, str2);
            hk hkVar = b;
            if (hkVar != null) {
                a = null;
                hkVar.a(aVar);
            } else {
                a = aVar;
            }
        }
    }
}
