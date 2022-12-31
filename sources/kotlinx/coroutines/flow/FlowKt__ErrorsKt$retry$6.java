package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Errors.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements kotlin.jvm.b.r<d<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ kotlin.jvm.b.l<Throwable, Boolean> $predicate;
    final /* synthetic */ int $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$6(kotlin.jvm.b.l<? super Throwable, Boolean> lVar, int i2, Continuation<? super FlowKt__ErrorsKt$retry$6> continuation) {
        super(4, continuation);
        this.$predicate = lVar;
        this.$retries = i2;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l2, Continuation<? super Boolean> continuation) {
        return invoke((d) obj, th, l2.longValue(), continuation);
    }

    public final Object invoke(d<? super T> dVar, Throwable th, long j2, Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.$predicate, this.$retries, continuation);
        flowKt__ErrorsKt$retry$6.L$0 = th;
        flowKt__ErrorsKt$retry$6.J$0 = j2;
        return flowKt__ErrorsKt$retry$6.invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            return Boxing.boxBoolean(this.$predicate.invoke((Throwable) this.L$0).booleanValue() && this.J$0 < ((long) this.$retries));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
