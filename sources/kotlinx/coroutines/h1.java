package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.g1;
/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public abstract class h1 extends f1 {
    protected abstract Thread Z();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a0(long j2, g1.c cVar) {
        if (o0.a()) {
            if (!(this != q0.f8788f)) {
                throw new AssertionError();
            }
        }
        q0.f8788f.k0(j2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b0() {
        Thread Z = Z();
        if (Thread.currentThread() != Z) {
            d a = e.a();
            if (a == null) {
                LockSupport.unpark(Z);
            } else {
                a.f(Z);
            }
        }
    }
}
