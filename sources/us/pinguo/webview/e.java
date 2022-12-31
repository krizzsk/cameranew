package us.pinguo.webview;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: PGWebViewUtil.java */
/* loaded from: classes6.dex */
public final class e {

    /* compiled from: PGWebViewUtil.java */
    /* loaded from: classes6.dex */
    private static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private static final AtomicInteger f12494e = new AtomicInteger(1);
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12495d;
        private final AtomicInteger b = new AtomicInteger(1);
        private final ThreadGroup a = Thread.currentThread().getThreadGroup();

        a(int i2, String str) {
            this.f12495d = i2;
            this.c = str + f12494e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f12495d);
            return thread;
        }
    }

    public static ThreadPoolExecutor a(int i2, int i3) {
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(i3, "uil-pool-"));
    }
}
