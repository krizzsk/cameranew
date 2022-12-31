package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException implements g0<TimeoutCancellationException> {
    public final v1 coroutine;

    public TimeoutCancellationException(String str, v1 v1Var) {
        super(str);
        this.coroutine = v1Var;
    }

    @Override // kotlinx.coroutines.g0
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }
}
