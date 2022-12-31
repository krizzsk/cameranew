package com.ironsource.mediationsdk.logger;
/* compiled from: IronSourceError.java */
/* loaded from: classes2.dex */
public class b {
    private String a;
    private int b;

    public b(int i2, String str) {
        this.b = i2;
        this.a = str == null ? "" : str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return "errorCode:" + this.b + ", errorMessage:" + this.a;
    }
}
