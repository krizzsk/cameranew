package us.pinguo.edit2020.controller;

import android.content.Context;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.bean.TutorialModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LongLegController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.LongLegController$showTutorial$1", f = "LongLegController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class LongLegController$showTutorial$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ LongLegController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLegController$showTutorial$1(LongLegController longLegController, Continuation<? super LongLegController$showTutorial$1> continuation) {
        super(2, continuation);
        this.this$0 = longLegController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new LongLegController$showTutorial$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((LongLegController$showTutorial$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            Context context = this.this$0.b.getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context, TutorialModel.VIDEO_TYPE_LONG_LEG);
            kVar.show();
            VdsAgent.showDialog(kVar);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
