package com.ironsource.mediationsdk.k0;
/* compiled from: ConfigFile.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f5569d;
    private String a;
    private String b;
    private String c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5569d == null) {
                f5569d = new a();
            }
            aVar = f5569d;
        }
        return aVar;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }
}
