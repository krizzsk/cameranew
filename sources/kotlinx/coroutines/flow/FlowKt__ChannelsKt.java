package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object b(d<? super T> dVar, ReceiveChannel<? extends T> receiveChannel, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Object c = c(dVar, receiveChannel, true, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c == coroutine_suspended ? c : kotlin.u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:28:0x0070, B:30:0x0076, B:36:0x0084, B:37:0x0085, B:18:0x004b), top: B:47:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:28:0x0070, B:30:0x0076, B:36:0x0084, B:37:0x0085, B:18:0x004b), top: B:47:0x0022 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0094 -> B:14:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.d<? super T> r7, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.u> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L57
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.d r9 = (kotlinx.coroutines.flow.d) r9
            kotlin.j.b(r10)     // Catch: java.lang.Throwable -> L55
        L35:
            r6 = r9
            r9 = r7
            r7 = r6
            goto L5d
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.d r9 = (kotlinx.coroutines.flow.d) r9
            kotlin.j.b(r10)     // Catch: java.lang.Throwable -> L55
            kotlinx.coroutines.channels.h r10 = (kotlinx.coroutines.channels.h) r10     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r10.l()     // Catch: java.lang.Throwable -> L55
            goto L6f
        L55:
            r9 = move-exception
            goto L9b
        L57:
            kotlin.j.b(r10)
            kotlinx.coroutines.flow.e.l(r7)
        L5d:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L97
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L97
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L97
            r0.label = r4     // Catch: java.lang.Throwable -> L97
            java.lang.Object r10 = r8.z(r0)     // Catch: java.lang.Throwable -> L97
            if (r10 != r1) goto L6c
            return r1
        L6c:
            r6 = r9
            r9 = r7
            r7 = r6
        L6f:
            r2 = 0
            boolean r5 = kotlinx.coroutines.channels.h.i(r10)     // Catch: java.lang.Throwable -> L55
            if (r5 == 0) goto L85
            java.lang.Throwable r9 = kotlinx.coroutines.channels.h.e(r10)     // Catch: java.lang.Throwable -> L55
            if (r9 != 0) goto L84
            if (r7 == 0) goto L81
            kotlinx.coroutines.channels.i.b(r8, r2)
        L81:
            kotlin.u r7 = kotlin.u.a
            return r7
        L84:
            throw r9     // Catch: java.lang.Throwable -> L55
        L85:
            kotlinx.coroutines.channels.h.g(r10)     // Catch: java.lang.Throwable -> L55
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L55
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L55
            r0.Z$0 = r7     // Catch: java.lang.Throwable -> L55
            r0.label = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r9.emit(r10, r0)     // Catch: java.lang.Throwable -> L55
            if (r10 != r1) goto L35
            return r1
        L97:
            r7 = move-exception
            r6 = r9
            r9 = r7
            r7 = r6
        L9b:
            throw r9     // Catch: java.lang.Throwable -> L9c
        L9c:
            r10 = move-exception
            if (r7 == 0) goto La2
            kotlinx.coroutines.channels.i.b(r8, r9)
        La2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.c(kotlinx.coroutines.flow.d, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> c<T> d(ReceiveChannel<? extends T> receiveChannel) {
        return new a(receiveChannel, false, null, 0, null, 28, null);
    }
}
