package kotlin.sequences;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.u;
/* compiled from: _Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$0", "L$1", "I$0"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements p<g<? super R>, Continuation<? super u>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ q<Integer, R, T, R> $operation;
    final /* synthetic */ e<T> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningFoldIndexed$1(R r, e<? extends T> eVar, q<? super Integer, ? super R, ? super T, ? extends R> qVar, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_runningFoldIndexed = eVar;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super R> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.L$1
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.g r5 = (kotlin.sequences.g) r5
            kotlin.j.b(r10)
            r10 = r1
            r1 = r4
            goto L51
        L20:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L28:
            java.lang.Object r1 = r9.L$0
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            kotlin.j.b(r10)
            goto L45
        L30:
            kotlin.j.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlin.sequences.g r1 = (kotlin.sequences.g) r1
            R r10 = r9.$initial
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r1.a(r10, r9)
            if (r10 != r0) goto L45
            return r0
        L45:
            r10 = 0
            R r3 = r9.$initial
            kotlin.sequences.e<T> r4 = r9.$this_runningFoldIndexed
            java.util.Iterator r4 = r4.iterator()
            r5 = r1
            r1 = r3
            r3 = r4
        L51:
            r4 = r9
        L52:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L83
            java.lang.Object r6 = r3.next()
            kotlin.jvm.b.q<java.lang.Integer, R, T, R> r7 = r4.$operation
            int r8 = r10 + 1
            if (r10 < 0) goto L7e
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            java.lang.Object r10 = r7.invoke(r10, r1, r6)
            r4.L$0 = r5
            r4.L$1 = r10
            r4.L$2 = r3
            r4.I$0 = r8
            r4.label = r2
            java.lang.Object r1 = r5.a(r10, r4)
            if (r1 != r0) goto L7b
            return r0
        L7b:
            r1 = r10
            r10 = r8
            goto L52
        L7e:
            kotlin.collections.s.n()
            r10 = 0
            throw r10
        L83:
            kotlin.u r10 = kotlin.u.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
