package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: SharingStarted.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {179, 181, 183, 184, 186}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes3.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements kotlin.jvm.b.q<d<? super SharingCommand>, Integer, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g1 this$0;

    StartedWhileSubscribed$command$1(g1 g1Var, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ Object invoke(d<? super SharingCommand> dVar, Integer num, Continuation<? super kotlin.u> continuation) {
        return invoke(dVar, num.intValue(), continuation);
    }

    public final Object invoke(d<? super SharingCommand> dVar, int i2, Continuation<? super kotlin.u> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = dVar;
        startedWhileSubscribed$command$1.I$0 = i2;
        return startedWhileSubscribed$command$1.invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L3c
            if (r1 == r6) goto L38
            if (r1 == r5) goto L30
            if (r1 == r4) goto L28
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            goto L38
        L18:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L20:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.j.b(r10)
            goto L8e
        L28:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.j.b(r10)
            goto L7d
        L30:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.j.b(r10)
            goto L64
        L38:
            kotlin.j.b(r10)
            goto L9c
        L3c:
            kotlin.j.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            int r10 = r9.I$0
            if (r10 <= 0) goto L53
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.START
            r9.label = r6
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L9c
            return r0
        L53:
            kotlinx.coroutines.flow.g1 r10 = r9.this$0
            long r6 = kotlinx.coroutines.flow.g1.c(r10)
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r10 != r0) goto L64
            return r0
        L64:
            kotlinx.coroutines.flow.g1 r10 = r9.this$0
            long r5 = kotlinx.coroutines.flow.g1.b(r10)
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L8e
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L7d
            return r0
        L7d:
            kotlinx.coroutines.flow.g1 r10 = r9.this$0
            long r4 = kotlinx.coroutines.flow.g1.b(r10)
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r4, r9)
            if (r10 != r0) goto L8e
            return r0
        L8e:
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r3 = 0
            r9.L$0 = r3
            r9.label = r2
            java.lang.Object r10 = r1.emit(r10, r9)
            if (r10 != r0) goto L9c
            return r0
        L9c:
            kotlin.u r10 = kotlin.u.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
