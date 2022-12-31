package kotlin.reflect;

import kotlin.reflect.k;
/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface n<D, E, V> extends k<V>, kotlin.jvm.b.p<D, E, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<D, E, V> extends k.a<V>, kotlin.jvm.b.p<D, E, V> {
    }

    Object getDelegate(D d2, E e2);

    a<D, E, V> getGetter();
}
