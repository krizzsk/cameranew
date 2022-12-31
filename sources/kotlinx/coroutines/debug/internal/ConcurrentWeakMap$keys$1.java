package kotlinx.coroutines.debug.internal;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
/* compiled from: ConcurrentWeakMap.kt */
/* loaded from: classes3.dex */
final class ConcurrentWeakMap$keys$1 extends Lambda implements p<K, V, K> {
    public static final ConcurrentWeakMap$keys$1 INSTANCE = new ConcurrentWeakMap$keys$1();

    ConcurrentWeakMap$keys$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final K invoke(K k2, V v) {
        return k2;
    }
}
