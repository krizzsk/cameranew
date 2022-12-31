package kotlinx.coroutines.flow;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1", f = "Limit.kt", i = {1, 1}, l = {136, 137, 139}, m = "emit", n = {"this", FirebaseAnalytics.Param.VALUE}, s = {"L$0", "L$1"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a0 this$0;

    public FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1(a0 a0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
