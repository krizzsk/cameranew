package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface v1 extends CoroutineContext.Element {
    public static final b b0 = b.a;

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(v1 v1Var, CancellationException cancellationException, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i2 & 1) != 0) {
                cancellationException = null;
            }
            v1Var.a(cancellationException);
        }

        public static <R> R b(v1 v1Var, R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(v1Var, r, pVar);
        }

        public static <E extends CoroutineContext.Element> E c(v1 v1Var, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(v1Var, key);
        }

        public static /* synthetic */ b1 d(v1 v1Var, boolean z, boolean z2, kotlin.jvm.b.l lVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    z2 = true;
                }
                return v1Var.h(z, z2, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(v1 v1Var, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(v1Var, key);
        }

        public static CoroutineContext f(v1 v1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(v1Var, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class b implements CoroutineContext.Key<v1> {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    v O(x xVar);

    void a(CancellationException cancellationException);

    boolean d();

    b1 h(boolean z, boolean z2, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean start();

    CancellationException t();

    b1 u(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar);

    Object x(Continuation<? super kotlin.u> continuation);
}
