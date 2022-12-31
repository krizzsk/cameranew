package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.j;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        return whenCreated(lifecycle, pVar, continuation);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        return whenResumed(lifecycle, pVar, continuation);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        return whenStarted(lifecycle, pVar, continuation);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return j.g(z0.c().z(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), continuation);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, continuation);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, continuation);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, continuation);
    }
}
