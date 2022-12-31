package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public final class TimeoutKt {
    public static final TimeoutCancellationException a(long j2, v1 v1Var) {
        return new TimeoutCancellationException("Timed out waiting for " + j2 + " ms", v1Var);
    }

    private static final <U, T extends U> Object b(x2<U, ? super T> x2Var, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar) {
        y1.f(x2Var, DelayKt.c(x2Var.c.getContext()).m(x2Var.f8848d, x2Var, x2Var.getContext()));
        return kotlinx.coroutines.d3.b.f(x2Var, x2Var, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.x2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(long r7, kotlin.jvm.b.p<? super kotlinx.coroutines.m0, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            long r7 = r0.J$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.b.p r8 = (kotlin.jvm.b.p) r8
            kotlin.j.b(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L34
            goto L6d
        L34:
            r8 = move-exception
            goto L70
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.j.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L48
            return r3
        L48:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.J$0 = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r0.label = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            kotlinx.coroutines.x2 r2 = new kotlinx.coroutines.x2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
            if (r7 != r8) goto L69
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L6e
        L69:
            if (r7 != r1) goto L6c
            return r1
        L6c:
            r10 = r7
        L6d:
            return r10
        L6e:
            r8 = move-exception
            r7 = r10
        L70:
            kotlinx.coroutines.v1 r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L77
            return r3
        L77:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.c(long, kotlin.jvm.b.p, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
