package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.z;
/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes3.dex */
public abstract class z<S extends z<S>> extends g<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8777d = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers");
    private final long c;
    private volatile /* synthetic */ int cleanedAndPointers;

    public z(long j2, S s, int i2) {
        super(s);
        this.c = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    @Override // kotlinx.coroutines.internal.g
    public boolean g() {
        return this.cleanedAndPointers == n() && !i();
    }

    public final boolean l() {
        return f8777d.addAndGet(this, SupportMenu.CATEGORY_MASK) == n() && !i();
    }

    public final long m() {
        return this.c;
    }

    public abstract int n();

    public final void o() {
        if (f8777d.incrementAndGet(this) != n() || i()) {
            return;
        }
        j();
    }

    public final boolean p() {
        int i2;
        do {
            i2 = this.cleanedAndPointers;
            if (!(i2 != n() || i())) {
                return false;
            }
        } while (!f8777d.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
