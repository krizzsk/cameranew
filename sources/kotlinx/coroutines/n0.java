package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
/* compiled from: CoroutineScope.kt */
/* loaded from: classes3.dex */
public final class n0 {
    public static final m0 a(CoroutineContext coroutineContext) {
        a0 b;
        if (coroutineContext.get(v1.b0) == null) {
            b = a2.b(null, 1, null);
            coroutineContext = coroutineContext.plus(b);
        }
        return new kotlinx.coroutines.internal.h(coroutineContext);
    }

    public static final <R> Object b(kotlin.jvm.b.p<? super m0, ? super Continuation<? super R>, ? extends Object> pVar, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(continuation.getContext(), continuation);
        Object e2 = kotlinx.coroutines.d3.b.e(yVar, yVar, pVar);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (e2 == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return e2;
    }

    public static final void c(m0 m0Var) {
        y1.g(m0Var.getCoroutineContext());
    }

    public static final boolean d(m0 m0Var) {
        v1 v1Var = (v1) m0Var.getCoroutineContext().get(v1.b0);
        if (v1Var == null) {
            return true;
        }
        return v1Var.isActive();
    }
}
