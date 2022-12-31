package kotlin.jvm.internal;

import kotlin.reflect.k;
/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.reflect.k {
    public PropertyReference() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && s.c(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (obj instanceof kotlin.reflect.k) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public abstract /* synthetic */ k.a<V> getGetter();

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.k
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.k
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.k getReflected() {
        return (kotlin.reflect.k) super.getReflected();
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
