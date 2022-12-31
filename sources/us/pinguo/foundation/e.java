package us.pinguo.foundation;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import us.pinguo.foundation.statistics.l;
/* compiled from: Foundation.java */
/* loaded from: classes4.dex */
public class e {
    private static Context a;
    private static volatile Handler b;

    private static void a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new Handler(Looper.getMainLooper());
                }
            }
        }
    }

    public static Context b() {
        return a;
    }

    public static void c(Runnable runnable, long j2) {
        a();
        b.postDelayed(runnable, j2);
    }

    public static void d(Runnable runnable) {
        a();
        b.removeCallbacks(runnable);
    }

    public static void e(Throwable th) {
        l.g(b(), th);
    }

    public static void f(Application application) {
        a = application.getApplicationContext();
    }
}
