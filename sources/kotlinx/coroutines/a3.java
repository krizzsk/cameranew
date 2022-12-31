package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
final class a3 implements CoroutineContext.Element, CoroutineContext.Key<a3> {
    public static final a3 a = new a3();

    private a3() {
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }
}
