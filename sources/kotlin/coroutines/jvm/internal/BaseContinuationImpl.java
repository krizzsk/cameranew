package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.j;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<u> create(Continuation<?> completion) {
        s.h(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object coroutine_suspended;
        Continuation continuation = this;
        while (true) {
            DebugProbesKt.probeCoroutineResumed(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation continuation2 = baseContinuationImpl.completion;
            s.e(continuation2);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m41constructorimpl(j.a(th));
            }
            if (invokeSuspend == coroutine_suspended) {
                return;
            }
            Result.a aVar2 = Result.Companion;
            obj = Result.m41constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation2 instanceof BaseContinuationImpl)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Continuation<u> create(Object obj, Continuation<?> completion) {
        s.h(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
