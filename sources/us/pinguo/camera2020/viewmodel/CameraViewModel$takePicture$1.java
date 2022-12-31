package us.pinguo.camera2020.viewmodel;

import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.foundation.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraViewModel.kt */
@DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$takePicture$1", f = "CameraViewModel.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraViewModel$takePicture$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $deviceOrientation;
    int label;
    final /* synthetic */ CameraViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$takePicture$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<byte[], u> {
        final /* synthetic */ int $deviceOrientation;
        final /* synthetic */ CameraViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CameraViewModel cameraViewModel, int i2) {
            super(1);
            this.this$0 = cameraViewModel;
            this.$deviceOrientation = i2;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(byte[] bArr) {
            invoke2(bArr);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(byte[] it) {
            s.h(it, "it");
            us.pinguo.common.manager.b.a.b();
            us.pinguo.common.log.a.c("takePicture-arrayBack", new Object[0]);
            this.this$0.getAfterCaptureModule().F(new us.pinguo.image.saver.b(it, this.this$0.unityRender.X() ? ((this.this$0.unityRender.L() - this.$deviceOrientation) + BaseBlurEffect.ROTATION_360) % BaseBlurEffect.ROTATION_360 : (this.this$0.unityRender.L() + this.$deviceOrientation) % BaseBlurEffect.ROTATION_360, false, false, 12, null));
            us.pinguo.common.log.a.c("takePicture-startCapture", new Object[0]);
            c.e("takePicture-startCapture");
            this.this$0.unityRender.G0(this.$deviceOrientation, it);
            this.this$0.setGettingPictureAfterSnapshot(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModel$takePicture$1(CameraViewModel cameraViewModel, int i2, Continuation<? super CameraViewModel$takePicture$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModel;
        this.$deviceOrientation = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModel$takePicture$1(this.this$0, this.$deviceOrientation, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraViewModel$takePicture$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.viewmodel.CameraViewModel$takePicture$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
