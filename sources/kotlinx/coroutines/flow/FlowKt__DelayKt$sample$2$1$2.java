package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlin.u, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ d<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$1$2(Ref$ObjectRef<Object> ref$ObjectRef, d<? super T> dVar, Continuation<? super FlowKt__DelayKt$sample$2$1$2> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlin.u uVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$2) create(uVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            Object obj2 = ref$ObjectRef.element;
            if (obj2 == null) {
                return kotlin.u.a;
            }
            ref$ObjectRef.element = null;
            d<T> dVar = this.$downstream;
            if (obj2 == kotlinx.coroutines.flow.internal.n.a) {
                obj2 = null;
            }
            this.label = 1;
            if (dVar.emit(obj2, this) == coroutine_suspended) {
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
