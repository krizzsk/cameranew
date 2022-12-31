package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
public interface p<T> extends Continuation<T> {

    /* compiled from: CancellableContinuation.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Object a(p pVar, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 == null) {
                if ((i2 & 2) != 0) {
                    obj2 = null;
                }
                return pVar.b(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object A(T t, Object obj, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    void B(CoroutineDispatcher coroutineDispatcher, T t);

    void F(Object obj);

    Object b(T t, Object obj);

    void e(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    Object g(Throwable th);

    void k(T t, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    boolean l(Throwable th);
}
