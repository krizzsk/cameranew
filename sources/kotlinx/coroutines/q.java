package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.v1;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
public class q<T> extends w0<T> implements p<T>, CoroutineStackFrame {

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8783g = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decision");

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f8784h = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: d  reason: collision with root package name */
    private final Continuation<T> f8785d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineContext f8786e;

    /* renamed from: f  reason: collision with root package name */
    private b1 f8787f;

    /* JADX WARN: Multi-variable type inference failed */
    public q(Continuation<? super T> continuation, int i2) {
        super(i2);
        this.f8785d = continuation;
        if (o0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.f8786e = continuation.getContext();
        this._decision = 0;
        this._state = f.a;
    }

    private final boolean C() {
        return x0.c(this.c) && ((kotlinx.coroutines.internal.i) this.f8785d).p();
    }

    private final n D(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        return lVar instanceof n ? (n) lVar : new s1(lVar);
    }

    private final void E(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void I() {
        Continuation<T> continuation = this.f8785d;
        kotlinx.coroutines.internal.i iVar = continuation instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) continuation : null;
        Throwable s = iVar != null ? iVar.s(this) : null;
        if (s == null) {
            return;
        }
        q();
        l(s);
    }

    private final void K(Object obj, int i2, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof j2) {
            } else {
                if (obj2 instanceof t) {
                    t tVar = (t) obj2;
                    if (tVar.c()) {
                        if (lVar == null) {
                            return;
                        }
                        o(lVar, tVar.a);
                        return;
                    }
                }
                j(obj);
                throw null;
            }
        } while (!f8784h.compareAndSet(this, obj2, M((j2) obj2, obj, i2, lVar, null)));
        r();
        s(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void L(q qVar, Object obj, int i2, kotlin.jvm.b.l lVar, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        qVar.K(obj, i2, lVar);
    }

    private final Object M(j2 j2Var, Object obj, int i2, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Object obj2) {
        if (obj instanceof c0) {
            if (o0.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (o0.a()) {
                if (lVar == null) {
                    return obj;
                }
                throw new AssertionError();
            }
            return obj;
        } else if (x0.b(i2) || obj2 != null) {
            if (lVar != null || (((j2Var instanceof n) && !(j2Var instanceof g)) || obj2 != null)) {
                return new b0(obj, j2Var instanceof n ? (n) j2Var : null, lVar, obj2, null, 16, null);
            }
            return obj;
        } else {
            return obj;
        }
    }

    private final boolean N() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f8783g.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.c0 O(Object obj, Object obj2, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof j2) {
            } else if (!(obj3 instanceof b0) || obj2 == null) {
                return null;
            } else {
                b0 b0Var = (b0) obj3;
                if (b0Var.f8695d == obj2) {
                    if (!o0.a() || kotlin.jvm.internal.s.c(b0Var.a, obj)) {
                        return r.a;
                    }
                    throw new AssertionError();
                }
                return null;
            }
        } while (!f8784h.compareAndSet(this, obj3, M((j2) obj3, obj, this.c, lVar, obj2)));
        r();
        return r.a;
    }

    private final boolean P() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f8783g.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void j(Object obj) {
        throw new IllegalStateException(kotlin.jvm.internal.s.q("Already resumed, but proposed with update ", obj).toString());
    }

    private final void m(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            j0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.q("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    private final boolean p(Throwable th) {
        if (C()) {
            return ((kotlinx.coroutines.internal.i) this.f8785d).q(th);
        }
        return false;
    }

    private final void r() {
        if (C()) {
            return;
        }
        q();
    }

    private final void s(int i2) {
        if (N()) {
            return;
        }
        x0.a(this, i2);
    }

    private final String w() {
        Object v = v();
        return v instanceof j2 ? "Active" : v instanceof t ? "Cancelled" : "Completed";
    }

    private final b1 y() {
        v1 v1Var = (v1) getContext().get(v1.b0);
        if (v1Var == null) {
            return null;
        }
        b1 d2 = v1.a.d(v1Var, true, false, new u(this), 2, null);
        this.f8787f = d2;
        return d2;
    }

    @Override // kotlinx.coroutines.p
    public Object A(T t, Object obj, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        return O(t, obj, lVar);
    }

    @Override // kotlinx.coroutines.p
    public void B(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.f8785d;
        kotlinx.coroutines.internal.i iVar = continuation instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) continuation : null;
        L(this, t, (iVar != null ? iVar.f8766d : null) == coroutineDispatcher ? 4 : this.c, null, 4, null);
    }

    @Override // kotlinx.coroutines.p
    public void F(Object obj) {
        if (o0.a()) {
            if (!(obj == r.a)) {
                throw new AssertionError();
            }
        }
        s(this.c);
    }

    protected String G() {
        return "CancellableContinuation";
    }

    public final void H(Throwable th) {
        if (p(th)) {
            return;
        }
        l(th);
        r();
    }

    public final boolean J() {
        if (o0.a()) {
            if (!(this.c == 2)) {
                throw new AssertionError();
            }
        }
        if (o0.a()) {
            if (!(this.f8787f != i2.a)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!o0.a() || (!(obj instanceof j2))) {
            if ((obj instanceof b0) && ((b0) obj).f8695d != null) {
                q();
                return false;
            }
            this._decision = 0;
            this._state = f.a;
            return true;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.w0
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof j2)) {
                if (obj2 instanceof c0) {
                    return;
                }
                if (obj2 instanceof b0) {
                    b0 b0Var = (b0) obj2;
                    if (!b0Var.c()) {
                        if (f8784h.compareAndSet(this, obj2, b0.b(b0Var, null, null, null, null, th, 15, null))) {
                            b0Var.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f8784h.compareAndSet(this, obj2, new b0(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.p
    public Object b(T t, Object obj) {
        return O(t, obj, null);
    }

    @Override // kotlinx.coroutines.w0
    public final Continuation<T> c() {
        return this.f8785d;
    }

    @Override // kotlinx.coroutines.w0
    public Throwable d(Object obj) {
        Throwable j2;
        Throwable d2 = super.d(obj);
        if (d2 == null) {
            return null;
        }
        Continuation<T> c = c();
        if (o0.d() && (c instanceof CoroutineStackFrame)) {
            j2 = kotlinx.coroutines.internal.b0.j(d2, (CoroutineStackFrame) c);
            return j2;
        }
        return d2;
    }

    @Override // kotlinx.coroutines.p
    public void e(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        n D = D(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof f) {
                if (f8784h.compareAndSet(this, obj, D)) {
                    return;
                }
            } else {
                if (!(obj instanceof n)) {
                    boolean z = obj instanceof c0;
                    if (z) {
                        c0 c0Var = (c0) obj;
                        if (c0Var.b()) {
                            if (obj instanceof t) {
                                if (!z) {
                                    c0Var = null;
                                }
                                m(lVar, c0Var != null ? c0Var.a : null);
                                return;
                            }
                            return;
                        }
                        E(lVar, obj);
                        throw null;
                    } else if (obj instanceof b0) {
                        b0 b0Var = (b0) obj;
                        if (b0Var.b == null) {
                            if (D instanceof g) {
                                return;
                            }
                            if (b0Var.c()) {
                                m(lVar, b0Var.f8696e);
                                return;
                            } else {
                                if (f8784h.compareAndSet(this, obj, b0.b(b0Var, null, D, null, null, null, 29, null))) {
                                    return;
                                }
                            }
                        } else {
                            E(lVar, obj);
                            throw null;
                        }
                    } else if (D instanceof g) {
                        return;
                    } else {
                        if (f8784h.compareAndSet(this, obj, new b0(obj, D, null, null, null, 28, null))) {
                            return;
                        }
                    }
                } else {
                    E(lVar, obj);
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.w0
    public <T> T f(Object obj) {
        return obj instanceof b0 ? (T) ((b0) obj).a : obj;
    }

    @Override // kotlinx.coroutines.p
    public Object g(Throwable th) {
        return O(new c0(th, false, 2, null), null, null);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f8785d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f8786e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.w0
    public Object i() {
        return v();
    }

    @Override // kotlinx.coroutines.p
    public void k(T t, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        K(t, this.c, lVar);
    }

    @Override // kotlinx.coroutines.p
    public boolean l(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof j2)) {
                return false;
            }
            z = obj instanceof n;
        } while (!f8784h.compareAndSet(this, obj, new t(this, th, z)));
        n nVar = z ? (n) obj : null;
        if (nVar != null) {
            n(nVar, th);
        }
        r();
        s(this.c);
        return true;
    }

    public final void n(n nVar, Throwable th) {
        try {
            nVar.a(th);
        } catch (Throwable th2) {
            j0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.q("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void o(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            j0.a(getContext(), new CompletionHandlerException(kotlin.jvm.internal.s.q("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public final void q() {
        b1 b1Var = this.f8787f;
        if (b1Var == null) {
            return;
        }
        b1Var.dispose();
        this.f8787f = i2.a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        L(this, f0.c(obj, this), this.c, null, 4, null);
    }

    public Throwable t(v1 v1Var) {
        return v1Var.t();
    }

    public String toString() {
        return G() + '(' + p0.c(this.f8785d) + "){" + w() + "}@" + p0.b(this);
    }

    public final Object u() {
        v1 v1Var;
        Throwable j2;
        Throwable j3;
        Object coroutine_suspended;
        boolean C = C();
        if (P()) {
            if (this.f8787f == null) {
                y();
            }
            if (C) {
                I();
            }
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended;
        }
        if (C) {
            I();
        }
        Object v = v();
        if (v instanceof c0) {
            Throwable th = ((c0) v).a;
            if (o0.d()) {
                j3 = kotlinx.coroutines.internal.b0.j(th, this);
                throw j3;
            }
            throw th;
        } else if (x0.b(this.c) && (v1Var = (v1) getContext().get(v1.b0)) != null && !v1Var.isActive()) {
            CancellationException t = v1Var.t();
            a(v, t);
            if (o0.d()) {
                j2 = kotlinx.coroutines.internal.b0.j(t, this);
                throw j2;
            }
            throw t;
        } else {
            return f(v);
        }
    }

    public final Object v() {
        return this._state;
    }

    public void x() {
        b1 y = y();
        if (y != null && z()) {
            y.dispose();
            this.f8787f = i2.a;
        }
    }

    public boolean z() {
        return !(v() instanceof j2);
    }
}
