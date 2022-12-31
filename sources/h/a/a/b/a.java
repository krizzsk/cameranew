package h.a.a.b;
/* compiled from: CodeSignatureImpl.java */
/* loaded from: classes3.dex */
abstract class a extends d implements org.aspectj.lang.b {

    /* renamed from: i  reason: collision with root package name */
    Class[] f8640i;

    /* renamed from: j  reason: collision with root package name */
    Class[] f8641j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i2, str, cls);
        this.f8640i = clsArr;
        this.f8641j = clsArr2;
    }

    public Class[] l() {
        if (this.f8641j == null) {
            this.f8641j = e(5);
        }
        return this.f8641j;
    }

    public Class[] m() {
        if (this.f8640i == null) {
            this.f8640i = e(3);
        }
        return this.f8640i;
    }
}
