package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.collections.g0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Deprecated.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements kotlin.jvm.b.p<n<? super g0<? extends E>>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(n<? super g0<? extends E>> nVar, Continuation<? super kotlin.u> continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(nVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0078 -> B:12:0x0043). Please submit an issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r11)
            r11 = r5
            goto L42
        L1d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L25:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
            kotlin.j.b(r11)
            r6 = r10
            goto L56
        L34:
            kotlin.j.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.channels.n r11 = (kotlinx.coroutines.channels.n) r11
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel<E> r4 = r10.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L42:
            r5 = r10
        L43:
            r5.L$0 = r11
            r5.L$1 = r4
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.a(r5)
            if (r6 != r0) goto L52
            return r0
        L52:
            r9 = r5
            r5 = r11
            r11 = r6
            r6 = r9
        L56:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L7c
            java.lang.Object r11 = r4.next()
            kotlin.collections.g0 r7 = new kotlin.collections.g0
            int r8 = r1 + 1
            r7.<init>(r1, r11)
            r6.L$0 = r5
            r6.L$1 = r4
            r6.I$0 = r8
            r6.label = r2
            java.lang.Object r11 = r5.D(r7, r6)
            if (r11 != r0) goto L78
            return r0
        L78:
            r11 = r5
            r5 = r6
            r1 = r8
            goto L43
        L7c:
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
