package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.v1;
/* compiled from: Share.kt */
/* loaded from: classes3.dex */
final class z0<T> implements h1<T>, Object<T>, kotlinx.coroutines.flow.internal.k<T> {
    private final v1 a;
    private final /* synthetic */ h1<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(h1<? extends T> h1Var, v1 v1Var) {
        this.a = v1Var;
        this.b = h1Var;
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public c<T> b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return i1.d(this, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.c
    public Object d(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        return this.b.d(dVar, continuation);
    }
}
