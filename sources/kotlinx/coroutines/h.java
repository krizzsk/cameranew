package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final class h<T> extends c<T> {
    private final Thread c;

    /* renamed from: d  reason: collision with root package name */
    private final f1 f8762d;

    public h(CoroutineContext coroutineContext, Thread thread, f1 f1Var) {
        super(coroutineContext, true, true);
        this.c = thread;
        this.f8762d = f1Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.c2
    public void K(Object obj) {
        if (kotlin.jvm.internal.s.c(Thread.currentThread(), this.c)) {
            return;
        }
        Thread thread = this.c;
        d a = e.a();
        if (a == null) {
            LockSupport.unpark(thread);
        } else {
            a.f(thread);
        }
    }

    public final T S0() {
        d a = e.a();
        if (a != null) {
            a.c();
        }
        try {
            f1 f1Var = this.f8762d;
            if (f1Var != null) {
                f1.T(f1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                f1 f1Var2 = this.f8762d;
                long W = f1Var2 == null ? LocationRequestCompat.PASSIVE_INTERVAL : f1Var2.W();
                if (d()) {
                    f1 f1Var3 = this.f8762d;
                    if (f1Var3 != null) {
                        f1.z(f1Var3, false, 1, null);
                    }
                    T t = (T) d2.h(h0());
                    c0 c0Var = t instanceof c0 ? (c0) t : null;
                    if (c0Var == null) {
                        return t;
                    }
                    throw c0Var.a;
                }
                d a2 = e.a();
                if (a2 == null) {
                    LockSupport.parkNanos(this, W);
                } else {
                    a2.b(this, W);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            P(interruptedException);
            throw interruptedException;
        } finally {
            d a3 = e.a();
            if (a3 != null) {
                a3.g();
            }
        }
    }

    @Override // kotlinx.coroutines.c2
    protected boolean l0() {
        return true;
    }
}
