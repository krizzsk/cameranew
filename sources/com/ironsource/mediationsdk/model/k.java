package com.ironsource.mediationsdk.model;
/* compiled from: InterstitialPlacement.java */
/* loaded from: classes2.dex */
public class k {
    private int a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private p f5609d;

    public k(int i2, String str, boolean z, p pVar) {
        this.a = i2;
        this.b = str;
        this.c = z;
        this.f5609d = pVar;
    }

    public p a() {
        return this.f5609d;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "placement name: " + this.b;
    }
}
