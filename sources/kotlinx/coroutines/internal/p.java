package kotlinx.coroutines.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.o0;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class p {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static abstract class a extends kotlinx.coroutines.internal.b {
        @Override // kotlinx.coroutines.internal.b
        public final void a(kotlinx.coroutines.internal.d<?> dVar, Object obj) {
            boolean z = obj == null;
            p h2 = h();
            if (h2 == null) {
                if (o0.a() && !(!z)) {
                    throw new AssertionError();
                }
                return;
            }
            p i2 = i();
            if (i2 == null) {
                if (o0.a() && !(!z)) {
                    throw new AssertionError();
                }
                return;
            }
            if (p.a.compareAndSet(h2, dVar, z ? n(h2, i2) : i2) && z) {
                f(h2, i2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
            if (kotlinx.coroutines.o0.a() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
            if (r4 != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
            if (r7 == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
            return null;
         */
        @Override // kotlinx.coroutines.internal.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(kotlinx.coroutines.internal.d<?> r7) {
            /*
                r6 = this;
            L0:
                kotlinx.coroutines.internal.p r0 = r6.m(r7)
                if (r0 != 0) goto L9
                java.lang.Object r7 = kotlinx.coroutines.internal.c.b
                return r7
            L9:
                java.lang.Object r1 = r0._next
                r2 = 0
                if (r1 != r7) goto Lf
                return r2
            Lf:
                boolean r3 = r7.h()
                if (r3 == 0) goto L16
                return r2
            L16:
                boolean r3 = r1 instanceof kotlinx.coroutines.internal.w
                if (r3 == 0) goto L29
                kotlinx.coroutines.internal.w r1 = (kotlinx.coroutines.internal.w) r1
                boolean r2 = r7.b(r1)
                if (r2 == 0) goto L25
                java.lang.Object r7 = kotlinx.coroutines.internal.c.b
                return r7
            L25:
                r1.c(r0)
                goto L0
            L29:
                java.lang.Object r3 = r6.e(r0)
                if (r3 == 0) goto L30
                return r3
            L30:
                boolean r3 = r6.l(r0, r1)
                if (r3 == 0) goto L37
                goto L0
            L37:
                kotlinx.coroutines.internal.p$c r3 = new kotlinx.coroutines.internal.p$c
                r4 = r1
                kotlinx.coroutines.internal.p r4 = (kotlinx.coroutines.internal.p) r4
                r3.<init>(r0, r4, r6)
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.p.a
                boolean r4 = r4.compareAndSet(r0, r1, r3)
                if (r4 == 0) goto L0
                java.lang.Object r4 = r3.c(r0)     // Catch: java.lang.Throwable -> L65
                java.lang.Object r5 = kotlinx.coroutines.internal.q.a     // Catch: java.lang.Throwable -> L65
                if (r4 != r5) goto L50
                goto L0
            L50:
                boolean r7 = kotlinx.coroutines.o0.a()     // Catch: java.lang.Throwable -> L65
                if (r7 == 0) goto L64
                if (r4 != 0) goto L5a
                r7 = 1
                goto L5b
            L5a:
                r7 = 0
            L5b:
                if (r7 == 0) goto L5e
                goto L64
            L5e:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L65
                r7.<init>()     // Catch: java.lang.Throwable -> L65
                throw r7     // Catch: java.lang.Throwable -> L65
            L64:
                return r2
            L65:
                r7 = move-exception
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.internal.p.a
                r2.compareAndSet(r0, r3, r1)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.p.a.c(kotlinx.coroutines.internal.d):java.lang.Object");
        }

        protected abstract Object e(p pVar);

        protected abstract void f(p pVar, p pVar2);

        public abstract void g(c cVar);

        protected abstract p h();

        protected abstract p i();

        public Object j(c cVar) {
            g(cVar);
            return null;
        }

        public void k(p pVar) {
        }

        protected abstract boolean l(p pVar, Object obj);

        protected abstract p m(w wVar);

        public abstract Object n(p pVar, p pVar2);
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static abstract class b extends kotlinx.coroutines.internal.d<p> {
        public final p b;
        public p c;

        public b(p pVar) {
            this.b = pVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j */
        public void d(p pVar, Object obj) {
            boolean z = obj == null;
            p pVar2 = z ? this.b : this.c;
            if (pVar2 != null && p.a.compareAndSet(pVar, this, pVar2) && z) {
                p pVar3 = this.b;
                p pVar4 = this.c;
                kotlin.jvm.internal.s.e(pVar4);
                pVar3.D(pVar4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class c extends w {
        public final p a;
        public final p b;
        public final a c;

        public c(p pVar, p pVar2, a aVar) {
            this.a = pVar;
            this.b = pVar2;
            this.c = aVar;
        }

        @Override // kotlinx.coroutines.internal.w
        public kotlinx.coroutines.internal.d<?> a() {
            return this.c.b();
        }

        @Override // kotlinx.coroutines.internal.w
        public Object c(Object obj) {
            Object f2;
            Object obj2;
            if (o0.a()) {
                if (!(obj == this.a)) {
                    throw new AssertionError();
                }
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            p pVar = (p) obj;
            Object j2 = this.c.j(this);
            Object obj3 = q.a;
            if (j2 == obj3) {
                p pVar2 = this.b;
                if (p.a.compareAndSet(pVar, this, pVar2.O())) {
                    this.c.k(pVar);
                    pVar2.z(null);
                }
                return obj3;
            }
            if (j2 != null) {
                f2 = a().e(j2);
            } else {
                f2 = a().f();
            }
            if (f2 == kotlinx.coroutines.internal.c.a) {
                obj2 = a();
            } else if (f2 == null) {
                obj2 = this.c.n(pVar, this.b);
            } else {
                obj2 = this.b;
            }
            p.a.compareAndSet(pVar, this, obj2);
            return null;
        }

        public final void d() {
            this.c.g(this);
        }

        @Override // kotlinx.coroutines.internal.w
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static class d<T> extends a {
        private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_affectedNode");

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f8771d = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;
        public final p b;

        public d(p pVar) {
            this.b = pVar;
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected Object e(p pVar) {
            if (pVar == this.b) {
                return o.b();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected final void f(p pVar, p pVar2) {
            pVar2.z(null);
        }

        @Override // kotlinx.coroutines.internal.p.a
        public void g(c cVar) {
            c.compareAndSet(this, null, cVar.a);
            f8771d.compareAndSet(this, null, cVar.b);
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected final p h() {
            return (p) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected final p i() {
            return (p) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected final boolean l(p pVar, Object obj) {
            if (obj instanceof x) {
                ((x) obj).a.J();
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.p.a
        protected final p m(w wVar) {
            p pVar = this.b;
            while (true) {
                Object obj = pVar._next;
                if (obj instanceof w) {
                    w wVar2 = (w) obj;
                    if (wVar.b(wVar2)) {
                        return null;
                    }
                    wVar2.c(this.b);
                } else {
                    return (p) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.p.a
        public final Object n(p pVar, p pVar2) {
            return pVar2.O();
        }

        public final T o() {
            T t = (T) h();
            kotlin.jvm.internal.s.e(t);
            return t;
        }
    }

    private final p C(p pVar) {
        while (pVar.K()) {
            pVar = (p) pVar._prev;
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(p pVar) {
        p pVar2;
        do {
            pVar2 = (p) pVar._prev;
            if (E() != pVar) {
                return;
            }
        } while (!b.compareAndSet(pVar, pVar2, this));
        if (K()) {
            pVar.z(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x O() {
        x xVar = (x) this._removedRef;
        if (xVar == null) {
            x xVar2 = new x(this);
            c.lazySet(this, xVar2);
            return xVar2;
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (kotlinx.coroutines.internal.p.a.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.x) r4).a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.p z(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.p r0 = (kotlinx.coroutines.internal.p) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.p.b
            boolean r0 = r1.compareAndSet(r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.K()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.p.a
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.p r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.p r2 = (kotlinx.coroutines.internal.p) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.p r3 = (kotlinx.coroutines.internal.p) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.p.z(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.p");
    }

    public final Object E() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    public final p G() {
        return o.c(E());
    }

    public final p H() {
        p z = z(null);
        return z == null ? C((p) this._prev) : z;
    }

    public final void I() {
        ((x) E()).a.J();
    }

    public final void J() {
        p pVar = this;
        while (true) {
            Object E = pVar.E();
            if (!(E instanceof x)) {
                pVar.z(null);
                return;
            }
            pVar = ((x) E).a;
        }
    }

    public boolean K() {
        return E() instanceof x;
    }

    public boolean L() {
        return N() == null;
    }

    public final p M() {
        while (true) {
            p pVar = (p) E();
            if (pVar == this) {
                return null;
            }
            if (pVar.L()) {
                return pVar;
            }
            pVar.I();
        }
    }

    public final p N() {
        Object E;
        p pVar;
        do {
            E = E();
            if (E instanceof x) {
                return ((x) E).a;
            }
            if (E == this) {
                return (p) E;
            }
            pVar = (p) E;
        } while (!a.compareAndSet(this, E, pVar.O()));
        pVar.z(null);
        return null;
    }

    public final int P(p pVar, p pVar2, b bVar) {
        b.lazySet(pVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(pVar, pVar2);
        bVar.c = pVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, pVar2, bVar)) {
            return bVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    public final void w(p pVar) {
        do {
        } while (!H().x(pVar, this));
    }

    public final boolean x(p pVar, p pVar2) {
        b.lazySet(pVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(pVar, pVar2);
        if (atomicReferenceFieldUpdater.compareAndSet(this, pVar2, pVar)) {
            pVar.D(pVar2);
            return true;
        }
        return false;
    }

    public final boolean y(p pVar) {
        b.lazySet(pVar, this);
        a.lazySet(pVar, this);
        while (E() == this) {
            if (a.compareAndSet(this, this, pVar)) {
                pVar.D(this);
                return true;
            }
        }
        return false;
    }
}
