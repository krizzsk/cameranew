package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class f {
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> b(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    public static <T> List<T> c(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return Collections.unmodifiableList(Arrays.asList(tArr));
            }
            return b(tArr[0]);
        }
        return a();
    }

    public static <K, V> Map<K, V> d(K k2, V v, K k3, V v2, K k4, V v3) {
        Map i2 = i(3, false);
        i2.put(k2, v);
        i2.put(k3, v2);
        i2.put(k4, v3);
        return Collections.unmodifiableMap(i2);
    }

    public static <K, V> Map<K, V> e(K[] kArr, V[] vArr) {
        if (kArr.length == vArr.length) {
            int length = kArr.length;
            if (length != 0) {
                if (length != 1) {
                    Map i2 = i(kArr.length, false);
                    for (int i3 = 0; i3 < kArr.length; i3++) {
                        i2.put(kArr[i3], vArr[i3]);
                    }
                    return Collections.unmodifiableMap(i2);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.emptyMap();
        }
        int length2 = kArr.length;
        int length3 = vArr.length;
        StringBuilder sb = new StringBuilder(66);
        sb.append("Key and values array lengths not equal: ");
        sb.append(length2);
        sb.append(" != ");
        sb.append(length3);
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public static <T> Set<T> f(T t, T t2, T t3) {
        Set h2 = h(3, false);
        h2.add(t);
        h2.add(t2);
        h2.add(t3);
        return Collections.unmodifiableSet(h2);
    }

    @Deprecated
    public static <T> Set<T> g(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2) {
                    T t = tArr[0];
                    T t2 = tArr[1];
                    Set h2 = h(2, false);
                    h2.add(t);
                    h2.add(t2);
                    return Collections.unmodifiableSet(h2);
                } else if (length != 3) {
                    if (length != 4) {
                        Set h3 = h(tArr.length, false);
                        Collections.addAll(h3, tArr);
                        return Collections.unmodifiableSet(h3);
                    }
                    T t3 = tArr[0];
                    T t4 = tArr[1];
                    T t5 = tArr[2];
                    T t6 = tArr[3];
                    Set h4 = h(4, false);
                    h4.add(t3);
                    h4.add(t4);
                    h4.add(t5);
                    h4.add(t6);
                    return Collections.unmodifiableSet(h4);
                } else {
                    return f(tArr[0], tArr[1], tArr[2]);
                }
            }
            return Collections.singleton(tArr[0]);
        }
        return Collections.emptySet();
    }

    private static <T> Set<T> h(int i2, boolean z) {
        float f2 = z ? 0.75f : 1.0f;
        if (i2 <= (z ? 128 : 256)) {
            return new ArraySet(i2);
        }
        return new HashSet(i2, f2);
    }

    private static <K, V> Map<K, V> i(int i2, boolean z) {
        if (i2 <= 256) {
            return new ArrayMap(i2);
        }
        return new HashMap(i2, 1.0f);
    }
}
