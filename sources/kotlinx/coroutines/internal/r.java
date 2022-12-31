package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public class r<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public r(boolean z) {
        this._cur = new s(8, z);
    }

    public final boolean a(E e2) {
        while (true) {
            s sVar = (s) this._cur;
            int a2 = sVar.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.compareAndSet(this, sVar, sVar.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            s sVar = (s) this._cur;
            if (sVar.d()) {
                return;
            }
            a.compareAndSet(this, sVar, sVar.i());
        }
    }

    public final int c() {
        return ((s) this._cur).f();
    }

    public final E d() {
        while (true) {
            s sVar = (s) this._cur;
            E e2 = (E) sVar.j();
            if (e2 != s.f8775h) {
                return e2;
            }
            a.compareAndSet(this, sVar, sVar.i());
        }
    }
}
