package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.h<? extends Object>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<kotlin.u> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<kotlin.u> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, continuation);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.h<? extends Object> hVar, Continuation<? super kotlin.u> continuation) {
        return m54invokeWpGqRn0(hVar.l(), continuation);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m54invokeWpGqRn0(Object obj, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(kotlinx.coroutines.channels.h.b(obj), continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.internal.c0, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            ?? l2 = ((kotlinx.coroutines.channels.h) this.L$0).l();
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            boolean z = l2 instanceof h.c;
            if (!z) {
                ref$ObjectRef.element = l2;
            }
            ReceiveChannel<kotlin.u> receiveChannel = this.$ticker;
            if (z) {
                Throwable e2 = kotlinx.coroutines.channels.h.e(l2);
                if (e2 == null) {
                    receiveChannel.a(new ChildCancelledException());
                    ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.c;
                } else {
                    throw e2;
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
