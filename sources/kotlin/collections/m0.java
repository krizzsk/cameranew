package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes3.dex */
public class m0 extends l0 {
    public static <K, V> Map<K, V> f() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        kotlin.jvm.internal.s.f(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> HashMap<K, V> g(Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.h(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(j0.c(pairs.length));
        l(hashMap, pairs);
        return hashMap;
    }

    public static <K, V> Map<K, V> h(Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.h(pairs, "pairs");
        if (pairs.length > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(j0.c(pairs.length));
            o(pairs, linkedHashMap);
            return linkedHashMap;
        }
        return j0.f();
    }

    public static <K, V> Map<K, V> i(Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.h(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.c(pairs.length));
        l(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> j(Map<K, ? extends V> map) {
        kotlin.jvm.internal.s.h(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : l0.e(map);
        }
        return j0.f();
    }

    public static final <K, V> void k(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.s.h(map, "<this>");
        kotlin.jvm.internal.s.h(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V> void l(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.s.h(map, "<this>");
        kotlin.jvm.internal.s.h(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static <K, V> Map<K, V> m(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return l0.d(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(j0.c(collection.size()));
                n(iterable, linkedHashMap);
                return linkedHashMap;
            }
            return j0.f();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        n(iterable, linkedHashMap2);
        return j(linkedHashMap2);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M n(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        k(destination, iterable);
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M o(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        kotlin.jvm.internal.s.h(pairArr, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        l(destination, pairArr);
        return destination;
    }

    public static <K, V> Map<K, V> p(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.h(map, "<this>");
        return new LinkedHashMap(map);
    }
}
