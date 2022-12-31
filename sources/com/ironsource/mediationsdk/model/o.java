package com.ironsource.mediationsdk.model;
/* compiled from: Placement.java */
/* loaded from: classes2.dex */
public class o {
    private int a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f5620d;

    /* renamed from: e  reason: collision with root package name */
    private int f5621e;

    /* renamed from: f  reason: collision with root package name */
    private p f5622f;

    public o(int i2, String str, boolean z, String str2, int i3, p pVar) {
        this.a = i2;
        this.b = str;
        this.c = z;
        this.f5620d = str2;
        this.f5621e = i3;
        this.f5622f = pVar;
    }

    public p a() {
        return this.f5622f;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f5621e;
    }

    public String e() {
        return this.f5620d;
    }

    public boolean f() {
        return this.c;
    }

    public String toString() {
        return "placement name: " + this.b + ", reward name: " + this.f5620d + " , amount: " + this.f5621e;
    }
}
