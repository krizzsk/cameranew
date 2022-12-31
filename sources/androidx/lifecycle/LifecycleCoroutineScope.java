package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;
/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements m0 {
    @Override // kotlinx.coroutines.m0
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_runtime_ktx_release();

    public final v1 launchWhenCreated(p<? super m0, ? super Continuation<? super u>, ? extends Object> block) {
        v1 d2;
        s.h(block, "block");
        d2 = l.d(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
        return d2;
    }

    public final v1 launchWhenResumed(p<? super m0, ? super Continuation<? super u>, ? extends Object> block) {
        v1 d2;
        s.h(block, "block");
        d2 = l.d(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
        return d2;
    }

    public final v1 launchWhenStarted(p<? super m0, ? super Continuation<? super u>, ? extends Object> block) {
        v1 d2;
        s.h(block, "block");
        d2 = l.d(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
        return d2;
    }
}
