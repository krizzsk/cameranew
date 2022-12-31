package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Errors.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements kotlin.jvm.b.r<d<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$3(long j2, kotlin.jvm.b.p<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super FlowKt__ErrorsKt$retry$3> continuation) {
        super(4, continuation);
        this.$retries = j2;
        this.$predicate = pVar;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l2, Continuation<? super Boolean> continuation) {
        return invoke((d) obj, th, l2.longValue(), continuation);
    }

    public final Object invoke(d<? super T> dVar, Throwable th, long j2, Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, continuation);
        flowKt__ErrorsKt$retry$3.L$0 = th;
        flowKt__ErrorsKt$retry$3.J$0 = j2;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.j.b(r8)
            goto L31
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            kotlin.j.b(r8)
            java.lang.Object r8 = r7.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.J$0
            long r5 = r7.$retries
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3a
            kotlin.jvm.b.p<java.lang.Throwable, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r7.$predicate
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L31
            return r0
        L31:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L3a
            goto L3b
        L3a:
            r2 = 0
        L3b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
