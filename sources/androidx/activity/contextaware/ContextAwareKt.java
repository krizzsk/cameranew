package androidx.activity.contextaware;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.q;
/* compiled from: ContextAware.kt */
/* loaded from: classes.dex */
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, l<? super Context, ? extends R> lVar, Continuation<? super R> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        q qVar = new q(intercepted, 1);
        qVar.x();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(qVar, contextAware, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        qVar.e(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, lVar));
        Object u = qVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
            return u;
        }
        return u;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, l lVar, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        r.c(0);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        q qVar = new q(intercepted, 1);
        qVar.x();
        ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 = new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(qVar, contextAware, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1);
        qVar.e(new ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$2(contextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, contextAware, lVar));
        Object u = qVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        r.c(1);
        return u;
    }
}
