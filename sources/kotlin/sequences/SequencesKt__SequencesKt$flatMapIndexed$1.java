package kotlin.sequences;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements p<g<? super R>, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.l<C, Iterator<R>> $iterator;
    final /* synthetic */ e<T> $source;
    final /* synthetic */ p<Integer, T, C> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$flatMapIndexed$1(e<? extends T> eVar, p<? super Integer, ? super T, ? extends C> pVar, kotlin.jvm.b.l<? super C, ? extends Iterator<? extends R>> lVar, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.$source = eVar;
        this.$transform = pVar;
        this.$iterator = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super R> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i2;
        Iterator it;
        g gVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            kotlin.j.b(obj);
            i2 = 0;
            it = this.$source.iterator();
            gVar = (g) this.L$0;
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.I$0;
            it = (Iterator) this.L$1;
            gVar = (g) this.L$0;
            kotlin.j.b(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            p<Integer, T, C> pVar = this.$transform;
            int i4 = i2 + 1;
            if (i2 >= 0) {
                Object invoke = pVar.invoke(Boxing.boxInt(i2), next);
                this.L$0 = gVar;
                this.L$1 = it;
                this.I$0 = i4;
                this.label = 1;
                if (gVar.c((Iterator) this.$iterator.invoke(invoke), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2 = i4;
            } else {
                s.n();
                throw null;
            }
        }
        return u.a;
    }
}
