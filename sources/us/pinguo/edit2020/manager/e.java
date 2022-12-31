package us.pinguo.edit2020.manager;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlin.z.j;
/* compiled from: FaceDetectorCache.kt */
/* loaded from: classes4.dex */
public final class e {
    private static ExecutorService b;

    /* renamed from: d  reason: collision with root package name */
    private static final int f10536d;
    public static final e a = new e();
    private static final Object c = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static HashMap<String, Future<us.pinguo.facedetector.c>> f10537e = new HashMap<>();

    static {
        int c2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        c2 = j.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
        f10536d = c2;
    }

    private e() {
    }

    private final ExecutorService d() {
        ExecutorService executorService;
        ExecutorService executorService2 = b;
        if (executorService2 == null) {
            synchronized (c) {
                executorService = b;
                if (executorService == null) {
                    executorService = Executors.newSingleThreadExecutor();
                    b = executorService;
                }
                u uVar = u.a;
            }
            executorService2 = executorService;
        }
        s.e(executorService2);
        return executorService2;
    }

    public final us.pinguo.facedetector.c a(String path, int i2) {
        s.h(path, "path");
        if (f10537e.get(path) != null) {
            Future<us.pinguo.facedetector.c> future = f10537e.get(path);
            if (future == null) {
                return null;
            }
            return future.get();
        }
        ExecutorService d2 = d();
        f fVar = new f(path, f10536d, i2);
        HashMap<String, Future<us.pinguo.facedetector.c>> hashMap = f10537e;
        Future<us.pinguo.facedetector.c> submit = d2.submit(fVar);
        s.g(submit, "exe.submit(callable)");
        hashMap.put(path, submit);
        Future<us.pinguo.facedetector.c> future2 = f10537e.get(path);
        if (future2 == null) {
            return null;
        }
        return future2.get();
    }

    public final void b() {
        f10537e.clear();
        ExecutorService executorService = b;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        b = null;
    }

    public final us.pinguo.facedetector.c c(String path) {
        s.h(path, "path");
        Future<us.pinguo.facedetector.c> future = f10537e.get(path);
        if (future == null) {
            return null;
        }
        return future.get();
    }
}
