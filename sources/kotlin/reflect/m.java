package kotlin.reflect;

import kotlin.reflect.k;
/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface m<T, V> extends k<V>, kotlin.jvm.b.l<T, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<T, V> extends k.a<V>, kotlin.jvm.b.l<T, V> {
    }

    Object getDelegate(T t);

    a<T, V> getGetter();
}
