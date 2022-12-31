package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.v1;
/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public class y<T> extends kotlinx.coroutines.c<T> implements CoroutineStackFrame {
    public final Continuation<T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public y(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.c = continuation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.c2
    public void K(Object obj) {
        Continuation intercepted;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.c);
        j.c(intercepted, kotlinx.coroutines.f0.a(obj, this.c), null, 2, null);
    }

    @Override // kotlinx.coroutines.c
    protected void O0(Object obj) {
        Continuation<T> continuation = this.c;
        continuation.resumeWith(kotlinx.coroutines.f0.a(obj, continuation));
    }

    public final v1 S0() {
        kotlinx.coroutines.v g0 = g0();
        if (g0 == null) {
            return null;
        }
        return g0.getParent();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.c;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.c2
    protected final boolean l0() {
        return true;
    }
}
