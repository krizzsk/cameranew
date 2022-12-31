package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
/* compiled from: Migration.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__MigrationKt$delayFlow$1 extends SuspendLambda implements kotlin.jvm.b.p<d<? super T>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__MigrationKt$delayFlow$1(long j2, Continuation<? super FlowKt__MigrationKt$delayFlow$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__MigrationKt$delayFlow$1(this.$timeMillis, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__MigrationKt$delayFlow$1) create(dVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            long j2 = this.$timeMillis;
            this.label = 1;
            if (DelayKt.b(j2, this) == coroutine_suspended) {
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
