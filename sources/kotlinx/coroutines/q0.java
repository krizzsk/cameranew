package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
/* compiled from: DefaultExecutor.kt */
/* loaded from: classes3.dex */
public final class q0 extends g1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: f  reason: collision with root package name */
    public static final q0 f8788f;

    /* renamed from: g  reason: collision with root package name */
    private static final long f8789g;

    static {
        Long l2;
        q0 q0Var = new q0();
        f8788f = q0Var;
        f1.T(q0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f8789g = timeUnit.toNanos(l2.longValue());
    }

    private q0() {
    }

    private final synchronized void p0() {
        if (r0()) {
            debugStatus = 3;
            j0();
            notifyAll();
        }
    }

    private final synchronized Thread q0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean r0() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean s0() {
        if (r0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.h1
    protected Thread Z() {
        Thread thread = _thread;
        return thread == null ? q0() : thread;
    }

    @Override // kotlinx.coroutines.g1, kotlinx.coroutines.u0
    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return m0(j2, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean h0;
        v2.a.d(this);
        d a = e.a();
        if (a != null) {
            a.c();
        }
        try {
            if (!s0()) {
                if (h0) {
                    return;
                }
                return;
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long W = W();
                if (W == LocationRequestCompat.PASSIVE_INTERVAL) {
                    d a2 = e.a();
                    long nanoTime = a2 == null ? System.nanoTime() : a2.a();
                    if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                        j2 = f8789g + nanoTime;
                    }
                    long j3 = j2 - nanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        p0();
                        d a3 = e.a();
                        if (a3 != null) {
                            a3.g();
                        }
                        if (h0()) {
                            return;
                        }
                        Z();
                        return;
                    }
                    W = kotlin.z.j.d(W, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (W > 0) {
                    if (r0()) {
                        _thread = null;
                        p0();
                        d a4 = e.a();
                        if (a4 != null) {
                            a4.g();
                        }
                        if (h0()) {
                            return;
                        }
                        Z();
                        return;
                    }
                    d a5 = e.a();
                    if (a5 == null) {
                        LockSupport.parkNanos(this, W);
                    } else {
                        a5.b(this, W);
                    }
                }
            }
        } finally {
            _thread = null;
            p0();
            d a6 = e.a();
            if (a6 != null) {
                a6.g();
            }
            if (!h0()) {
                Z();
            }
        }
    }
}
