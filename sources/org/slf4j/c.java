package org.slf4j;

import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.d;
import org.slf4j.helpers.e;
import org.slf4j.helpers.f;
/* compiled from: LoggerFactory.java */
/* loaded from: classes3.dex */
public final class c {
    static volatile int a;
    static e b = new e();
    static org.slf4j.helpers.c c = new org.slf4j.helpers.c();

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f8966d;

    /* renamed from: e  reason: collision with root package name */
    private static String f8967e;

    static {
        f.c("slf4j.detectLoggerNameMismatch");
        f8966d = new String[]{"1.6", "1.7"};
        f8967e = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private c() {
    }

    private static final void a() {
        Set<URL> set = null;
        try {
            if (!k()) {
                set = f();
                q(set);
            }
            org.slf4j.impl.b.c();
            a = 3;
            p(set);
            g();
            n();
            b.b();
        } catch (Exception e2) {
            e(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        } catch (NoClassDefFoundError e3) {
            if (l(e3.getMessage())) {
                a = 4;
                f.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                f.a("Defaulting to no-operation (NOP) logger implementation");
                f.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            e(e3);
            throw e3;
        } catch (NoSuchMethodError e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                a = 2;
                f.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                f.a("Your binding is version 1.5.5 or earlier.");
                f.a("Upgrade your binding to version 1.6.x.");
            }
            throw e4;
        }
    }

    private static void b(org.slf4j.event.c cVar, int i2) {
        if (cVar.a().d()) {
            c(i2);
        } else if (cVar.a().e()) {
        } else {
            d();
        }
    }

    private static void c(int i2) {
        f.a("A number (" + i2 + ") of logging calls during the initialization phase have been intercepted and are");
        f.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        f.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        f.a("The following set of substitute loggers may have been accessed");
        f.a("during the initialization phase. Logging calls during this");
        f.a("phase were not honored. However, subsequent logging calls to these");
        f.a("loggers will work as normally expected.");
        f.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        a = 2;
        f.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f8967e);
            } else {
                resources = classLoader.getResources(f8967e);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e2) {
            f.b("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    private static void g() {
        synchronized (b) {
            b.e();
            for (d dVar : b.d()) {
                dVar.h(i(dVar.c()));
            }
        }
    }

    public static a h() {
        if (a == 0) {
            synchronized (c.class) {
                if (a == 0) {
                    a = 1;
                    m();
                }
            }
        }
        int i2 = a;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return c;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return org.slf4j.impl.b.c().a();
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return b;
    }

    public static b i(String str) {
        return h().a(str);
    }

    private static boolean j(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean k() {
        String d2 = f.d("java.vendor.url");
        if (d2 == null) {
            return false;
        }
        return d2.toLowerCase().contains(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
    }

    private static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static final void m() {
        a();
        if (a == 3) {
            r();
        }
    }

    private static void n() {
        LinkedBlockingQueue<org.slf4j.event.c> c2 = b.c();
        int size = c2.size();
        ArrayList<org.slf4j.event.c> arrayList = new ArrayList(128);
        int i2 = 0;
        while (c2.drainTo(arrayList, 128) != 0) {
            for (org.slf4j.event.c cVar : arrayList) {
                o(cVar);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    b(cVar, size);
                }
                i2 = i3;
            }
            arrayList.clear();
        }
    }

    private static void o(org.slf4j.event.c cVar) {
        if (cVar == null) {
            return;
        }
        d a2 = cVar.a();
        String c2 = a2.c();
        if (!a2.f()) {
            if (a2.e()) {
                return;
            }
            if (a2.d()) {
                a2.g(cVar);
                return;
            } else {
                f.a(c2);
                return;
            }
        }
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void p(Set<URL> set) {
        if (set == null || !j(set)) {
            return;
        }
        f.a("Actual binding is of type [" + org.slf4j.impl.b.c().b() + "]");
    }

    private static void q(Set<URL> set) {
        if (j(set)) {
            f.a("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                f.a("Found binding in [" + it.next() + "]");
            }
            f.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void r() {
        try {
            String str = org.slf4j.impl.b.c;
            boolean z = false;
            for (String str2 : f8966d) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            f.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f8966d).toString());
            f.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            f.b("Unexpected problem occured during version sanity check", th);
        }
    }
}
