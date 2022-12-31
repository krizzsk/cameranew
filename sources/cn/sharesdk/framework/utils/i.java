package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ThreadPoolManager.java */
/* loaded from: classes.dex */
public class i {
    public static ThreadPoolExecutor a;

    /* compiled from: ThreadPoolManager.java */
    /* loaded from: classes.dex */
    public static abstract class a implements Runnable {
        public abstract void a() throws Throwable;

        public void a(Throwable th) {
        }

        public String b() {
            return "";
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!TextUtils.isEmpty(b())) {
                    Thread.currentThread().setName(b());
                }
                a();
            } catch (Throwable th) {
                try {
                    a(th);
                } catch (Throwable unused) {
                }
                SSDKLog.b().e(th);
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }
}
