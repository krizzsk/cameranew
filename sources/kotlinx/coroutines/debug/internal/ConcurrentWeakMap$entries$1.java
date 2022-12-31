package kotlinx.coroutines.debug.internal;

import java.util.Map;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
/* compiled from: ConcurrentWeakMap.kt */
/* loaded from: classes3.dex */
final class ConcurrentWeakMap$entries$1 extends Lambda implements p<K, V, Map.Entry<K, V>> {
    public static final ConcurrentWeakMap$entries$1 INSTANCE = new ConcurrentWeakMap$entries$1();

    ConcurrentWeakMap$entries$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ConcurrentWeakMap$entries$1) obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public final Map.Entry<K, V> invoke(K k2, V v) {
        return new ConcurrentWeakMap.b(k2, v);
    }
}
