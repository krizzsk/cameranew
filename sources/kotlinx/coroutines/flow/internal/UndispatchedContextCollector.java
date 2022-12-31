package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
import kotlinx.coroutines.internal.ThreadContextKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.d<T> {
    private final CoroutineContext a;
    private final Object b;
    private final kotlin.jvm.b.p<T, Continuation<? super u>, Object> c;

    public UndispatchedContextCollector(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        this.b = ThreadContextKt.b(coroutineContext);
        this.c = new UndispatchedContextCollector$emitRef$1(dVar, null);
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object b = d.b(this.a, t, this.b, this.c, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return b == coroutine_suspended ? b : u.a;
    }
}
