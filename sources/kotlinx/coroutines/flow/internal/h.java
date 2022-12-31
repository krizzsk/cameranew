package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowCoroutine.kt */
/* loaded from: classes3.dex */
public final class h<T> extends y<T> {
    public h(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.c2
    public boolean V(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return Q(th);
    }
}
