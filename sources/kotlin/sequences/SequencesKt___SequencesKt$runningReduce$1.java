package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: _Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2344, 2347}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements p<g<? super S>, Continuation<? super u>, Object> {
    final /* synthetic */ p<S, T, S> $operation;
    final /* synthetic */ e<T> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$runningReduce$1(e<? extends T> eVar, p<? super S, ? super T, ? extends S> pVar, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.$this_runningReduce = eVar;
        this.$operation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super S> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        g gVar;
        Object next;
        Iterator it;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            gVar = (g) this.L$0;
            Iterator it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = gVar;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (gVar.a(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = it2;
            }
            return u.a;
        } else if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            next = this.L$2;
            it = (Iterator) this.L$1;
            gVar = (g) this.L$0;
            kotlin.j.b(obj);
        }
        while (it.hasNext()) {
            next = this.$operation.invoke(next, it.next());
            this.L$0 = gVar;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (gVar.a(next, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return u.a;
    }
}
