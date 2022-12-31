package us.pinguo.common.imageloader;

import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ImageLoaderExecutorFactory.java */
/* loaded from: classes4.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageLoaderExecutorFactory.java */
    /* renamed from: us.pinguo.common.imageloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class ThreadFactoryC0380a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private static final AtomicInteger f9927e = new AtomicInteger(1);
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9928d;
        private final AtomicInteger b = new AtomicInteger(1);
        private final ThreadGroup a = Thread.currentThread().getThreadGroup();

        ThreadFactoryC0380a(int i2, String str) {
            this.f9928d = i2;
            this.c = str + f9927e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f9928d);
            return thread;
        }
    }

    public static Executor a() {
        return b(3, 3);
    }

    public static Executor b(int i2, int i3) {
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new LIFOLinkedBlockingDeque(), e(i3, "uil-cache-pool-"));
    }

    public static Executor c() {
        return d(true, 6, 3);
    }

    public static Executor d(boolean z, int i2, int i3) {
        if (z) {
            int i4 = i2 / 3;
            if (i4 < 1) {
                i4 = 1;
            }
            if (i4 > 2) {
                i4 = 2;
            }
            int i5 = i2 - i4;
            return new e(i4, i5 >= 2 ? i5 : 2, i3);
        }
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new LIFOLinkedBlockingDeque(), e(i3, "uil-file-pool-"));
    }

    public static ThreadFactory e(int i2, String str) {
        return new ThreadFactoryC0380a(i2, str);
    }
}
