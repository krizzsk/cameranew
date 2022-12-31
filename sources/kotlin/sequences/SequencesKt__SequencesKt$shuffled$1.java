package kotlin.sequences;

import com.growingio.android.sdk.monitor.BuildConfig;
import java.util.List;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.random.Random;
import kotlin.u;
/* compiled from: Sequences.kt */
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements p<g<? super T>, Continuation<? super u>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ e<T> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$shuffled$1(e<? extends T> eVar, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.$this_shuffled = eVar;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, continuation);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super T> gVar, Continuation<? super u> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List o;
        g gVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            o = SequencesKt___SequencesKt.o(this.$this_shuffled);
            gVar = (g) this.L$0;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            o = (List) this.L$1;
            gVar = (g) this.L$0;
            kotlin.j.b(obj);
        }
        while (!o.isEmpty()) {
            int nextInt = this.$random.nextInt(o.size());
            Object v = s.v(o);
            if (nextInt < o.size()) {
                v = o.set(nextInt, v);
            }
            this.L$0 = gVar;
            this.L$1 = o;
            this.label = 1;
            if (gVar.a(v, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return u.a;
    }
}
