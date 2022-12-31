package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.r;
import com.facebook.internal.x;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = "com.facebook.appevents.internal.a";
    private static volatile ScheduledFuture c;

    /* renamed from: f  reason: collision with root package name */
    private static volatile i f2304f;

    /* renamed from: h  reason: collision with root package name */
    private static String f2306h;

    /* renamed from: i  reason: collision with root package name */
    private static long f2307i;

    /* renamed from: k  reason: collision with root package name */
    private static WeakReference<Activity> f2309k;
    private static final ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2302d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static AtomicInteger f2303e = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private static AtomicBoolean f2305g = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private static int f2308j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityLifecycleTracker.java */
    /* renamed from: com.facebook.appevents.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0076a implements FeatureManager.c {
        C0076a() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.appevents.codeless.b.h();
            } else {
                com.facebook.appevents.codeless.b.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityCreated");
            com.facebook.appevents.internal.b.a();
            a.t(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityDestroyed");
            a.u(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityPaused");
            com.facebook.appevents.internal.b.a();
            a.v(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityResumed");
            com.facebook.appevents.internal.b.a();
            a.w(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.c();
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            r.g(LoggingBehavior.APP_EVENTS, a.a, "onActivityStopped");
            AppEventsLogger.j();
            a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (a.f2304f == null) {
                    i unused = a.f2304f = i.h();
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ String b;
        final /* synthetic */ Context c;

        d(long j2, String str, Context context) {
            this.a = j2;
            this.b = str;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (a.f2304f == null) {
                    i unused = a.f2304f = new i(Long.valueOf(this.a), null);
                    j.c(this.b, null, a.f2306h, this.c);
                } else if (a.f2304f.e() != null) {
                    long longValue = this.a - a.f2304f.e().longValue();
                    if (longValue > a.r() * 1000) {
                        j.e(this.b, a.f2304f, a.f2306h);
                        j.c(this.b, null, a.f2306h, this.c);
                        i unused2 = a.f2304f = new i(Long.valueOf(this.a), null);
                    } else if (longValue > 1000) {
                        a.f2304f.i();
                    }
                }
                a.f2304f.j(Long.valueOf(this.a));
                a.f2304f.k();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ String b;

        /* compiled from: ActivityLifecycleTracker.java */
        /* renamed from: com.facebook.appevents.internal.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0077a implements Runnable {
            RunnableC0077a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.facebook.internal.instrument.e.a.c(this)) {
                    return;
                }
                try {
                    if (a.f2304f == null) {
                        i unused = a.f2304f = new i(Long.valueOf(e.this.a), null);
                    }
                    if (a.f2303e.get() <= 0) {
                        j.e(e.this.b, a.f2304f, a.f2306h);
                        i.a();
                        i unused2 = a.f2304f = null;
                    }
                    synchronized (a.f2302d) {
                        ScheduledFuture unused3 = a.c = null;
                    }
                } catch (Throwable th) {
                    com.facebook.internal.instrument.e.a.b(th, this);
                }
            }
        }

        e(long j2, String str) {
            this.a = j2;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (a.f2304f == null) {
                    i unused = a.f2304f = new i(Long.valueOf(this.a), null);
                }
                a.f2304f.j(Long.valueOf(this.a));
                if (a.f2303e.get() <= 0) {
                    RunnableC0077a runnableC0077a = new RunnableC0077a();
                    synchronized (a.f2302d) {
                        ScheduledFuture unused2 = a.c = a.b.schedule(runnableC0077a, a.r(), TimeUnit.SECONDS);
                    }
                }
                long j2 = a.f2307i;
                com.facebook.appevents.internal.c.e(this.b, j2 > 0 ? (this.a - j2) / 1000 : 0L);
                a.f2304f.k();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    static /* synthetic */ int c() {
        int i2 = f2308j;
        f2308j = i2 + 1;
        return i2;
    }

    static /* synthetic */ int d() {
        int i2 = f2308j;
        f2308j = i2 - 1;
        return i2;
    }

    private static void o() {
        synchronized (f2302d) {
            if (c != null) {
                c.cancel(false);
            }
            c = null;
        }
    }

    @Nullable
    public static Activity p() {
        WeakReference<Activity> weakReference = f2309k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static UUID q() {
        if (f2304f != null) {
            return f2304f.d();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r() {
        l j2 = FetchedAppSettingsManager.j(com.facebook.f.g());
        if (j2 == null) {
            return com.facebook.appevents.internal.d.a();
        }
        return j2.l();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean s() {
        return f2308j == 0;
    }

    public static void t(Activity activity) {
        b.execute(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Activity activity) {
        com.facebook.appevents.codeless.b.l(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(Activity activity) {
        if (f2303e.decrementAndGet() < 0) {
            f2303e.set(0);
            Log.w(a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        o();
        long currentTimeMillis = System.currentTimeMillis();
        String r = x.r(activity);
        com.facebook.appevents.codeless.b.m(activity);
        b.execute(new e(currentTimeMillis, r));
    }

    public static void w(Activity activity) {
        f2309k = new WeakReference<>(activity);
        f2303e.incrementAndGet();
        o();
        long currentTimeMillis = System.currentTimeMillis();
        f2307i = currentTimeMillis;
        String r = x.r(activity);
        com.facebook.appevents.codeless.b.n(activity);
        com.facebook.appevents.j.a.d(activity);
        com.facebook.appevents.n.d.h(activity);
        b.execute(new d(currentTimeMillis, r, activity.getApplicationContext()));
    }

    public static void x(Application application, String str) {
        if (f2305g.compareAndSet(false, true)) {
            FeatureManager.a(FeatureManager.Feature.CodelessEvents, new C0076a());
            f2306h = str;
            application.registerActivityLifecycleCallbacks(new b());
        }
    }
}
