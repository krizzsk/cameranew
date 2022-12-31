package h.a.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MethodSignatureImpl.java */
/* loaded from: classes3.dex */
public class e extends a implements org.aspectj.lang.reflect.a {

    /* renamed from: k  reason: collision with root package name */
    Class f8647k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i2, str, cls, clsArr, strArr, clsArr2);
        this.f8647k = cls2;
    }

    @Override // h.a.a.b.f
    protected String a(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.e(i()));
        if (hVar.b) {
            stringBuffer.append(hVar.g(n()));
        }
        if (hVar.b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.f(f(), g()));
        stringBuffer.append(".");
        stringBuffer.append(j());
        hVar.a(stringBuffer, m());
        hVar.b(stringBuffer, l());
        return stringBuffer.toString();
    }

    public Class n() {
        if (this.f8647k == null) {
            this.f8647k = d(6);
        }
        return this.f8647k;
    }
}
