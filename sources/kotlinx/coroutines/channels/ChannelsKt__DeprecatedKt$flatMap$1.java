package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Deprecated.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements kotlin.jvm.b.p<n<? super R>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_flatMap;
    final /* synthetic */ kotlin.jvm.b.p<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.b.p<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> pVar, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> continuation) {
        super(2, continuation);
        this.$this_flatMap = receiveChannel;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, continuation);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(n<? super R> nVar, Continuation<? super kotlin.u> continuation) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0091 -> B:14:0x0054). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L45
            if (r1 == r4) goto L35
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r10)
            goto L53
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L25:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L82
        L35:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L67
        L45:
            kotlin.j.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.n r10 = (kotlinx.coroutines.channels.n) r10
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r9.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L53:
            r10 = r9
        L54:
            r10.L$0 = r5
            r10.L$1 = r1
            r10.label = r4
            java.lang.Object r6 = r1.a(r10)
            if (r6 != r0) goto L61
            return r0
        L61:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L67:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L96
            java.lang.Object r10 = r5.next()
            kotlin.jvm.b.p<E, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>, java.lang.Object> r7 = r0.$transform
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r10 = r7.invoke(r10, r0)
            if (r10 != r1) goto L82
            return r1
        L82:
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r2
            java.lang.Object r10 = kotlinx.coroutines.channels.i.s(r10, r6, r0)
            if (r10 != r1) goto L91
            return r1
        L91:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L54
        L96:
            kotlin.u r10 = kotlin.u.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
