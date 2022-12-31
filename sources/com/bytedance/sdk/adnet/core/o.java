package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* compiled from: VNetLog.java */
/* loaded from: classes.dex */
public class o {
    public static boolean a = Log.isLoggable("VNetLog", 2);
    private static String b = "VNetLog";

    public static void a(String str, Object... objArr) {
        if (a) {
            Log.v(b, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(b, e(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(b, e(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(b, e(str, objArr));
    }

    private static String e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(b, e(str, objArr), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VNetLog.java */
    /* loaded from: classes.dex */
    public static class a {
        public static final boolean a = o.a;
        private final List<C0042a> b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: VNetLog.java */
        /* renamed from: com.bytedance.sdk.adnet.core.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0042a {
            public final String a;
            public final long b;
            public final long c;

            public C0042a(String str, long j2, long j3) {
                this.a = str;
                this.b = j2;
                this.c = j3;
            }
        }

        public synchronized void a(String str, long j2) {
            if (!this.c) {
                this.b.add(new C0042a(str, j2, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        protected void finalize() throws Throwable {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            o.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j2 = this.b.get(0).c;
            o.b("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C0042a c0042a : this.b) {
                long j3 = c0042a.c;
                o.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0042a.b), c0042a.a);
                j2 = j3;
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            long j2 = this.b.get(0).c;
            List<C0042a> list = this.b;
            return list.get(list.size() - 1).c - j2;
        }
    }
}
