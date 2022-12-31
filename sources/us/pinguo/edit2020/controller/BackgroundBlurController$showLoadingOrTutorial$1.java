package us.pinguo.edit2020.controller;

import android.content.Context;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import us.pinguo.edit2020.bean.TutorialModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundBlurController$showLoadingOrTutorial$1", f = "BackgroundBlurController.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class BackgroundBlurController$showLoadingOrTutorial$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$showLoadingOrTutorial$1(BackgroundBlurController backgroundBlurController, Continuation<? super BackgroundBlurController$showLoadingOrTutorial$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundBlurController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurController$showLoadingOrTutorial$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundBlurController$showLoadingOrTutorial$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ViewGroup viewGroup;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(250L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        viewGroup = this.this$0.b;
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
        us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context, TutorialModel.VIDEO_TYPE_BG_BLUR);
        kVar.d(new BackgroundBlurController$showLoadingOrTutorial$1$dialog$1$1(this.this$0));
        kVar.show();
        VdsAgent.showDialog(kVar);
        return kotlin.u.a;
    }
}
