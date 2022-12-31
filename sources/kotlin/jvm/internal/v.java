package kotlin.jvm.internal;
/* compiled from: Reflection.java */
/* loaded from: classes3.dex */
public class v {
    private static final w a;
    private static final kotlin.reflect.c[] b;

    static {
        w wVar = null;
        try {
            wVar = (w) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (wVar == null) {
            wVar = new w();
        }
        a = wVar;
        b = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.f a(FunctionReference functionReference) {
        a.a(functionReference);
        return functionReference;
    }

    public static kotlin.reflect.c b(Class cls) {
        return a.b(cls);
    }

    public static kotlin.reflect.e c(Class cls) {
        return a.c(cls, "");
    }

    public static kotlin.reflect.h d(MutablePropertyReference0 mutablePropertyReference0) {
        a.d(mutablePropertyReference0);
        return mutablePropertyReference0;
    }

    public static kotlin.reflect.i e(MutablePropertyReference1 mutablePropertyReference1) {
        a.e(mutablePropertyReference1);
        return mutablePropertyReference1;
    }

    public static kotlin.reflect.j f(MutablePropertyReference2 mutablePropertyReference2) {
        a.f(mutablePropertyReference2);
        return mutablePropertyReference2;
    }

    public static kotlin.reflect.l g(PropertyReference0 propertyReference0) {
        a.g(propertyReference0);
        return propertyReference0;
    }

    public static kotlin.reflect.m h(PropertyReference1 propertyReference1) {
        a.h(propertyReference1);
        return propertyReference1;
    }

    public static kotlin.reflect.n i(PropertyReference2 propertyReference2) {
        a.i(propertyReference2);
        return propertyReference2;
    }

    public static String j(q qVar) {
        return a.j(qVar);
    }

    public static String k(Lambda lambda) {
        return a.k(lambda);
    }
}
