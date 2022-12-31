package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.module.AfterCaptureMode;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$doTakePicture$1", f = "ViewFinderFragment.kt", i = {}, l = {1666}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$doTakePicture$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ boolean $isAutoSave;
    final /* synthetic */ AfterCaptureMode $mode;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$doTakePicture$1(boolean z, ViewFinderFragment viewFinderFragment, FilterEntry filterEntry, AfterCaptureMode afterCaptureMode, Continuation<? super ViewFinderFragment$doTakePicture$1> continuation) {
        super(2, continuation);
        this.$isAutoSave = z;
        this.this$0 = viewFinderFragment;
        this.$entry = filterEntry;
        this.$mode = afterCaptureMode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$doTakePicture$1(this.$isAutoSave, this.this$0, this.$entry, this.$mode, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$doTakePicture$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (kotlin.jvm.internal.s.c(r4, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) != false) goto L10;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.j.b(r4)
            goto L3d
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L17:
            kotlin.j.b(r4)
            boolean r4 = r3.$isAutoSave
            if (r4 == 0) goto L4f
            us.pinguo.camera2020.i.a r4 = us.pinguo.camera2020.i.a.a
            boolean r4 = r4.e()
            if (r4 != 0) goto L4f
            us.pinguo.camera2020.fragment.ViewFinderFragment r4 = r3.this$0
            us.pinguo.camera2020.viewmodel.CameraViewModel r4 = us.pinguo.camera2020.fragment.ViewFinderFragment.q0(r4)
            if (r4 == 0) goto L48
            us.pinguo.common.filter.CameraFilterModule r4 = r4.getCameraFilterModule()
            us.pinguo.repository2020.entity.FilterEntry r1 = r3.$entry
            r3.label = r2
            java.lang.Object r4 = r4.W(r1, r3)
            if (r4 != r0) goto L3d
            return r0
        L3d:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r4 = kotlin.jvm.internal.s.c(r4, r0)
            if (r4 == 0) goto L58
            goto L4f
        L48:
            java.lang.String r4 = "cameraViewModel"
            kotlin.jvm.internal.s.z(r4)
            r4 = 0
            throw r4
        L4f:
            us.pinguo.camera2020.fragment.ViewFinderFragment r4 = r3.this$0
            us.pinguo.camera2020.module.AfterCaptureMode r0 = r3.$mode
            us.pinguo.camera2020.widget.CameraSwitchMode r1 = us.pinguo.camera2020.widget.CameraSwitchMode.PHOTO
            us.pinguo.camera2020.fragment.ViewFinderFragment.K0(r4, r0, r1)
        L58:
            kotlin.u r4 = kotlin.u.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$doTakePicture$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
