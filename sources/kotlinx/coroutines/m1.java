package kotlinx.coroutines;

import java.util.concurrent.Executor;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public final class m1 {
    public static final CoroutineDispatcher a(Executor executor) {
        y0 y0Var = executor instanceof y0 ? (y0) executor : null;
        return y0Var == null ? new l1(executor) : y0Var.a;
    }
}
