package kotlinx.coroutines.flow;

import com.tapjoy.TJAdUnitConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {355}, m = "invokeSuspend", n = {"downstream", TJAdUnitConstants.String.USAGE_TRACKER_VALUES, "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements kotlin.jvm.b.q<kotlinx.coroutines.m0, d<? super T>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ c<T> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$sample$2(long j2, c<? extends T> cVar, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.$periodMillis = j2;
        this.$this_sample = cVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(kotlinx.coroutines.m0 m0Var, d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, continuation);
        flowKt__DelayKt$sample$2.L$0 = m0Var;
        flowKt__DelayKt$sample$2.L$1 = dVar;
        return flowKt__DelayKt$sample$2.invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ReceiveChannel b;
        d dVar;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel2;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.m0 m0Var = (kotlinx.coroutines.m0) this.L$0;
            ReceiveChannel e2 = ProduceKt.e(m0Var, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            b = FlowKt__DelayKt.b(m0Var, this.$periodMillis, 0L, 2, null);
            dVar = (d) this.L$1;
            receiveChannel = e2;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannel2 = b;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            receiveChannel2 = (ReceiveChannel) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            dVar = (d) this.L$0;
            kotlin.j.b(obj);
        }
        while (ref$ObjectRef.element != kotlinx.coroutines.flow.internal.n.c) {
            this.L$0 = dVar;
            this.L$1 = receiveChannel;
            this.L$2 = ref$ObjectRef;
            this.L$3 = receiveChannel2;
            this.label = 1;
            kotlinx.coroutines.selects.b bVar = new kotlinx.coroutines.selects.b(this);
            try {
                bVar.s(receiveChannel.s(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannel2, null));
                bVar.s(receiveChannel2.r(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, dVar, null));
            } catch (Throwable th) {
                bVar.V(th);
            }
            Object U = bVar.U();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (U == coroutine_suspended2) {
                DebugProbesKt.probeCoroutineSuspended(this);
                continue;
            }
            if (U == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return kotlin.u.a;
    }
}
