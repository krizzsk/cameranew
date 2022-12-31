package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class hn {

    /* renamed from: e  reason: collision with root package name */
    private static String f7630e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f7631f;
    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
    public static final CountDownLatch b = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private static final Runnable f7629d = new Runnable() { // from class: com.tapjoy.internal.hn.1
        @Override // java.lang.Runnable
        public final void run() {
            if (v.c()) {
                hn.b.countDown();
            } else if (v.a()) {
                hn.b.countDown();
            } else {
                hn.a.schedule(this, 300L, TimeUnit.SECONDS);
            }
        }
    };
    public static final CountDownLatch c = new CountDownLatch(1);

    public static void a() {
        a.execute(f7629d);
    }

    public static String b() {
        return f7630e;
    }

    public static boolean c() {
        return f7631f;
    }

    public static void a(String str, boolean z) {
        f7630e = str;
        f7631f = z;
        c.countDown();
    }
}
