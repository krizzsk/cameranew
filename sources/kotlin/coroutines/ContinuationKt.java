package kotlin.coroutines;

import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Continuation.kt */
/* loaded from: classes3.dex */
public final class ContinuationKt {
    private static final <T> Continuation<T> Continuation(final CoroutineContext context, final l<? super Result<? extends T>, u> resumeWith) {
        s.h(context, "context");
        s.h(resumeWith, "resumeWith");
        return new Continuation<T>() { // from class: kotlin.coroutines.ContinuationKt$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                resumeWith.invoke(Result.m40boximpl(obj));
            }
        };
    }

    public static final <T> Continuation<u> createCoroutine(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> completion) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        Object coroutine_suspended;
        s.h(lVar, "<this>");
        s.h(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(lVar, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(intercepted, coroutine_suspended);
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(Continuation<? super T> continuation, T t) {
        s.h(continuation, "<this>");
        Result.a aVar = Result.Companion;
        continuation.resumeWith(Result.m41constructorimpl(t));
    }

    private static final <T> void resumeWithException(Continuation<? super T> continuation, Throwable exception) {
        s.h(continuation, "<this>");
        s.h(exception, "exception");
        Result.a aVar = Result.Companion;
        continuation.resumeWith(Result.m41constructorimpl(j.a(exception)));
    }

    public static final <T> void startCoroutine(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> completion) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        s.h(lVar, "<this>");
        s.h(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(lVar, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        Result.a aVar = Result.Companion;
        intercepted.resumeWith(Result.m41constructorimpl(u.a));
    }

    private static final <T> Object suspendCoroutine(l<? super Continuation<? super T>, u> lVar, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        r.c(0);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        lVar.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        r.c(1);
        return orThrow;
    }

    public static final <R, T> Continuation<u> createCoroutine(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> completion) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        Object coroutine_suspended;
        s.h(pVar, "<this>");
        s.h(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, r, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return new SafeContinuation(intercepted, coroutine_suspended);
    }

    public static final <R, T> void startCoroutine(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> completion) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        s.h(pVar, "<this>");
        s.h(completion, "completion");
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, r, completion);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
        Result.a aVar = Result.Companion;
        intercepted.resumeWith(Result.m41constructorimpl(u.a));
    }
}
