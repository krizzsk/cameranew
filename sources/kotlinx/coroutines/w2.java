package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* compiled from: Interruptible.kt */
/* loaded from: classes3.dex */
final class w2 implements kotlin.jvm.b.l<Throwable, kotlin.u> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8847d = AtomicIntegerFieldUpdater.newUpdater(w2.class, "_state");
    private final v1 a;
    private b1 c;
    private volatile /* synthetic */ int _state = 0;
    private final Thread b = Thread.currentThread();

    public w2(v1 v1Var) {
        this.a = v1Var;
    }

    private final Void b(int i2) {
        throw new IllegalStateException(kotlin.jvm.internal.s.q("Illegal state ", Integer.valueOf(i2)).toString());
    }

    public final void a() {
        while (true) {
            int i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i2);
                        throw null;
                    }
                }
            } else if (f8847d.compareAndSet(this, i2, 1)) {
                b1 b1Var = this.c;
                if (b1Var == null) {
                    return;
                }
                b1Var.dispose();
                return;
            }
        }
    }

    public void c(Throwable th) {
        int i2;
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw null;
            }
        } while (!f8847d.compareAndSet(this, i2, 2));
        this.b.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i2;
        this.c = this.a.h(true, true, this);
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw null;
            }
        } while (!f8847d.compareAndSet(this, i2, 0));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        c(th);
        return kotlin.u.a;
    }
}
