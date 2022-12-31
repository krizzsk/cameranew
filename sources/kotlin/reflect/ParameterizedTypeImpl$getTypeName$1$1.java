package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements kotlin.jvm.b.l<Type, String> {
    public static final ParameterizedTypeImpl$getTypeName$1$1 INSTANCE = new ParameterizedTypeImpl$getTypeName$1$1();

    ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(Type p0) {
        String b;
        s.h(p0, "p0");
        b = TypesJVMKt.b(p0);
        return b;
    }
}
