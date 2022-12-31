package us.pinguo.camera2020.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: CameraBottomViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$longPressRunnable$1$1", f = "CameraBottomViewController.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class CameraBottomViewController$longPressRunnable$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ CameraBottomViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBottomViewController$longPressRunnable$1$1(CameraBottomViewController cameraBottomViewController, Continuation<? super CameraBottomViewController$longPressRunnable$1$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraBottomViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new CameraBottomViewController$longPressRunnable$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((CameraBottomViewController$longPressRunnable$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.j.b(r5)
            goto L3d
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L18:
            kotlin.j.b(r5)
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            boolean r5 = us.pinguo.camera2020.view.CameraBottomViewController.t(r5)
            if (r5 != 0) goto L5f
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            boolean r5 = us.pinguo.camera2020.view.CameraBottomViewController.j(r5)
            if (r5 == 0) goto L5f
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            us.pinguo.camera2020.view.r2 r5 = us.pinguo.camera2020.view.CameraBottomViewController.o(r5)
            if (r5 != 0) goto L34
            goto L47
        L34:
            r4.label = r3
            java.lang.Object r5 = r5.d(r4)
            if (r5 != r0) goto L3d
            return r0
        L3d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != r3) goto L47
            r5 = 1
            goto L48
        L47:
            r5 = 0
        L48:
            if (r5 == 0) goto L5f
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            us.pinguo.camera2020.view.CameraBottomViewController.u(r5, r2)
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            us.pinguo.camera2020.view.CameraBottomViewController.y(r5, r3)
            us.pinguo.camera2020.view.CameraBottomViewController r5 = r4.this$0
            us.pinguo.camera2020.widget.ShutterButton r5 = us.pinguo.camera2020.view.CameraBottomViewController.g(r5)
            us.pinguo.camera2020.widget.ShutterButtonDrawable$State r0 = us.pinguo.camera2020.widget.ShutterButtonDrawable.State.VIDEO_LONG_TOUCH
            r5.setState(r0)
        L5f:
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.CameraBottomViewController$longPressRunnable$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
