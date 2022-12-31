package com.ironsource.sdk.data;

import java.util.HashMap;
import java.util.Map;
/* compiled from: DemandSource.java */
/* loaded from: classes2.dex */
public class b {
    private String a;
    private String b;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f5770d;

    /* renamed from: g  reason: collision with root package name */
    private d.e.d.n.a f5773g;
    private int c = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f5771e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5772f = false;

    public b(String str, String str2, Map<String, String> map, d.e.d.n.a aVar) {
        this.b = str;
        this.a = str2;
        this.f5770d = map;
        this.f5773g = aVar;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.b);
        hashMap.put("demandSourceName", this.a);
        Map<String, String> map = this.f5770d;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public boolean b() {
        return this.f5772f;
    }

    public int c() {
        return this.f5771e;
    }

    public String d() {
        return this.a;
    }

    public Map<String, String> e() {
        return this.f5770d;
    }

    public String f() {
        return this.b;
    }

    public d.e.d.n.a g() {
        return this.f5773g;
    }

    public int h() {
        return this.c;
    }

    public boolean i(int i2) {
        return this.c == i2;
    }

    public boolean j() {
        Map<String, String> map = this.f5770d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.f5770d.get("rewarded"));
    }

    public void k(boolean z) {
        this.f5772f = z;
    }

    public synchronized void l(int i2) {
        this.f5771e = i2;
    }

    public void m(int i2) {
        this.c = i2;
    }
}
