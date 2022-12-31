package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.m0;
/* compiled from: FlowCoroutine.kt */
/* loaded from: classes3.dex */
public final class i {
    public static final <R> Object a(kotlin.jvm.b.p<? super m0, ? super Continuation<? super R>, ? extends Object> pVar, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        h hVar = new h(continuation.getContext(), continuation);
        Object e2 = kotlinx.coroutines.d3.b.e(hVar, hVar, pVar);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (e2 == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return e2;
    }
}
