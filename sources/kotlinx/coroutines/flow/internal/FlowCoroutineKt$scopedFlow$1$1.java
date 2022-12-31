package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: FlowCoroutine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.q<m0, kotlinx.coroutines.flow.d<? super R>, Continuation<? super u>, Object> $block;
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowCoroutineKt$scopedFlow$1$1(kotlin.jvm.b.q<? super m0, ? super kotlinx.coroutines.flow.d<? super R>, ? super Continuation<? super u>, ? extends Object> qVar, kotlinx.coroutines.flow.d<? super R> dVar, Continuation<? super FlowCoroutineKt$scopedFlow$1$1> continuation) {
        super(2, continuation);
        this.$block = qVar;
        this.$this_unsafeFlow = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, continuation);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlin.jvm.b.q<m0, kotlinx.coroutines.flow.d<? super R>, Continuation<? super u>, Object> qVar = this.$block;
            Object obj2 = this.$this_unsafeFlow;
            this.label = 1;
            if (qVar.invoke((m0) this.L$0, obj2, this) == coroutine_suspended) {
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
