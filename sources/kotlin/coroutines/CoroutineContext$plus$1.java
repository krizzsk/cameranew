package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class CoroutineContext$plus$1 extends Lambda implements p<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final CoroutineContext invoke(CoroutineContext acc, CoroutineContext.Element element) {
        CombinedContext combinedContext;
        s.h(acc, "acc");
        s.h(element, "element");
        CoroutineContext minusKey = acc.minusKey(element.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (minusKey == emptyCoroutineContext) {
            return element;
        }
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(key);
        if (continuationInterceptor == null) {
            combinedContext = new CombinedContext(minusKey, element);
        } else {
            CoroutineContext minusKey2 = minusKey.minusKey(key);
            if (minusKey2 == emptyCoroutineContext) {
                return new CombinedContext(element, continuationInterceptor);
            }
            combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
        }
        return combinedContext;
    }
}
