package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Errors.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", f = "Errors.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$onErrorCollect$2 extends SuspendLambda implements kotlin.jvm.b.q<d<? super T>, Throwable, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T> $fallback;
    final /* synthetic */ kotlin.jvm.b.l<Throwable, Boolean> $predicate;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$onErrorCollect$2(kotlin.jvm.b.l<? super Throwable, Boolean> lVar, c<? extends T> cVar, Continuation<? super FlowKt__ErrorsKt$onErrorCollect$2> continuation) {
        super(3, continuation);
        this.$predicate = lVar;
        this.$fallback = cVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(d<? super T> dVar, Throwable th, Continuation<? super kotlin.u> continuation) {
        FlowKt__ErrorsKt$onErrorCollect$2 flowKt__ErrorsKt$onErrorCollect$2 = new FlowKt__ErrorsKt$onErrorCollect$2(this.$predicate, this.$fallback, continuation);
        flowKt__ErrorsKt$onErrorCollect$2.L$0 = dVar;
        flowKt__ErrorsKt$onErrorCollect$2.L$1 = th;
        return flowKt__ErrorsKt$onErrorCollect$2.invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            d dVar = (d) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (this.$predicate.invoke(th).booleanValue()) {
                c<T> cVar = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (e.k(dVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return kotlin.u.a;
    }
}
