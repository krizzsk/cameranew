package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes3.dex */
public class l0 extends k0 {
    public static <K, V> Map<K, V> a(Map<K, V> builder) {
        kotlin.jvm.internal.s.h(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    public static <K, V> Map<K, V> b(int i2) {
        return new MapBuilder(i2);
    }

    public static int c(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> d(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.s.h(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.s.g(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> e(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.h(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.s.g(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
