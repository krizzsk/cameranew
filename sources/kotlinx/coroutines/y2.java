package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: Unconfined.kt */
/* loaded from: classes3.dex */
public final class y2 extends CoroutineDispatcher {
    public static final y2 a = new y2();

    private y2() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b3 b3Var = (b3) coroutineContext.get(b3.b);
        if (b3Var != null) {
            b3Var.a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
