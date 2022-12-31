package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
/* compiled from: StateFlow.kt */
/* loaded from: classes3.dex */
public final class i1 {
    private static final kotlinx.coroutines.internal.c0 a = new kotlinx.coroutines.internal.c0("NONE");
    private static final kotlinx.coroutines.internal.c0 b = new kotlinx.coroutines.internal.c0("PENDING");

    public static final <T> y0<T> a(T t) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.n.a;
        }
        return new StateFlowImpl(t);
    }

    public static final <T> c<T> d(h1<? extends T> h1Var, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        boolean z = true;
        if (kotlinx.coroutines.o0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        return ((((i2 < 0 || i2 > 1) ? false : false) || i2 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) ? h1Var : d1.a(h1Var, coroutineContext, i2, bufferOverflow);
    }

    public static final void e(y0<Integer> y0Var, int i2) {
        Integer value;
        do {
            value = y0Var.getValue();
        } while (!y0Var.f(value, Integer.valueOf(value.intValue() + i2)));
    }
}
