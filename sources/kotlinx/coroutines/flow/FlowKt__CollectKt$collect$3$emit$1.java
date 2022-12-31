package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__CollectKt$collect$3$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ q this$0;

    public FlowKt__CollectKt$collect$3$emit$1(q qVar, Continuation<? super FlowKt__CollectKt$collect$3$emit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
