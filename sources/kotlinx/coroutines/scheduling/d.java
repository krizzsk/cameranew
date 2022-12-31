package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
final class d extends ExecutorCoroutineDispatcher implements i, Executor {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8807f = AtomicIntegerFieldUpdater.newUpdater(d.class, "inFlightTasks");
    private final b a;
    private final int b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8808d;

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f8809e = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public d(b bVar, int i2, String str, int i3) {
        this.a = bVar;
        this.b = i2;
        this.c = str;
        this.f8808d = i3;
    }

    private final void s(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f8807f;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.b) {
                this.a.A(runnable, this, z);
                return;
            }
            this.f8809e.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.b) {
                return;
            }
            runnable = this.f8809e.poll();
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        s(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        s(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        s(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.c;
        if (str == null) {
            return super.toString() + "[dispatcher = " + this.a + ']';
        }
        return str;
    }

    @Override // kotlinx.coroutines.scheduling.i
    public void v() {
        Runnable poll = this.f8809e.poll();
        if (poll != null) {
            this.a.A(poll, this, true);
            return;
        }
        f8807f.decrementAndGet(this);
        Runnable poll2 = this.f8809e.poll();
        if (poll2 == null) {
            return;
        }
        s(poll2, true);
    }

    @Override // kotlinx.coroutines.scheduling.i
    public int y() {
        return this.f8808d;
    }
}
