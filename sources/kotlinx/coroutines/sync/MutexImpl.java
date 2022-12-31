package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;
/* compiled from: Mutex.kt */
/* loaded from: classes3.dex */
public final class MutexImpl implements kotlinx.coroutines.sync.c, kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes3.dex */
    public final class LockCont extends a {

        /* renamed from: f  reason: collision with root package name */
        private final p<u> f8822f;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, p<? super u> pVar) {
            super(MutexImpl.this, obj);
            this.f8822f = pVar;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void Q() {
            this.f8822f.F(r.a);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean S() {
            return R() && this.f8822f.A(u.a, null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this)) != null;
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "LockCont[" + this.f8828d + ", " + this.f8822f + "] for " + MutexImpl.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes3.dex */
    public final class LockSelect<R> extends a {

        /* renamed from: f  reason: collision with root package name */
        public final kotlinx.coroutines.selects.f<R> f8824f;

        /* renamed from: g  reason: collision with root package name */
        public final kotlin.jvm.b.p<kotlinx.coroutines.sync.c, Continuation<? super R>, Object> f8825g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ MutexImpl f8826h;

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void Q() {
            kotlinx.coroutines.d3.a.e(this.f8825g, this.f8826h, this.f8824f.o(), new MutexImpl$LockSelect$completeResumeLockWaiter$1(this.f8826h, this));
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean S() {
            return R() && this.f8824f.n();
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "LockSelect[" + this.f8828d + ", " + this.f8824f + "] for " + this.f8826h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes3.dex */
    public abstract class a extends kotlinx.coroutines.internal.p implements b1 {

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f8827e = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "isTaken");

        /* renamed from: d  reason: collision with root package name */
        public final Object f8828d;
        private volatile /* synthetic */ Object isTaken = Boolean.FALSE;

        public a(MutexImpl mutexImpl, Object obj) {
            this.f8828d = obj;
        }

        public abstract void Q();

        public final boolean R() {
            return f8827e.compareAndSet(this, Boolean.FALSE, Boolean.TRUE);
        }

        public abstract boolean S();

        @Override // kotlinx.coroutines.b1
        public final void dispose() {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes3.dex */
    public static final class b extends n {

        /* renamed from: d  reason: collision with root package name */
        public Object f8829d;

        public b(Object obj) {
            this.f8829d = obj;
        }

        @Override // kotlinx.coroutines.internal.p
        public String toString() {
            return "LockedQueue[" + this.f8829d + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    /* loaded from: classes3.dex */
    public static final class c extends kotlinx.coroutines.internal.d<MutexImpl> {
        public final b b;

        public c(b bVar) {
            this.b = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j */
        public void d(MutexImpl mutexImpl, Object obj) {
            MutexImpl.a.compareAndSet(mutexImpl, this, obj == null ? MutexKt.f8832f : this.b);
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: k */
        public Object i(MutexImpl mutexImpl) {
            c0 c0Var;
            if (this.b.Q()) {
                return null;
            }
            c0Var = MutexKt.b;
            return c0Var;
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.f8831e : MutexKt.f8832f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        kotlinx.coroutines.s.c(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object c(java.lang.Object r7, kotlin.coroutines.Continuation<? super kotlin.u> r8) {
        /*
            r6 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r8)
            kotlinx.coroutines.q r0 = kotlinx.coroutines.s.b(r0)
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.b
            if (r3 == 0) goto L4a
            r3 = r2
            kotlinx.coroutines.sync.b r3 = (kotlinx.coroutines.sync.b) r3
            java.lang.Object r4 = r3.a
            kotlinx.coroutines.internal.c0 r5 = kotlinx.coroutines.sync.MutexKt.f()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.a
            kotlinx.coroutines.sync.MutexImpl$b r5 = new kotlinx.coroutines.sync.MutexImpl$b
            java.lang.Object r3 = r3.a
            r5.<init>(r3)
            r4.compareAndSet(r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            kotlinx.coroutines.sync.b r3 = kotlinx.coroutines.sync.MutexKt.c()
            goto L37
        L32:
            kotlinx.coroutines.sync.b r3 = new kotlinx.coroutines.sync.b
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.a
            boolean r2 = r4.compareAndSet(r6, r2, r3)
            if (r2 == 0) goto Ld
            kotlin.u r1 = kotlin.u.a
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r2 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r2.<init>(r6, r7)
            r0.k(r1, r2)
            goto L71
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.MutexImpl.b
            if (r3 == 0) goto L98
            r3 = r2
            kotlinx.coroutines.sync.MutexImpl$b r3 = (kotlinx.coroutines.sync.MutexImpl.b) r3
            java.lang.Object r4 = r3.f8829d
            if (r4 == r7) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L88
            r3.w(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L6e
            boolean r2 = r1.R()
            if (r2 != 0) goto L68
            goto L6e
        L68:
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
            goto Ld
        L6e:
            kotlinx.coroutines.s.c(r0, r1)
        L71:
            java.lang.Object r7 = r0.u()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r0) goto L7e
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8)
        L7e:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto L85
            return r7
        L85:
            kotlin.u r7 = kotlin.u.a
            return r7
        L88:
            java.lang.String r8 = "Already locked by "
            java.lang.String r7 = kotlin.jvm.internal.s.q(r8, r7)
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L98:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.w
            if (r3 == 0) goto La3
            kotlinx.coroutines.internal.w r2 = (kotlinx.coroutines.internal.w) r2
            r2.c(r6)
            goto Ld
        La3:
            java.lang.String r7 = "Illegal state "
            java.lang.String r7 = kotlin.jvm.internal.s.q(r7, r2)
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.c(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.c
    public Object a(Object obj, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        if (d(obj)) {
            return u.a;
        }
        Object c2 = c(obj, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c2 == coroutine_suspended ? c2 : u.a;
    }

    @Override // kotlinx.coroutines.sync.c
    public void b(Object obj) {
        kotlinx.coroutines.sync.b bVar;
        c0 c0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                if (obj == null) {
                    Object obj3 = ((kotlinx.coroutines.sync.b) obj2).a;
                    c0Var = MutexKt.f8830d;
                    if (!(obj3 != c0Var)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.b bVar2 = (kotlinx.coroutines.sync.b) obj2;
                    if (!(bVar2.a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                bVar = MutexKt.f8832f;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, bVar)) {
                    return;
                }
            } else if (obj2 instanceof w) {
                ((w) obj2).c(this);
            } else if (obj2 instanceof b) {
                if (obj != null) {
                    b bVar3 = (b) obj2;
                    if (!(bVar3.f8829d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar3.f8829d + " but expected " + obj).toString());
                    }
                }
                b bVar4 = (b) obj2;
                kotlinx.coroutines.internal.p M = bVar4.M();
                if (M == null) {
                    c cVar = new c(bVar4);
                    if (a.compareAndSet(this, obj2, cVar) && cVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) M;
                    if (aVar.S()) {
                        Object obj4 = aVar.f8828d;
                        if (obj4 == null) {
                            obj4 = MutexKt.c;
                        }
                        bVar4.f8829d = obj4;
                        aVar.Q();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(s.q("Illegal state ", obj2).toString());
            }
        }
    }

    public boolean d(Object obj) {
        c0 c0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                Object obj3 = ((kotlinx.coroutines.sync.b) obj2).a;
                c0Var = MutexKt.f8830d;
                if (obj3 != c0Var) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f8831e : new kotlinx.coroutines.sync.b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof b) {
                if (((b) obj2).f8829d != obj) {
                    return false;
                }
                throw new IllegalStateException(s.q("Already locked by ", obj).toString());
            } else if (!(obj2 instanceof w)) {
                throw new IllegalStateException(s.q("Illegal state ", obj2).toString());
            } else {
                ((w) obj2).c(this);
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return "Mutex[" + ((kotlinx.coroutines.sync.b) obj).a + ']';
            } else if (!(obj instanceof w)) {
                if (obj instanceof b) {
                    return "Mutex[" + ((b) obj).f8829d + ']';
                }
                throw new IllegalStateException(s.q("Illegal state ", obj).toString());
            } else {
                ((w) obj).c(this);
            }
        }
    }
}
