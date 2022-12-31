package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ImageLoaderIoTaskExecutor.java */
/* loaded from: classes3.dex */
public class e implements Executor {
    private final ThreadPoolExecutor a;
    private final ThreadPoolExecutor b;

    /* compiled from: ImageLoaderIoTaskExecutor.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            a = iArr;
            try {
                iArr[ImageDownloader.Scheme.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageDownloader.Scheme.CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageDownloader.Scheme.ASSETS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageDownloader.Scheme.HTTP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageDownloader.Scheme.HTTPS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public e(int i2, int i3, int i4) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = new ThreadPoolExecutor(i3, i3, 0L, timeUnit, new LIFOLinkedBlockingDeque(), us.pinguo.common.imageloader.a.e(i4, "uil-net-pool-"));
        this.b = new ThreadPoolExecutor(i2, i2, 0L, timeUnit, new LIFOLinkedBlockingDeque(), us.pinguo.common.imageloader.a.e(i4, "uil-file-pool-"));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (!(runnable instanceof LoadAndDisplayImageTask)) {
            this.a.execute(runnable);
            return;
        }
        String n = ((LoadAndDisplayImageTask) runnable).n();
        if (n == null) {
            this.a.execute(runnable);
            return;
        }
        int i2 = a.a[ImageDownloader.Scheme.ofUri(n).ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            this.a.execute(runnable);
        } else {
            this.b.execute(runnable);
        }
    }
}
