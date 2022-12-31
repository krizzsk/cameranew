package com.iab.omid.library.ironsrc.adsession;
/* loaded from: classes2.dex */
public class e {
    private final String a;
    private final String b;

    private e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static e a(String str, String str2) {
        d.d.a.a.a.g.e.e(str, "Name is null or empty");
        d.d.a.a.a.g.e.e(str2, "Version is null or empty");
        return new e(str, str2);
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }
}
