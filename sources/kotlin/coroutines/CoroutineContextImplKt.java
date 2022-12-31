package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element element, CoroutineContext.Key<E> key) {
        s.h(element, "<this>");
        s.h(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) {
                E e2 = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
                if (e2 instanceof CoroutineContext.Element) {
                    return e2;
                }
                return null;
            }
            return null;
        } else if (element.getKey() == key) {
            return element;
        } else {
            return null;
        }
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element element, CoroutineContext.Key<?> key) {
        s.h(element, "<this>");
        s.h(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return element.getKey() == key ? EmptyCoroutineContext.INSTANCE : element;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(element) == null) ? element : EmptyCoroutineContext.INSTANCE;
    }
}
