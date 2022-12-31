package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class f0 {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof c0) {
            Result.a aVar = Result.Companion;
            Throwable th = ((c0) obj).a;
            if (o0.d() && (continuation instanceof CoroutineStackFrame)) {
                th = kotlinx.coroutines.internal.b0.j(th, (CoroutineStackFrame) continuation);
            }
            return Result.m41constructorimpl(kotlin.j.a(th));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m41constructorimpl(obj);
    }

    public static final <T> Object b(Object obj, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(obj);
        if (m44exceptionOrNullimpl == null) {
            return lVar != null ? new d0(obj, lVar) : obj;
        }
        return new c0(m44exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object c(Object obj, p<?> pVar) {
        Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(obj);
        if (m44exceptionOrNullimpl != null) {
            if (o0.d() && (pVar instanceof CoroutineStackFrame)) {
                m44exceptionOrNullimpl = kotlinx.coroutines.internal.b0.j(m44exceptionOrNullimpl, (CoroutineStackFrame) pVar);
            }
            obj = new c0(m44exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, kotlin.jvm.b.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
