package us.pinguo.camera2020.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimerCountDownController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.TimerCountDownController$startTimer$1", f = "TimerCountDownController.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class TimerCountDownController$startTimer$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.a<kotlin.u> $endBlock;
    final /* synthetic */ Ref$IntRef $tmpTime;
    int label;
    final /* synthetic */ TimerCountDownController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimerCountDownController$startTimer$1(Ref$IntRef ref$IntRef, TimerCountDownController timerCountDownController, kotlin.jvm.b.a<kotlin.u> aVar, Continuation<? super TimerCountDownController$startTimer$1> continuation) {
        super(2, continuation);
        this.$tmpTime = ref$IntRef;
        this.this$0 = timerCountDownController;
        this.$endBlock = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new TimerCountDownController$startTimer$1(this.$tmpTime, this.this$0, this.$endBlock, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((TimerCountDownController$startTimer$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please submit an issue!!! */
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
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.j.b(r6)
            r6 = r5
            goto L32
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.j.b(r6)
            r6 = r5
        L1c:
            kotlin.jvm.internal.Ref$IntRef r1 = r6.$tmpTime
            int r1 = r1.element
            if (r1 <= 0) goto L3b
            us.pinguo.camera2020.view.TimerCountDownController r3 = r6.this$0
            us.pinguo.camera2020.view.TimerCountDownController.a(r3, r1)
            r3 = 1000(0x3e8, double:4.94E-321)
            r6.label = r2
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r3, r6)
            if (r1 != r0) goto L32
            return r0
        L32:
            kotlin.jvm.internal.Ref$IntRef r1 = r6.$tmpTime
            int r3 = r1.element
            int r3 = r3 + (-1)
            r1.element = r3
            goto L1c
        L3b:
            kotlin.jvm.b.a<kotlin.u> r6 = r6.$endBlock
            r6.invoke()
            kotlin.u r6 = kotlin.u.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.TimerCountDownController$startTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
