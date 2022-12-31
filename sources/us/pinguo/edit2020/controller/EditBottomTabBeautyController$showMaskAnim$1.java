package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: EditBottomTabBeautyController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditBottomTabBeautyController$showMaskAnim$1", f = "EditBottomTabBeautyController.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {949, 954}, m = "invokeSuspend", n = {"endAlpha", "currentAlpha", "oneFrameDuration", "oneFrameAlpha", "currentAlpha", "oneFrameDuration", "oneFrameAlpha"}, s = {"F$0", "F$1", "J$0", "F$2", "F$0", "J$0", "F$1"})
/* loaded from: classes4.dex */
final class EditBottomTabBeautyController$showMaskAnim$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ float $duration;
    final /* synthetic */ int $framePerSecond;
    float F$0;
    float F$1;
    float F$2;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$showMaskAnim$1(float f2, int i2, Continuation<? super EditBottomTabBeautyController$showMaskAnim$1> continuation) {
        super(2, continuation);
        this.$duration = f2;
        this.$framePerSecond = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditBottomTabBeautyController$showMaskAnim$1(this.$duration, this.$framePerSecond, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditBottomTabBeautyController$showMaskAnim$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:7:0x001c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r3 = 1
            r4 = 0
            r5 = 2
            if (r1 == 0) goto L35
            if (r1 == r3) goto L26
            if (r1 != r5) goto L1e
            float r1 = r10.F$1
            long r2 = r10.J$0
            float r6 = r10.F$0
            kotlin.j.b(r11)
            r8 = r10
        L1c:
            r11 = r6
            goto L74
        L1e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L26:
            float r1 = r10.F$2
            long r6 = r10.J$0
            float r2 = r10.F$1
            float r8 = r10.F$0
            kotlin.j.b(r11)
            r11 = r2
            r2 = r8
            r8 = r10
            goto L58
        L35:
            kotlin.j.b(r11)
            float r11 = r10.$duration
            float r1 = (float) r5
            float r6 = r11 / r1
            int r7 = r10.$framePerSecond
            float r7 = (float) r7
            float r6 = r6 * r7
            int r6 = (int) r6
            float r11 = r11 / r1
            r1 = 1000(0x3e8, float:1.401E-42)
            float r1 = (float) r1
            float r11 = r11 * r1
            float r1 = (float) r6
            float r11 = r11 / r1
            long r6 = (long) r11
            float r11 = r2 / r1
            us.pinguo.u3dengine.edit.UnityEditCaller$Brush r1 = us.pinguo.u3dengine.edit.UnityEditCaller.Brush.INSTANCE
            r8 = 1073676288(0x3fff0000, float:1.9921875)
            r1.setBrushMaskHighlightColor(r8, r8)
            r8 = r10
            r1 = r11
            r11 = 0
        L58:
            int r9 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r9 >= 0) goto L73
            float r11 = r11 + r1
            us.pinguo.u3dengine.edit.UnityEditCaller$Brush r9 = us.pinguo.u3dengine.edit.UnityEditCaller.Brush.INSTANCE
            r9.setSoftSkinMaskViewOpacity(r11)
            r8.F$0 = r2
            r8.F$1 = r11
            r8.J$0 = r6
            r8.F$2 = r1
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r8)
            if (r9 != r0) goto L58
            return r0
        L73:
            r2 = r6
        L74:
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 <= 0) goto L8e
            float r6 = r11 - r1
            us.pinguo.u3dengine.edit.UnityEditCaller$Brush r11 = us.pinguo.u3dengine.edit.UnityEditCaller.Brush.INSTANCE
            r11.setSoftSkinMaskViewOpacity(r6)
            r8.F$0 = r6
            r8.J$0 = r2
            r8.F$1 = r1
            r8.label = r5
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r2, r8)
            if (r11 != r0) goto L1c
            return r0
        L8e:
            us.pinguo.u3dengine.edit.UnityEditCaller$Brush r11 = us.pinguo.u3dengine.edit.UnityEditCaller.Brush.INSTANCE
            r11.setSoftSkinMaskViewOpacity(r4)
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditBottomTabBeautyController$showMaskAnim$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
