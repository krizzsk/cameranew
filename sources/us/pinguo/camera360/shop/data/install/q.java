package us.pinguo.camera360.shop.data.install;
/* compiled from: InstallResult.java */
/* loaded from: classes3.dex */
public class q {
    private boolean a;
    private String b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Exception f9607d;

    public q(String str, boolean z, int i2, Exception exc) {
        this.a = z;
        this.b = str;
        this.c = i2;
        this.f9607d = exc;
    }

    public int a() {
        return this.c;
    }

    public Exception b() {
        return this.f9607d;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.a;
    }
}
