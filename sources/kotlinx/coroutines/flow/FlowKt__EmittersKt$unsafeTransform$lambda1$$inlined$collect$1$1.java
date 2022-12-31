package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$unsafeTransform$lambda1$$inlined$collect$1$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ x this$0;

    public FlowKt__EmittersKt$unsafeTransform$lambda1$$inlined$collect$1$1(x xVar, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
