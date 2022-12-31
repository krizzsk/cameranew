package com.ironsource.sdk.utils;

import android.content.Context;
/* compiled from: DeviceProperties.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    private static a f5776g;
    private String a = com.ironsource.environment.e.r();
    private String b = com.ironsource.environment.e.q();
    private String c = com.ironsource.environment.e.t();

    /* renamed from: d  reason: collision with root package name */
    private String f5777d = com.ironsource.environment.e.f();

    /* renamed from: e  reason: collision with root package name */
    private int f5778e = com.ironsource.environment.e.e();

    /* renamed from: f  reason: collision with root package name */
    private String f5779f;

    private a(Context context) {
        this.f5779f = com.ironsource.environment.e.G(context);
    }

    public static a h(Context context) {
        if (f5776g == null) {
            f5776g = new a(context);
        }
        return f5776g;
    }

    public static String i() {
        return "5.101";
    }

    public int a() {
        return this.f5778e;
    }

    public String b() {
        return this.f5779f;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.f5777d;
    }

    public float g(Context context) {
        return com.ironsource.environment.e.K(context);
    }
}
