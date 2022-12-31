package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super Object>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T> $this_sample;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Collect.kt */
    /* loaded from: classes3.dex */
    public static final class a implements d<T> {
        final /* synthetic */ kotlinx.coroutines.channels.n a;

        public a(kotlinx.coroutines.channels.n nVar) {
            this.a = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.d
        public Object emit(T t, Continuation<? super kotlin.u> continuation) {
            Object coroutine_suspended;
            kotlinx.coroutines.channels.n nVar = this.a;
            kotlinx.coroutines.internal.c0 c0Var = t;
            if (t == 0) {
                c0Var = kotlinx.coroutines.flow.internal.n.a;
            }
            Object D = nVar.D(c0Var, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return D == coroutine_suspended ? D : kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$values$1(c<? extends T> cVar, Continuation<? super FlowKt__DelayKt$sample$2$values$1> continuation) {
        super(2, continuation);
        this.$this_sample = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, continuation);
        flowKt__DelayKt$sample$2$values$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$values$1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.n<? super Object> nVar, Continuation<? super kotlin.u> continuation) {
        return invoke2((kotlinx.coroutines.channels.n<Object>) nVar, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.n<Object> nVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__DelayKt$sample$2$values$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            c<T> cVar = this.$this_sample;
            a aVar = new a((kotlinx.coroutines.channels.n) this.L$0);
            this.label = 1;
            if (cVar.d(aVar, this) == coroutine_suspended) {
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
