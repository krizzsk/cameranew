package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static <T> T awaitEvenIfOnMainThread(g<T> gVar) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        gVar.f(TASK_CONTINUATION_EXECUTOR_SERVICE, Utils$$Lambda$1.lambdaFactory$(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (gVar.n()) {
            return gVar.j();
        }
        if (!gVar.l()) {
            if (gVar.m()) {
                throw new IllegalStateException(gVar.i());
            }
            throw new TimeoutException();
        }
        throw new CancellationException("Task is already canceled");
    }

    public static <T> g<T> callTask(Executor executor, final Callable<g<T>> callable) {
        final h hVar = new h();
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.Utils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((g) callable.call()).e(new a<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.Utils.2.1
                        @Override // com.google.android.gms.tasks.a
                        public Void then(@NonNull g<T> gVar) throws Exception {
                            if (gVar.n()) {
                                hVar.c(gVar.j());
                                return null;
                            }
                            hVar.b(gVar.i());
                            return null;
                        }
                    });
                } catch (Exception e2) {
                    hVar.b(e2);
                }
            }
        });
        return hVar.a();
    }

    public static <T> g<T> race(g<T> gVar, g<T> gVar2) {
        final h hVar = new h();
        a aVar = (a<T, Void>) new a<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.Utils.1
            @Override // com.google.android.gms.tasks.a
            public Void then(@NonNull g<T> gVar3) throws Exception {
                if (gVar3.n()) {
                    h.this.e(gVar3.j());
                    return null;
                }
                h.this.d(gVar3.i());
                return null;
            }
        };
        gVar.e(aVar);
        gVar2.e(aVar);
        return hVar.a();
    }
}
