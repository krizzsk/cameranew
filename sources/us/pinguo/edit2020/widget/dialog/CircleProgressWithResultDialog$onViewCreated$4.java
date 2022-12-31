package us.pinguo.edit2020.widget.dialog;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: CircleProgressWithResultDialog.kt */
@DebugMetadata(c = "us.pinguo.edit2020.widget.dialog.CircleProgressWithResultDialog$onViewCreated$4", f = "CircleProgressWithResultDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class CircleProgressWithResultDialog$onViewCreated$4 extends SuspendLambda implements p<Boolean, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ CircleProgressWithResultDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressWithResultDialog$onViewCreated$4(CircleProgressWithResultDialog circleProgressWithResultDialog, Continuation<? super CircleProgressWithResultDialog$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = circleProgressWithResultDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CircleProgressWithResultDialog$onViewCreated$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super u> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super u> continuation) {
        return ((CircleProgressWithResultDialog$onViewCreated$4) create(Boolean.valueOf(z), continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            this.this$0.dismiss();
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
