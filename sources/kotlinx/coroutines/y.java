package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
/* compiled from: CommonPool.kt */
/* loaded from: classes3.dex */
public final class y extends ExecutorCoroutineDispatcher {
    public static final y a = new y();
    private static final int b;
    private static boolean c;
    private static volatile Executor pool;

    static {
        String str;
        Integer h2;
        int intValue;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            intValue = -1;
        } else {
            h2 = kotlin.text.s.h(str);
            if (h2 != null && h2.intValue() >= 1) {
                intValue = h2.intValue();
            } else {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
        }
        b = intValue;
    }

    private y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread A(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, kotlin.jvm.internal.s.q("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.concurrent.ExecutorService Q() {
        /*
            r6 = this;
            java.lang.SecurityManager r0 = java.lang.System.getSecurityManager()
            if (r0 == 0) goto Lb
            java.util.concurrent.ExecutorService r0 = r6.z()
            return r0
        Lb:
            r0 = 0
            java.lang.String r1 = "java.util.concurrent.ForkJoinPool"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L13
            goto L14
        L13:
            r1 = r0
        L14:
            if (r1 != 0) goto L1b
            java.util.concurrent.ExecutorService r0 = r6.z()
            return r0
        L1b:
            boolean r2 = kotlinx.coroutines.y.c
            r3 = 0
            if (r2 != 0) goto L4b
            int r2 = kotlinx.coroutines.y.b
            if (r2 >= 0) goto L4b
            java.lang.String r2 = "commonPool"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L39
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch: java.lang.Throwable -> L39
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L39
            java.lang.Object r2 = r2.invoke(r0, r4)     // Catch: java.lang.Throwable -> L39
            boolean r4 = r2 instanceof java.util.concurrent.ExecutorService     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L39
            java.util.concurrent.ExecutorService r2 = (java.util.concurrent.ExecutorService) r2     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
            r2 = r0
        L3a:
            if (r2 != 0) goto L3d
            goto L4b
        L3d:
            kotlinx.coroutines.y r4 = kotlinx.coroutines.y.a
            boolean r4 = r4.T(r1, r2)
            if (r4 == 0) goto L46
            goto L47
        L46:
            r2 = r0
        L47:
            if (r2 != 0) goto L4a
            goto L4b
        L4a:
            return r2
        L4b:
            r2 = 1
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L70
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L70
            r4[r3] = r5     // Catch: java.lang.Throwable -> L70
            java.lang.reflect.Constructor r1 = r1.getConstructor(r4)     // Catch: java.lang.Throwable -> L70
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L70
            kotlinx.coroutines.y r4 = kotlinx.coroutines.y.a     // Catch: java.lang.Throwable -> L70
            int r4 = r4.S()     // Catch: java.lang.Throwable -> L70
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L70
            r2[r3] = r4     // Catch: java.lang.Throwable -> L70
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.Throwable -> L70
            boolean r2 = r1 instanceof java.util.concurrent.ExecutorService     // Catch: java.lang.Throwable -> L70
            if (r2 == 0) goto L71
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1     // Catch: java.lang.Throwable -> L70
            r0 = r1
            goto L71
        L70:
        L71:
            if (r0 != 0) goto L77
            java.util.concurrent.ExecutorService r0 = r6.z()
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.y.Q():java.util.concurrent.ExecutorService");
    }

    private final synchronized Executor R() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = Q();
            pool = executor;
        }
        return executor;
    }

    private final int S() {
        int a2;
        Integer valueOf = Integer.valueOf(b);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf == null) {
            a2 = kotlin.z.j.a(Runtime.getRuntime().availableProcessors() - 1, 1);
            return a2;
        }
        return valueOf.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
    }

    private final ExecutorService z() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return Executors.newFixedThreadPool(S(), new ThreadFactory() { // from class: kotlinx.coroutines.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread A;
                A = y.A(atomicInteger, runnable);
                return A;
            }
        });
    }

    public final boolean T(Class<?> cls, ExecutorService executorService) {
        executorService.submit(a.a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = R();
            }
            d a2 = e.a();
            executor.execute(a2 == null ? runnable : a2.h(runnable));
        } catch (RejectedExecutionException unused) {
            d a3 = e.a();
            if (a3 != null) {
                a3.e();
            }
            q0.f8788f.f0(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }
}
