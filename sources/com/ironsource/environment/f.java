package com.ironsource.environment;
/* compiled from: ExceptionLog.java */
/* loaded from: classes2.dex */
public class f {
    private String a;
    private String b;
    private String c;

    public f(String str, String str2, String str3) {
        this.b = str2;
        this.a = str;
        this.c = str3;
    }

    public void a() {
        DbHandler.a(this);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public f(int i2, String str, String str2, String str3) {
        this.b = str2;
        this.a = str;
        this.c = str3;
    }
}
