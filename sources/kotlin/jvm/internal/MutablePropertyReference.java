package kotlin.jvm.internal;

import kotlin.reflect.k;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference extends PropertyReference implements kotlin.reflect.k {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ k.a<V> getGetter();

    public abstract /* synthetic */ kotlin.reflect.g<V> getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
