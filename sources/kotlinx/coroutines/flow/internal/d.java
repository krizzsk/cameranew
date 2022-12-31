package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final <T, V> Object b(CoroutineContext coroutineContext, V v, Object obj, kotlin.jvm.b.p<? super V, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Object c = ThreadContextKt.c(coroutineContext, obj);
        try {
            q qVar = new q(continuation, coroutineContext);
            if (pVar != null) {
                y.d(pVar, 2);
                Object invoke = pVar.invoke(v, qVar);
                ThreadContextKt.a(coroutineContext, c);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke == coroutine_suspended) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c);
            throw th;
        }
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Object obj, Object obj2, kotlin.jvm.b.p pVar, Continuation continuation, int i2, Object obj3) {
        if ((i2 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return b(coroutineContext, obj, obj2, pVar, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.d<T> d(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext) {
        return dVar instanceof p ? true : dVar instanceof m ? dVar : new UndispatchedContextCollector(dVar, coroutineContext);
    }
}
