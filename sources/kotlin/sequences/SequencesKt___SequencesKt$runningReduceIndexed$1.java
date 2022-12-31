package kotlin.sequences;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.u;
/* compiled from: _Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2373, 2377}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements p<g<? super S>, Continuation<? super u>, Object> {
    final /* synthetic */ q<Integer, S, T, S> $operation;
    final /* synthetic */ e<T> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningReduceIndexed$1(e<? extends T> eVar, q<? super Integer, ? super S, ? super T, ? extends S> qVar, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> continuation) {
        super(2, continuation);
        this.$this_runningReduceIndexed = eVar;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super S> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.j.b(r11)
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
            goto L60
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2a:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.j.b(r11)
            goto L5f
        L38:
            kotlin.j.b(r11)
            java.lang.Object r11 = r10.L$0
            r5 = r11
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.sequences.e<T> r11 = r10.$this_runningReduceIndexed
            java.util.Iterator r4 = r11.iterator()
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L91
            java.lang.Object r1 = r4.next()
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r11 = r5.a(r1, r10)
            if (r11 != r0) goto L5f
            return r0
        L5f:
            r11 = r10
        L60:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L91
            kotlin.jvm.b.q<java.lang.Integer, S, T, S> r6 = r11.$operation
            int r7 = r3 + 1
            if (r3 < 0) goto L8c
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.Object r8 = r4.next()
            java.lang.Object r3 = r6.invoke(r3, r1, r8)
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.I$0 = r7
            r11.label = r2
            java.lang.Object r1 = r5.a(r3, r11)
            if (r1 != r0) goto L89
            return r0
        L89:
            r1 = r3
            r3 = r7
            goto L60
        L8c:
            kotlin.collections.s.n()
            r11 = 0
            throw r11
        L91:
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
