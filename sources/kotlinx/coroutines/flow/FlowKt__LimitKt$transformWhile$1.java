package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.AbortFlowException;
/* compiled from: Limit.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {154}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$transformWhile$1 extends SuspendLambda implements kotlin.jvm.b.p<d<? super R>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T> $this_transformWhile;
    final /* synthetic */ kotlin.jvm.b.q<d<? super R>, T, Continuation<? super Boolean>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$transformWhile$1(c<? extends T> cVar, kotlin.jvm.b.q<? super d<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> qVar, Continuation<? super FlowKt__LimitKt$transformWhile$1> continuation) {
        super(2, continuation);
        this.$this_transformWhile = cVar;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, continuation);
        flowKt__LimitKt$transformWhile$1.L$0 = obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d<? super R> dVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__LimitKt$transformWhile$1) create(dVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            c<T> cVar = this.$this_transformWhile;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, (d) this.L$0);
            try {
                this.L$0 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                this.label = 1;
                if (cVar.d(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                kotlinx.coroutines.flow.internal.j.a(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return kotlin.u.a;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
            try {
                kotlin.j.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                kotlinx.coroutines.flow.internal.j.a(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return kotlin.u.a;
            }
        }
        return kotlin.u.a;
    }
}
