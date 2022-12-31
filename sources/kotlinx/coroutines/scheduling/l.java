package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.o0;
/* compiled from: WorkQueue.kt */
/* loaded from: classes3.dex */
public final class l {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask");
    private static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8812d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8813e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray<h> a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(l lVar, h hVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return lVar.a(hVar, z);
    }

    private final h c(h hVar) {
        if (hVar.b.y() == 1) {
            f8813e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.a.get(i2) != null) {
            Thread.yield();
        }
        this.a.lazySet(i2, hVar);
        c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            if (hVar.b.y() == 1) {
                int decrementAndGet = f8813e.decrementAndGet(this);
                if (o0.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f8812d.compareAndSet(this, i2, i2 + 1) && (andSet = this.a.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(c cVar) {
        h i2 = i();
        if (i2 == null) {
            return false;
        }
        cVar.a(i2);
        return true;
    }

    private final long m(l lVar, boolean z) {
        h hVar;
        do {
            hVar = (h) lVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z) {
                if (!(hVar.b.y() == 1)) {
                    return -2L;
                }
            }
            long a = k.f8811e.a() - hVar.a;
            long j2 = k.a;
            if (a < j2) {
                return j2 - a;
            }
        } while (!b.compareAndSet(lVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }

    public final h a(h hVar, boolean z) {
        if (z) {
            return c(hVar);
        }
        h hVar2 = (h) b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(c cVar) {
        h hVar = (h) b.getAndSet(this, null);
        if (hVar != null) {
            cVar.a(hVar);
        }
        do {
        } while (j(cVar));
    }

    public final h h() {
        h hVar = (h) b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final long k(l lVar) {
        if (o0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = lVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = lVar.a;
        for (int i3 = lVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (lVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i4);
            if (hVar != null) {
                if ((hVar.b.y() == 1) && atomicReferenceArray.compareAndSet(i4, hVar, null)) {
                    f8813e.decrementAndGet(lVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(lVar, true);
    }

    public final long l(l lVar) {
        if (o0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        h i2 = lVar.i();
        if (i2 != null) {
            h b2 = b(this, i2, false, 2, null);
            if (o0.a()) {
                if (b2 == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return m(lVar, false);
    }
}
