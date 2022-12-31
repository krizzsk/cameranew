package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;
/* compiled from: Produce.kt */
/* loaded from: classes3.dex */
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.coroutines.channels.n<?> r4, kotlin.jvm.b.a<kotlin.u> r5, kotlin.coroutines.Continuation<? super kotlin.u> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.b.a r5 = (kotlin.jvm.b.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.n r4 = (kotlinx.coroutines.channels.n) r4
            kotlin.j.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L7a
        L32:
            r4 = move-exception
            goto L80
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.j.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.v1$b r2 = kotlinx.coroutines.v1.b0
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            if (r6 != r4) goto L4d
            r6 = 1
            goto L4e
        L4d:
            r6 = 0
        L4e:
            if (r6 == 0) goto L84
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.q r6 = new kotlinx.coroutines.q     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.x()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.m(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.u()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L77
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch: java.lang.Throwable -> L32
        L77:
            if (r4 != r1) goto L7a
            return r1
        L7a:
            r5.invoke()
            kotlin.u r4 = kotlin.u.a
            return r4
        L80:
            r5.invoke()
            throw r4
        L84:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.n, kotlin.jvm.b.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(n nVar, kotlin.jvm.b.a aVar, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = ProduceKt$awaitClose$2.INSTANCE;
        }
        return a(nVar, aVar, continuation);
    }

    public static final <E> ReceiveChannel<E> c(m0 m0Var, CoroutineContext coroutineContext, int i2, kotlin.jvm.b.p<? super n<? super E>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return d(m0Var, coroutineContext, i2, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    public static final <E> ReceiveChannel<E> d(m0 m0Var, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, kotlin.jvm.b.p<? super n<? super E>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        m mVar = new m(h0.c(m0Var, coroutineContext), g.b(i2, bufferOverflow, null, 4, null));
        if (lVar != null) {
            mVar.u(lVar);
        }
        mVar.R0(coroutineStart, mVar, pVar);
        return mVar;
    }

    public static /* synthetic */ ReceiveChannel e(m0 m0Var, CoroutineContext coroutineContext, int i2, kotlin.jvm.b.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c(m0Var, coroutineContext, i2, pVar);
    }

    public static /* synthetic */ ReceiveChannel f(m0 m0Var, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, kotlin.jvm.b.l lVar, kotlin.jvm.b.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i4 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i3 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 16) != 0) {
            lVar = null;
        }
        return d(m0Var, coroutineContext2, i4, bufferOverflow2, coroutineStart2, lVar, pVar);
    }
}
