package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: CoroutinesRoom.kt */
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ kotlinx.coroutines.p<R> $continuation;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.p<? super R> pVar, Continuation<? super CoroutinesRoom$Companion$execute$4$job$1> continuation) {
        super(2, continuation);
        this.$callable = callable;
        this.$continuation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            try {
                Object call = this.$callable.call();
                Continuation continuation = this.$continuation;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m41constructorimpl(call));
            } catch (Throwable th) {
                Continuation continuation2 = this.$continuation;
                Result.a aVar2 = Result.Companion;
                continuation2.resumeWith(Result.m41constructorimpl(kotlin.j.a(th)));
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
