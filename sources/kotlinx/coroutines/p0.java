package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
/* compiled from: DebugStrings.kt */
/* loaded from: classes3.dex */
public final class p0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation<?> continuation) {
        String m41constructorimpl;
        if (continuation instanceof kotlinx.coroutines.internal.i) {
            return continuation.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        if (Result.m44exceptionOrNullimpl(m41constructorimpl) != null) {
            m41constructorimpl = ((Object) continuation.getClass().getName()) + '@' + b(continuation);
        }
        return (String) m41constructorimpl;
    }
}
