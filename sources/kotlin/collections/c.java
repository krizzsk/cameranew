package kotlin.collections;

import java.util.Map;
/* compiled from: AbstractMap.kt */
/* loaded from: classes3.dex */
public abstract class c<K, V> implements Map<K, V>, kotlin.jvm.internal.z.a {
    private final String b(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(Map.Entry<? extends K, ? extends V> entry) {
        return b(entry.getKey()) + '=' + b(entry.getValue());
    }
}
