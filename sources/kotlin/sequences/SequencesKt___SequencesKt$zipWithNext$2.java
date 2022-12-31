package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: _Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2864}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements p<g<? super R>, Continuation<? super u>, Object> {
    final /* synthetic */ e<T> $this_zipWithNext;
    final /* synthetic */ p<T, T, R> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$zipWithNext$2(e<? extends T> eVar, p<? super T, ? super T, ? extends R> pVar, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.$this_zipWithNext = eVar;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super R> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(gVar, continuation)).invokeSuspend(u.a);
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
            g gVar2 = (g) this.L$0;
            Iterator it2 = this.$this_zipWithNext.iterator();
            if (!it2.hasNext()) {
                return u.a;
            }
            gVar = gVar2;
            next = it2.next();
            it = it2;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.L$2;
            it = (Iterator) this.L$1;
            gVar = (g) this.L$0;
            kotlin.j.b(obj);
            next = obj2;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            Object invoke = this.$transform.invoke(next, next2);
            this.L$0 = gVar;
            this.L$1 = it;
            this.L$2 = next2;
            this.label = 1;
            if (gVar.a(invoke, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            next = next2;
        }
        return u.a;
    }
}
