package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class b {
    public static com.tencent.bugly.crashreport.biz.a a = null;
    private static boolean b = false;
    private static int c = 10;

    /* renamed from: d  reason: collision with root package name */
    private static long f7808d = 300000;

    /* renamed from: e  reason: collision with root package name */
    private static long f7809e = 30000;

    /* renamed from: f  reason: collision with root package name */
    private static long f7810f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static int f7811g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static long f7812h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static long f7813i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static long f7814j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f7815k = null;

    /* renamed from: l  reason: collision with root package name */
    private static Class<?> f7816l = null;
    private static boolean m = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private /* synthetic */ Context a;
        private /* synthetic */ BuglyStrategy b;

        a(Context context, BuglyStrategy buglyStrategy) {
            this.a = context;
            this.b = buglyStrategy;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.c(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0262b implements Application.ActivityLifecycleCallbacks {
        C0262b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f7816l == null || b.f7816l.getName().equals(name)) {
                x.c(">>> %s onCreated <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b != null) {
                    b.D.add(b.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f7816l == null || b.f7816l.getName().equals(name)) {
                x.c(">>> %s onDestroyed <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b != null) {
                    b.D.add(b.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f7816l == null || b.f7816l.getName().equals(name)) {
                x.c(">>> %s onPaused <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b == null) {
                    return;
                }
                b.D.add(b.a(name, "onPaused"));
                b.a(false);
                long currentTimeMillis = System.currentTimeMillis();
                b.s = currentTimeMillis;
                b.t = currentTimeMillis - b.r;
                long unused = b.f7812h = currentTimeMillis;
                if (b.t < 0) {
                    b.t = 0L;
                }
                if (activity != null) {
                    b.q = "background";
                } else {
                    b.q = "unknown";
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity != null ? activity.getClass().getName() : "unknown";
            if (b.f7816l == null || b.f7816l.getName().equals(name)) {
                x.c(">>> %s onResumed <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b == null) {
                    return;
                }
                b.D.add(b.a(name, "onResumed"));
                b.a(true);
                b.q = name;
                long currentTimeMillis = System.currentTimeMillis();
                b.r = currentTimeMillis;
                b.u = currentTimeMillis - b.f7813i;
                long j2 = b.r - b.f7812h;
                if (j2 > (b.f7810f > 0 ? b.f7810f : b.f7809e)) {
                    b.d();
                    b.g();
                    x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f7809e / 1000));
                    if (b.f7811g % b.c == 0) {
                        b.a.a(4, b.m, 0L);
                        return;
                    }
                    b.a.a(4, false, 0L);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - b.f7814j > b.f7808d) {
                        long unused = b.f7814j = currentTimeMillis2;
                        x.a("add a timer to upload hot start user info", new Object[0]);
                        if (b.m) {
                            w.a().a(new a.c(null, true), b.f7808d);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int g() {
        int i2 = f7811g;
        f7811g = i2 + 1;
        return i2;
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        long j2;
        if (b) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f7818e;
        m = z;
        a = new com.tencent.bugly.crashreport.biz.a(context, z);
        b = true;
        if (buglyStrategy != null) {
            f7816l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new a(context, buglyStrategy), j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
        }
        f7810f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w a2;
        com.tencent.bugly.crashreport.biz.a aVar = a;
        if (aVar != null && !z && (a2 = w.a()) != null) {
            a2.a(new a.b());
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.o;
        if (j2 > 0) {
            f7809e = j2;
        }
        int i2 = strategyBean.t;
        if (i2 > 0) {
            c = i2;
        }
        long j3 = strategyBean.u;
        if (j3 > 0) {
            f7808d = j3;
        }
    }

    public static void a() {
        com.tencent.bugly.crashreport.biz.a aVar = a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f7815k;
                    if (activityLifecycleCallbacks != null) {
                        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    }
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        b = false;
    }
}
