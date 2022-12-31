package kotlinx.coroutines.d3;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.o0;
/* compiled from: Undispatched.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <T> void a(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (lVar != null) {
                y.d(lVar, 1);
                Object invoke = lVar.invoke(probeCoroutineCreated);
                ThreadContextKt.a(context, c);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    Result.a aVar = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m41constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m41constructorimpl(j.a(th)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void b(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, null);
            if (pVar != null) {
                y.d(pVar, 2);
                Object invoke = pVar.invoke(r, probeCoroutineCreated);
                ThreadContextKt.a(context, c);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    Result.a aVar = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m41constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m41constructorimpl(j.a(th)));
        }
    }

    public static final <T> void c(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (lVar != null) {
                y.d(lVar, 1);
                Object invoke = lVar.invoke(probeCoroutineCreated);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    Result.a aVar = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m41constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m41constructorimpl(j.a(th)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void d(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (pVar != null) {
                y.d(pVar, 2);
                Object invoke = pVar.invoke(r, probeCoroutineCreated);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    Result.a aVar = Result.Companion;
                    probeCoroutineCreated.resumeWith(Result.m41constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            probeCoroutineCreated.resumeWith(Result.m41constructorimpl(j.a(th)));
        }
    }

    public static final <T, R> Object e(kotlinx.coroutines.internal.y<? super T> yVar, R r, p<? super R, ? super Continuation<? super T>, ? extends Object> pVar) {
        Object c0Var;
        Object coroutine_suspended;
        Throwable j2;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        try {
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (pVar != null) {
            y.d(pVar, 2);
            c0Var = pVar.invoke(r, yVar);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (c0Var == coroutine_suspended) {
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended3;
            }
            Object p0 = yVar.p0(c0Var);
            if (p0 == d2.b) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            } else if (p0 instanceof c0) {
                Throwable th2 = ((c0) p0).a;
                Continuation<? super T> continuation = yVar.c;
                if (o0.d() && (continuation instanceof CoroutineStackFrame)) {
                    j2 = b0.j(th2, (CoroutineStackFrame) continuation);
                    throw j2;
                }
                throw th2;
            } else {
                return d2.h(p0);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    public static final <T, R> Object f(kotlinx.coroutines.internal.y<? super T> yVar, R r, p<? super R, ? super Continuation<? super T>, ? extends Object> pVar) {
        Object c0Var;
        Object coroutine_suspended;
        Throwable j2;
        Throwable j3;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        boolean z = false;
        try {
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (pVar != null) {
            y.d(pVar, 2);
            c0Var = pVar.invoke(r, yVar);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (c0Var == coroutine_suspended) {
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended3;
            }
            Object p0 = yVar.p0(c0Var);
            if (p0 == d2.b) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            if (p0 instanceof c0) {
                Throwable th2 = ((c0) p0).a;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == yVar) ? true : true) {
                    Continuation<? super T> continuation = yVar.c;
                    if (o0.d() && (continuation instanceof CoroutineStackFrame)) {
                        j3 = b0.j(th2, (CoroutineStackFrame) continuation);
                        throw j3;
                    }
                    throw th2;
                } else if (c0Var instanceof c0) {
                    Throwable th3 = ((c0) c0Var).a;
                    Continuation<? super T> continuation2 = yVar.c;
                    if (o0.d() && (continuation2 instanceof CoroutineStackFrame)) {
                        j2 = b0.j(th3, (CoroutineStackFrame) continuation2);
                        throw j2;
                    }
                    throw th3;
                }
            } else {
                c0Var = d2.h(p0);
            }
            return c0Var;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
}
