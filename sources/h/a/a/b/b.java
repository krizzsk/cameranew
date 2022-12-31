package h.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import h.a.a.b.c;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.a;
import org.slf4j.Marker;
/* compiled from: Factory.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    static Hashtable f8642e;

    /* renamed from: f  reason: collision with root package name */
    private static Object[] f8643f;

    /* renamed from: g  reason: collision with root package name */
    static /* synthetic */ Class f8644g;
    Class a;
    ClassLoader b;
    String c;

    /* renamed from: d  reason: collision with root package name */
    int f8645d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f8642e = hashtable;
        hashtable.put("void", Void.TYPE);
        f8642e.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        f8642e.put("byte", Byte.TYPE);
        f8642e.put("char", Character.TYPE);
        f8642e.put("short", Short.TYPE);
        f8642e.put("int", Integer.TYPE);
        f8642e.put(Constants.LONG, Long.TYPE);
        f8642e.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        f8642e.put("double", Double.TYPE);
        f8643f = new Object[0];
    }

    public b(String str, Class cls) {
        this.c = str;
        this.a = cls;
        this.b = cls.getClassLoader();
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        if (str.equals(Marker.ANY_MARKER)) {
            return null;
        }
        Class cls = (Class) f8642e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f8644g;
            if (cls2 == null) {
                Class a = a("java.lang.ClassNotFoundException");
                f8644g = a;
                return a;
            }
            return cls2;
        }
    }

    public static org.aspectj.lang.a c(a.InterfaceC0328a interfaceC0328a, Object obj, Object obj2) {
        return new c(interfaceC0328a, obj, obj2, f8643f);
    }

    public static org.aspectj.lang.a d(a.InterfaceC0328a interfaceC0328a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0328a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a e(a.InterfaceC0328a interfaceC0328a, Object obj, Object obj2, Object obj3, Object obj4) {
        return new c(interfaceC0328a, obj, obj2, new Object[]{obj3, obj4});
    }

    public static org.aspectj.lang.a f(a.InterfaceC0328a interfaceC0328a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0328a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.a g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = b(stringTokenizer.nextToken(), this.b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i3 = 0; i3 < countTokens2; i3++) {
            strArr[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i4 = 0; i4 < countTokens3; i4++) {
            clsArr2[i4] = b(stringTokenizer3.nextToken(), this.b);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.b));
    }

    public a.InterfaceC0328a h(String str, org.aspectj.lang.b bVar, int i2) {
        int i3 = this.f8645d;
        this.f8645d = i3 + 1;
        return new c.a(i3, str, bVar, i(i2, -1));
    }

    public org.aspectj.lang.reflect.b i(int i2, int i3) {
        return new g(this.a, this.c, i2);
    }
}
