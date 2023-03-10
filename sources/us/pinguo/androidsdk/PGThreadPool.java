package us.pinguo.androidsdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class PGThreadPool {
    private static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    private static PGThreadPool self;

    public static PGThreadPool getInstance() {
        if (self == null) {
            self = new PGThreadPool();
        }
        return self;
    }

    public void execute(Runnable runnable) {
        cacheThreadPool.execute(runnable);
    }
}
