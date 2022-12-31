package us.pinguo.edit2020.widget.dialog;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
/* compiled from: CircleProgressWithResultDialog.kt */
@DebugMetadata(c = "us.pinguo.edit2020.widget.dialog.CircleProgressWithResultDialog$onViewCreated$3", f = "CircleProgressWithResultDialog.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"it"}, s = {"I$0"})
/* loaded from: classes4.dex */
final class CircleProgressWithResultDialog$onViewCreated$3 extends SuspendLambda implements p<Integer, Continuation<? super u>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CircleProgressWithResultDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressWithResultDialog$onViewCreated$3(CircleProgressWithResultDialog circleProgressWithResultDialog, Continuation<? super CircleProgressWithResultDialog$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = circleProgressWithResultDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        CircleProgressWithResultDialog$onViewCreated$3 circleProgressWithResultDialog$onViewCreated$3 = new CircleProgressWithResultDialog$onViewCreated$3(this.this$0, continuation);
        circleProgressWithResultDialog$onViewCreated$3.I$0 = ((Number) obj).intValue();
        return circleProgressWithResultDialog$onViewCreated$3;
    }

    public final Object invoke(int i2, Continuation<? super u> continuation) {
        return ((CircleProgressWithResultDialog$onViewCreated$3) create(Integer.valueOf(i2), continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super u> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            j.b(obj);
            int i4 = this.I$0;
            this.I$0 = i4;
            this.label = 1;
            if (DelayKt.b(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i2 = i4;
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.I$0;
            j.b(obj);
        }
        if (i2 < 0) {
            this.this$0.n0();
        } else if (i2 == 100) {
            this.this$0.o0();
        } else {
            this.this$0.p0(i2);
        }
        return u.a;
    }
}
