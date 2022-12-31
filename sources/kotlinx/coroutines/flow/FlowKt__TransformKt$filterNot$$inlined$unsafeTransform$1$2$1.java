package kotlinx.coroutines.flow;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {136, 136}, m = "emit", n = {FirebaseAnalytics.Param.VALUE, "$this$filterNot_u24lambda_u2d1"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ k0 this$0;

    public FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1(k0 k0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
