package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
import kotlinx.coroutines.channels.BufferOverflow;
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public final class f<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ f(kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, kotlin.jvm.internal.o oVar) {
        this(cVar, (i3 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 4) != 0 ? -3 : i2, (i3 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> j(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new f(this.f8751d, coroutineContext, i2, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object q(kotlinx.coroutines.flow.d<? super T> dVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object d2 = this.f8751d.d(dVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : u.a;
    }

    public f(kotlinx.coroutines.flow.c<? extends T> cVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(cVar, coroutineContext, i2, bufferOverflow);
    }
}
