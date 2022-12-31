package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;
/* loaded from: classes3.dex */
public final class y1 {
    public static final a0 a(v1 v1Var) {
        return a2.a(v1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        a2.c(coroutineContext, cancellationException);
    }

    public static final void e(p<?> pVar, Future<?> future) {
        z1.a(pVar, future);
    }

    public static final b1 f(v1 v1Var, b1 b1Var) {
        return a2.e(v1Var, b1Var);
    }

    public static final void g(CoroutineContext coroutineContext) {
        a2.f(coroutineContext);
    }

    public static final void h(v1 v1Var) {
        a2.g(v1Var);
    }

    public static final v1 i(CoroutineContext coroutineContext) {
        return a2.h(coroutineContext);
    }
}
