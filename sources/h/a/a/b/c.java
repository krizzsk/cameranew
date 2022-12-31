package h.a.a.b;

import org.aspectj.lang.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JoinPointImpl.java */
/* loaded from: classes3.dex */
public class c implements org.aspectj.lang.a {
    Object a;
    Object b;
    Object[] c;

    /* renamed from: d  reason: collision with root package name */
    a.InterfaceC0328a f8646d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JoinPointImpl.java */
    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC0328a {
        String a;
        org.aspectj.lang.b b;

        public a(int i2, String str, org.aspectj.lang.b bVar, org.aspectj.lang.reflect.b bVar2) {
            this.a = str;
            this.b = bVar;
        }

        public String a() {
            return this.a;
        }

        public org.aspectj.lang.b b() {
            return this.b;
        }

        String c(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.d(a()));
            stringBuffer.append("(");
            stringBuffer.append(((f) b()).k(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        @Override // org.aspectj.lang.a.InterfaceC0328a
        public final String toString() {
            return c(h.f8654h);
        }
    }

    public c(a.InterfaceC0328a interfaceC0328a, Object obj, Object obj2, Object[] objArr) {
        this.f8646d = interfaceC0328a;
        this.a = obj;
        this.b = obj2;
        this.c = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object a() {
        return this.b;
    }

    public final String toString() {
        return this.f8646d.toString();
    }
}
