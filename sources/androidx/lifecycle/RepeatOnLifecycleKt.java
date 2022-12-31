package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p<? super m0, ? super Continuation<? super u>, ? extends Object> pVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        if (state != Lifecycle.State.INITIALIZED) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                return u.a;
            }
            Object b = n0.b(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return b == coroutine_suspended ? b : u.a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p<? super m0, ? super Continuation<? super u>, ? extends Object> pVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycle, state, pVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return repeatOnLifecycle == coroutine_suspended ? repeatOnLifecycle : u.a;
    }
}
