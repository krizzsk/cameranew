package kotlin.jvm.internal;
/* loaded from: classes3.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(kotlin.reflect.e eVar, String str, String str2) {
        super(((l) eVar).a(), str, str2, !(eVar instanceof kotlin.reflect.c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    public PropertyReference2Impl(Class cls, String str, String str2, int i2) {
        super(cls, str, str2, i2);
    }
}
