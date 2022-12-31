package com.ironsource.mediationsdk;
/* compiled from: BannerData.java */
/* loaded from: classes2.dex */
public class g {
    private String a;
    private String b;
    private com.ironsource.mediationsdk.model.g c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, String str2, com.ironsource.mediationsdk.model.g gVar) {
        this.a = str;
        this.b = str2;
        this.c = gVar;
    }

    public String a() {
        return this.a;
    }

    public com.ironsource.mediationsdk.utils.b b() {
        return this.c.c();
    }

    public int c() {
        return this.c.d();
    }

    public long d() {
        return this.c.b();
    }

    public int e() {
        return this.c.g();
    }

    public long f() {
        return this.c.c().m();
    }

    public String g() {
        return this.b;
    }

    public boolean h() {
        return this.c.c().i() > 0;
    }
}
