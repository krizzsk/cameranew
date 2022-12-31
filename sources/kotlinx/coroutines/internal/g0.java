package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.t2;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class g0<T> implements t2<T> {
    private final T a;
    private final ThreadLocal<T> b;
    private final CoroutineContext.Key<?> c;

    public g0(T t, ThreadLocal<T> threadLocal) {
        this.a = t;
        this.b = threadLocal;
        this.c = new h0(threadLocal);
    }

    @Override // kotlinx.coroutines.t2
    public T N(CoroutineContext coroutineContext) {
        T t = this.b.get();
        this.b.set(this.a);
        return t;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
        return (R) t2.a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (kotlin.jvm.internal.s.c(getKey(), key)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return kotlin.jvm.internal.s.c(getKey(), key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlinx.coroutines.t2
    public void n(CoroutineContext coroutineContext, T t) {
        this.b.set(t);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return t2.a.b(this, coroutineContext);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.a + ", threadLocal = " + this.b + ')';
    }
}
