package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.o0;
/* compiled from: ConflatedChannel.kt */
/* loaded from: classes3.dex */
public class k<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f8726d;

    /* renamed from: e  reason: collision with root package name */
    private Object f8727e;

    public k(kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(lVar);
        this.f8726d = new ReentrantLock();
        this.f8727e = a.a;
    }

    private final UndeliveredElementException e0(Object obj) {
        kotlin.jvm.b.l<E, kotlin.u> lVar;
        Object obj2 = this.f8727e;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != a.a && (lVar = this.a) != null) {
            undeliveredElementException = OnUndeliveredElementKt.d(lVar, obj2, null, 2, null);
        }
        this.f8727e = obj;
        return undeliveredElementException;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean O(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f8726d;
        reentrantLock.lock();
        try {
            return super.O(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean Q() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean R() {
        return this.f8727e == a.a;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void U(boolean z) {
        ReentrantLock reentrantLock = this.f8726d;
        reentrantLock.lock();
        try {
            UndeliveredElementException e0 = e0(a.a);
            kotlin.u uVar = kotlin.u.a;
            reentrantLock.unlock();
            super.U(z);
            if (e0 != null) {
                throw e0;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object Y() {
        ReentrantLock reentrantLock = this.f8726d;
        reentrantLock.lock();
        try {
            Object obj = this.f8727e;
            c0 c0Var = a.a;
            if (obj != c0Var) {
                this.f8727e = c0Var;
                kotlin.u uVar = kotlin.u.a;
                return obj;
            }
            Object i2 = i();
            if (i2 == null) {
                i2 = a.f8715d;
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object Z(kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f8726d;
        reentrantLock.lock();
        try {
            Object obj = this.f8727e;
            c0 c0Var = a.a;
            if (obj == c0Var) {
                Object i2 = i();
                if (i2 == null) {
                    i2 = a.f8715d;
                }
                return i2;
            } else if (!fVar.n()) {
                return kotlinx.coroutines.selects.g.d();
            } else {
                Object obj2 = this.f8727e;
                this.f8727e = c0Var;
                kotlin.u uVar = kotlin.u.a;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    protected String g() {
        return "(value=" + this.f8727e + ')';
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean t() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected Object x(E e2) {
        p<E> G;
        c0 r;
        ReentrantLock reentrantLock = this.f8726d;
        reentrantLock.lock();
        try {
            j<?> i2 = i();
            if (i2 == null) {
                if (this.f8727e == a.a) {
                    do {
                        G = G();
                        if (G != null) {
                            if (G instanceof j) {
                                return G;
                            }
                            r = G.r(e2, null);
                        }
                    } while (r == null);
                    if (o0.a()) {
                        if (!(r == kotlinx.coroutines.r.a)) {
                            throw new AssertionError();
                        }
                    }
                    kotlin.u uVar = kotlin.u.a;
                    reentrantLock.unlock();
                    G.i(e2);
                    return G.a();
                }
                UndeliveredElementException e0 = e0(e2);
                if (e0 == null) {
                    return a.b;
                }
                throw e0;
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }
}
