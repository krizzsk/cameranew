package us.pinguo.edit2020.controller;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$gotoManualMatting$1", f = "BackgroundReplacementController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$gotoManualMatting$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$gotoManualMatting$1(BackgroundReplacementController backgroundReplacementController, Continuation<? super BackgroundReplacementController$gotoManualMatting$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundReplacementController$gotoManualMatting$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundReplacementController$gotoManualMatting$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.edit2020.view.c0 c0Var;
        ConstraintLayout constraintLayout;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.this$0.f10290k = true;
            this.this$0.c.B(true);
            this.this$0.f10287h.V(false);
            c0Var = this.this$0.f10289j;
            c0Var.F(true);
            this.this$0.c.J0(true);
            constraintLayout = this.this$0.t;
            if (constraintLayout != null) {
                this.this$0.B0(constraintLayout);
                constraintLayout.setVisibility(4);
                VdsAgent.onSetViewVisibility(constraintLayout, 4);
            }
            this.this$0.S0();
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
