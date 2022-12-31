package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.u0;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class g1 extends h1 implements u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f8757d = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_queue");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f8758e = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    private final class a extends c {

        /* renamed from: d  reason: collision with root package name */
        private final p<kotlin.u> f8759d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, p<? super kotlin.u> pVar) {
            super(j2);
            this.f8759d = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8759d.B(g1.this, kotlin.u.a);
        }

        @Override // kotlinx.coroutines.g1.c
        public String toString() {
            return kotlin.jvm.internal.s.q(super.toString(), this.f8759d);
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    private static final class b extends c {

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f8761d;

        public b(long j2, Runnable runnable) {
            super(j2);
            this.f8761d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8761d.run();
        }

        @Override // kotlinx.coroutines.g1.c
        public String toString() {
            return kotlin.jvm.internal.s.q(super.toString(), this.f8761d);
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static abstract class c implements Runnable, Comparable<c>, b1, kotlinx.coroutines.internal.j0 {
        public long a;
        private Object b;
        private int c = -1;

        public c(long j2) {
            this.a = j2;
        }

        @Override // kotlinx.coroutines.internal.j0
        public void a(kotlinx.coroutines.internal.i0<?> i0Var) {
            kotlinx.coroutines.internal.c0 c0Var;
            Object obj = this.b;
            c0Var = j1.a;
            if (obj != c0Var) {
                this.b = i0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.j0
        public kotlinx.coroutines.internal.i0<?> b() {
            Object obj = this.b;
            if (obj instanceof kotlinx.coroutines.internal.i0) {
                return (kotlinx.coroutines.internal.i0) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.j0
        public int d() {
            return this.c;
        }

        @Override // kotlinx.coroutines.b1
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.c0 c0Var;
            kotlinx.coroutines.internal.c0 c0Var2;
            Object obj = this.b;
            c0Var = j1.a;
            if (obj == c0Var) {
                return;
            }
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                dVar.g(this);
            }
            c0Var2 = j1.a;
            this.b = c0Var2;
        }

        @Override // java.lang.Comparable
        /* renamed from: e */
        public int compareTo(c cVar) {
            int i2 = ((this.a - cVar.a) > 0L ? 1 : ((this.a - cVar.a) == 0L ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        public final synchronized int f(long j2, d dVar, g1 g1Var) {
            kotlinx.coroutines.internal.c0 c0Var;
            Object obj = this.b;
            c0Var = j1.a;
            if (obj == c0Var) {
                return 2;
            }
            synchronized (dVar) {
                c b = dVar.b();
                if (g1Var.d()) {
                    return 1;
                }
                if (b == null) {
                    dVar.b = j2;
                } else {
                    long j3 = b.a;
                    if (j3 - j2 < 0) {
                        j2 = j3;
                    }
                    if (j2 - dVar.b > 0) {
                        dVar.b = j2;
                    }
                }
                long j4 = this.a;
                long j5 = dVar.b;
                if (j4 - j5 < 0) {
                    this.a = j5;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final boolean g(long j2) {
            return j2 - this.a >= 0;
        }

        @Override // kotlinx.coroutines.internal.j0
        public void setIndex(int i2) {
            this.c = i2;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static final class d extends kotlinx.coroutines.internal.i0<c> {
        public long b;

        public d(long j2) {
            this.b = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean d() {
        return this._isCompleted;
    }

    private final void d0() {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        if (o0.a() && !d()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8757d;
                c0Var = j1.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, c0Var)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.s)) {
                c0Var2 = j1.b;
                if (obj == c0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.s sVar = new kotlinx.coroutines.internal.s(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (f8757d.compareAndSet(this, obj, sVar)) {
                    return;
                }
            } else {
                ((kotlinx.coroutines.internal.s) obj).d();
                return;
            }
        }
    }

    private final Runnable e0() {
        kotlinx.coroutines.internal.c0 c0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.s)) {
                c0Var = j1.b;
                if (obj == c0Var) {
                    return null;
                }
                if (f8757d.compareAndSet(this, obj, null)) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) obj;
                Object j2 = sVar.j();
                if (j2 != kotlinx.coroutines.internal.s.f8775h) {
                    return (Runnable) j2;
                }
                f8757d.compareAndSet(this, obj, sVar.i());
            }
        }
    }

    private final boolean g0(Runnable runnable) {
        kotlinx.coroutines.internal.c0 c0Var;
        while (true) {
            Object obj = this._queue;
            if (d()) {
                return false;
            }
            if (obj == null) {
                if (f8757d.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.s)) {
                c0Var = j1.b;
                if (obj == c0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.s sVar = new kotlinx.coroutines.internal.s(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                sVar.a(runnable);
                if (f8757d.compareAndSet(this, obj, sVar)) {
                    return true;
                }
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.s sVar2 = (kotlinx.coroutines.internal.s) obj;
                int a2 = sVar2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    f8757d.compareAndSet(this, obj, sVar2.i());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    private final void i0() {
        kotlinx.coroutines.d a2 = e.a();
        long nanoTime = a2 == null ? System.nanoTime() : a2.a();
        while (true) {
            d dVar = (d) this._delayed;
            c i2 = dVar == null ? null : dVar.i();
            if (i2 == null) {
                return;
            }
            a0(nanoTime, i2);
        }
    }

    private final int l0(long j2, c cVar) {
        if (d()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            f8758e.compareAndSet(this, null, new d(j2));
            Object obj = this._delayed;
            kotlin.jvm.internal.s.e(obj);
            dVar = (d) obj;
        }
        return cVar.f(j2, dVar, this);
    }

    private final void n0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean o0(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar == null ? null : dVar.e()) == cVar;
    }

    @Override // kotlinx.coroutines.f1
    protected long R() {
        kotlinx.coroutines.internal.c0 c0Var;
        if (super.R() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.s)) {
                c0Var = j1.b;
                if (obj == c0Var) {
                    return LocationRequestCompat.PASSIVE_INTERVAL;
                }
                return 0L;
            } else if (!((kotlinx.coroutines.internal.s) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        c e2 = dVar == null ? null : dVar.e();
        if (e2 == null) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j2 = e2.a;
        kotlinx.coroutines.d a2 = e.a();
        return kotlin.z.h.b(j2 - (a2 == null ? System.nanoTime() : a2.a()), 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057  */
    @Override // kotlinx.coroutines.f1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long W() {
        /*
            r9 = this;
            boolean r0 = r9.X()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.g1$d r0 = (kotlinx.coroutines.g1.d) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.d()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.d r3 = kotlinx.coroutines.e.a()
            if (r3 != 0) goto L20
            long r3 = java.lang.System.nanoTime()
            goto L24
        L20:
            long r3 = r3.a()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.j0 r5 = r0.b()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 != 0) goto L2e
            monitor-exit(r0)
            goto L45
        L2e:
            kotlinx.coroutines.g1$c r5 = (kotlinx.coroutines.g1.c) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.g(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3c
            boolean r5 = r9.g0(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3d
        L3c:
            r5 = 0
        L3d:
            if (r5 == 0) goto L44
            kotlinx.coroutines.internal.j0 r5 = r0.h(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.g1$c r6 = (kotlinx.coroutines.g1.c) r6
            if (r6 != 0) goto L24
            goto L4d
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.e0()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.R()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.g1.W():long");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f0(runnable);
    }

    @Override // kotlinx.coroutines.u0
    public void e(long j2, p<? super kotlin.u> pVar) {
        long d2 = j1.d(j2);
        if (d2 < 4611686018427387903L) {
            kotlinx.coroutines.d a2 = e.a();
            long nanoTime = a2 == null ? System.nanoTime() : a2.a();
            a aVar = new a(d2 + nanoTime, pVar);
            s.a(pVar, aVar);
            k0(nanoTime, aVar);
        }
    }

    public final void f0(Runnable runnable) {
        if (g0(runnable)) {
            b0();
        } else {
            q0.f8788f.f0(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h0() {
        kotlinx.coroutines.internal.c0 c0Var;
        if (V()) {
            d dVar = (d) this._delayed;
            if (dVar == null || dVar.d()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof kotlinx.coroutines.internal.s) {
                        return ((kotlinx.coroutines.internal.s) obj).g();
                    }
                    c0Var = j1.b;
                    if (obj != c0Var) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void k0(long j2, c cVar) {
        int l0 = l0(j2, cVar);
        if (l0 == 0) {
            if (o0(cVar)) {
                b0();
            }
        } else if (l0 == 1) {
            a0(j2, cVar);
        } else if (l0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // kotlinx.coroutines.u0
    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return u0.a.a(this, j2, runnable, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b1 m0(long j2, Runnable runnable) {
        long d2 = j1.d(j2);
        if (d2 < 4611686018427387903L) {
            kotlinx.coroutines.d a2 = e.a();
            long nanoTime = a2 == null ? System.nanoTime() : a2.a();
            b bVar = new b(d2 + nanoTime, runnable);
            k0(nanoTime, bVar);
            return bVar;
        }
        return i2.a;
    }

    @Override // kotlinx.coroutines.f1
    protected void shutdown() {
        v2.a.c();
        n0(true);
        d0();
        do {
        } while (W() <= 0);
        i0();
    }
}
