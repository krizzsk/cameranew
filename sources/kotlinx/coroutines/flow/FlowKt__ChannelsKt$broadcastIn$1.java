package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Channels.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt$broadcastIn$1", f = "Channels.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ChannelsKt$broadcastIn$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super T>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T> $this_broadcastIn;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Collect.kt */
    /* loaded from: classes3.dex */
    public static final class a implements d<T> {
        final /* synthetic */ kotlinx.coroutines.channels.n a;

        public a(kotlinx.coroutines.channels.n nVar) {
            this.a = nVar;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T t, Continuation<? super kotlin.u> continuation) {
            Object coroutine_suspended;
            Object D = this.a.D(t, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return D == coroutine_suspended ? D : kotlin.u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ChannelsKt$broadcastIn$1(c<? extends T> cVar, Continuation<? super FlowKt__ChannelsKt$broadcastIn$1> continuation) {
        super(2, continuation);
        this.$this_broadcastIn = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__ChannelsKt$broadcastIn$1 flowKt__ChannelsKt$broadcastIn$1 = new FlowKt__ChannelsKt$broadcastIn$1(this.$this_broadcastIn, continuation);
        flowKt__ChannelsKt$broadcastIn$1.L$0 = obj;
        return flowKt__ChannelsKt$broadcastIn$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__ChannelsKt$broadcastIn$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            c<T> cVar = this.$this_broadcastIn;
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
