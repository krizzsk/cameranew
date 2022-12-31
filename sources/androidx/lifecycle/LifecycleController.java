package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.v1;
/* compiled from: LifecycleController.kt */
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State minState, DispatchQueue dispatchQueue, final v1 parentJob) {
        s.h(lifecycle, "lifecycle");
        s.h(minState, "minState");
        s.h(dispatchQueue, "dispatchQueue");
        s.h(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner source, Lifecycle.Event noName_1) {
                Lifecycle.State state;
                DispatchQueue dispatchQueue2;
                DispatchQueue dispatchQueue3;
                s.h(source, "source");
                s.h(noName_1, "$noName_1");
                if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = LifecycleController.this;
                    v1.a.a(parentJob, null, 1, null);
                    lifecycleController.finish();
                    return;
                }
                Lifecycle.State currentState = source.getLifecycle().getCurrentState();
                state = LifecycleController.this.minState;
                if (currentState.compareTo(state) < 0) {
                    dispatchQueue3 = LifecycleController.this.dispatchQueue;
                    dispatchQueue3.pause();
                    return;
                }
                dispatchQueue2 = LifecycleController.this.dispatchQueue;
                dispatchQueue2.resume();
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            v1.a.a(parentJob, null, 1, null);
            finish();
            return;
        }
        lifecycle.addObserver(lifecycleEventObserver);
    }

    private final void handleDestroy(v1 v1Var) {
        v1.a.a(v1Var, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
