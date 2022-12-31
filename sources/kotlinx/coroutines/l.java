package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class l {
    public static final <T> s0<T> a(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar) {
        t0 t0Var;
        CoroutineContext c = h0.c(m0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            t0Var = new e2(c, pVar);
        } else {
            t0Var = new t0(c, true);
        }
        ((c) t0Var).R0(coroutineStart, t0Var, pVar);
        return t0Var;
    }

    public static /* synthetic */ s0 b(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return j.a(m0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final v1 c(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p<? super m0, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        c q2Var;
        CoroutineContext c = h0.c(m0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            q2Var = new f2(c, pVar);
        } else {
            q2Var = new q2(c, true);
        }
        q2Var.R0(coroutineStart, q2Var, pVar);
        return q2Var;
    }

    public static /* synthetic */ v1 d(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return j.c(m0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        Object T0;
        Object coroutine_suspended;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        y1.g(plus);
        if (plus == context) {
            kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(plus, continuation);
            T0 = kotlinx.coroutines.d3.b.e(yVar, yVar, pVar);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
            if (kotlin.jvm.internal.s.c(plus.get(key), context.get(key))) {
                z2 z2Var = new z2(plus, continuation);
                Object c = ThreadContextKt.c(plus, null);
                try {
                    Object e2 = kotlinx.coroutines.d3.b.e(z2Var, z2Var, pVar);
                    ThreadContextKt.a(plus, c);
                    T0 = e2;
                } catch (Throwable th) {
                    ThreadContextKt.a(plus, c);
                    throw th;
                }
            } else {
                v0 v0Var = new v0(plus, continuation);
                kotlinx.coroutines.d3.a.f(pVar, v0Var, v0Var, null, 4, null);
                T0 = v0Var.T0();
            }
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (T0 == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return T0;
    }
}
