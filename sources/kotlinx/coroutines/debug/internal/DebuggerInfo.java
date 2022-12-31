package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
/* compiled from: DebuggerInfo.kt */
/* loaded from: classes3.dex */
public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        Thread.State state;
        k0 k0Var = (k0) coroutineContext.get(k0.b);
        this.coroutineId = k0Var == null ? null : Long.valueOf(k0Var.z());
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        this.dispatcher = continuationInterceptor == null ? null : continuationInterceptor.toString();
        l0 l0Var = (l0) coroutineContext.get(l0.b);
        this.name = l0Var == null ? null : l0Var.getName();
        this.state = debugCoroutineInfoImpl.d();
        Thread thread = debugCoroutineInfoImpl.f8742d;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.f8742d;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.e();
        this.sequenceNumber = debugCoroutineInfoImpl.a;
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }
}
