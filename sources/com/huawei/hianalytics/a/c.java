package com.huawei.hianalytics.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static Object a = new Object();
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5106d;

    /* renamed from: e  reason: collision with root package name */
    private String f5107e;

    /* renamed from: f  reason: collision with root package name */
    private String f5108f;

    /* renamed from: g  reason: collision with root package name */
    private String f5109g;

    /* renamed from: h  reason: collision with root package name */
    private String f5110h;

    /* renamed from: i  reason: collision with root package name */
    private String f5111i;

    /* renamed from: j  reason: collision with root package name */
    private String f5112j;

    /* renamed from: l  reason: collision with root package name */
    private String f5114l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String r;
    private String s;
    private String t;
    private String w;

    /* renamed from: k  reason: collision with root package name */
    private long f5113k = 0;
    private String q = "";
    private String u = "";
    private boolean v = true;
    private String x = "";
    private HashMap<Object, String> y = new HashMap<>();

    public String a() {
        return this.q;
    }

    public void a(long j2) {
        this.f5113k = j2;
    }

    public void a(String str) {
        this.q = str;
    }

    public void a(String str, String str2, String str3) {
        synchronized (a) {
            this.y.put(str, str3);
        }
    }

    public void a(HashMap<Object, String> hashMap) {
        synchronized (a) {
            HashMap<Object, String> hashMap2 = this.y;
            if (hashMap2 != null && hashMap != null) {
                hashMap2.putAll(hashMap);
            }
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public boolean b() {
        return this.p;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public boolean c() {
        return this.o;
    }

    public void d(String str) {
        this.f5106d = str;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public boolean d() {
        return this.n;
    }

    public void e(String str) {
        this.f5107e = str;
    }

    public void e(boolean z) {
        this.v = z;
    }

    public boolean e() {
        return this.m;
    }

    public String f() {
        return this.u;
    }

    public void f(String str) {
        this.f5108f = str;
    }

    public String g() {
        return this.x;
    }

    public void g(String str) {
        this.f5110h = str;
    }

    public String h() {
        return this.b;
    }

    public void h(String str) {
        this.f5111i = str;
    }

    public String i() {
        return this.c;
    }

    public void i(String str) {
        this.s = str;
    }

    public String j() {
        return this.f5106d;
    }

    public void j(String str) {
        this.t = str;
    }

    public String k() {
        return this.f5107e;
    }

    public void k(String str) {
        this.w = str;
    }

    public String l() {
        return this.f5108f;
    }

    public void l(String str) {
        this.u = str;
    }

    public String m() {
        return this.t;
    }

    public void m(String str) {
        this.x = str;
    }

    public String n() {
        return this.s;
    }

    public void n(String str) {
        this.r = str;
    }

    public String o() {
        return this.w;
    }

    public void o(String str) {
        this.f5114l = str;
    }

    public String p() {
        return this.r;
    }

    public void p(String str) {
        this.f5112j = str;
    }

    public String q() {
        return this.f5114l;
    }

    public void q(String str) {
        this.f5109g = str;
    }

    public long r() {
        return this.f5113k;
    }

    public String s() {
        return this.f5112j;
    }

    public String t() {
        return this.f5110h;
    }

    public String u() {
        return this.f5111i;
    }

    public String v() {
        return this.f5109g;
    }

    public synchronized void w() {
        this.f5110h = "";
        this.f5111i = "";
        this.t = "";
        this.u = "";
        this.x = "";
        this.f5114l = "";
        this.p = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = "";
        this.r = "";
        this.f5113k = 0L;
        this.s = "";
    }

    public void x() {
        synchronized (a) {
            this.y.clear();
        }
    }

    public HashMap<Object, String> y() {
        HashMap<Object, String> hashMap;
        synchronized (a) {
            hashMap = this.y;
        }
        return hashMap;
    }

    public boolean z() {
        return this.v;
    }
}
