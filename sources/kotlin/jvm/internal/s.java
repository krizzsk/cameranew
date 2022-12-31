package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* compiled from: Intrinsics.java */
/* loaded from: classes3.dex */
public class s {
    private s() {
    }

    public static boolean a(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    public static boolean b(Float f2, Float f3) {
        if (f2 == null) {
            if (f3 == null) {
                return true;
            }
        } else if (f3 != null && f2.floatValue() == f3.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        o(illegalStateException);
        throw illegalStateException;
    }

    public static void e(Object obj) {
        if (obj != null) {
            return;
        }
        r();
        throw null;
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        s(str);
        throw null;
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
        o(nullPointerException);
        throw nullPointerException;
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        v(str);
        throw null;
    }

    public static void i(Object obj, String str) {
        if (obj != null) {
            return;
        }
        u(str);
        throw null;
    }

    public static int j(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int k(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    private static String l(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void m() {
        w();
        throw null;
    }

    public static void n(int i2, String str) {
        w();
        throw null;
    }

    private static <T extends Throwable> T o(T t) {
        p(t, s.class.getName());
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T p(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static String q(String str, Object obj) {
        return str + obj;
    }

    public static void r() {
        NullPointerException nullPointerException = new NullPointerException();
        o(nullPointerException);
        throw nullPointerException;
    }

    public static void s(String str) {
        NullPointerException nullPointerException = new NullPointerException(str);
        o(nullPointerException);
        throw nullPointerException;
    }

    public static void t() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        o(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    private static void u(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(l(str));
        o(illegalArgumentException);
        throw illegalArgumentException;
    }

    private static void v(String str) {
        NullPointerException nullPointerException = new NullPointerException(l(str));
        o(nullPointerException);
        throw nullPointerException;
    }

    public static void w() {
        x("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw null;
    }

    public static void x(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void y(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        o(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void z(String str) {
        y("lateinit property " + str + " has not been initialized");
        throw null;
    }
}
