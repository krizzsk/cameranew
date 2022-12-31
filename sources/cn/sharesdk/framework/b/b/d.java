package cn.sharesdk.framework.b.b;
/* compiled from: DemoEvent.java */
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: d  reason: collision with root package name */
    private static int f96d;
    private static long m;
    public String a;
    public int b;
    public String c = "";

    @Override // cn.sharesdk.framework.b.b.c
    protected String a() {
        return "[EVT]";
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void a(long j2) {
        m = j2;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long d() {
        return f96d;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long e() {
        return m;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void f() {
        f96d++;
    }

    @Override // cn.sharesdk.framework.b.b.c
    public String toString() {
        return super.toString() + '|' + this.a + '|' + this.b + '|' + this.c;
    }
}
