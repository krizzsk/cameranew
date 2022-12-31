package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public final class j {
    private static Handler c;

    /* renamed from: d  reason: collision with root package name */
    private static HandlerThread f8213d;
    private static Object b = new Object();
    public static final Executor a = c();

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private static class b implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        /* compiled from: ProGuard */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ Runnable a;

            a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.a.run();
                } finally {
                    b.this.a();
                }
            }
        }

        private b() {
            this.a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                j.a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.a.offer(new a(runnable));
            if (this.b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (c == null) {
            synchronized (j.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f8213d = handlerThread;
                handlerThread.start();
                c = new Handler(f8213d.getLooper());
            }
        }
        return c;
    }

    public static Executor b() {
        return new b();
    }

    private static Executor c() {
        Executor threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }
}
