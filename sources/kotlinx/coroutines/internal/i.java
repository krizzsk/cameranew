package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.v2;
import kotlinx.coroutines.w0;
/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class i<T> extends w0<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f8765h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineDispatcher f8766d;

    /* renamed from: e  reason: collision with root package name */
    public final Continuation<T> f8767e;

    /* renamed from: f  reason: collision with root package name */
    public Object f8768f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f8769g;

    /* JADX WARN: Multi-variable type inference failed */
    public i(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f8766d = coroutineDispatcher;
        this.f8767e = continuation;
        this.f8768f = j.a();
        this.f8769g = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final kotlinx.coroutines.q<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof kotlinx.coroutines.q) {
            return (kotlinx.coroutines.q) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.w0
    public void a(Object obj, Throwable th) {
        if (obj instanceof kotlinx.coroutines.d0) {
            ((kotlinx.coroutines.d0) obj).b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.w0
    public Continuation<T> c() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f8767e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f8767e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.w0
    public Object i() {
        Object obj = this.f8768f;
        if (o0.a()) {
            if (!(obj != j.a())) {
                throw new AssertionError();
            }
        }
        this.f8768f = j.a();
        return obj;
    }

    public final void j() {
        do {
        } while (this._reusableCancellableContinuation == j.b);
    }

    public final kotlinx.coroutines.q<T> m() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = j.b;
                return null;
            } else if (obj instanceof kotlinx.coroutines.q) {
                if (f8765h.compareAndSet(this, obj, j.b)) {
                    return (kotlinx.coroutines.q) obj;
                }
            } else if (obj != j.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void n(CoroutineContext coroutineContext, T t) {
        this.f8768f = t;
        this.c = 1;
        this.f8766d.dispatchYield(coroutineContext, this);
    }

    public final boolean p() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean q(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            c0 c0Var = j.b;
            if (kotlin.jvm.internal.s.c(obj, c0Var)) {
                if (f8765h.compareAndSet(this, c0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f8765h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        j();
        kotlinx.coroutines.q<?> o = o();
        if (o == null) {
            return;
        }
        o.q();
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.f8767e.getContext();
        Object d2 = kotlinx.coroutines.f0.d(obj, null, 1, null);
        if (this.f8766d.isDispatchNeeded(context)) {
            this.f8768f = d2;
            this.c = 0;
            this.f8766d.dispatch(context, this);
            return;
        }
        o0.a();
        f1 b = v2.a.b();
        if (b.U()) {
            this.f8768f = d2;
            this.c = 0;
            b.Q(this);
            return;
        }
        b.S(true);
        try {
            CoroutineContext context2 = getContext();
            Object c = ThreadContextKt.c(context2, this.f8769g);
            this.f8767e.resumeWith(obj);
            kotlin.u uVar = kotlin.u.a;
            ThreadContextKt.a(context2, c);
            do {
            } while (b.X());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(kotlinx.coroutines.p<?> pVar) {
        c0 c0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            c0Var = j.b;
            if (obj != c0Var) {
                if (obj instanceof Throwable) {
                    if (f8765h.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Inconsistent state ", obj).toString());
            }
        } while (!f8765h.compareAndSet(this, c0Var, pVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f8766d + ", " + p0.c(this.f8767e) + ']';
    }
}
