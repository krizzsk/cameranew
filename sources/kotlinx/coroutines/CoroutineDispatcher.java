package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final Key Key = new Key(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes3.dex */
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {

        /* compiled from: CoroutineDispatcher.kt */
        /* renamed from: kotlinx.coroutines.CoroutineDispatcher$Key$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<CoroutineContext.Element, CoroutineDispatcher> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            public final CoroutineDispatcher invoke(CoroutineContext.Element element) {
                if (element instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) element;
                }
                return null;
            }
        }

        private Key() {
            super(ContinuationInterceptor.Key, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new kotlinx.coroutines.internal.i(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(Continuation<?> continuation) {
        ((kotlinx.coroutines.internal.i) continuation).r();
    }

    public String toString() {
        return p0.a(this) + '@' + p0.b(this);
    }
}
