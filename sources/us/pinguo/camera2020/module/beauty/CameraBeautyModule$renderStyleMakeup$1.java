package us.pinguo.camera2020.module.beauty;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.StyleMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBeautyModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.beauty.CameraBeautyModule$renderStyleMakeup$1", f = "CameraBeautyModule.kt", i = {1}, l = {338, 342}, m = "invokeSuspend", n = {"styleMakeupParam"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class CameraBeautyModule$renderStyleMakeup$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Float $overrideValue;
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ String $styleMakeupDir;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ CameraBeautyModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBeautyModule$renderStyleMakeup$1(String str, CameraBeautyModule cameraBeautyModule, StyleMakeup styleMakeup, Float f2, Continuation<? super CameraBeautyModule$renderStyleMakeup$1> continuation) {
        super(2, continuation);
        this.$styleMakeupDir = str;
        this.this$0 = cameraBeautyModule;
        this.$styleMakeup = styleMakeup;
        this.$overrideValue = f2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraBeautyModule$renderStyleMakeup$1(this.$styleMakeupDir, this.this$0, this.$styleMakeup, this.$overrideValue, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraBeautyModule$renderStyleMakeup$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e5, code lost:
        r10 = kotlin.text.r.g(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        r10 = kotlin.text.r.g(r10);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.lifecycle.MutableLiveData] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.beauty.CameraBeautyModule$renderStyleMakeup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
