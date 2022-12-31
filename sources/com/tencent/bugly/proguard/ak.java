package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ak extends k {
    private static ArrayList<aj> A;
    private static Map<String, String> B;
    private static Map<String, String> C;
    private static Map<String, String> v;
    private static ai w;
    private static ah x;
    private static ArrayList<ah> y;
    private static ArrayList<ah> z;
    public String a = "";
    public long b = 0;
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f7927d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f7928e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f7929f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f7930g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f7931h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f7932i = "";

    /* renamed from: j  reason: collision with root package name */
    public ai f7933j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f7934k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f7935l = "";
    public String m = "";
    public ah n = null;
    public ArrayList<ah> o = null;
    public ArrayList<ah> p = null;
    public ArrayList<aj> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    private String t = "";
    private boolean u = true;

    static {
        HashMap hashMap = new HashMap();
        v = hashMap;
        hashMap.put("", "");
        w = new ai();
        x = new ah();
        y = new ArrayList<>();
        y.add(new ah());
        z = new ArrayList<>();
        z.add(new ah());
        A = new ArrayList<>();
        A.add(new aj());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        String str = this.f7927d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f7928e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        String str3 = this.f7929f;
        if (str3 != null) {
            jVar.a(str3, 5);
        }
        String str4 = this.f7930g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        Map<String, String> map = this.f7931h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
        String str5 = this.f7932i;
        if (str5 != null) {
            jVar.a(str5, 8);
        }
        ai aiVar = this.f7933j;
        if (aiVar != null) {
            jVar.a((k) aiVar, 9);
        }
        jVar.a(this.f7934k, 10);
        String str6 = this.f7935l;
        if (str6 != null) {
            jVar.a(str6, 11);
        }
        String str7 = this.m;
        if (str7 != null) {
            jVar.a(str7, 12);
        }
        ah ahVar = this.n;
        if (ahVar != null) {
            jVar.a((k) ahVar, 13);
        }
        ArrayList<ah> arrayList = this.o;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 14);
        }
        ArrayList<ah> arrayList2 = this.p;
        if (arrayList2 != null) {
            jVar.a((Collection) arrayList2, 15);
        }
        ArrayList<aj> arrayList3 = this.q;
        if (arrayList3 != null) {
            jVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            jVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            jVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            jVar.a(str8, 19);
        }
        jVar.a(this.u, 20);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.b(0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, true);
        this.f7927d = iVar.b(3, false);
        this.f7928e = iVar.b(4, false);
        this.f7929f = iVar.b(5, false);
        this.f7930g = iVar.b(6, false);
        this.f7931h = (Map) iVar.a((i) v, 7, false);
        this.f7932i = iVar.b(8, false);
        this.f7933j = (ai) iVar.a((k) w, 9, false);
        this.f7934k = iVar.a(this.f7934k, 10, false);
        this.f7935l = iVar.b(11, false);
        this.m = iVar.b(12, false);
        this.n = (ah) iVar.a((k) x, 13, false);
        this.o = (ArrayList) iVar.a((i) y, 14, false);
        this.p = (ArrayList) iVar.a((i) z, 15, false);
        this.q = (ArrayList) iVar.a((i) A, 16, false);
        this.r = (Map) iVar.a((i) B, 17, false);
        this.s = (Map) iVar.a((i) C, 18, false);
        this.t = iVar.b(19, false);
        this.u = iVar.a(20, false);
    }
}
