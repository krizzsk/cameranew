package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
/* compiled from: Yield.kt */
/* loaded from: classes3.dex */
public final class c3 {
    public static final Object a(Continuation<? super kotlin.u> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        CoroutineContext context = continuation.getContext();
        y1.g(context);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.internal.i iVar = intercepted instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) intercepted : null;
        if (iVar == null) {
            coroutine_suspended = kotlin.u.a;
        } else {
            if (iVar.f8766d.isDispatchNeeded(context)) {
                iVar.n(context, kotlin.u.a);
            } else {
                b3 b3Var = new b3();
                CoroutineContext plus = context.plus(b3Var);
                kotlin.u uVar = kotlin.u.a;
                iVar.n(plus, uVar);
                if (b3Var.a) {
                    coroutine_suspended = kotlinx.coroutines.internal.j.d(iVar) ? IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() : uVar;
                }
            }
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutine_suspended == coroutine_suspended3 ? coroutine_suspended : kotlin.u.a;
    }
}
