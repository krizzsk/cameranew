package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements p<g<? super T>, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.a<e<T>> $defaultValue;
    final /* synthetic */ e<T> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$ifEmpty$1(e<? extends T> eVar, kotlin.jvm.b.a<? extends e<? extends T>> aVar, Continuation<? super SequencesKt__SequencesKt$ifEmpty$1> continuation) {
        super(2, continuation);
        this.$this_ifEmpty = eVar;
        this.$defaultValue = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super T> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            g gVar = (g) this.L$0;
            Iterator it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.label = 1;
                if (gVar.c(it, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                if (gVar.d((e) this.$defaultValue.invoke(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return u.a;
    }
}
