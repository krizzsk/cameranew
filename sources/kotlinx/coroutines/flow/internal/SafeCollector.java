package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.u;
import kotlinx.coroutines.y1;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.d<T>, CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final kotlinx.coroutines.flow.d<T> collector;
    private Continuation<? super u> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext) {
        super(l.a, EmptyCoroutineContext.INSTANCE);
        this.collector = dVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, SafeCollector$collectContextSize$1.INSTANCE)).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof g) {
            exceptionTransparencyViolated((g) coroutineContext2, t);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
        this.lastEmissionContext = coroutineContext;
    }

    private final void exceptionTransparencyViolated(g gVar, Object obj) {
        String e2;
        e2 = StringsKt__IndentKt.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + gVar.a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(e2.toString());
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        try {
            Object emit = emit(continuation, (Continuation<? super u>) t);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emit == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return emit == coroutine_suspended2 ? emit : u.a;
        } catch (Throwable th) {
            this.lastEmissionContext = new g(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super u> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Continuation<? super u> continuation = this.completion;
        CoroutineContext context = continuation == null ? null : continuation.getContext();
        return context == null ? EmptyCoroutineContext.INSTANCE : context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(obj);
        if (m44exceptionOrNullimpl != null) {
            this.lastEmissionContext = new g(m44exceptionOrNullimpl);
        }
        Continuation<? super u> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutine_suspended;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(Continuation<? super u> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        y1.g(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t);
        }
        this.completion = continuation;
        return SafeCollectorKt.a().invoke(this.collector, t, this);
    }
}
