package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.openadsdk.utils.o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: TTExecutor.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private static volatile ThreadPoolExecutor b;
    private static volatile ThreadPoolExecutor c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f2072d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f2073e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile ScheduledExecutorService f2074f;

    /* renamed from: g  reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f2075g;

    /* renamed from: h  reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f2076h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f2077i = new ConcurrentHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f2078j = new ConcurrentHashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicBoolean f2079k = new AtomicBoolean();

    private a() {
        if (f2079k.get()) {
            return;
        }
        a(false);
    }

    public static void a(boolean z) {
        AtomicBoolean atomicBoolean = f2079k;
        if (atomicBoolean.get()) {
            return;
        }
        b = d.a();
        c = d.b();
        f2074f = d.c();
        f2073e = d.e();
        if (z) {
            f2072d = d.d();
            f2075g = new ConcurrentHashMap<>();
        }
        atomicBoolean.set(true);
    }

    private void c() {
        if (f2072d == null) {
            f2072d = d.d();
            f2075g = new ConcurrentHashMap<>();
        }
    }

    public ExecutorService b() {
        return b;
    }

    public void b(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "executeDefaultTask -> runnable param is not be null");
            }
        } else if (c != null) {
            c.execute(new b(i2) { // from class: com.bytedance.sdk.openadsdk.i.a.2
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "executeAIDLTask -> runnable param is not be null");
                return;
            }
            return;
        }
        c();
        f2072d.execute(new b(i2) { // from class: com.bytedance.sdk.openadsdk.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    public ScheduledFuture<?> a(Runnable runnable, long j2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "delayExecuteTask->runnable param is not be null");
            }
            return null;
        } else if (j2 <= 0) {
            f2074f.execute(runnable);
            return null;
        } else {
            return f2074f.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }
}
