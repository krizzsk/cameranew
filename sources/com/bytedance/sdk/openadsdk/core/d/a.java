package com.bytedance.sdk.openadsdk.core.d;

import java.util.ArrayList;
import java.util.List;
/* compiled from: AdInfo.java */
/* loaded from: classes.dex */
public class a {
    private String a;
    private int b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private List<h> f1547d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private String f1548e;

    /* renamed from: f  reason: collision with root package name */
    private long f1549f;

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public List<h> c() {
        return this.f1547d;
    }

    public String d() {
        return this.f1548e;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.f1548e = str;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(h hVar) {
        this.f1547d.add(hVar);
    }

    public void a(long j2) {
        this.f1549f = j2;
    }
}
