package cn.sharesdk.framework.b.b;
/* compiled from: ApiEvent.java */
/* loaded from: classes.dex */
public class a extends c {
    private static int c;

    /* renamed from: d  reason: collision with root package name */
    private static long f86d;
    public int a;
    public String b;

    @Override // cn.sharesdk.framework.b.b.c
    protected String a() {
        return "[API]";
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void a(long j2) {
        f86d = j2;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int c() {
        return 50;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long d() {
        return c;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long e() {
        return f86d;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void f() {
        c++;
    }

    @Override // cn.sharesdk.framework.b.b.c
    public String toString() {
        return super.toString() + '|' + this.a + '|' + this.b;
    }
}
