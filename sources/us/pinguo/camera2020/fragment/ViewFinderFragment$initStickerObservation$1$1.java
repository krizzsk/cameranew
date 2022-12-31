package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$1$1", f = "ViewFinderFragment.kt", i = {}, l = {2911, 2915}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$initStickerObservation$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ CameraBeautyModule $beautyModule;
    final /* synthetic */ String $sid;
    final /* synthetic */ CameraStickerModule $stickerModule;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initStickerObservation$1$1(CameraStickerModule cameraStickerModule, String str, CameraBeautyModule cameraBeautyModule, Continuation<? super ViewFinderFragment$initStickerObservation$1$1> continuation) {
        super(2, continuation);
        this.$stickerModule = cameraStickerModule;
        this.$sid = str;
        this.$beautyModule = cameraBeautyModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$initStickerObservation$1$1(this.$stickerModule, this.$sid, this.$beautyModule, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$initStickerObservation$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
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
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L1e
            if (r1 == r2) goto L1a
            if (r1 != r3) goto L12
            kotlin.j.b(r5)
            goto L44
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.j.b(r5)
            goto L2e
        L1e:
            kotlin.j.b(r5)
            us.pinguo.camera2020.module.sticker.CameraStickerModule r5 = r4.$stickerModule
            java.lang.String r1 = r4.$sid
            r4.label = r2
            java.lang.Object r5 = r5.p(r1, r4)
            if (r5 != r0) goto L2e
            return r0
        L2e:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L37
            us.pinguo.camera2020.module.beauty.CameraBeautyModule r1 = r4.$beautyModule
            r1.h0(r5)
        L37:
            us.pinguo.camera2020.module.sticker.CameraStickerModule r5 = r4.$stickerModule
            java.lang.String r1 = r4.$sid
            r4.label = r3
            java.lang.Object r5 = r5.l(r1, r4)
            if (r5 != r0) goto L44
            return r0
        L44:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L50
            us.pinguo.camera2020.module.beauty.CameraBeautyModule r5 = r4.$beautyModule
            r5.q()
            kotlin.u r5 = kotlin.u.a
            return r5
        L50:
            java.lang.String r0 = "none"
            boolean r0 = kotlin.jvm.internal.s.c(r5, r0)
            if (r0 == 0) goto L5b
            kotlin.u r5 = kotlin.u.a
            return r5
        L5b:
            us.pinguo.camera2020.module.beauty.CameraBeautyModule r0 = r4.$beautyModule
            r1 = 0
            us.pinguo.camera2020.module.beauty.CameraBeautyModule.j0(r0, r5, r1, r3, r1)
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
