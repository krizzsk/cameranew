package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<T> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.c<T> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelLimitedFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.c<? extends T> cVar, p<T> pVar, Continuation<? super ChannelLimitedFlowMerge$collectTo$2$1> continuation) {
        super(2, continuation);
        this.$flow = cVar;
        this.$collector = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.flow.c<T> cVar = this.$flow;
            kotlinx.coroutines.flow.d dVar = this.$collector;
            this.label = 1;
            if (cVar.d(dVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return u.a;
    }
}
