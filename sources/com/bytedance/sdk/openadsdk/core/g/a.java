package com.bytedance.sdk.openadsdk.core.g;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* compiled from: AdSlotSetter.java */
/* loaded from: classes.dex */
public class a {
    public String a;
    public List<String> z;
    public int b = 1;
    public int c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f1635d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f1636e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f1637f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f1638g = 100;

    /* renamed from: h  reason: collision with root package name */
    public int f1639h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f1640i = 2;

    /* renamed from: j  reason: collision with root package name */
    public int f1641j = 1;

    /* renamed from: k  reason: collision with root package name */
    public int f1642k = 3;

    /* renamed from: l  reason: collision with root package name */
    public int f1643l = -1;
    public int m = -1;
    public int n = -1;
    public int o = 2;
    public int p = 1;
    public int q = 0;
    public int r = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int s = 2;
    public int t = -1;
    public int u = 20;
    public int v = -1;
    public int w = 0;
    public int x = 5;
    public int y = 0;
    public int A = 2;

    private a() {
    }

    public static a a() {
        return new a();
    }

    public a b(int i2) {
        this.w = i2;
        return this;
    }

    public a c(int i2) {
        this.y = i2;
        return this;
    }

    public a d(int i2) {
        this.u = i2;
        return this;
    }

    public a e(int i2) {
        this.t = i2;
        return this;
    }

    public a f(int i2) {
        this.q = i2;
        return this;
    }

    public a g(int i2) {
        this.r = i2;
        return this;
    }

    public a h(int i2) {
        this.s = i2;
        return this;
    }

    public a i(int i2) {
        this.o = i2;
        return this;
    }

    public a j(int i2) {
        this.m = i2;
        return this;
    }

    public a k(int i2) {
        this.n = i2;
        return this;
    }

    public a l(int i2) {
        this.f1643l = i2;
        return this;
    }

    public a m(int i2) {
        this.f1642k = i2;
        return this;
    }

    public a n(int i2) {
        this.b = i2;
        return this;
    }

    public a o(int i2) {
        this.c = i2;
        return this;
    }

    public a p(int i2) {
        this.f1635d = i2;
        return this;
    }

    public a q(int i2) {
        this.f1636e = i2;
        return this;
    }

    public a r(int i2) {
        this.f1637f = i2;
        return this;
    }

    public a s(int i2) {
        this.f1638g = i2;
        return this;
    }

    public a t(int i2) {
        this.f1639h = i2;
        return this;
    }

    public a u(int i2) {
        this.f1640i = i2;
        return this;
    }

    public a v(int i2) {
        this.f1641j = i2;
        return this;
    }

    public a w(int i2) {
        this.p = i2;
        return this;
    }

    public a x(int i2) {
        this.A = i2;
        return this;
    }

    public a y(int i2) {
        this.x = i2;
        return this;
    }

    public a a(int i2) {
        this.v = i2;
        return this;
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.z = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.z.add(jSONArray.get(i2).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
