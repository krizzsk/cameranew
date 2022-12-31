package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ v0 this$0;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1(v0 v0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
