package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: AbstractMutableMap.kt */
/* loaded from: classes3.dex */
public abstract class f<K, V> extends AbstractMap<K, V> implements Map<K, V>, Object {
    public abstract Set a();

    public abstract /* bridge */ Set<Object> b();

    public abstract /* bridge */ int c();

    public /* bridge */ Collection<Object> d() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) d();
    }
}
