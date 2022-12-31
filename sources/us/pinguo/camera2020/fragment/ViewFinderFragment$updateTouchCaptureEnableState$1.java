package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$updateTouchCaptureEnableState$1", f = "ViewFinderFragment.kt", i = {0}, l = {2319}, m = "invokeSuspend", n = {"bottomModule"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$updateTouchCaptureEnableState$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$updateTouchCaptureEnableState$1(ViewFinderFragment viewFinderFragment, Continuation<? super ViewFinderFragment$updateTouchCaptureEnableState$1> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$updateTouchCaptureEnableState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$updateTouchCaptureEnableState$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r7.a().getValue() == us.pinguo.camera2020.widget.CameraSwitchMode.PHOTO) goto L10;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 != r3) goto L18
            java.lang.Object r0 = r6.L$1
            us.pinguo.camera2020.module.settings.CameraTopSettingsModule r0 = (us.pinguo.camera2020.module.settings.CameraTopSettingsModule) r0
            java.lang.Object r1 = r6.L$0
            us.pinguo.camera2020.module.settings.a r1 = (us.pinguo.camera2020.module.settings.a) r1
            kotlin.j.b(r7)
            goto L65
        L18:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L20:
            kotlin.j.b(r7)
            us.pinguo.camera2020.fragment.ViewFinderFragment r7 = r6.this$0
            us.pinguo.camera2020.viewmodel.CameraViewModel r7 = us.pinguo.camera2020.fragment.ViewFinderFragment.q0(r7)
            if (r7 == 0) goto L82
            us.pinguo.camera2020.module.settings.CameraTopSettingsModule r1 = r7.getCameraTopSettingModule()
            us.pinguo.camera2020.module.sticker.CameraStickerModule r4 = r7.getCameraStickerModule()
            us.pinguo.camera2020.module.settings.a r7 = r7.getCameraBottomModule()
            androidx.lifecycle.LiveData r5 = r4.u()
            java.lang.Object r5 = r5.getValue()
            us.pinguo.repository2020.database.sticker.Sticker r5 = (us.pinguo.repository2020.database.sticker.Sticker) r5
            if (r5 != 0) goto L51
            us.pinguo.repository2020.u r7 = r7.a()
            java.lang.Object r7 = r7.getValue()
            us.pinguo.camera2020.widget.CameraSwitchMode r0 = us.pinguo.camera2020.widget.CameraSwitchMode.PHOTO
            if (r7 != r0) goto L7c
        L4f:
            r2 = 1
            goto L7c
        L51:
            java.lang.String r5 = r5.getPid()
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r4 = r4.x(r5, r6)
            if (r4 != r0) goto L62
            return r0
        L62:
            r0 = r1
            r1 = r7
            r7 = r4
        L65:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 == r3) goto L7b
            us.pinguo.repository2020.u r7 = r1.a()
            java.lang.Object r7 = r7.getValue()
            us.pinguo.camera2020.widget.CameraSwitchMode r1 = us.pinguo.camera2020.widget.CameraSwitchMode.PHOTO
            if (r7 != r1) goto L7b
            r1 = r0
            goto L4f
        L7b:
            r1 = r0
        L7c:
            r1.c(r2)
            kotlin.u r7 = kotlin.u.a
            return r7
        L82:
            java.lang.String r7 = "cameraViewModel"
            kotlin.jvm.internal.s.z(r7)
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$updateTouchCaptureEnableState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
