package cn.sharesdk.framework.loopshare.watermark;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ThreadPoolUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    private static BlockingQueue<Runnable> f143d = new ArrayBlockingQueue(10);

    /* renamed from: e  reason: collision with root package name */
    private static ThreadFactory f144e = new ThreadFactory() { // from class: cn.sharesdk.framework.loopshare.watermark.f.1
        private final AtomicInteger a = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "myThreadPool thread:" + this.a.getAndIncrement());
        }
    };
    private static int a = 5;
    private static int b = 100;
    private static int c = 10000;

    /* renamed from: f  reason: collision with root package name */
    private static ThreadPoolExecutor f145f = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, f143d, f144e);

    public static void a(Runnable runnable) {
        f145f.execute(runnable);
    }
}
