package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
/* compiled from: SharedFlow.kt */
/* loaded from: classes3.dex */
public final class d1 {
    public static final kotlinx.coroutines.internal.c0 a = new kotlinx.coroutines.internal.c0("NO_VALUE");

    public static final <T> c<T> a(b1<? extends T> b1Var, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return ((i2 == 0 || i2 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? b1Var : new kotlinx.coroutines.flow.internal.f(b1Var, coroutineContext, i2, bufferOverflow);
    }
}
