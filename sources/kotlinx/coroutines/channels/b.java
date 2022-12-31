package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class b<E> implements s<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "onCloseHandler");
    protected final kotlin.jvm.b.l<E, kotlin.u> a;
    private final kotlinx.coroutines.internal.n b = new kotlinx.coroutines.internal.n();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class a<E> extends r {

        /* renamed from: d  reason: collision with root package name */
        public final E f8718d;

        public a(E e2) {
            this.f8718d = e2;
        }

        @Override // kotlinx.coroutines.channels.r
        public void Q() {
        }

        @Override // kotlinx.coroutines.channels.r
        public Object R() {
            return this.f8718d;
        }

        @Override // kotlinx.coroutines.channels.r
        public void S(j<?> jVar) {
            if (o0.a()) {
                throw new AssertionError();
            }
        }

        @Override // kotlinx.coroutines.channels.r
        public c0 T(p.c cVar) {
            c0 c0Var = kotlinx.coroutines.r.a;
            if (cVar != null) {
                cVar.d();
            }
            return c0Var;
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "SendBuffered@" + p0.b(this) + '(' + this.f8718d + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: kotlinx.coroutines.channels.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0322b extends p.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f8719d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0322b(kotlinx.coroutines.internal.p pVar, b bVar) {
            super(pVar);
            this.f8719d = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: k */
        public Object i(kotlinx.coroutines.internal.p pVar) {
            if (this.f8719d.u()) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        this.a = lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
        r4 = r0.u();
        r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r4 != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
        if (r4 != r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
        return kotlin.u.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object F(E r4, kotlin.coroutines.Continuation<? super kotlin.u> r5) {
        /*
            r3 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r5)
            kotlinx.coroutines.q r0 = kotlinx.coroutines.s.b(r0)
        L8:
            boolean r1 = c(r3)
            if (r1 == 0) goto L4d
            kotlin.jvm.b.l<E, kotlin.u> r1 = r3.a
            if (r1 != 0) goto L18
            kotlinx.coroutines.channels.t r1 = new kotlinx.coroutines.channels.t
            r1.<init>(r4, r0)
            goto L1f
        L18:
            kotlinx.coroutines.channels.u r1 = new kotlinx.coroutines.channels.u
            kotlin.jvm.b.l<E, kotlin.u> r2 = r3.a
            r1.<init>(r4, r0, r2)
        L1f:
            java.lang.Object r2 = r3.e(r1)
            if (r2 != 0) goto L29
            kotlinx.coroutines.s.c(r0, r1)
            goto L6f
        L29:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.j
            if (r1 == 0) goto L33
            kotlinx.coroutines.channels.j r2 = (kotlinx.coroutines.channels.j) r2
            b(r3, r0, r4, r2)
            goto L6f
        L33:
            kotlinx.coroutines.internal.c0 r1 = kotlinx.coroutines.channels.a.f8716e
            if (r2 != r1) goto L38
            goto L4d
        L38:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.o
            if (r1 == 0) goto L3d
            goto L4d
        L3d:
            java.lang.String r4 = "enqueueSend returned "
            java.lang.String r4 = kotlin.jvm.internal.s.q(r4, r2)
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L4d:
            java.lang.Object r1 = r3.x(r4)
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.a.b
            if (r1 != r2) goto L61
            kotlin.u r4 = kotlin.u.a
            kotlin.Result$a r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.Result.m41constructorimpl(r4)
            r0.resumeWith(r4)
            goto L6f
        L61:
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.a.c
            if (r1 != r2) goto L66
            goto L8
        L66:
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.j
            if (r2 == 0) goto L86
            kotlinx.coroutines.channels.j r1 = (kotlinx.coroutines.channels.j) r1
            b(r3, r0, r4, r1)
        L6f:
            java.lang.Object r4 = r0.u()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r0) goto L7c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)
        L7c:
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L83
            return r4
        L83:
            kotlin.u r4 = kotlin.u.a
            return r4
        L86:
            java.lang.String r4 = "offerInternal returned "
            java.lang.String r4 = kotlin.jvm.internal.s.q(r4, r1)
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b.F(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int d() {
        kotlinx.coroutines.internal.n nVar = this.b;
        int i2 = 0;
        for (kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) nVar.E(); !kotlin.jvm.internal.s.c(pVar, nVar); pVar = pVar.G()) {
            if (pVar instanceof kotlinx.coroutines.internal.p) {
                i2++;
            }
        }
        return i2;
    }

    private final String k() {
        String q;
        kotlinx.coroutines.internal.p G = this.b.G();
        if (G == this.b) {
            return "EmptyQueue";
        }
        if (G instanceof j) {
            q = G.toString();
        } else if (G instanceof o) {
            q = "ReceiveQueued";
        } else {
            q = G instanceof r ? "SendQueued" : kotlin.jvm.internal.s.q("UNEXPECTED:", G);
        }
        kotlinx.coroutines.internal.p H = this.b.H();
        if (H != G) {
            String str = q + ",queueSize=" + d();
            if (H instanceof j) {
                return str + ",closedForSend=" + H;
            }
            return str;
        }
        return q;
    }

    private final void l(j<?> jVar) {
        Object b = kotlinx.coroutines.internal.m.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.p H = jVar.H();
            o oVar = H instanceof o ? (o) H : null;
            if (oVar == null) {
                break;
            } else if (!oVar.L()) {
                oVar.I();
            } else {
                b = kotlinx.coroutines.internal.m.c(b, oVar);
            }
        }
        if (b != null) {
            if (!(b instanceof ArrayList)) {
                ((o) b).S(jVar);
            } else {
                Objects.requireNonNull(b, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) b;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        ((o) arrayList.get(size)).S(jVar);
                        if (i2 < 0) {
                            break;
                        }
                        size = i2;
                    }
                }
            }
        }
        A(jVar);
    }

    private final Throwable n(j<?> jVar) {
        l(jVar);
        return jVar.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Continuation<?> continuation, E e2, j<?> jVar) {
        UndeliveredElementException d2;
        l(jVar);
        Throwable Y = jVar.Y();
        kotlin.jvm.b.l<E, kotlin.u> lVar = this.a;
        if (lVar == null || (d2 = OnUndeliveredElementKt.d(lVar, e2, null, 2, null)) == null) {
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m41constructorimpl(kotlin.j.a(Y)));
            return;
        }
        kotlin.b.a(d2, Y);
        Result.a aVar2 = Result.Companion;
        continuation.resumeWith(Result.m41constructorimpl(kotlin.j.a(d2)));
    }

    private final void p(Throwable th) {
        c0 c0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (c0Var = kotlinx.coroutines.channels.a.f8717f) || !c.compareAndSet(this, obj, c0Var)) {
            return;
        }
        y.d(obj, 1);
        ((kotlin.jvm.b.l) obj).invoke(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w() {
        return !(this.b.G() instanceof p) && u();
    }

    protected void A(kotlinx.coroutines.internal.p pVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p<?> B(E e2) {
        kotlinx.coroutines.internal.p H;
        kotlinx.coroutines.internal.p pVar = this.b;
        a aVar = new a(e2);
        do {
            H = pVar.H();
            if (H instanceof p) {
                return (p) H;
            }
        } while (!H.x(aVar, pVar));
        return null;
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean C(Throwable th) {
        boolean z;
        j<?> jVar = new j<>(th);
        kotlinx.coroutines.internal.p pVar = this.b;
        while (true) {
            kotlinx.coroutines.internal.p H = pVar.H();
            z = true;
            if (!(!(H instanceof j))) {
                z = false;
                break;
            } else if (H.x(jVar, pVar)) {
                break;
            }
        }
        if (!z) {
            jVar = (j) this.b.H();
        }
        l(jVar);
        if (z) {
            p(th);
        }
        return z;
    }

    @Override // kotlinx.coroutines.channels.s
    public final Object D(E e2, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        if (x(e2) == kotlinx.coroutines.channels.a.b) {
            return kotlin.u.a;
        }
        Object F = F(e2, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return F == coroutine_suspended ? F : kotlin.u.a;
    }

    @Override // kotlinx.coroutines.channels.s
    public final boolean E() {
        return i() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public p<E> G() {
        kotlinx.coroutines.internal.p pVar;
        kotlinx.coroutines.internal.p N;
        kotlinx.coroutines.internal.n nVar = this.b;
        while (true) {
            pVar = (kotlinx.coroutines.internal.p) nVar.E();
            if (pVar != nVar && (pVar instanceof p)) {
                if (((((p) pVar) instanceof j) && !pVar.K()) || (N = pVar.N()) == null) {
                    break;
                }
                N.J();
            }
        }
        pVar = null;
        return (p) pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final r H() {
        kotlinx.coroutines.internal.p pVar;
        kotlinx.coroutines.internal.p N;
        kotlinx.coroutines.internal.n nVar = this.b;
        while (true) {
            pVar = (kotlinx.coroutines.internal.p) nVar.E();
            if (pVar != nVar && (pVar instanceof r)) {
                if (((((r) pVar) instanceof j) && !pVar.K()) || (N = pVar.N()) == null) {
                    break;
                }
                N.J();
            }
        }
        pVar = null;
        return (r) pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object e(r rVar) {
        boolean z;
        kotlinx.coroutines.internal.p H;
        if (t()) {
            kotlinx.coroutines.internal.p pVar = this.b;
            do {
                H = pVar.H();
                if (H instanceof p) {
                    return H;
                }
            } while (!H.x(rVar, pVar));
            return null;
        }
        kotlinx.coroutines.internal.p pVar2 = this.b;
        C0322b c0322b = new C0322b(rVar, this);
        while (true) {
            kotlinx.coroutines.internal.p H2 = pVar2.H();
            if (!(H2 instanceof p)) {
                int P = H2.P(rVar, pVar2, c0322b);
                z = true;
                if (P != 1) {
                    if (P == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return H2;
            }
        }
        if (z) {
            return null;
        }
        return kotlinx.coroutines.channels.a.f8716e;
    }

    protected String g() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j<?> h() {
        kotlinx.coroutines.internal.p G = this.b.G();
        j<?> jVar = G instanceof j ? (j) G : null;
        if (jVar == null) {
            return null;
        }
        l(jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j<?> i() {
        kotlinx.coroutines.internal.p H = this.b.H();
        j<?> jVar = H instanceof j ? (j) H : null;
        if (jVar == null) {
            return null;
        }
        l(jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlinx.coroutines.internal.n j() {
        return this.b;
    }

    @Override // kotlinx.coroutines.channels.s
    public void m(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj == kotlinx.coroutines.channels.a.f8717f) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(kotlin.jvm.internal.s.q("Another handler was already registered: ", obj));
        }
        j<?> i2 = i();
        if (i2 == null || !atomicReferenceFieldUpdater.compareAndSet(this, lVar, kotlinx.coroutines.channels.a.f8717f)) {
            return;
        }
        lVar.invoke(i2.f8725d);
    }

    @Override // kotlinx.coroutines.channels.s
    public final Object q(E e2) {
        Object x = x(e2);
        if (x == kotlinx.coroutines.channels.a.b) {
            h.b bVar = h.b;
            kotlin.u uVar = kotlin.u.a;
            bVar.c(uVar);
            return uVar;
        } else if (x == kotlinx.coroutines.channels.a.c) {
            j<?> i2 = i();
            return i2 == null ? h.b.b() : h.b.a(n(i2));
        } else if (x instanceof j) {
            return h.b.a(n((j) x));
        } else {
            throw new IllegalStateException(kotlin.jvm.internal.s.q("trySend returned ", x).toString());
        }
    }

    protected abstract boolean t();

    public String toString() {
        return p0.a(this) + '@' + p0.b(this) + '{' + k() + '}' + g();
    }

    protected abstract boolean u();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object x(E e2) {
        p<E> G;
        c0 r;
        do {
            G = G();
            if (G == null) {
                return kotlinx.coroutines.channels.a.c;
            }
            r = G.r(e2, null);
        } while (r == null);
        if (o0.a()) {
            if (!(r == kotlinx.coroutines.r.a)) {
                throw new AssertionError();
            }
        }
        G.i(e2);
        return G.a();
    }
}
