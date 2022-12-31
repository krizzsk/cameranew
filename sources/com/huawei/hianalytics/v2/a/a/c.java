package com.huawei.hianalytics.v2.a.a;
/* loaded from: classes2.dex */
public abstract class c {
    protected String a;
    protected String b;
    protected String c;

    /* renamed from: d  reason: collision with root package name */
    protected String f5128d;

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a(b());
        cVar.c(d());
        cVar.b(c());
        cVar.d(e());
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.f5128d = str;
    }

    public String d() {
        return this.f5128d;
    }

    public void d(String str) {
        this.c = str;
    }

    public String e() {
        return this.c;
    }
}
