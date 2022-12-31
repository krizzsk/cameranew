package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;
/* compiled from: ProviderOrder.java */
/* loaded from: classes2.dex */
public class q {
    private String b;
    private String c;
    private ArrayList<String> a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f5629d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f5630e = new ArrayList<>();

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5630e.add(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5629d.add(str);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.add(str);
    }

    public ArrayList<String> d() {
        return this.f5630e;
    }

    public ArrayList<String> e() {
        return this.f5629d;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public ArrayList<String> h() {
        return this.a;
    }

    public void i(String str) {
    }

    public void j(String str) {
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(String str) {
        this.c = str;
    }
}
