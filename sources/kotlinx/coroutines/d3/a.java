package kotlinx.coroutines.d3;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.u;
/* compiled from: Cancellable.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final /* synthetic */ void a(Continuation continuation, Throwable th) {
        b(continuation, th);
        throw null;
    }

    private static final void b(Continuation<?> continuation, Throwable th) {
        Result.a aVar = Result.Companion;
        continuation.resumeWith(Result.m41constructorimpl(j.a(th)));
        throw th;
    }

    public static final void c(Continuation<? super u> continuation, Continuation<?> continuation2) {
        Continuation intercepted;
        try {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Result.a aVar = Result.Companion;
            kotlinx.coroutines.internal.j.c(intercepted, Result.m41constructorimpl(u.a), null, 2, null);
        } catch (Throwable th) {
            a(continuation2, th);
            throw null;
        }
    }

    public static final <T> void d(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> continuation) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        try {
            createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(lVar, continuation);
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            Result.a aVar = Result.Companion;
            kotlinx.coroutines.internal.j.c(intercepted, Result.m41constructorimpl(u.a), null, 2, null);
        } catch (Throwable th) {
            a(continuation, th);
            throw null;
        }
    }

    public static final <R, T> void e(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> continuation, l<? super Throwable, u> lVar) {
        Continuation<u> createCoroutineUnintercepted;
        Continuation intercepted;
        try {
            createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, r, continuation);
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            Result.a aVar = Result.Companion;
            kotlinx.coroutines.internal.j.b(intercepted, Result.m41constructorimpl(u.a), lVar);
        } catch (Throwable th) {
            a(continuation, th);
            throw null;
        }
    }

    public static /* synthetic */ void f(p pVar, Object obj, Continuation continuation, l lVar, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        e(pVar, obj, continuation, lVar);
    }
}
