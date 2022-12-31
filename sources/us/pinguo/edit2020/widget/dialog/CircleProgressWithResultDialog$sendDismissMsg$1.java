package us.pinguo.edit2020.widget.dialog;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleProgressWithResultDialog.kt */
@DebugMetadata(c = "us.pinguo.edit2020.widget.dialog.CircleProgressWithResultDialog$sendDismissMsg$1", f = "CircleProgressWithResultDialog.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class CircleProgressWithResultDialog$sendDismissMsg$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ CircleProgressWithResultDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressWithResultDialog$sendDismissMsg$1(CircleProgressWithResultDialog circleProgressWithResultDialog, Continuation<? super CircleProgressWithResultDialog$sendDismissMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = circleProgressWithResultDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CircleProgressWithResultDialog$sendDismissMsg$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CircleProgressWithResultDialog$sendDismissMsg$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e eVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            eVar = this.this$0.f10965g;
            Boolean boxBoolean = Boxing.boxBoolean(true);
            this.label = 1;
            if (eVar.D(boxBoolean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
