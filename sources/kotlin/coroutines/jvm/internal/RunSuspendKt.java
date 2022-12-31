package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: RunSuspend.kt */
/* loaded from: classes3.dex */
public final class RunSuspendKt {
    public static final void runSuspend(l<? super Continuation<? super u>, ? extends Object> block) {
        s.h(block, "block");
        RunSuspend runSuspend = new RunSuspend();
        ContinuationKt.startCoroutine(block, runSuspend);
        runSuspend.await();
    }
}
