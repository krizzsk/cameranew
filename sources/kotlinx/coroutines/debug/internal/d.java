package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* compiled from: ConcurrentWeakMap.kt */
/* loaded from: classes3.dex */
public final class d<T> extends WeakReference<T> {
    public final int a;

    public d(T t, ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.a = t != null ? t.hashCode() : 0;
    }
}
