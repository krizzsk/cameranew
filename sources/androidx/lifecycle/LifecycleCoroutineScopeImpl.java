package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l;
import kotlinx.coroutines.z0;
/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        s.h(lifecycle, "lifecycle");
        s.h(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState() == Lifecycle.State.DESTROYED) {
            a2.d(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, kotlinx.coroutines.m0
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_runtime_ktx_release() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        s.h(source, "source");
        s.h(event, "event");
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_runtime_ktx_release().removeObserver(this);
            a2.d(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        l.d(this, z0.c().z(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}
