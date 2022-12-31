package kotlinx.coroutines.selects;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.w1;
/* compiled from: Select.kt */
/* loaded from: classes3.dex */
public final class b<R> extends n implements kotlinx.coroutines.selects.a<R>, f<R>, Continuation<R>, CoroutineStackFrame {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f8814e = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f8815f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");
    private volatile /* synthetic */ Object _parentHandle;
    volatile /* synthetic */ Object _result;
    volatile /* synthetic */ Object _state = g.e();

    /* renamed from: d  reason: collision with root package name */
    private final Continuation<R> f8816d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlinx.coroutines.internal.d<Object> {
        public final b<?> b;
        public final kotlinx.coroutines.internal.b c;

        /* renamed from: d  reason: collision with root package name */
        private final long f8817d;

        public a(b<?> bVar, kotlinx.coroutines.internal.b bVar2) {
            h hVar;
            this.b = bVar;
            this.c = bVar2;
            hVar = g.f8821e;
            this.f8817d = hVar.a();
            bVar2.d(this);
        }

        private final void j(Object obj) {
            boolean z = obj == null;
            if (b.f8814e.compareAndSet(this.b, this, z ? null : g.e()) && z) {
                this.b.S();
            }
        }

        private final Object k() {
            b<?> bVar = this.b;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof w) {
                    ((w) obj).c(this.b);
                } else if (obj == g.e()) {
                    if (b.f8814e.compareAndSet(this.b, g.e(), this)) {
                        return null;
                    }
                } else {
                    return g.d();
                }
            }
        }

        private final void l() {
            b.f8814e.compareAndSet(this.b, this, g.e());
        }

        @Override // kotlinx.coroutines.internal.d
        public void d(Object obj, Object obj2) {
            j(obj2);
            this.c.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.d
        public long g() {
            return this.f8817d;
        }

        @Override // kotlinx.coroutines.internal.d
        public Object i(Object obj) {
            Object k2;
            if (obj != null || (k2 = k()) == null) {
                try {
                    return this.c.c(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        l();
                    }
                    throw th;
                }
            }
            return k2;
        }

        @Override // kotlinx.coroutines.internal.w
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* renamed from: kotlinx.coroutines.selects.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0324b extends p {

        /* renamed from: d  reason: collision with root package name */
        public final b1 f8818d;

        public C0324b(b1 b1Var) {
            this.f8818d = b1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes3.dex */
    public static final class c extends w {
        public final p.c a;

        public c(p.c cVar) {
            this.a = cVar;
        }

        @Override // kotlinx.coroutines.internal.w
        public kotlinx.coroutines.internal.d<?> a() {
            return this.a.a();
        }

        @Override // kotlinx.coroutines.internal.w
        public Object c(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            b bVar = (b) obj;
            this.a.d();
            Object e2 = this.a.a().e(null);
            b.f8814e.compareAndSet(bVar, this, e2 == null ? this.a.c : g.e());
            return e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Select.kt */
    /* loaded from: classes3.dex */
    public final class d extends w1 {
        public d() {
        }

        @Override // kotlinx.coroutines.e0
        public void Q(Throwable th) {
            if (b.this.n()) {
                b.this.p(R().t());
            }
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            Q(th);
            return u.a;
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        final /* synthetic */ l b;

        public e(l lVar) {
            this.b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.n()) {
                l lVar = this.b;
                b bVar = b.this;
                bVar.o();
                kotlinx.coroutines.d3.a.d(lVar, bVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Continuation<? super R> continuation) {
        Object obj;
        this.f8816d = continuation;
        obj = g.c;
        this._result = obj;
        this._parentHandle = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        b1 T = T();
        if (T != null) {
            T.dispose();
        }
        for (p pVar = (p) E(); !s.c(pVar, this); pVar = pVar.G()) {
            if (pVar instanceof C0324b) {
                ((C0324b) pVar).f8818d.dispose();
            }
        }
    }

    private final b1 T() {
        return (b1) this._parentHandle;
    }

    private final void W() {
        v1 v1Var = (v1) getContext().get(v1.b0);
        if (v1Var == null) {
            return;
        }
        b1 d2 = v1.a.d(v1Var, true, false, new d(), 2, null);
        X(d2);
        if (f()) {
            d2.dispose();
        }
    }

    private final void X(b1 b1Var) {
        this._parentHandle = b1Var;
    }

    public final Object U() {
        Object obj;
        Object obj2;
        Object obj3;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (!f()) {
            W();
        }
        Object obj4 = this._result;
        obj = g.c;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8815f;
            obj3 = g.c;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, coroutine_suspended)) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            obj4 = this._result;
        }
        obj2 = g.f8820d;
        if (obj4 != obj2) {
            if (obj4 instanceof c0) {
                throw ((c0) obj4).a;
            }
            return obj4;
        }
        throw new IllegalStateException("Already resumed");
    }

    public final void V(Throwable th) {
        if (n()) {
            Result.a aVar = Result.Companion;
            resumeWith(Result.m41constructorimpl(j.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object U = U();
            if (U instanceof c0) {
                Throwable th2 = ((c0) U).a;
                if (o0.d()) {
                    th2 = b0.n(th2);
                }
                if (th2 == (!o0.d() ? th : b0.n(th))) {
                    return;
                }
            }
            j0.a(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean f() {
        while (true) {
            Object obj = this._state;
            if (obj == g.e()) {
                return false;
            }
            if (!(obj instanceof w)) {
                return true;
            }
            ((w) obj).c(this);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.f8816d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f8816d.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.a
    public void h(long j2, l<? super Continuation<? super R>, ? extends Object> lVar) {
        if (j2 <= 0) {
            if (n()) {
                o();
                kotlinx.coroutines.d3.b.c(lVar, this);
                return;
            }
            return;
        }
        j(DelayKt.c(getContext()).m(j2, new e(lVar), getContext()));
    }

    @Override // kotlinx.coroutines.selects.f
    public void j(b1 b1Var) {
        C0324b c0324b = new C0324b(b1Var);
        if (!f()) {
            w(c0324b);
            if (!f()) {
                return;
            }
        }
        b1Var.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return kotlinx.coroutines.r.a;
     */
    @Override // kotlinx.coroutines.selects.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(kotlinx.coroutines.internal.p.c r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.b.f8814e
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.b$c r0 = new kotlinx.coroutines.selects.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.b.f8814e
            java.lang.Object r2 = kotlinx.coroutines.selects.g.e()
            boolean r1 = r1.compareAndSet(r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.S()
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.r.a
            return r4
        L37:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.w
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            kotlinx.coroutines.internal.d r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.b.a
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.b$a r2 = (kotlinx.coroutines.selects.b.a) r2
            kotlinx.coroutines.selects.b<?> r2 = r2.b
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            kotlinx.coroutines.internal.w r2 = (kotlinx.coroutines.internal.w) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = kotlinx.coroutines.internal.c.b
            return r4
        L65:
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            r0.c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            kotlinx.coroutines.internal.p$a r4 = r4.c
            if (r0 != r4) goto L75
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.r.a
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.b.m(kotlinx.coroutines.internal.p$c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean n() {
        Object m = m(null);
        if (m == r.a) {
            return true;
        }
        if (m == null) {
            return false;
        }
        throw new IllegalStateException(s.q("Unexpected trySelectIdempotent result ", m).toString());
    }

    @Override // kotlinx.coroutines.selects.f
    public Continuation<R> o() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.f
    public void p(Throwable th) {
        Object obj;
        Object obj2;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object obj3;
        Continuation intercepted;
        if (o0.a() && !f()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = g.c;
            if (obj4 == obj) {
                Continuation<R> continuation = this.f8816d;
                c0 c0Var = new c0((o0.d() && (continuation instanceof CoroutineStackFrame)) ? b0.j(th, (CoroutineStackFrame) continuation) : th, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8815f;
                obj2 = g.c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0Var)) {
                    return;
                }
            } else {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj4 == coroutine_suspended) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8815f;
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    obj3 = g.f8820d;
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, coroutine_suspended2, obj3)) {
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f8816d);
                        Result.a aVar = Result.Companion;
                        intercepted.resumeWith(Result.m41constructorimpl(j.a(th)));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.f
    public Object q(kotlinx.coroutines.internal.b bVar) {
        return new a(this, bVar).c(null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object obj4;
        if (o0.a() && !f()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj5 = this._result;
            obj2 = g.c;
            if (obj5 == obj2) {
                Object d2 = f0.d(obj, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8815f;
                obj3 = g.c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, d2)) {
                    return;
                }
            } else {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj5 == coroutine_suspended) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8815f;
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    obj4 = g.f8820d;
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, coroutine_suspended2, obj4)) {
                        if (Result.m47isFailureimpl(obj)) {
                            Continuation<R> continuation = this.f8816d;
                            Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(obj);
                            s.e(m44exceptionOrNullimpl);
                            Result.a aVar = Result.Companion;
                            if (o0.d() && (continuation instanceof CoroutineStackFrame)) {
                                m44exceptionOrNullimpl = b0.j(m44exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                            }
                            continuation.resumeWith(Result.m41constructorimpl(j.a(m44exceptionOrNullimpl)));
                            return;
                        }
                        this.f8816d.resumeWith(obj);
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <Q> void s(kotlinx.coroutines.selects.d<? extends Q> dVar, kotlin.jvm.b.p<? super Q, ? super Continuation<? super R>, ? extends Object> pVar) {
        dVar.c(this, pVar);
    }

    @Override // kotlinx.coroutines.internal.p
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }
}
