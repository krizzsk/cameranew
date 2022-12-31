package kotlin.coroutines;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext context) {
            s.h(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes3.dex */
        public static final class DefaultImpls {
            public static <R> R fold(Element element, R r, p<? super R, ? super Element, ? extends R> operation) {
                s.h(operation, "operation");
                return operation.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                s.h(key, "key");
                if (s.c(element.getKey(), key)) {
                    s.f(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                s.h(key, "key");
                return s.c(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext context) {
                s.h(context, "context");
                return DefaultImpls.plus(element, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, p<? super R, ? super Element, ? extends R> pVar);

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        CoroutineContext minusKey(Key<?> key);
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, p<? super R, ? super Element, ? extends R> pVar);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
