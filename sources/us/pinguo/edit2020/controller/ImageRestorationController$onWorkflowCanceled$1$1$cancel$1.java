package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: ImageRestorationController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$onWorkflowCanceled$1$1$cancel$1", f = "ImageRestorationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class ImageRestorationController$onWorkflowCanceled$1$1$cancel$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ boolean $cancelResult;
    int label;
    final /* synthetic */ ImageRestorationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationController$onWorkflowCanceled$1$1$cancel$1(ImageRestorationController imageRestorationController, boolean z, Continuation<? super ImageRestorationController$onWorkflowCanceled$1$1$cancel$1> continuation) {
        super(2, continuation);
        this.this$0 = imageRestorationController;
        this.$cancelResult = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ImageRestorationController$onWorkflowCanceled$1$1$cancel$1(this.this$0, this.$cancelResult, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ImageRestorationController$onWorkflowCanceled$1$1$cancel$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.edit2020.viewmodel.module.a aVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.this$0.G();
            aVar = this.this$0.b;
            kotlin.jvm.b.l<Boolean, kotlin.u> a = aVar.a();
            if (a != null) {
                a.invoke(Boxing.boxBoolean(this.$cancelResult));
            }
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("Image Restoration cancel:", Boxing.boxBoolean(this.$cancelResult)), new Object[0]);
            this.this$0.C();
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
