package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
/* compiled from: Share.kt */
/* loaded from: classes3.dex */
public final class SubscribedFlowCollector<T> implements d<T> {
    private final d<T> a;
    private final kotlin.jvm.b.p<d<? super T>, Continuation<? super kotlin.u>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.u> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r7)
            goto L77
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r4 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r4
            kotlin.j.b(r7)     // Catch: java.lang.Throwable -> L7d
            goto L5e
        L40:
            kotlin.j.b(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlinx.coroutines.flow.d<T> r7 = r6.a
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r2.<init>(r7, r5)
            kotlin.jvm.b.p<kotlinx.coroutines.flow.d<? super T>, kotlin.coroutines.Continuation<? super kotlin.u>, java.lang.Object> r7 = r6.b     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L7d
            r0.label = r4     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L7d
            if (r7 != r1) goto L5d
            return r1
        L5d:
            r4 = r6
        L5e:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.d<T> r7 = r4.a
            boolean r2 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r2 == 0) goto L7a
            kotlinx.coroutines.flow.SubscribedFlowCollector r7 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r7
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            kotlin.u r7 = kotlin.u.a
            return r7
        L7a:
            kotlin.u r7 = kotlin.u.a
            return r7
        L7d:
            r7 = move-exception
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super kotlin.u> continuation) {
        return this.a.emit(t, continuation);
    }
}
