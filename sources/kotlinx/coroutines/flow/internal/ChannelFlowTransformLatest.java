package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.o0;
/* compiled from: Merge.kt */
/* loaded from: classes3.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.jvm.b.q<kotlinx.coroutines.flow.d<? super R>, T, Continuation<? super u>, Object> f8752e;

    public /* synthetic */ ChannelFlowTransformLatest(kotlin.jvm.b.q qVar, kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, kotlin.jvm.internal.o oVar) {
        this(qVar, cVar, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<R> j(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f8752e, this.f8751d, coroutineContext, i2, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object q(kotlinx.coroutines.flow.d<? super R> dVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        if (!o0.a() || (dVar instanceof p)) {
            Object a = i.a(new ChannelFlowTransformLatest$flowCollect$3(this, dVar, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return a == coroutine_suspended ? a : u.a;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(kotlin.jvm.b.q<? super kotlinx.coroutines.flow.d<? super R>, ? super T, ? super Continuation<? super u>, ? extends Object> qVar, kotlinx.coroutines.flow.c<? extends T> cVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(cVar, coroutineContext, i2, bufferOverflow);
        this.f8752e = qVar;
    }
}
