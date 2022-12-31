package com.ironsource.sdk.data;
/* compiled from: ISNError.java */
/* loaded from: classes2.dex */
public class c {
    private String a;
    private int b;

    public c(int i2, String str) {
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
        return "error - code:" + this.b + ", message:" + this.a;
    }
}
