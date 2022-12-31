package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes3.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, p<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            s.h(operation, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(continuationInterceptor, r, operation);
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            s.h(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) {
                    E e2 = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor);
                    if (e2 instanceof CoroutineContext.Element) {
                        return e2;
                    }
                    return null;
                }
                return null;
            } else if (ContinuationInterceptor.Key == key) {
                s.f(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            } else {
                return null;
            }
        }

        public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            s.h(key, "key");
            if (!(key instanceof AbstractCoroutineContextKey)) {
                return ContinuationInterceptor.Key == key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.INSTANCE;
        }

        public static CoroutineContext plus(ContinuationInterceptor continuationInterceptor, CoroutineContext context) {
            s.h(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus(continuationInterceptor, context);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor continuationInterceptor, Continuation<?> continuation) {
            s.h(continuation, "continuation");
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
