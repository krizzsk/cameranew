package h.a.a.b;

import java.lang.reflect.Modifier;
/* compiled from: StringMaker.java */
/* loaded from: classes3.dex */
class h {

    /* renamed from: g  reason: collision with root package name */
    static h f8653g;

    /* renamed from: h  reason: collision with root package name */
    static h f8654h;

    /* renamed from: i  reason: collision with root package name */
    static h f8655i;
    boolean a = true;
    boolean b = true;
    boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f8656d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f8657e = false;

    /* renamed from: f  reason: collision with root package name */
    int f8658f;

    static {
        h hVar = new h();
        f8653g = hVar;
        hVar.a = true;
        hVar.b = false;
        hVar.c = false;
        hVar.f8656d = false;
        hVar.f8657e = true;
        hVar.f8658f = 0;
        h hVar2 = new h();
        f8654h = hVar2;
        hVar2.a = true;
        hVar2.b = true;
        hVar2.c = false;
        hVar2.f8656d = false;
        hVar2.f8657e = false;
        hVar.f8658f = 1;
        h hVar3 = new h();
        f8655i = hVar3;
        hVar3.a = false;
        hVar3.b = true;
        hVar3.c = false;
        hVar3.f8656d = true;
        hVar3.f8657e = false;
        hVar3.f8658f = 2;
    }

    h() {
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.b) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        c(stringBuffer, clsArr);
        stringBuffer.append(")");
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        c(stringBuffer, clsArr);
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(g(clsArr[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e(int i2) {
        if (this.f8656d) {
            String modifier = Modifier.toString(i2);
            if (modifier.length() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(modifier);
            stringBuffer.append(" ");
            return stringBuffer.toString();
        }
        return "";
    }

    public String f(Class cls, String str) {
        return h(cls, str, this.f8657e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.a);
    }

    String h(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return i(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    String i(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }
}
