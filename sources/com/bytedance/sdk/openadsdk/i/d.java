package com.bytedance.sdk.openadsdk.i;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: TTThreadPool.java */
/* loaded from: classes.dex */
public class d {
    private static final int a;
    private static final int b;
    private static final int c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f2082d;

    /* renamed from: e  reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f2083e;

    /* renamed from: f  reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f2084f;

    /* renamed from: g  reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f2085g;

    /* renamed from: h  reason: collision with root package name */
    private static final ArrayBlockingQueue<Runnable> f2086h;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = (availableProcessors / 2) + 1 < 4 ? 4 : (availableProcessors / 2) + 1;
        c = (availableProcessors / 2) + 1 < 4 ? 4 : (availableProcessors / 2) + 1;
        f2082d = (availableProcessors / 2) + 1 > 4 ? 4 : (availableProcessors / 2) + 1;
        f2083e = new PriorityBlockingQueue<>();
        f2084f = new PriorityBlockingQueue<>();
        f2085g = new PriorityBlockingQueue<>();
        f2086h = new ArrayBlockingQueue<>(4);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, f2083e, new c(5, "tt-api-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, c, 5L, TimeUnit.SECONDS, f2084f, new c(5, "tt-background-thread-"), f());
    }

    public static ScheduledExecutorService c() {
        return Executors.newSingleThreadScheduledExecutor(new c(1, "tt-delay-thread-"));
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, f2085g, new c(5, "tt-aidl-thread-"), f());
    }

    public static ThreadPoolExecutor e() {
        return new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, f2086h, new c(5, "tt-file-log-upload-thread-"), f());
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.i.d.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
