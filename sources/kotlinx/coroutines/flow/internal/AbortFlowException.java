package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.o0;
/* compiled from: FlowExceptions.kt */
/* loaded from: classes3.dex */
public final class AbortFlowException extends CancellationException {
    private final kotlinx.coroutines.flow.d<?> owner;

    public AbortFlowException(kotlinx.coroutines.flow.d<?> dVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = dVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (o0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final kotlinx.coroutines.flow.d<?> getOwner() {
        return this.owner;
    }
}
