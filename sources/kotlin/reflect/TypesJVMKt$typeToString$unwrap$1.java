package kotlin.reflect;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
/* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements kotlin.jvm.b.l<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // kotlin.jvm.b.l
    public final Class<?> invoke(Class<?> p0) {
        s.h(p0, "p0");
        return p0.getComponentType();
    }
}
