package us.pinguo.edit2020.viewmodel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: AIEditViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.AIEditViewModel$save$1", f = "AIEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class AIEditViewModel$save$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $isWorkFlowFunItemUsed;
    final /* synthetic */ kotlin.jvm.b.a<u> $saveEndAction;
    int label;
    final /* synthetic */ AIEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEditViewModel$save$1(boolean z, AIEditViewModel aIEditViewModel, kotlin.jvm.b.a<u> aVar, Continuation<? super AIEditViewModel$save$1> continuation) {
        super(2, continuation);
        this.$isWorkFlowFunItemUsed = z;
        this.this$0 = aIEditViewModel;
        this.$saveEndAction = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AIEditViewModel$save$1(this.$isWorkFlowFunItemUsed, this.this$0, this.$saveEndAction, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AIEditViewModel$save$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            if (this.$isWorkFlowFunItemUsed) {
                this.this$0.q(false);
            } else {
                kotlin.jvm.b.a<u> f2 = this.this$0.f();
                if (f2 != null) {
                    f2.invoke();
                }
            }
            this.$saveEndAction.invoke();
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
