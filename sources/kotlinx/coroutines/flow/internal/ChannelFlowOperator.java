package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.channels.BufferOverflow;
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    protected final kotlinx.coroutines.flow.c<S> f8751d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(kotlinx.coroutines.flow.c<? extends S> cVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f8751d = cVar;
    }

    static /* synthetic */ Object n(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.flow.d dVar, Continuation continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        if (channelFlowOperator.b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.a);
            if (s.c(plus, context)) {
                Object q = channelFlowOperator.q(dVar, continuation);
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return q == coroutine_suspended3 ? q : u.a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
            if (s.c(plus.get(key), context.get(key))) {
                Object p = channelFlowOperator.p(dVar, plus, continuation);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return p == coroutine_suspended2 ? p : u.a;
            }
        }
        Object d2 = super.d(dVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : u.a;
    }

    static /* synthetic */ Object o(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.channels.n nVar, Continuation continuation) {
        Object coroutine_suspended;
        Object q = channelFlowOperator.q(new p(nVar), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return q == coroutine_suspended ? q : u.a;
    }

    private final Object p(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object c = d.c(coroutineContext, d.a(dVar, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c == coroutine_suspended ? c : u.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.c
    public Object d(kotlinx.coroutines.flow.d<? super T> dVar, Continuation<? super u> continuation) {
        return n(this, dVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super u> continuation) {
        return o(this, nVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object q(kotlinx.coroutines.flow.d<? super T> dVar, Continuation<? super u> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f8751d + " -> " + super.toString();
    }
}
