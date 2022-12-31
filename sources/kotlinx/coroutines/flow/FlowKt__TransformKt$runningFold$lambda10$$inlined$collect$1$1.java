package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1", f = "Transform.kt", i = {0}, l = {135, 136}, m = "emit", n = {"this"}, s = {"L$0"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ s0 this$0;

    public FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1$1(s0 s0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
