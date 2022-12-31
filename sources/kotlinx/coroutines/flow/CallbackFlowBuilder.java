package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final class CallbackFlowBuilder<T> extends b<T> {

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super T>, Continuation<? super kotlin.u>, Object> f8745e;

    public /* synthetic */ CallbackFlowBuilder(kotlin.jvm.b.p pVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, kotlin.jvm.internal.o oVar) {
        this(pVar, (i3 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 4) != 0 ? -2 : i2, (i3 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    @Override // kotlinx.coroutines.flow.b, kotlinx.coroutines.flow.internal.ChannelFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(kotlinx.coroutines.channels.n<? super T> r5, kotlin.coroutines.Continuation<? super kotlin.u> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.j.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = super.i(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.E()
            if (r5 == 0) goto L4c
            kotlin.u r5 = kotlin.u.a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.i(kotlinx.coroutines.channels.n, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> j(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new CallbackFlowBuilder(this.f8745e, coroutineContext, i2, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(kotlin.jvm.b.p<? super kotlinx.coroutines.channels.n<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(pVar, coroutineContext, i2, bufferOverflow);
        this.f8745e = pVar;
    }
}
