package kotlin.internal;

import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final a a;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int a2 = a();
        if (a2 >= 65544 || a2 < 65536) {
            try {
                newInstance = Class.forName("kotlin.internal.e.a").newInstance();
                s.g(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                } catch (ClassCastException e2) {
                    ClassLoader classLoader = newInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = a.class.getClassLoader();
                    if (s.c(classLoader, classLoader2)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
                }
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                s.g(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassCastException e3) {
                    ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    if (s.c(classLoader3, classLoader4)) {
                        throw e3;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e3);
                }
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance;
            a = aVar;
        }
        if (a2 >= 65543 || a2 < 65536) {
            try {
                newInstance2 = Class.forName("kotlin.internal.d.a").newInstance();
                s.g(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        if (s.c(classLoader5, classLoader6)) {
                            throw e4;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e4);
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                s.g(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance4;
                } catch (ClassCastException e5) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (s.c(classLoader7, classLoader8)) {
                        throw e5;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e5);
                }
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance2;
            a = aVar;
        }
        aVar = new a();
        a = aVar;
    }

    private static final int a() {
        int O;
        int O2;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        O = StringsKt__StringsKt.O(property, '.', 0, false, 6, null);
        if (O < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = O + 1;
        O2 = StringsKt__StringsKt.O(property, '.', i2, false, 4, null);
        if (O2 < 0) {
            O2 = property.length();
        }
        String substring = property.substring(0, O);
        s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = property.substring(i2, O2);
        s.g(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
