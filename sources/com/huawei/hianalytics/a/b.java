package com.huawei.hianalytics.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private boolean a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5099d;

    /* renamed from: e  reason: collision with root package name */
    private String f5100e;

    /* renamed from: f  reason: collision with root package name */
    private String f5101f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Object, String> f5102g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private String f5103h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f5104i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f5105j = "";

    public void a(String str) {
        this.f5100e = str;
    }

    public void a(HashMap<Object, String> hashMap) {
        HashMap<Object, String> hashMap2 = this.f5102g;
        if (hashMap2 == null || hashMap == null) {
            return;
        }
        hashMap2.putAll(hashMap);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    public void b(String str) {
        this.f5101f = str;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public void c(String str) {
        this.f5103h = str;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.c;
    }

    public void d(String str) {
        this.f5104i = str;
    }

    public void d(boolean z) {
        this.f5099d = z;
    }

    public boolean d() {
        return this.f5099d;
    }

    public HashMap<Object, String> e() {
        HashMap<Object, String> hashMap = new HashMap<>();
        hashMap.putAll(this.f5102g);
        return hashMap;
    }

    public void e(String str) {
        this.f5105j = str;
    }

    public String f() {
        return this.f5100e;
    }

    public String g() {
        return this.f5101f;
    }

    public String h() {
        return this.f5103h;
    }

    public String i() {
        return this.f5104i;
    }

    public String j() {
        return this.f5105j;
    }
}
