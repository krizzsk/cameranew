package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
import kotlinx.coroutines.channels.s;
/* compiled from: SendingCollector.kt */
/* loaded from: classes3.dex */
public final class p<T> implements kotlinx.coroutines.flow.d<T> {
    private final s<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public p(s<? super T> sVar) {
        this.a = sVar;
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object D = this.a.D(t, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return D == coroutine_suspended ? D : u.a;
    }
}
