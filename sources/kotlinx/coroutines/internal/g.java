package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.o0;
/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes3.dex */
public abstract class g<N extends g<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    public g(N n) {
        this._prev = n;
    }

    private final N c() {
        N f2 = f();
        while (f2 != null && f2.g()) {
            f2 = (N) f2._prev;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        if (!o0.a() || (!i())) {
            N d2 = d();
            kotlin.jvm.internal.s.e(d2);
            while (d2.g()) {
                d2 = (N) d2.d();
                kotlin.jvm.internal.s.e(d2);
            }
            return d2;
        }
        throw new AssertionError();
    }

    public final void b() {
        b.lazySet(this, null);
    }

    public final N d() {
        c0 c0Var;
        Object e2 = e();
        c0Var = f.a;
        if (e2 == c0Var) {
            return null;
        }
        return (N) e2;
    }

    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final void j() {
        if (o0.a() && !g()) {
            throw new AssertionError();
        }
        if (o0.a() && !(!i())) {
            throw new AssertionError();
        }
        while (true) {
            N c = c();
            N h2 = h();
            h2._prev = c;
            if (c != null) {
                c._next = h2;
            }
            if (!h2.g() && (c == null || !c.g())) {
                return;
            }
        }
    }

    public final boolean k(N n) {
        return a.compareAndSet(this, null, n);
    }
}
