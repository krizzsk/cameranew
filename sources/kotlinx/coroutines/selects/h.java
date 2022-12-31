package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
/* compiled from: Select.kt */
/* loaded from: classes3.dex */
public final class h {
    private static final /* synthetic */ AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(h.class, "number");
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return a.incrementAndGet(this);
    }
}
