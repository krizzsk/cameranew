package com.facebook.internal;

import android.util.Log;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.report.Issue;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f3077e = new HashMap<>();
    private final LoggingBehavior a;
    private final String b;
    private StringBuilder c;

    /* renamed from: d  reason: collision with root package name */
    private int f3078d = 3;

    public r(LoggingBehavior loggingBehavior, String str) {
        y.m(str, Issue.ISSUE_REPORT_TAG);
        this.a = loggingBehavior;
        this.b = "FacebookSDK." + str;
        this.c = new StringBuilder();
    }

    public static void e(LoggingBehavior loggingBehavior, int i2, String str, String str2) {
        if (com.facebook.f.B(loggingBehavior)) {
            String l2 = l(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i2, str, l2);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    public static void f(LoggingBehavior loggingBehavior, int i2, String str, String str2, Object... objArr) {
        if (com.facebook.f.B(loggingBehavior)) {
            e(loggingBehavior, i2, str, String.format(str2, objArr));
        }
    }

    public static void g(LoggingBehavior loggingBehavior, String str, String str2) {
        e(loggingBehavior, 3, str, str2);
    }

    public static void h(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        if (com.facebook.f.B(loggingBehavior)) {
            e(loggingBehavior, 3, str, String.format(str2, objArr));
        }
    }

    public static synchronized void j(String str) {
        synchronized (r.class) {
            if (!com.facebook.f.B(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                k(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static synchronized void k(String str, String str2) {
        synchronized (r.class) {
            f3077e.put(str, str2);
        }
    }

    private static synchronized String l(String str) {
        synchronized (r.class) {
            for (Map.Entry<String, String> entry : f3077e.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    private boolean m() {
        return com.facebook.f.B(this.a);
    }

    public void a(String str) {
        if (m()) {
            this.c.append(str);
        }
    }

    public void b(String str, Object... objArr) {
        if (m()) {
            this.c.append(String.format(str, objArr));
        }
    }

    public void c(String str, Object obj) {
        b("  %s:\t%s\n", str, obj);
    }

    public void d() {
        i(this.c.toString());
        this.c = new StringBuilder();
    }

    public void i(String str) {
        e(this.a, this.f3078d, this.b, str);
    }
}
