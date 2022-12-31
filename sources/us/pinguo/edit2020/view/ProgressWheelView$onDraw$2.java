package us.pinguo.edit2020.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
/* compiled from: ProgressWheelView.kt */
@DebugMetadata(c = "us.pinguo.edit2020.view.ProgressWheelView$onDraw$2", f = "ProgressWheelView.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class ProgressWheelView$onDraw$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ ProgressWheelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressWheelView$onDraw$2(ProgressWheelView progressWheelView, Continuation<? super ProgressWheelView$onDraw$2> continuation) {
        super(2, continuation);
        this.this$0 = progressWheelView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ProgressWheelView$onDraw$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ProgressWheelView$onDraw$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(2000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        this.this$0.q = false;
        this.this$0.invalidate();
        return kotlin.u.a;
    }
}
