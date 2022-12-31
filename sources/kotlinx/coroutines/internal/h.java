package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.m0;
/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public final class h implements m0 {
    private final CoroutineContext a;

    public h(CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }

    @Override // kotlinx.coroutines.m0
    public CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
