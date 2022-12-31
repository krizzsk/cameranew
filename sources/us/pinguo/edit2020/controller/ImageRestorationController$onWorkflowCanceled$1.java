package us.pinguo.edit2020.controller;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.libdeepvision.callback.RestorationCancelCallback;
/* compiled from: ImageRestorationController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$onWorkflowCanceled$1", f = "ImageRestorationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class ImageRestorationController$onWorkflowCanceled$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ ImageRestorationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationController$onWorkflowCanceled$1(ImageRestorationController imageRestorationController, Continuation<? super ImageRestorationController$onWorkflowCanceled$1> continuation) {
        super(2, continuation);
        this.this$0 = imageRestorationController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ImageRestorationController$onWorkflowCanceled$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ImageRestorationController$onWorkflowCanceled$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.common.helper.b bVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            bVar = this.this$0.f10381j;
            final ImageRestorationController imageRestorationController = this.this$0;
            bVar.c(new RestorationCancelCallback() { // from class: us.pinguo.edit2020.controller.ImageRestorationController$onWorkflowCanceled$1.1
                @Override // us.pinguo.libdeepvision.callback.RestorationCancelCallback
                public void cancel(boolean z) {
                    LifecycleCoroutineScope D;
                    D = ImageRestorationController.this.D();
                    if (D == null) {
                        return;
                    }
                    kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.c(), null, new ImageRestorationController$onWorkflowCanceled$1$1$cancel$1(ImageRestorationController.this, z, null), 2, null);
                }
            });
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
