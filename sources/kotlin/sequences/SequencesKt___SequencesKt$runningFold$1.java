package kotlin.sequences;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: _Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2286, 2290}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements p<g<? super R>, Continuation<? super u>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ p<R, T, R> $operation;
    final /* synthetic */ e<T> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningFold$1(R r, e<? extends T> eVar, p<? super R, ? super T, ? extends R> pVar, Continuation<? super SequencesKt___SequencesKt$runningFold$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_runningFold = eVar;
        this.$operation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super R> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
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
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r7.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r7.L$1
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.g r4 = (kotlin.sequences.g) r4
            kotlin.j.b(r8)
            r8 = r3
            goto L4c
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            java.lang.Object r1 = r7.L$0
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            kotlin.j.b(r8)
            goto L42
        L2d:
            kotlin.j.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            R r8 = r7.$initial
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r1.a(r8, r7)
            if (r8 != r0) goto L42
            return r0
        L42:
            R r8 = r7.$initial
            kotlin.sequences.e<T> r3 = r7.$this_runningFold
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
            r1 = r3
        L4c:
            r3 = r7
        L4d:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6c
            java.lang.Object r5 = r1.next()
            kotlin.jvm.b.p<R, T, R> r6 = r3.$operation
            java.lang.Object r8 = r6.invoke(r8, r5)
            r3.L$0 = r4
            r3.L$1 = r8
            r3.L$2 = r1
            r3.label = r2
            java.lang.Object r5 = r4.a(r8, r3)
            if (r5 != r0) goto L4d
            return r0
        L6c:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
