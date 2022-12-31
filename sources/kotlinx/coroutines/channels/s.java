package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface s<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ boolean a(s sVar, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return sVar.C(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean C(Throwable th);

    Object D(E e2, Continuation<? super kotlin.u> continuation);

    boolean E();

    void m(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    Object q(E e2);
}
