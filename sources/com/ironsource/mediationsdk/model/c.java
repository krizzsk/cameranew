package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.HashSet;
/* compiled from: ApplicationCrashReporterSettings.java */
/* loaded from: classes2.dex */
public class c {
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5585d;

    /* renamed from: f  reason: collision with root package name */
    private int f5587f;
    private HashSet<String> b = new HashSet<>();
    private boolean a = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5586e = false;

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.add(str);
    }

    public int b() {
        return this.f5587f;
    }

    public HashSet<String> c() {
        return this.b;
    }

    public String d() {
        return this.f5585d;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.f5586e;
    }

    public boolean g() {
        return this.a;
    }

    public void h(int i2) {
        this.f5587f = i2;
    }

    public void i(boolean z) {
        this.a = z;
    }

    public void j(String str) {
        this.f5585d = str;
    }

    public void k(String str) {
        this.c = str;
    }

    public void l(boolean z) {
        this.f5586e = z;
    }
}
