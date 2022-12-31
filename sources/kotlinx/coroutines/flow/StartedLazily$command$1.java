package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
/* compiled from: SharingStarted.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class StartedLazily$command$1 extends SuspendLambda implements kotlin.jvm.b.p<d<? super SharingCommand>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ h1<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(h1<Integer> h1Var, Continuation<? super StartedLazily$command$1> continuation) {
        super(2, continuation);
        this.$subscriptionCount = h1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, continuation);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d<? super SharingCommand> dVar, Continuation<? super kotlin.u> continuation) {
        return ((StartedLazily$command$1) create(dVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            h1<Integer> h1Var = this.$subscriptionCount;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(ref$BooleanRef, (d) this.L$0);
            this.label = 1;
            if (h1Var.d(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return kotlin.u.a;
    }
}
