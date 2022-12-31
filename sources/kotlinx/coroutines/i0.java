package kotlinx.coroutines;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes3.dex */
public final class i0 {
    private static final List<CoroutineExceptionHandler> a;

    static {
        kotlin.sequences.e c;
        List<CoroutineExceptionHandler> n;
        c = SequencesKt__SequencesKt.c(defpackage.a.a());
        n = SequencesKt___SequencesKt.n(c);
        a = n;
    }

    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : a) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, j0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
