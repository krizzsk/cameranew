package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.z0;
/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        s.h(context, "context");
        s.h(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        s.h(context, "context");
        if (z0.c().z().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
