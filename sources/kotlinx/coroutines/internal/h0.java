package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class h0 implements CoroutineContext.Key<g0<?>> {
    private final ThreadLocal<?> a;

    public h0(ThreadLocal<?> threadLocal) {
        this.a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h0) && kotlin.jvm.internal.s.c(this.a, ((h0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ')';
    }
}
