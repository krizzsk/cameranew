package kotlin.reflect;

import kotlin.reflect.k;
/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface l<V> extends k<V>, kotlin.jvm.b.a<V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<V> extends k.a<V>, kotlin.jvm.b.a<V> {
    }

    Object getDelegate();

    a<V> getGetter();
}
