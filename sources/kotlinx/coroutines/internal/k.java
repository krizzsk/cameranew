package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: FastServiceLoader.kt */
/* loaded from: classes3.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> U;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            U = kotlin.collections.c0.U(ServiceLoader.load(cls, classLoader));
            return U;
        }
    }

    private final List<String> e(URL url) {
        boolean x;
        String y0;
        String D0;
        String y02;
        String url2 = url.toString();
        x = kotlin.text.t.x(url2, "jar", false, 2, null);
        if (x) {
            y0 = StringsKt__StringsKt.y0(url2, "jar:file:", null, 2, null);
            D0 = StringsKt__StringsKt.D0(y0, '!', null, 2, null);
            y02 = StringsKt__StringsKt.y0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(D0, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(y02)), "UTF-8"));
                List<String> f2 = a.f(bufferedReader);
                kotlin.io.b.a(bufferedReader, null);
                jarFile.close();
                return f2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        kotlin.b.a(th, th3);
                        throw th;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        try {
            List<String> f3 = a.f(bufferedReader2);
            kotlin.io.b.a(bufferedReader2, null);
            return f3;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                kotlin.io.b.a(bufferedReader2, th4);
                throw th5;
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> U;
        String E0;
        CharSequence H0;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                U = kotlin.collections.c0.U(linkedHashSet);
                return U;
            }
            E0 = StringsKt__StringsKt.E0(readLine, "#", null, 2, null);
            Objects.requireNonNull(E0, "null cannot be cast to non-null type kotlin.CharSequence");
            H0 = StringsKt__StringsKt.H0(E0);
            String obj = H0.toString();
            int i2 = 0;
            while (true) {
                if (i2 >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i2);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                if (obj.length() > 0) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(kotlin.jvm.internal.s.q("Illegal service provider class name: ", obj).toString());
            }
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!l.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set<String> X;
        int o;
        ArrayList<URL> list = Collections.list(classLoader.getResources(kotlin.jvm.internal.s.q("META-INF/services/", cls.getName())));
        kotlin.jvm.internal.s.g(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            kotlin.collections.z.q(arrayList, a.e(url));
        }
        X = kotlin.collections.c0.X(arrayList);
        if (!X.isEmpty()) {
            o = kotlin.collections.v.o(X, 10);
            ArrayList arrayList2 = new ArrayList(o);
            for (String str : X) {
                arrayList2.add(a.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
