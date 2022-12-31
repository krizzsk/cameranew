package kotlinx.coroutines;

import java.util.concurrent.Future;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
final class a1 implements b1 {
    private final Future<?> a;

    public a1(Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
