package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
/* compiled from: JobSupport.kt */
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements kotlin.jvm.b.p<kotlin.sequences.g<? super x>, Continuation<? super kotlin.u>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ c2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(c2 c2Var, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = c2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlin.sequences.g<? super x> gVar, Continuation<? super kotlin.u> continuation) {
        return ((JobSupport$children$1) create(gVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:28:0x007f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007c -> B:28:0x007f). Please submit an issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.p r1 = (kotlinx.coroutines.internal.p) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.n r3 = (kotlinx.coroutines.internal.n) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.j.b(r8)
            r8 = r7
            goto L7f
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            kotlin.j.b(r8)
            goto L84
        L2b:
            kotlin.j.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.g r8 = (kotlin.sequences.g) r8
            kotlinx.coroutines.c2 r1 = r7.this$0
            java.lang.Object r1 = r1.h0()
            boolean r4 = r1 instanceof kotlinx.coroutines.w
            if (r4 == 0) goto L49
            kotlinx.coroutines.w r1 = (kotlinx.coroutines.w) r1
            kotlinx.coroutines.x r1 = r1.f8846e
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L84
            return r0
        L49:
            boolean r3 = r1 instanceof kotlinx.coroutines.p1
            if (r3 == 0) goto L84
            kotlinx.coroutines.p1 r1 = (kotlinx.coroutines.p1) r1
            kotlinx.coroutines.h2 r1 = r1.d()
            if (r1 != 0) goto L56
            goto L84
        L56:
            java.lang.Object r3 = r1.E()
            kotlinx.coroutines.internal.p r3 = (kotlinx.coroutines.internal.p) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L61:
            boolean r5 = kotlin.jvm.internal.s.c(r1, r3)
            if (r5 != 0) goto L84
            boolean r5 = r1 instanceof kotlinx.coroutines.w
            if (r5 == 0) goto L7f
            r5 = r1
            kotlinx.coroutines.w r5 = (kotlinx.coroutines.w) r5
            kotlinx.coroutines.x r5 = r5.f8846e
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.a(r5, r8)
            if (r5 != r0) goto L7f
            return r0
        L7f:
            kotlinx.coroutines.internal.p r1 = r1.G()
            goto L61
        L84:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
