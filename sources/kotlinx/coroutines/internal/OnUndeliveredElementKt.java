package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes3.dex */
public final class OnUndeliveredElementKt {
    public static final <E> kotlin.jvm.b.l<Throwable, kotlin.u> a(kotlin.jvm.b.l<? super E, kotlin.u> lVar, E e2, CoroutineContext coroutineContext) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(lVar, e2, coroutineContext);
    }

    public static final <E> void b(kotlin.jvm.b.l<? super E, kotlin.u> lVar, E e2, CoroutineContext coroutineContext) {
        UndeliveredElementException c = c(lVar, e2, null);
        if (c == null) {
            return;
        }
        kotlinx.coroutines.j0.a(coroutineContext, c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(kotlin.jvm.b.l<? super E, kotlin.u> lVar, E e2, UndeliveredElementException undeliveredElementException) {
        try {
            lVar.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                kotlin.b.a(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException(kotlin.jvm.internal.s.q("Exception in undelivered element handler for ", e2), th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(kotlin.jvm.b.l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
