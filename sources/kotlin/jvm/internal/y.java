package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
/* compiled from: TypeIntrinsics.java */
/* loaded from: classes3.dex */
public class y {
    public static Collection a(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.z.a) && !(obj instanceof kotlin.jvm.internal.z.b)) {
            l(obj, "kotlin.collections.MutableCollection");
            throw null;
        }
        return e(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.z.a) && !(obj instanceof kotlin.jvm.internal.z.c)) {
            l(obj, "kotlin.collections.MutableIterable");
            throw null;
        }
        return f(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.z.a) && !(obj instanceof kotlin.jvm.internal.z.d)) {
            l(obj, "kotlin.collections.MutableList");
            throw null;
        }
        return g(obj);
    }

    public static Object d(Object obj, int i2) {
        if (obj == null || i(obj, i2)) {
            return obj;
        }
        l(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static Collection e(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            k(e2);
            throw null;
        }
    }

    public static Iterable f(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            k(e2);
            throw null;
        }
    }

    public static List g(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            k(e2);
            throw null;
        }
    }

    public static int h(Object obj) {
        if (obj instanceof q) {
            return ((q) obj).getArity();
        }
        if (obj instanceof kotlin.jvm.b.a) {
            return 0;
        }
        if (obj instanceof kotlin.jvm.b.l) {
            return 1;
        }
        if (obj instanceof kotlin.jvm.b.p) {
            return 2;
        }
        if (obj instanceof kotlin.jvm.b.q) {
            return 3;
        }
        if (obj instanceof kotlin.jvm.b.r) {
            return 4;
        }
        if (obj instanceof kotlin.jvm.b.s) {
            return 5;
        }
        if (obj instanceof kotlin.jvm.b.t) {
            return 6;
        }
        if (obj instanceof kotlin.jvm.b.u) {
            return 7;
        }
        if (obj instanceof kotlin.jvm.b.v) {
            return 8;
        }
        if (obj instanceof kotlin.jvm.b.w) {
            return 9;
        }
        if (obj instanceof kotlin.jvm.b.b) {
            return 10;
        }
        if (obj instanceof kotlin.jvm.b.c) {
            return 11;
        }
        if (obj instanceof kotlin.jvm.b.d) {
            return 12;
        }
        if (obj instanceof kotlin.jvm.b.e) {
            return 13;
        }
        if (obj instanceof kotlin.jvm.b.f) {
            return 14;
        }
        if (obj instanceof kotlin.jvm.b.g) {
            return 15;
        }
        if (obj instanceof kotlin.jvm.b.h) {
            return 16;
        }
        if (obj instanceof kotlin.jvm.b.i) {
            return 17;
        }
        if (obj instanceof kotlin.jvm.b.j) {
            return 18;
        }
        if (obj instanceof kotlin.jvm.b.k) {
            return 19;
        }
        if (obj instanceof kotlin.jvm.b.m) {
            return 20;
        }
        if (obj instanceof kotlin.jvm.b.n) {
            return 21;
        }
        return obj instanceof kotlin.jvm.b.o ? 22 : -1;
    }

    public static boolean i(Object obj, int i2) {
        return (obj instanceof kotlin.c) && h(obj) == i2;
    }

    private static <T extends Throwable> T j(T t) {
        s.p(t, y.class.getName());
        return t;
    }

    public static ClassCastException k(ClassCastException classCastException) {
        j(classCastException);
        throw classCastException;
    }

    public static void l(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m(name + " cannot be cast to " + str);
        throw null;
    }

    public static void m(String str) {
        k(new ClassCastException(str));
        throw null;
    }
}
