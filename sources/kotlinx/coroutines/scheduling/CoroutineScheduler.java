package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
import kotlin.u;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    public final int a;
    public final int b;
    public final long c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f8794d;

    /* renamed from: e  reason: collision with root package name */
    public final c f8795e;

    /* renamed from: f  reason: collision with root package name */
    public final c f8796f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReferenceArray<b> f8797g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k  reason: collision with root package name */
    public static final c0 f8793k = new c0("NOT_IN_STACK");

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f8790h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f8791i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8792j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.f8794d = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 > 0) {
            this.f8795e = new c();
            this.f8796f = new c();
            this.parkedWorkersStack = 0L;
            this.f8797g = new AtomicReferenceArray<>(i3 + 1);
            this.controlState = i2 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
    }

    private final void O(boolean z) {
        long addAndGet = f8791i.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (z || U() || S(addAndGet)) {
            return;
        }
        U();
    }

    private final h R(b bVar, h hVar, boolean z) {
        if (bVar == null || bVar.b == WorkerState.TERMINATED) {
            return hVar;
        }
        if (hVar.b.y() == 0 && bVar.b == WorkerState.BLOCKING) {
            return hVar;
        }
        bVar.f8801f = true;
        return bVar.a.a(hVar, z);
    }

    private final boolean S(long j2) {
        int a2;
        a2 = kotlin.z.j.a(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0);
        if (a2 < this.a) {
            int d2 = d();
            if (d2 == 1 && this.a > 1) {
                d();
            }
            if (d2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean T(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.S(j2);
    }

    private final boolean U() {
        b x;
        do {
            x = x();
            if (x == null) {
                return false;
            }
        } while (!b.f8798h.compareAndSet(x, -1, 0));
        LockSupport.unpark(x);
        return true;
    }

    private final boolean a(h hVar) {
        if (hVar.b.y() == 1) {
            return this.f8796f.a(hVar);
        }
        return this.f8795e.a(hVar);
    }

    private final int d() {
        int a2;
        synchronized (this.f8797g) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            a2 = kotlin.z.j.a(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (a2 >= this.a) {
                return 0;
            }
            if (i2 >= this.b) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.f8797g.get(i3) == null) {
                b bVar = new b(i3);
                this.f8797g.set(i3, bVar);
                if (i3 == ((int) (2097151 & f8791i.incrementAndGet(this)))) {
                    bVar.start();
                    return a2 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final b t() {
        Thread currentThread = Thread.currentThread();
        b bVar = currentThread instanceof b ? (b) currentThread : null;
        if (bVar != null && s.c(CoroutineScheduler.this, this)) {
            return bVar;
        }
        return null;
    }

    public static /* synthetic */ void v(CoroutineScheduler coroutineScheduler, Runnable runnable, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iVar = f.a;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.u(runnable, iVar, z);
    }

    private final int w(b bVar) {
        Object g2 = bVar.g();
        while (g2 != f8793k) {
            if (g2 == null) {
                return 0;
            }
            b bVar2 = (b) g2;
            int f2 = bVar2.f();
            if (f2 != 0) {
                return f2;
            }
            g2 = bVar2.g();
        }
        return -1;
    }

    private final b x() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.f8797g.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int w = w(bVar);
            if (w >= 0 && f8790h.compareAndSet(this, j2, w | j3)) {
                bVar.o(f8793k);
                return bVar;
            }
        }
    }

    public final void A(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                kotlinx.coroutines.d a2 = kotlinx.coroutines.e.a();
                if (a2 == null) {
                }
            } finally {
                kotlinx.coroutines.d a3 = kotlinx.coroutines.e.a();
                if (a3 != null) {
                    a3.e();
                }
            }
        }
    }

    public final void N(long j2) {
        int i2;
        if (f8792j.compareAndSet(this, 0, 1)) {
            b t = t();
            synchronized (this.f8797g) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    b bVar = this.f8797g.get(i3);
                    s.e(bVar);
                    b bVar2 = bVar;
                    if (bVar2 != t) {
                        while (bVar2.isAlive()) {
                            LockSupport.unpark(bVar2);
                            bVar2.join(j2);
                        }
                        WorkerState workerState = bVar2.b;
                        if (o0.a()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        bVar2.a.g(this.f8796f);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            this.f8796f.b();
            this.f8795e.b();
            while (true) {
                h e2 = t == null ? null : t.e(true);
                if (e2 == null && (e2 = this.f8795e.d()) == null && (e2 = this.f8796f.d()) == null) {
                    break;
                }
                A(e2);
            }
            if (t != null) {
                t.r(WorkerState.TERMINATED);
            }
            if (o0.a()) {
                if (!(((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.a)) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void Q() {
        if (U() || T(this, 0L, 1, null)) {
            return;
        }
        U();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        N(10000L);
    }

    public final h e(Runnable runnable, i iVar) {
        long a2 = k.f8811e.a();
        if (runnable instanceof h) {
            h hVar = (h) runnable;
            hVar.a = a2;
            hVar.b = iVar;
            return hVar;
        }
        return new j(runnable, a2, iVar);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        v(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        int length = this.f8797g.length();
        int i6 = 0;
        if (1 < length) {
            i3 = 0;
            int i7 = 0;
            i4 = 0;
            i5 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i8 + 1;
                b bVar = this.f8797g.get(i8);
                if (bVar != null) {
                    int f2 = bVar.a.f();
                    int i10 = a.a[bVar.b.ordinal()];
                    if (i10 == 1) {
                        i6++;
                    } else if (i10 == 2) {
                        i3++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(f2);
                        sb.append('b');
                        arrayList.add(sb.toString());
                    } else if (i10 == 3) {
                        i7++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f2);
                        sb2.append('c');
                        arrayList.add(sb2.toString());
                    } else if (i10 == 4) {
                        i4++;
                        if (f2 > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(f2);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (i10 == 5) {
                        i5++;
                    }
                }
                if (i9 >= length) {
                    break;
                }
                i8 = i9;
            }
            i2 = i6;
            i6 = i7;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        long j2 = this.controlState;
        return this.f8794d + '@' + p0.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i6 + ", blocking = " + i3 + ", parked = " + i2 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f8795e.c() + ", global blocking queue size = " + this.f8796f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final void u(Runnable runnable, i iVar, boolean z) {
        kotlinx.coroutines.d a2 = kotlinx.coroutines.e.a();
        if (a2 != null) {
            a2.d();
        }
        h e2 = e(runnable, iVar);
        b t = t();
        h R = R(t, e2, z);
        if (R != null && !a(R)) {
            throw new RejectedExecutionException(s.q(this.f8794d, " was terminated"));
        }
        boolean z2 = z && t != null;
        if (e2.b.y() != 0) {
            O(z2);
        } else if (z2) {
        } else {
            Q();
        }
    }

    public final boolean y(b bVar) {
        long j2;
        long j3;
        int f2;
        if (bVar.g() != f8793k) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            f2 = bVar.f();
            if (o0.a()) {
                if (!(f2 != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.o(this.f8797g.get(i2));
        } while (!f8790h.compareAndSet(this, j2, f2 | j3));
        return true;
    }

    public final void z(b bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? w(bVar) : i3;
            }
            if (i4 >= 0 && f8790h.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public final class b extends Thread {

        /* renamed from: h  reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f8798h = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
        public final l a;
        public WorkerState b;
        private long c;

        /* renamed from: d  reason: collision with root package name */
        private long f8799d;

        /* renamed from: e  reason: collision with root package name */
        private int f8800e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8801f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private b() {
            setDaemon(true);
            this.a = new l();
            this.b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f8793k;
            this.f8800e = Random.Default.nextInt();
        }

        private final void a(int i2) {
            if (i2 == 0) {
                return;
            }
            CoroutineScheduler.f8791i.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.b;
            if (workerState != WorkerState.TERMINATED) {
                if (o0.a()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.DORMANT;
            }
        }

        private final void b(int i2) {
            if (i2 != 0 && r(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.Q();
            }
        }

        private final void c(h hVar) {
            int y = hVar.b.y();
            h(y);
            b(y);
            CoroutineScheduler.this.A(hVar);
            a(y);
        }

        private final h d(boolean z) {
            h l2;
            h l3;
            if (z) {
                boolean z2 = j(CoroutineScheduler.this.a * 2) == 0;
                if (z2 && (l3 = l()) != null) {
                    return l3;
                }
                h h2 = this.a.h();
                if (h2 != null) {
                    return h2;
                }
                if (!z2 && (l2 = l()) != null) {
                    return l2;
                }
            } else {
                h l4 = l();
                if (l4 != null) {
                    return l4;
                }
            }
            return s(false);
        }

        private final void h(int i2) {
            this.c = 0L;
            if (this.b == WorkerState.PARKING) {
                if (o0.a()) {
                    if (!(i2 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.b = WorkerState.BLOCKING;
            }
        }

        private final boolean i() {
            return this.nextParkedWorker != CoroutineScheduler.f8793k;
        }

        private final void k() {
            if (this.c == 0) {
                this.c = System.nanoTime() + CoroutineScheduler.this.c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.c);
            if (System.nanoTime() - this.c >= 0) {
                this.c = 0L;
                t();
            }
        }

        private final h l() {
            if (j(2) == 0) {
                h d2 = CoroutineScheduler.this.f8795e.d();
                return d2 == null ? CoroutineScheduler.this.f8796f.d() : d2;
            }
            h d3 = CoroutineScheduler.this.f8796f.d();
            return d3 == null ? CoroutineScheduler.this.f8795e.d() : d3;
        }

        private final void m() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.b != WorkerState.TERMINATED) {
                    h e2 = e(this.f8801f);
                    if (e2 != null) {
                        this.f8799d = 0L;
                        c(e2);
                    } else {
                        this.f8801f = false;
                        if (this.f8799d == 0) {
                            q();
                        } else if (z) {
                            r(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f8799d);
                            this.f8799d = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            r(WorkerState.TERMINATED);
        }

        private final boolean p() {
            boolean z;
            if (this.b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                        if (CoroutineScheduler.f8791i.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void q() {
            if (!i()) {
                CoroutineScheduler.this.y(this);
                return;
            }
            if (o0.a()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (i() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.b != WorkerState.TERMINATED) {
                r(WorkerState.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final h s(boolean z) {
            long l2;
            if (o0.a()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i2 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int j2 = j(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j3 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                j2++;
                if (j2 > i2) {
                    j2 = 1;
                }
                b bVar = coroutineScheduler.f8797g.get(j2);
                if (bVar != null && bVar != this) {
                    if (o0.a()) {
                        if (!(this.a.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        l2 = this.a.k(bVar.a);
                    } else {
                        l2 = this.a.l(bVar.a);
                    }
                    if (l2 == -1) {
                        return this.a.h();
                    }
                    if (l2 > 0) {
                        j3 = Math.min(j3, l2);
                    }
                }
            }
            if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                j3 = 0;
            }
            this.f8799d = j3;
            return null;
        }

        private final void t() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f8797g) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.a) {
                    return;
                }
                if (f8798h.compareAndSet(this, -1, 1)) {
                    int f2 = f();
                    n(0);
                    coroutineScheduler.z(this, f2, 0);
                    int andDecrement = (int) (CoroutineScheduler.f8791i.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != f2) {
                        b bVar = coroutineScheduler.f8797g.get(andDecrement);
                        s.e(bVar);
                        b bVar2 = bVar;
                        coroutineScheduler.f8797g.set(f2, bVar2);
                        bVar2.n(f2);
                        coroutineScheduler.z(bVar2, andDecrement, f2);
                    }
                    coroutineScheduler.f8797g.set(andDecrement, null);
                    u uVar = u.a;
                    this.b = WorkerState.TERMINATED;
                }
            }
        }

        public final h e(boolean z) {
            h d2;
            if (p()) {
                return d(z);
            }
            if (z) {
                d2 = this.a.h();
                if (d2 == null) {
                    d2 = CoroutineScheduler.this.f8796f.d();
                }
            } else {
                d2 = CoroutineScheduler.this.f8796f.d();
            }
            return d2 == null ? s(true) : d2;
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i2) {
            int i3 = this.f8800e;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f8800e = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void n(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f8794d);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(WorkerState workerState) {
            WorkerState workerState2 = this.b;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f8791i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.b = workerState;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public b(int i2) {
            this();
            n(i2);
        }
    }
}
