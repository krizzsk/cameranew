package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultConfigurationFactory.java */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultConfigurationFactory.java */
    /* renamed from: com.nostra13.universalimageloader.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class ThreadFactoryC0226a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        private static final AtomicInteger f5923e = new AtomicInteger(1);
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5924d;
        private final AtomicInteger b = new AtomicInteger(1);
        private final ThreadGroup a = Thread.currentThread().getThreadGroup();

        ThreadFactoryC0226a(int i2, String str) {
            this.f5924d = i2;
            this.c = str + f5923e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f5924d);
            return thread;
        }
    }

    public static com.nostra13.universalimageloader.core.i.a a() {
        return new com.nostra13.universalimageloader.core.i.b();
    }

    public static d.f.a.a.a.b b(Context context, d.f.a.a.a.d.a aVar, long j2, int i2) {
        File h2 = h(context);
        if (j2 > 0 || i2 > 0) {
            try {
                return new d.f.a.a.a.c.c.b(d.f.a.b.f.d(context), h2, aVar, j2, i2);
            } catch (IOException e2) {
                d.f.a.b.d.c(e2);
            }
        }
        return new d.f.a.a.a.c.b(d.f.a.b.f.a(context), h2, aVar);
    }

    public static Executor c(int i2, int i3, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), j(i3, "uil-pool-"));
    }

    public static d.f.a.a.a.d.a d() {
        return new d.f.a.a.a.d.b();
    }

    public static com.nostra13.universalimageloader.core.h.b e(boolean z) {
        return new com.nostra13.universalimageloader.core.h.a(z);
    }

    public static ImageDownloader f(Context context) {
        return new BaseImageDownloader(context);
    }

    public static d.f.a.a.b.a g(int i2) {
        if (i2 == 0) {
            i2 = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new d.f.a.a.b.c.b(i2);
    }

    private static File h(Context context) {
        File b = d.f.a.b.f.b(context, false);
        File file = new File(b, "uil-images");
        return (file.exists() || file.mkdir()) ? file : b;
    }

    public static Executor i() {
        return Executors.newCachedThreadPool(j(5, "uil-pool-d-"));
    }

    private static ThreadFactory j(int i2, String str) {
        return new ThreadFactoryC0226a(i2, str);
    }
}
