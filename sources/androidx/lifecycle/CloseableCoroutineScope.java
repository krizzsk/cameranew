package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.m0;
/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, m0 {
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext context) {
        s.h(context, "context");
        this.coroutineContext = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a2.d(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.m0
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
