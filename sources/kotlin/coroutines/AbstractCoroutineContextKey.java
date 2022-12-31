package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    private final l<CoroutineContext.Element, E> safeCast;
    private final CoroutineContext.Key<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.b.l<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.b.l<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.Key<B> baseKey, l<? super CoroutineContext.Element, ? extends E> safeCast) {
        s.h(baseKey, "baseKey");
        s.h(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof AbstractCoroutineContextKey ? (CoroutineContext.Key<B>) ((AbstractCoroutineContextKey) baseKey).topmostKey : baseKey;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        s.h(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        s.h(element, "element");
        return (CoroutineContext.Element) this.safeCast.invoke(element);
    }
}
