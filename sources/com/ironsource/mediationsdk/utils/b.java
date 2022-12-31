package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
/* compiled from: AuctionSettings.java */
/* loaded from: classes2.dex */
public class b {
    private boolean a;
    private boolean b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5658d;

    /* renamed from: e  reason: collision with root package name */
    private int f5659e;

    /* renamed from: f  reason: collision with root package name */
    private int f5660f;

    /* renamed from: g  reason: collision with root package name */
    private int f5661g;

    /* renamed from: h  reason: collision with root package name */
    private long f5662h;

    /* renamed from: i  reason: collision with root package name */
    private long f5663i;

    /* renamed from: j  reason: collision with root package name */
    private long f5664j;

    /* renamed from: k  reason: collision with root package name */
    private long f5665k;

    /* renamed from: l  reason: collision with root package name */
    private long f5666l;
    private boolean m;
    private boolean n;
    private ArrayList<String> o;
    private boolean p;
    private boolean q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.c = "";
        this.f5658d = "";
        this.a = false;
        this.f5663i = 0L;
        this.f5664j = 0L;
        this.f5665k = 0L;
        this.f5666l = 0L;
        this.m = true;
        this.n = true;
        this.o = new ArrayList<>();
        this.f5661g = 0;
        this.p = false;
        this.q = false;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.add(str);
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.f5664j;
    }

    public int d() {
        return this.f5660f;
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.n;
    }

    public boolean g() {
        return this.a;
    }

    public ArrayList<String> h() {
        return this.o;
    }

    public int i() {
        return this.f5659e;
    }

    public boolean j() {
        return this.b;
    }

    public int k() {
        return this.f5661g;
    }

    public long l() {
        return this.f5665k;
    }

    public long m() {
        return this.f5663i;
    }

    public long n() {
        return this.f5666l;
    }

    public long o() {
        return this.f5662h;
    }

    public String p() {
        return this.f5658d;
    }

    public boolean q() {
        return this.p;
    }

    public boolean r() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, int i2, int i3, long j2, boolean z, long j3, long j4, long j5, long j6, boolean z2, boolean z3, int i4, boolean z4, boolean z5, boolean z6) {
        this.c = str;
        this.f5658d = str2;
        this.f5659e = i2;
        this.f5660f = i3;
        this.f5662h = j2;
        this.a = z;
        this.b = z6;
        this.f5663i = j3;
        this.f5664j = j4;
        this.f5665k = j5;
        this.f5666l = j6;
        this.m = z2;
        this.n = z3;
        this.f5661g = i4;
        this.o = new ArrayList<>();
        this.p = z4;
        this.q = z5;
    }
}
