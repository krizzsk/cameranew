package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.p0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class AbstractChannel<E> extends kotlinx.coroutines.channels.b<E> implements kotlinx.coroutines.channels.e<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class a<E> implements ChannelIterator<E> {
        public final AbstractChannel<E> a;
        private Object b = kotlinx.coroutines.channels.a.f8715d;

        public a(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        private final boolean c(Object obj) {
            if (obj instanceof kotlinx.coroutines.channels.j) {
                kotlinx.coroutines.channels.j jVar = (kotlinx.coroutines.channels.j) obj;
                if (jVar.f8725d == null) {
                    return false;
                }
                throw b0.k(jVar.X());
            }
            return true;
        }

        private final Object d(Continuation<? super Boolean> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            kotlinx.coroutines.q b = kotlinx.coroutines.s.b(intercepted);
            d dVar = new d(this, b);
            while (true) {
                if (this.a.N(dVar)) {
                    this.a.c0(b, dVar);
                    break;
                }
                Object Y = this.a.Y();
                e(Y);
                if (Y instanceof kotlinx.coroutines.channels.j) {
                    kotlinx.coroutines.channels.j jVar = (kotlinx.coroutines.channels.j) Y;
                    if (jVar.f8725d == null) {
                        Boolean boxBoolean = Boxing.boxBoolean(false);
                        Result.a aVar = Result.Companion;
                        b.resumeWith(Result.m41constructorimpl(boxBoolean));
                    } else {
                        Throwable X = jVar.X();
                        Result.a aVar2 = Result.Companion;
                        b.resumeWith(Result.m41constructorimpl(kotlin.j.a(X)));
                    }
                } else if (Y != kotlinx.coroutines.channels.a.f8715d) {
                    Boolean boxBoolean2 = Boxing.boxBoolean(true);
                    kotlin.jvm.b.l<E, kotlin.u> lVar = this.a.a;
                    b.k(boxBoolean2, lVar == null ? null : OnUndeliveredElementKt.a(lVar, Y, b.getContext()));
                }
            }
            Object u = b.u();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (u == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation<? super Boolean> continuation) {
            Object b = b();
            c0 c0Var = kotlinx.coroutines.channels.a.f8715d;
            if (b != c0Var) {
                return Boxing.boxBoolean(c(b()));
            }
            e(this.a.Y());
            return b() != c0Var ? Boxing.boxBoolean(c(b())) : d(continuation);
        }

        public final Object b() {
            return this.b;
        }

        public final void e(Object obj) {
            this.b = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e2 = (E) this.b;
            if (!(e2 instanceof kotlinx.coroutines.channels.j)) {
                c0 c0Var = kotlinx.coroutines.channels.a.f8715d;
                if (e2 != c0Var) {
                    this.b = c0Var;
                    return e2;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw b0.k(((kotlinx.coroutines.channels.j) e2).X());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static class b<E> extends o<E> {

        /* renamed from: d  reason: collision with root package name */
        public final kotlinx.coroutines.p<Object> f8705d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8706e;

        public b(kotlinx.coroutines.p<Object> pVar, int i2) {
            this.f8705d = pVar;
            this.f8706e = i2;
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(kotlinx.coroutines.channels.j<?> jVar) {
            if (this.f8706e == 1) {
                kotlinx.coroutines.p<Object> pVar = this.f8705d;
                kotlinx.coroutines.channels.h b = kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.b.a(jVar.f8725d));
                Result.a aVar = Result.Companion;
                pVar.resumeWith(Result.m41constructorimpl(b));
                return;
            }
            kotlinx.coroutines.p<Object> pVar2 = this.f8705d;
            Throwable X = jVar.X();
            Result.a aVar2 = Result.Companion;
            pVar2.resumeWith(Result.m41constructorimpl(kotlin.j.a(X)));
        }

        public final Object T(E e2) {
            if (this.f8706e == 1) {
                kotlinx.coroutines.channels.h.b.c(e2);
                return kotlinx.coroutines.channels.h.b(e2);
            }
            return e2;
        }

        @Override // kotlinx.coroutines.channels.p
        public void i(E e2) {
            this.f8705d.F(kotlinx.coroutines.r.a);
        }

        @Override // kotlinx.coroutines.channels.p
        public c0 r(E e2, p.c cVar) {
            Object A = this.f8705d.A(T(e2), cVar == null ? null : cVar.c, R(e2));
            if (A == null) {
                return null;
            }
            if (o0.a()) {
                if (!(A == kotlinx.coroutines.r.a)) {
                    throw new AssertionError();
                }
            }
            if (cVar != null) {
                cVar.d();
            }
            return kotlinx.coroutines.r.a;
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "ReceiveElement@" + p0.b(this) + "[receiveMode=" + this.f8706e + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class c<E> extends b<E> {

        /* renamed from: f  reason: collision with root package name */
        public final kotlin.jvm.b.l<E, kotlin.u> f8707f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(kotlinx.coroutines.p<Object> pVar, int i2, kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
            super(pVar, i2);
            this.f8707f = lVar;
        }

        @Override // kotlinx.coroutines.channels.o
        public kotlin.jvm.b.l<Throwable, kotlin.u> R(E e2) {
            return OnUndeliveredElementKt.a(this.f8707f, e2, this.f8705d.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static class d<E> extends o<E> {

        /* renamed from: d  reason: collision with root package name */
        public final a<E> f8708d;

        /* renamed from: e  reason: collision with root package name */
        public final kotlinx.coroutines.p<Boolean> f8709e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> aVar, kotlinx.coroutines.p<? super Boolean> pVar) {
            this.f8708d = aVar;
            this.f8709e = pVar;
        }

        @Override // kotlinx.coroutines.channels.o
        public kotlin.jvm.b.l<Throwable, kotlin.u> R(E e2) {
            kotlin.jvm.b.l<E, kotlin.u> lVar = this.f8708d.a.a;
            if (lVar == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(lVar, e2, this.f8709e.getContext());
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(kotlinx.coroutines.channels.j<?> jVar) {
            Object g2;
            if (jVar.f8725d == null) {
                g2 = p.a.a(this.f8709e, Boolean.FALSE, null, 2, null);
            } else {
                g2 = this.f8709e.g(jVar.X());
            }
            if (g2 != null) {
                this.f8708d.e(jVar);
                this.f8709e.F(g2);
            }
        }

        @Override // kotlinx.coroutines.channels.p
        public void i(E e2) {
            this.f8708d.e(e2);
            this.f8709e.F(kotlinx.coroutines.r.a);
        }

        @Override // kotlinx.coroutines.channels.p
        public c0 r(E e2, p.c cVar) {
            Object A = this.f8709e.A(Boolean.TRUE, cVar == null ? null : cVar.c, R(e2));
            if (A == null) {
                return null;
            }
            if (o0.a()) {
                if (!(A == kotlinx.coroutines.r.a)) {
                    throw new AssertionError();
                }
            }
            if (cVar != null) {
                cVar.d();
            }
            return kotlinx.coroutines.r.a;
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return kotlin.jvm.internal.s.q("ReceiveHasNext@", p0.b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class e<R, E> extends o<E> implements b1 {

        /* renamed from: d  reason: collision with root package name */
        public final AbstractChannel<E> f8710d;

        /* renamed from: e  reason: collision with root package name */
        public final kotlinx.coroutines.selects.f<R> f8711e;

        /* renamed from: f  reason: collision with root package name */
        public final kotlin.jvm.b.p<Object, Continuation<? super R>, Object> f8712f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8713g;

        /* JADX WARN: Multi-variable type inference failed */
        public e(AbstractChannel<E> abstractChannel, kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<Object, ? super Continuation<? super R>, ? extends Object> pVar, int i2) {
            this.f8710d = abstractChannel;
            this.f8711e = fVar;
            this.f8712f = pVar;
            this.f8713g = i2;
        }

        @Override // kotlinx.coroutines.channels.o
        public kotlin.jvm.b.l<Throwable, kotlin.u> R(E e2) {
            kotlin.jvm.b.l<E, kotlin.u> lVar = this.f8710d.a;
            if (lVar == null) {
                return null;
            }
            return OnUndeliveredElementKt.a(lVar, e2, this.f8711e.o().getContext());
        }

        @Override // kotlinx.coroutines.channels.o
        public void S(kotlinx.coroutines.channels.j<?> jVar) {
            if (this.f8711e.n()) {
                int i2 = this.f8713g;
                if (i2 == 0) {
                    this.f8711e.p(jVar.X());
                } else if (i2 != 1) {
                } else {
                    kotlinx.coroutines.d3.a.f(this.f8712f, kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.b.a(jVar.f8725d)), this.f8711e.o(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.b1
        public void dispose() {
            if (L()) {
                this.f8710d.W();
            }
        }

        @Override // kotlinx.coroutines.channels.p
        public void i(E e2) {
            Object obj;
            kotlin.jvm.b.p<Object, Continuation<? super R>, Object> pVar = this.f8712f;
            if (this.f8713g == 1) {
                kotlinx.coroutines.channels.h.b.c(e2);
                obj = kotlinx.coroutines.channels.h.b(e2);
            } else {
                obj = e2;
            }
            kotlinx.coroutines.d3.a.e(pVar, obj, this.f8711e.o(), R(e2));
        }

        @Override // kotlinx.coroutines.channels.p
        public c0 r(E e2, p.c cVar) {
            return (c0) this.f8711e.m(cVar);
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "ReceiveSelect@" + p0.b(this) + '[' + this.f8711e + ",receiveMode=" + this.f8713g + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public final class f extends kotlinx.coroutines.g {
        private final o<?> a;

        public f(o<?> oVar) {
            this.a = oVar;
        }

        @Override // kotlinx.coroutines.o
        public void a(Throwable th) {
            if (this.a.L()) {
                AbstractChannel.this.W();
            }
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            a(th);
            return kotlin.u.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class g<E> extends p.d<r> {
        public g(kotlinx.coroutines.internal.n nVar) {
            super(nVar);
        }

        @Override // kotlinx.coroutines.internal.p.d, kotlinx.coroutines.internal.p.a
        protected Object e(kotlinx.coroutines.internal.p pVar) {
            if (pVar instanceof kotlinx.coroutines.channels.j) {
                return pVar;
            }
            if (pVar instanceof r) {
                return null;
            }
            return kotlinx.coroutines.channels.a.f8715d;
        }

        @Override // kotlinx.coroutines.internal.p.a
        public Object j(p.c cVar) {
            c0 T = ((r) cVar.a).T(cVar);
            if (T == null) {
                return kotlinx.coroutines.internal.q.a;
            }
            Object obj = kotlinx.coroutines.internal.c.b;
            if (T == obj) {
                return obj;
            }
            if (o0.a()) {
                if (T == kotlinx.coroutines.r.a) {
                    return null;
                }
                throw new AssertionError();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.p.a
        public void k(kotlinx.coroutines.internal.p pVar) {
            ((r) pVar).U();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class h extends p.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AbstractChannel f8714d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(kotlinx.coroutines.internal.p pVar, AbstractChannel abstractChannel) {
            super(pVar);
            this.f8714d = abstractChannel;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: k */
        public Object i(kotlinx.coroutines.internal.p pVar) {
            if (this.f8714d.R()) {
                return null;
            }
            return kotlinx.coroutines.internal.o.a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class i implements kotlinx.coroutines.selects.d<E> {
        final /* synthetic */ AbstractChannel<E> a;

        i(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void c(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super E, ? super Continuation<? super R>, ? extends Object> pVar) {
            this.a.b0(fVar, 0, pVar);
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class j implements kotlinx.coroutines.selects.d<kotlinx.coroutines.channels.h<? extends E>> {
        final /* synthetic */ AbstractChannel<E> a;

        j(AbstractChannel<E> abstractChannel) {
            this.a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void c(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super kotlinx.coroutines.channels.h<? extends E>, ? super Continuation<? super R>, ? extends Object> pVar) {
            this.a.b0(fVar, 1, pVar);
        }
    }

    public AbstractChannel(kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(o<? super E> oVar) {
        boolean O = O(oVar);
        if (O) {
            X();
        }
        return O;
    }

    private final <R> boolean P(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<Object, ? super Continuation<? super R>, ? extends Object> pVar, int i2) {
        e eVar = new e(this, fVar, pVar, i2);
        boolean N = N(eVar);
        if (N) {
            fVar.j(eVar);
        }
        return N;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$b] */
    private final <R> Object a0(int i2, Continuation<? super R> continuation) {
        Continuation intercepted;
        c cVar;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.q b2 = kotlinx.coroutines.s.b(intercepted);
        if (this.a == null) {
            cVar = new b(b2, i2);
        } else {
            cVar = new c(b2, i2, this.a);
        }
        while (true) {
            if (N(cVar)) {
                c0(b2, cVar);
                break;
            }
            Object Y = Y();
            if (Y instanceof kotlinx.coroutines.channels.j) {
                cVar.S((kotlinx.coroutines.channels.j) Y);
                break;
            } else if (Y != kotlinx.coroutines.channels.a.f8715d) {
                b2.k(cVar.T(Y), cVar.R(Y));
                break;
            }
        }
        Object u = b2.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void b0(kotlinx.coroutines.selects.f<? super R> fVar, int i2, kotlin.jvm.b.p<Object, ? super Continuation<? super R>, ? extends Object> pVar) {
        while (!fVar.f()) {
            if (T()) {
                if (P(fVar, pVar, i2)) {
                    return;
                }
            } else {
                Object Z = Z(fVar);
                if (Z == kotlinx.coroutines.selects.g.d()) {
                    return;
                }
                if (Z != kotlinx.coroutines.channels.a.f8715d && Z != kotlinx.coroutines.internal.c.b) {
                    d0(pVar, fVar, i2, Z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(kotlinx.coroutines.p<?> pVar, o<?> oVar) {
        pVar.e(new f(oVar));
    }

    private final <R> void d0(kotlin.jvm.b.p<Object, ? super Continuation<? super R>, ? extends Object> pVar, kotlinx.coroutines.selects.f<? super R> fVar, int i2, Object obj) {
        boolean z = obj instanceof kotlinx.coroutines.channels.j;
        if (z) {
            if (i2 != 0) {
                if (i2 == 1 && fVar.n()) {
                    kotlinx.coroutines.d3.b.d(pVar, kotlinx.coroutines.channels.h.b(kotlinx.coroutines.channels.h.b.a(((kotlinx.coroutines.channels.j) obj).f8725d)), fVar.o());
                    return;
                }
                return;
            }
            throw b0.k(((kotlinx.coroutines.channels.j) obj).X());
        } else if (i2 == 1) {
            h.b bVar = kotlinx.coroutines.channels.h.b;
            if (z) {
                obj = bVar.a(((kotlinx.coroutines.channels.j) obj).f8725d);
            } else {
                bVar.c(obj);
            }
            kotlinx.coroutines.d3.b.d(pVar, kotlinx.coroutines.channels.h.b(obj), fVar.o());
        } else {
            kotlinx.coroutines.d3.b.d(pVar, obj, fVar.o());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.b
    public p<E> G() {
        p<E> G = super.G();
        if (G != null && !(G instanceof kotlinx.coroutines.channels.j)) {
            W();
        }
        return G;
    }

    public final boolean L(Throwable th) {
        boolean C = C(th);
        U(C);
        return C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g<E> M() {
        return new g<>(j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean O(o<? super E> oVar) {
        int P;
        kotlinx.coroutines.internal.p H;
        if (Q()) {
            kotlinx.coroutines.internal.p j2 = j();
            do {
                H = j2.H();
                if (!(!(H instanceof r))) {
                    return false;
                }
            } while (!H.x(oVar, j2));
        } else {
            kotlinx.coroutines.internal.p j3 = j();
            h hVar = new h(oVar, this);
            do {
                kotlinx.coroutines.internal.p H2 = j3.H();
                if (!(!(H2 instanceof r))) {
                    return false;
                }
                P = H2.P(oVar, j3, hVar);
                if (P != 1) {
                }
            } while (P != 2);
            return false;
        }
        return true;
    }

    protected abstract boolean Q();

    protected abstract boolean R();

    public boolean S() {
        return h() != null && R();
    }

    protected final boolean T() {
        return !(j().G() instanceof r) && R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(boolean z) {
        kotlinx.coroutines.channels.j<?> i2 = i();
        if (i2 != null) {
            Object b2 = kotlinx.coroutines.internal.m.b(null, 1, null);
            while (true) {
                kotlinx.coroutines.internal.p H = i2.H();
                if (H instanceof kotlinx.coroutines.internal.n) {
                    V(b2, i2);
                    return;
                } else if (o0.a() && !(H instanceof r)) {
                    throw new AssertionError();
                } else {
                    if (!H.L()) {
                        H.I();
                    } else {
                        b2 = kotlinx.coroutines.internal.m.c(b2, (r) H);
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    protected void V(Object obj, kotlinx.coroutines.channels.j<?> jVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((r) obj).S(jVar);
            return;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            ((r) arrayList.get(size)).S(jVar);
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    protected void W() {
    }

    protected void X() {
    }

    protected Object Y() {
        while (true) {
            r H = H();
            if (H == null) {
                return kotlinx.coroutines.channels.a.f8715d;
            }
            c0 T = H.T(null);
            if (T != null) {
                if (o0.a()) {
                    if (!(T == kotlinx.coroutines.r.a)) {
                        throw new AssertionError();
                    }
                }
                H.Q();
                return H.R();
            }
            H.U();
        }
    }

    protected Object Z(kotlinx.coroutines.selects.f<?> fVar) {
        g<E> M = M();
        Object q = fVar.q(M);
        if (q != null) {
            return q;
        }
        M.o().Q();
        return M.o().R();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void a(CancellationException cancellationException) {
        if (S()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(kotlin.jvm.internal.s.q(p0.a(this), " was cancelled"));
        }
        L(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return (E) e.a.a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.d<E> r() {
        return new i(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.d<kotlinx.coroutines.channels.h<E>> s() {
        return new j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object y() {
        Object Y = Y();
        if (Y == kotlinx.coroutines.channels.a.f8715d) {
            return kotlinx.coroutines.channels.h.b.b();
        }
        if (Y instanceof kotlinx.coroutines.channels.j) {
            return kotlinx.coroutines.channels.h.b.a(((kotlinx.coroutines.channels.j) Y).f8725d);
        }
        kotlinx.coroutines.channels.h.b.c(Y);
        return Y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.h<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r5)
            goto L5a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.j.b(r5)
            java.lang.Object r5 = r4.Y()
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.a.f8715d
            if (r5 == r2) goto L51
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.j
            if (r0 == 0) goto L4b
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.b
            kotlinx.coroutines.channels.j r5 = (kotlinx.coroutines.channels.j) r5
            java.lang.Throwable r5 = r5.f8725d
            java.lang.Object r5 = r0.a(r5)
            goto L50
        L4b:
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.b
            r0.c(r5)
        L50:
            return r5
        L51:
            r0.label = r3
            java.lang.Object r5 = r4.a0(r3, r0)
            if (r5 != r1) goto L5a
            return r1
        L5a:
            kotlinx.coroutines.channels.h r5 = (kotlinx.coroutines.channels.h) r5
            java.lang.Object r5 = r5.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
