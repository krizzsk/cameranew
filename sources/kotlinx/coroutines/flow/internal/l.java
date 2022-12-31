package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
final class l implements Continuation<Object> {
    public static final l a = new l();
    private static final CoroutineContext b = EmptyCoroutineContext.INSTANCE;

    private l() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
