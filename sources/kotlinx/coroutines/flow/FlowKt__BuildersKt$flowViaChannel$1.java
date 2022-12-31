package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
/* compiled from: Builders.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowViaChannel$1", f = "Builders.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__BuildersKt$flowViaChannel$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super T>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<kotlinx.coroutines.m0, kotlinx.coroutines.channels.s<? super T>, kotlin.u> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__BuildersKt$flowViaChannel$1(kotlin.jvm.b.p<? super kotlinx.coroutines.m0, ? super kotlinx.coroutines.channels.s<? super T>, kotlin.u> pVar, Continuation<? super FlowKt__BuildersKt$flowViaChannel$1> continuation) {
        super(2, continuation);
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__BuildersKt$flowViaChannel$1 flowKt__BuildersKt$flowViaChannel$1 = new FlowKt__BuildersKt$flowViaChannel$1(this.$block, continuation);
        flowKt__BuildersKt$flowViaChannel$1.L$0 = obj;
        return flowKt__BuildersKt$flowViaChannel$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__BuildersKt$flowViaChannel$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.channels.n nVar = (kotlinx.coroutines.channels.n) this.L$0;
            this.$block.invoke(nVar, nVar.v());
            this.label = 1;
            if (ProduceKt.b(nVar, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return kotlin.u.a;
    }
}
