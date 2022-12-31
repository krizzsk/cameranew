package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Deprecated.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements kotlin.jvm.b.p<n<? super E>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.b.p<? super E, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(n<? super E> nVar, Continuation<? super kotlin.u> continuation) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a4 -> B:14:0x0057). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L48
            if (r1 == r5) goto L38
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.j.b(r11)
            goto L56
        L1e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L26:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r6 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.channels.n r7 = (kotlinx.coroutines.channels.n) r7
            kotlin.j.b(r11)
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r10
            goto L8d
        L38:
            java.lang.Object r1 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r10.L$0
            kotlinx.coroutines.channels.n r6 = (kotlinx.coroutines.channels.n) r6
            kotlin.j.b(r11)
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r10
            goto L6c
        L48:
            kotlin.j.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.n r11 = (kotlinx.coroutines.channels.n) r11
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r10.$this_filter
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = r11
        L56:
            r11 = r10
        L57:
            r11.L$0 = r6
            r11.L$1 = r1
            r11.L$2 = r2
            r11.label = r5
            java.lang.Object r7 = r1.a(r11)
            if (r7 != r0) goto L66
            return r0
        L66:
            r9 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L6c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La9
            java.lang.Object r11 = r6.next()
            kotlin.jvm.b.p<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r0.$predicate
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r11, r0)
            if (r8 != r1) goto L89
            return r1
        L89:
            r9 = r7
            r7 = r11
            r11 = r8
            r8 = r9
        L8d:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La4
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r11 = r8.D(r7, r0)
            if (r11 != r1) goto La4
            return r1
        La4:
            r11 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            goto L57
        La9:
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
