package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class am extends k {
    private static byte[] y;
    private static Map<String, String> z;
    public int a = 0;
    public String b = "";
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f7936d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f7937e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f7938f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f7939g = 0;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f7940h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f7941i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f7942j = "";

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f7943k = null;

    /* renamed from: l  reason: collision with root package name */
    public String f7944l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    private String u = "";
    public String r = "";
    private String v = "";
    private String w = "";
    public String s = "";
    public String t = "";
    private String x = "";

    static {
        y = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        jVar.a(this.f7936d, 3);
        String str = this.f7937e;
        if (str != null) {
            jVar.a(str, 4);
        }
        jVar.a(this.f7938f, 5);
        jVar.a(this.f7939g, 6);
        jVar.a(this.f7940h, 7);
        String str2 = this.f7941i;
        if (str2 != null) {
            jVar.a(str2, 8);
        }
        String str3 = this.f7942j;
        if (str3 != null) {
            jVar.a(str3, 9);
        }
        Map<String, String> map = this.f7943k;
        if (map != null) {
            jVar.a((Map) map, 10);
        }
        String str4 = this.f7944l;
        if (str4 != null) {
            jVar.a(str4, 11);
        }
        jVar.a(this.m, 12);
        String str5 = this.n;
        if (str5 != null) {
            jVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            jVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            jVar.a(str7, 15);
        }
        jVar.a(this.q, 16);
        String str8 = this.u;
        if (str8 != null) {
            jVar.a(str8, 17);
        }
        String str9 = this.r;
        if (str9 != null) {
            jVar.a(str9, 18);
        }
        String str10 = this.v;
        if (str10 != null) {
            jVar.a(str10, 19);
        }
        String str11 = this.w;
        if (str11 != null) {
            jVar.a(str11, 20);
        }
        String str12 = this.s;
        if (str12 != null) {
            jVar.a(str12, 21);
        }
        String str13 = this.t;
        if (str13 != null) {
            jVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            jVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.b(1, true);
        this.c = iVar.b(2, true);
        this.f7936d = iVar.b(3, true);
        this.f7937e = iVar.b(4, false);
        this.f7938f = iVar.b(5, true);
        this.f7939g = iVar.a(this.f7939g, 6, true);
        this.f7940h = iVar.c(7, true);
        this.f7941i = iVar.b(8, false);
        this.f7942j = iVar.b(9, false);
        this.f7943k = (Map) iVar.a((i) z, 10, false);
        this.f7944l = iVar.b(11, false);
        this.m = iVar.a(this.m, 12, false);
        this.n = iVar.b(13, false);
        this.o = iVar.b(14, false);
        this.p = iVar.b(15, false);
        this.q = iVar.a(this.q, 16, false);
        this.u = iVar.b(17, false);
        this.r = iVar.b(18, false);
        this.v = iVar.b(19, false);
        this.w = iVar.b(20, false);
        this.s = iVar.b(21, false);
        this.t = iVar.b(22, false);
        this.x = iVar.b(23, false);
    }
}
