package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
final class y0 implements Executor {
    public final CoroutineDispatcher a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    public String toString() {
        return this.a.toString();
    }
}
