package kotlin.jvm.internal;
/* loaded from: classes3.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(kotlin.reflect.e eVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((l) eVar).a(), str, str2, !(eVar instanceof kotlin.reflect.c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public PropertyReference0Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
