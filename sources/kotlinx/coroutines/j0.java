package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public final class j0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.a0);
            if (coroutineExceptionHandler == null) {
                i0.a(coroutineContext, th);
            } else {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            }
        } catch (Throwable th2) {
            i0.a(coroutineContext, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.b.a(runtimeException, th);
        return runtimeException;
    }
}
