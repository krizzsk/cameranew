package kotlin.jvm.internal;
/* loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(kotlin.reflect.e eVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((l) eVar).a(), str, str2, !(eVar instanceof kotlin.reflect.c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
