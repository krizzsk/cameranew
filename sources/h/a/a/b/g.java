package h.a.a.b;
/* compiled from: SourceLocationImpl.java */
/* loaded from: classes3.dex */
class g implements org.aspectj.lang.reflect.b {
    String a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Class cls, String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(":");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }
}
