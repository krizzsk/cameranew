package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.v1;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class c2 implements v1, x, k2, kotlinx.coroutines.selects.c {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c2.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> extends q<T> {

        /* renamed from: i  reason: collision with root package name */
        private final c2 f8698i;

        public a(Continuation<? super T> continuation, c2 c2Var) {
            super(continuation, 1);
            this.f8698i = c2Var;
        }

        @Override // kotlinx.coroutines.q
        protected String G() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.q
        public Throwable t(v1 v1Var) {
            Throwable e2;
            Object h0 = this.f8698i.h0();
            return (!(h0 instanceof c) || (e2 = ((c) h0).e()) == null) ? h0 instanceof c0 ? ((c0) h0).a : v1Var.t() : e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class b extends b2 {

        /* renamed from: e  reason: collision with root package name */
        private final c2 f8699e;

        /* renamed from: f  reason: collision with root package name */
        private final c f8700f;

        /* renamed from: g  reason: collision with root package name */
        private final w f8701g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f8702h;

        public b(c2 c2Var, c cVar, w wVar, Object obj) {
            this.f8699e = c2Var;
            this.f8700f = cVar;
            this.f8701g = wVar;
            this.f8702h = obj;
        }

        @Override // kotlinx.coroutines.e0
        public void Q(Throwable th) {
            this.f8699e.X(this.f8700f, this.f8701g, this.f8702h);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            Q(th);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class c implements p1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        private final h2 a;

        public c(h2 h2Var, boolean z, Throwable th) {
            this.a = h2Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th) {
            Throwable e2 = e();
            if (e2 == null) {
                l(th);
            } else if (th == e2) {
            } else {
                Object c = c();
                if (c == null) {
                    k(th);
                } else if (!(c instanceof Throwable)) {
                    if (!(c instanceof ArrayList)) {
                        throw new IllegalStateException(kotlin.jvm.internal.s.q("State is ", c).toString());
                    }
                    ((ArrayList) c).add(th);
                } else if (th == c) {
                } else {
                    ArrayList<Throwable> b = b();
                    b.add(c);
                    b.add(th);
                    kotlin.u uVar = kotlin.u.a;
                    k(b);
                }
            }
        }

        @Override // kotlinx.coroutines.p1
        public h2 d() {
            return this.a;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.c0 c0Var;
            Object c = c();
            c0Var = d2.f8733e;
            return c == c0Var;
        }

        public final List<Throwable> i(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.c0 c0Var;
            Object c = c();
            if (c == null) {
                arrayList = b();
            } else if (c instanceof Throwable) {
                ArrayList<Throwable> b = b();
                b.add(c);
                arrayList = b;
            } else if (!(c instanceof ArrayList)) {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("State is ", c).toString());
            } else {
                arrayList = (ArrayList) c;
            }
            Throwable e2 = e();
            if (e2 != null) {
                arrayList.add(0, e2);
            }
            if (th != null && !kotlin.jvm.internal.s.c(th, e2)) {
                arrayList.add(th);
            }
            c0Var = d2.f8733e;
            k(c0Var);
            return arrayList;
        }

        @Override // kotlinx.coroutines.p1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + c() + ", list=" + d() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class d extends p.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c2 f8703d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f8704e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.p pVar, c2 c2Var, Object obj) {
            super(pVar);
            this.f8703d = c2Var;
            this.f8704e = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: k */
        public Object i(kotlinx.coroutines.internal.p pVar) {
            if (this.f8703d.h0() == this.f8704e) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    public c2(boolean z) {
        this._state = z ? d2.f8735g : d2.f8734f;
        this._parentHandle = null;
    }

    private final int E0(Object obj) {
        e1 e1Var;
        if (obj instanceof e1) {
            if (((e1) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            e1Var = d2.f8735g;
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, e1Var)) {
                x0();
                return 1;
            }
            return -1;
        } else if (obj instanceof o1) {
            if (a.compareAndSet(this, obj, ((o1) obj).d())) {
                x0();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    private final String F0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof p1 ? ((p1) obj).isActive() ? "Active" : "New" : obj instanceof c0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException H0(c2 c2Var, Throwable th, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return c2Var.G0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean I(Object obj, h2 h2Var, b2 b2Var) {
        int P;
        d dVar = new d(b2Var, this, obj);
        do {
            P = h2Var.H().P(b2Var, h2Var, dVar);
            if (P == 1) {
                return true;
            }
        } while (P != 2);
        return false;
    }

    private final void J(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable n = !o0.d() ? th : kotlinx.coroutines.internal.b0.n(th);
        for (Throwable th2 : list) {
            if (o0.d()) {
                th2 = kotlinx.coroutines.internal.b0.n(th2);
            }
            if (th2 != th && th2 != n && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.b.a(th, th2);
            }
        }
    }

    private final boolean J0(p1 p1Var, Object obj) {
        if (o0.a()) {
            if (!((p1Var instanceof e1) || (p1Var instanceof b2))) {
                throw new AssertionError();
            }
        }
        if (!o0.a() || (!(obj instanceof c0))) {
            if (a.compareAndSet(this, p1Var, d2.g(obj))) {
                v0(null);
                w0(obj);
                W(p1Var, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    private final boolean K0(p1 p1Var, Throwable th) {
        if (!o0.a() || (!(p1Var instanceof c))) {
            if (!o0.a() || p1Var.isActive()) {
                h2 f0 = f0(p1Var);
                if (f0 == null) {
                    return false;
                }
                if (a.compareAndSet(this, p1Var, new c(f0, false, th))) {
                    t0(f0, th);
                    return true;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Object L0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        if (!(obj instanceof p1)) {
            c0Var2 = d2.a;
            return c0Var2;
        } else if (((obj instanceof e1) || (obj instanceof b2)) && !(obj instanceof w) && !(obj2 instanceof c0)) {
            if (J0((p1) obj, obj2)) {
                return obj2;
            }
            c0Var = d2.c;
            return c0Var;
        } else {
            return M0((p1) obj, obj2);
        }
    }

    private final Object M(Continuation<Object> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        a aVar = new a(intercepted, this);
        aVar.x();
        s.a(aVar, u(new m2(aVar)));
        Object u = aVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    private final Object M0(p1 p1Var, Object obj) {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        kotlinx.coroutines.internal.c0 c0Var3;
        h2 f0 = f0(p1Var);
        if (f0 == null) {
            c0Var3 = d2.c;
            return c0Var3;
        }
        c cVar = p1Var instanceof c ? (c) p1Var : null;
        if (cVar == null) {
            cVar = new c(f0, false, null);
        }
        synchronized (cVar) {
            if (cVar.g()) {
                c0Var2 = d2.a;
                return c0Var2;
            }
            cVar.j(true);
            if (cVar != p1Var && !a.compareAndSet(this, p1Var, cVar)) {
                c0Var = d2.c;
                return c0Var;
            }
            if (o0.a() && !(!cVar.h())) {
                throw new AssertionError();
            }
            boolean f2 = cVar.f();
            c0 c0Var4 = obj instanceof c0 ? (c0) obj : null;
            if (c0Var4 != null) {
                cVar.a(c0Var4.a);
            }
            Throwable e2 = true ^ f2 ? cVar.e() : null;
            kotlin.u uVar = kotlin.u.a;
            if (e2 != null) {
                t0(f0, e2);
            }
            w a0 = a0(p1Var);
            if (a0 != null && N0(cVar, a0, obj)) {
                return d2.b;
            }
            return Z(cVar, obj);
        }
    }

    private final boolean N0(c cVar, w wVar, Object obj) {
        while (v1.a.d(wVar.f8846e, false, false, new b(this, cVar, wVar, obj), 1, null) == i2.a) {
            wVar = s0(wVar);
            if (wVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object S(Object obj) {
        kotlinx.coroutines.internal.c0 c0Var;
        Object L0;
        kotlinx.coroutines.internal.c0 c0Var2;
        do {
            Object h0 = h0();
            if (!(h0 instanceof p1) || ((h0 instanceof c) && ((c) h0).g())) {
                c0Var = d2.a;
                return c0Var;
            }
            L0 = L0(h0, new c0(Y(obj), false, 2, null));
            c0Var2 = d2.c;
        } while (L0 == c0Var2);
        return L0;
    }

    private final boolean T(Throwable th) {
        if (l0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        v g0 = g0();
        return (g0 == null || g0 == i2.a) ? z : g0.c(th) || z;
    }

    private final void W(p1 p1Var, Object obj) {
        v g0 = g0();
        if (g0 != null) {
            g0.dispose();
            D0(i2.a);
        }
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.a : null;
        if (p1Var instanceof b2) {
            try {
                ((b2) p1Var).Q(th);
                return;
            } catch (Throwable th2) {
                j0(new CompletionHandlerException("Exception in completion handler " + p1Var + " for " + this, th2));
                return;
            }
        }
        h2 d2 = p1Var.d();
        if (d2 == null) {
            return;
        }
        u0(d2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(c cVar, w wVar, Object obj) {
        if (o0.a()) {
            if (!(h0() == cVar)) {
                throw new AssertionError();
            }
        }
        w s0 = s0(wVar);
        if (s0 == null || !N0(cVar, s0, obj)) {
            K(Z(cVar, obj));
        }
    }

    private final Throwable Y(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(U(), null, this) : th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((k2) obj).w();
    }

    private final Object Z(c cVar, Object obj) {
        boolean f2;
        Throwable c0;
        boolean z = true;
        if (o0.a()) {
            if (!(h0() == cVar)) {
                throw new AssertionError();
            }
        }
        if (!o0.a() || (!cVar.h())) {
            if (!o0.a() || cVar.g()) {
                c0 c0Var = obj instanceof c0 ? (c0) obj : null;
                Throwable th = c0Var == null ? null : c0Var.a;
                synchronized (cVar) {
                    f2 = cVar.f();
                    List<Throwable> i2 = cVar.i(th);
                    c0 = c0(cVar, i2);
                    if (c0 != null) {
                        J(c0, i2);
                    }
                }
                if (c0 != null && c0 != th) {
                    obj = new c0(c0, false, 2, null);
                }
                if (c0 != null) {
                    if (!T(c0) && !i0(c0)) {
                        z = false;
                    }
                    if (z) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        ((c0) obj).b();
                    }
                }
                if (!f2) {
                    v0(c0);
                }
                w0(obj);
                boolean compareAndSet = a.compareAndSet(this, cVar, d2.g(obj));
                if (!o0.a() || compareAndSet) {
                    W(cVar, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final w a0(p1 p1Var) {
        w wVar = p1Var instanceof w ? (w) p1Var : null;
        if (wVar == null) {
            h2 d2 = p1Var.d();
            if (d2 == null) {
                return null;
            }
            return s0(d2);
        }
        return wVar;
    }

    private final Throwable b0(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var == null) {
            return null;
        }
        return c0Var.a;
    }

    private final Throwable c0(c cVar, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new JobCancellationException(U(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof TimeoutCancellationException)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final h2 f0(p1 p1Var) {
        h2 d2 = p1Var.d();
        if (d2 == null) {
            if (p1Var instanceof e1) {
                return new h2();
            }
            if (p1Var instanceof b2) {
                z0((b2) p1Var);
                return null;
            }
            throw new IllegalStateException(kotlin.jvm.internal.s.q("State should have list: ", p1Var).toString());
        }
        return d2;
    }

    private final boolean m0() {
        Object h0;
        do {
            h0 = h0();
            if (!(h0 instanceof p1)) {
                return false;
            }
        } while (E0(h0) < 0);
        return true;
    }

    private final Object n0(Continuation<? super kotlin.u> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        q qVar = new q(intercepted, 1);
        qVar.x();
        s.a(qVar, u(new n2(qVar)));
        Object u = qVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return u == coroutine_suspended2 ? u : kotlin.u.a;
    }

    private final Object o0(Object obj) {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        kotlinx.coroutines.internal.c0 c0Var3;
        kotlinx.coroutines.internal.c0 c0Var4;
        kotlinx.coroutines.internal.c0 c0Var5;
        kotlinx.coroutines.internal.c0 c0Var6;
        Throwable th = null;
        while (true) {
            Object h0 = h0();
            if (h0 instanceof c) {
                synchronized (h0) {
                    if (((c) h0).h()) {
                        c0Var2 = d2.f8732d;
                        return c0Var2;
                    }
                    boolean f2 = ((c) h0).f();
                    if (obj != null || !f2) {
                        if (th == null) {
                            th = Y(obj);
                        }
                        ((c) h0).a(th);
                    }
                    Throwable e2 = f2 ^ true ? ((c) h0).e() : null;
                    if (e2 != null) {
                        t0(((c) h0).d(), e2);
                    }
                    c0Var = d2.a;
                    return c0Var;
                }
            } else if (!(h0 instanceof p1)) {
                c0Var3 = d2.f8732d;
                return c0Var3;
            } else {
                if (th == null) {
                    th = Y(obj);
                }
                p1 p1Var = (p1) h0;
                if (p1Var.isActive()) {
                    if (K0(p1Var, th)) {
                        c0Var4 = d2.a;
                        return c0Var4;
                    }
                } else {
                    Object L0 = L0(h0, new c0(th, false, 2, null));
                    c0Var5 = d2.a;
                    if (L0 != c0Var5) {
                        c0Var6 = d2.c;
                        if (L0 != c0Var6) {
                            return L0;
                        }
                    } else {
                        throw new IllegalStateException(kotlin.jvm.internal.s.q("Cannot happen in ", h0).toString());
                    }
                }
            }
        }
    }

    private final b2 q0(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, boolean z) {
        if (z) {
            r0 = lVar instanceof w1 ? (w1) lVar : null;
            if (r0 == null) {
                r0 = new t1(lVar);
            }
        } else {
            b2 b2Var = lVar instanceof b2 ? (b2) lVar : null;
            if (b2Var != null) {
                if (o0.a() && !(!(b2Var instanceof w1))) {
                    throw new AssertionError();
                }
                r0 = b2Var;
            }
            if (r0 == null) {
                r0 = new u1(lVar);
            }
        }
        r0.S(this);
        return r0;
    }

    private final w s0(kotlinx.coroutines.internal.p pVar) {
        while (pVar.K()) {
            pVar = pVar.H();
        }
        while (true) {
            pVar = pVar.G();
            if (!pVar.K()) {
                if (pVar instanceof w) {
                    return (w) pVar;
                }
                if (pVar instanceof h2) {
                    return null;
                }
            }
        }
    }

    private final void t0(h2 h2Var, Throwable th) {
        CompletionHandlerException completionHandlerException;
        v0(th);
        CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) h2Var.E(); !kotlin.jvm.internal.s.c(pVar, h2Var); pVar = pVar.G()) {
            if (pVar instanceof w1) {
                b2 b2Var = (b2) pVar;
                try {
                    b2Var.Q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.b.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + b2Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            j0(completionHandlerException2);
        }
        T(th);
    }

    private final void u0(h2 h2Var, Throwable th) {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) h2Var.E(); !kotlin.jvm.internal.s.c(pVar, h2Var); pVar = pVar.G()) {
            if (pVar instanceof b2) {
                b2 b2Var = (b2) pVar;
                try {
                    b2Var.Q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.b.a(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + b2Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 == null) {
            return;
        }
        j0(completionHandlerException2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.o1] */
    private final void y0(e1 e1Var) {
        h2 h2Var = new h2();
        if (!e1Var.isActive()) {
            h2Var = new o1(h2Var);
        }
        a.compareAndSet(this, e1Var, h2Var);
    }

    private final void z0(b2 b2Var) {
        b2Var.y(new h2());
        a.compareAndSet(this, b2Var, b2Var.G());
    }

    public final <T, R> void A0(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        Object h0;
        do {
            h0 = h0();
            if (fVar.f()) {
                return;
            }
            if (!(h0 instanceof p1)) {
                if (fVar.n()) {
                    if (h0 instanceof c0) {
                        fVar.p(((c0) h0).a);
                        return;
                    } else {
                        kotlinx.coroutines.d3.b.d(pVar, d2.h(h0), fVar.o());
                        return;
                    }
                }
                return;
            }
        } while (E0(h0) != 0);
        fVar.j(u(new p2(fVar, pVar)));
    }

    public final void B0(b2 b2Var) {
        Object h0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var;
        do {
            h0 = h0();
            if (!(h0 instanceof b2)) {
                if (!(h0 instanceof p1) || ((p1) h0).d() == null) {
                    return;
                }
                b2Var.L();
                return;
            } else if (h0 != b2Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = a;
                e1Var = d2.f8735g;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, h0, e1Var));
    }

    public final <T, R> void C0(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        Object h0 = h0();
        if (h0 instanceof c0) {
            fVar.p(((c0) h0).a);
        } else {
            kotlinx.coroutines.d3.a.f(pVar, d2.h(h0), fVar.o(), null, 4, null);
        }
    }

    public final void D0(v vVar) {
        this._parentHandle = vVar;
    }

    protected final CancellationException G0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = U();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public final String I0() {
        return r0() + '{' + F0(h0()) + '}';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(Object obj) {
    }

    public final Object L(Continuation<Object> continuation) {
        Object h0;
        do {
            h0 = h0();
            if (!(h0 instanceof p1)) {
                if (h0 instanceof c0) {
                    Throwable th = ((c0) h0).a;
                    if (o0.d()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            throw kotlinx.coroutines.internal.b0.a(th, (CoroutineStackFrame) continuation);
                        }
                        throw th;
                    }
                    throw th;
                }
                return d2.h(h0);
            }
        } while (E0(h0) < 0);
        return M(continuation);
    }

    @Override // kotlinx.coroutines.v1
    public final v O(x xVar) {
        return (v) v1.a.d(this, true, false, new w(xVar), 2, null);
    }

    public final boolean P(Throwable th) {
        return Q(th);
    }

    public final boolean Q(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        kotlinx.coroutines.internal.c0 c0Var3;
        obj2 = d2.a;
        if (e0() && (obj2 = S(obj)) == d2.b) {
            return true;
        }
        c0Var = d2.a;
        if (obj2 == c0Var) {
            obj2 = o0(obj);
        }
        c0Var2 = d2.a;
        if (obj2 == c0Var2 || obj2 == d2.b) {
            return true;
        }
        c0Var3 = d2.f8732d;
        if (obj2 == c0Var3) {
            return false;
        }
        K(obj2);
        return true;
    }

    public void R(Throwable th) {
        Q(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String U() {
        return "Job was cancelled";
    }

    public boolean V(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return Q(th) && d0();
    }

    @Override // kotlinx.coroutines.v1
    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(U(), null, this);
        }
        R(cancellationException);
    }

    @Override // kotlinx.coroutines.v1
    public final boolean d() {
        return !(h0() instanceof p1);
    }

    public boolean d0() {
        return true;
    }

    public boolean e0() {
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
        return (R) v1.a.b(this, r, pVar);
    }

    public final v g0() {
        return (v) this._parentHandle;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) v1.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return v1.b0;
    }

    @Override // kotlinx.coroutines.v1
    public final b1 h(boolean z, boolean z2, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        b2 q0 = q0(lVar, z);
        while (true) {
            Object h0 = h0();
            if (h0 instanceof e1) {
                e1 e1Var = (e1) h0;
                if (e1Var.isActive()) {
                    if (a.compareAndSet(this, h0, q0)) {
                        return q0;
                    }
                } else {
                    y0(e1Var);
                }
            } else {
                if (h0 instanceof p1) {
                    h2 d2 = ((p1) h0).d();
                    if (d2 == null) {
                        Objects.requireNonNull(h0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        z0((b2) h0);
                    } else {
                        b1 b1Var = i2.a;
                        if (z && (h0 instanceof c)) {
                            synchronized (h0) {
                                r3 = ((c) h0).e();
                                if (r3 == null || ((lVar instanceof w) && !((c) h0).g())) {
                                    if (I(h0, d2, q0)) {
                                        if (r3 == null) {
                                            return q0;
                                        }
                                        b1Var = q0;
                                    }
                                }
                                kotlin.u uVar = kotlin.u.a;
                            }
                        }
                        if (r3 != null) {
                            if (z2) {
                                lVar.invoke(r3);
                            }
                            return b1Var;
                        } else if (I(h0, d2, q0)) {
                            return q0;
                        }
                    }
                } else {
                    if (z2) {
                        c0 c0Var = h0 instanceof c0 ? (c0) h0 : null;
                        lVar.invoke(c0Var != null ? c0Var.a : null);
                    }
                    return i2.a;
                }
            }
        }
    }

    public final Object h0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.w) obj).c(this);
        }
    }

    protected boolean i0(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.v1
    public boolean isActive() {
        Object h0 = h0();
        return (h0 instanceof p1) && ((p1) h0).isActive();
    }

    @Override // kotlinx.coroutines.v1
    public final boolean isCancelled() {
        Object h0 = h0();
        return (h0 instanceof c0) || ((h0 instanceof c) && ((c) h0).f());
    }

    @Override // kotlinx.coroutines.x
    public final void j(k2 k2Var) {
        Q(k2Var);
    }

    public void j0(Throwable th) {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k0(v1 v1Var) {
        if (o0.a()) {
            if (!(g0() == null)) {
                throw new AssertionError();
            }
        }
        if (v1Var == null) {
            D0(i2.a);
            return;
        }
        v1Var.start();
        v O = v1Var.O(this);
        D0(O);
        if (d()) {
            O.dispose();
            D0(i2.a);
        }
    }

    protected boolean l0() {
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return v1.a.e(this, key);
    }

    public final Object p0(Object obj) {
        Object L0;
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        do {
            L0 = L0(h0(), obj);
            c0Var = d2.a;
            if (L0 != c0Var) {
                c0Var2 = d2.c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, b0(obj));
            }
        } while (L0 == c0Var2);
        return L0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return v1.a.f(this, coroutineContext);
    }

    public String r0() {
        return p0.a(this);
    }

    @Override // kotlinx.coroutines.v1
    public final boolean start() {
        int E0;
        do {
            E0 = E0(h0());
            if (E0 == 0) {
                return false;
            }
        } while (E0 != 1);
        return true;
    }

    @Override // kotlinx.coroutines.v1
    public final CancellationException t() {
        Object h0 = h0();
        if (!(h0 instanceof c)) {
            if (h0 instanceof p1) {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Job is still new or active: ", this).toString());
            }
            return h0 instanceof c0 ? H0(this, ((c0) h0).a, null, 1, null) : new JobCancellationException(kotlin.jvm.internal.s.q(p0.a(this), " has completed normally"), null, this);
        }
        Throwable e2 = ((c) h0).e();
        if (e2 != null) {
            return G0(e2, kotlin.jvm.internal.s.q(p0.a(this), " is cancelling"));
        }
        throw new IllegalStateException(kotlin.jvm.internal.s.q("Job is still new or active: ", this).toString());
    }

    public String toString() {
        return I0() + '@' + p0.b(this);
    }

    @Override // kotlinx.coroutines.v1
    public final b1 u(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        return h(false, true, lVar);
    }

    protected void v0(Throwable th) {
    }

    @Override // kotlinx.coroutines.k2
    public CancellationException w() {
        Throwable th;
        Object h0 = h0();
        if (h0 instanceof c) {
            th = ((c) h0).e();
        } else if (h0 instanceof c0) {
            th = ((c0) h0).a;
        } else if (h0 instanceof p1) {
            throw new IllegalStateException(kotlin.jvm.internal.s.q("Cannot be cancelling child in this state: ", h0).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        return cancellationException == null ? new JobCancellationException(kotlin.jvm.internal.s.q("Parent job is ", F0(h0)), th, this) : cancellationException;
    }

    protected void w0(Object obj) {
    }

    @Override // kotlinx.coroutines.v1
    public final Object x(Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        if (!m0()) {
            y1.g(continuation.getContext());
            return kotlin.u.a;
        }
        Object n0 = n0(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return n0 == coroutine_suspended ? n0 : kotlin.u.a;
    }

    protected void x0() {
    }
}
