package us.pinguo.camera2020.view;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBottomViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$updateRecordState$1", f = "CameraBottomViewController.kt", i = {0}, l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class CameraBottomViewController$updateRecordState$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CameraBottomViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBottomViewController$updateRecordState$1(CameraBottomViewController cameraBottomViewController, Continuation<? super CameraBottomViewController$updateRecordState$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraBottomViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        CameraBottomViewController$updateRecordState$1 cameraBottomViewController$updateRecordState$1 = new CameraBottomViewController$updateRecordState$1(this.this$0, continuation);
        cameraBottomViewController$updateRecordState$1.L$0 = obj;
        return cameraBottomViewController$updateRecordState$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((CameraBottomViewController$updateRecordState$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:14:0x0038). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.m0 r1 = (kotlinx.coroutines.m0) r1
            kotlin.j.b(r6)
            r6 = r5
            goto L38
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            kotlin.j.b(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.m0 r6 = (kotlinx.coroutines.m0) r6
            r1 = r6
            r6 = r5
        L25:
            boolean r3 = kotlinx.coroutines.n0.d(r1)
            if (r3 == 0) goto L54
            r3 = 600(0x258, double:2.964E-321)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r3, r6)
            if (r3 != r0) goto L38
            return r0
        L38:
            us.pinguo.camera2020.view.CameraBottomViewController r3 = r6.this$0
            android.view.View r3 = us.pinguo.camera2020.view.CameraBottomViewController.q(r3)
            us.pinguo.camera2020.view.CameraBottomViewController r4 = r6.this$0
            android.view.View r4 = us.pinguo.camera2020.view.CameraBottomViewController.q(r4)
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L4c
            r4 = 4
            goto L4d
        L4c:
            r4 = 0
        L4d:
            r3.setVisibility(r4)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r3, r4)
            goto L25
        L54:
            kotlin.u r6 = kotlin.u.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.CameraBottomViewController$updateRecordState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
