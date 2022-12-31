package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
/* compiled from: CancellationException.kt */
/* loaded from: classes3.dex */
public final class CancellationExceptionKt {
    private static final CancellationException CancellationException(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static /* synthetic */ void CancellationException$annotations() {
    }

    private static final CancellationException CancellationException(Throwable th) {
        CancellationException cancellationException = new CancellationException(th != null ? th.toString() : null);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
