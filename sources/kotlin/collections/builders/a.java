package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.g;
import kotlin.jvm.internal.s;
/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends g<E> {
    public final boolean a(E element) {
        s.h(element, "element");
        return b(element);
    }

    public abstract boolean b(Map.Entry<? extends K, ? extends V> entry);

    public abstract /* bridge */ boolean c(Map.Entry<?, ?> entry);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return a((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return c((Map.Entry) obj);
        }
        return false;
    }
}
