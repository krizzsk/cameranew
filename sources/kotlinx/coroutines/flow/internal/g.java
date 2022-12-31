package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class g implements CoroutineContext.Element {
    public static final a c = new a(null);
    public final Throwable a;
    private final CoroutineContext.Key<?> b = c;

    /* compiled from: SafeCollector.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CoroutineContext.Key<g> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public g(Throwable th) {
        this.a = th;
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
        return this.b;
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
