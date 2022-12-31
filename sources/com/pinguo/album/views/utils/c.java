package com.pinguo.album.views.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: FlingScroller.java */
/* loaded from: classes3.dex */
public class c {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f6130d;

    /* renamed from: e  reason: collision with root package name */
    private int f6131e;

    /* renamed from: f  reason: collision with root package name */
    private int f6132f;

    /* renamed from: g  reason: collision with root package name */
    private double f6133g;

    /* renamed from: h  reason: collision with root package name */
    private double f6134h;

    /* renamed from: i  reason: collision with root package name */
    private int f6135i;

    /* renamed from: j  reason: collision with root package name */
    private int f6136j;

    /* renamed from: k  reason: collision with root package name */
    private int f6137k;

    /* renamed from: l  reason: collision with root package name */
    private int f6138l;
    private int m;
    private int n;
    private double o;

    private double j(float f2) {
        return (((this.f6136j * 4) * 1000) * Math.pow(1.0f - f2, 3.0d)) / this.f6135i;
    }

    private int k(float f2) {
        int round = (int) Math.round(this.a + (f2 * this.f6136j * this.f6134h));
        double d2 = this.f6134h;
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i2 = this.a;
            int i3 = this.f6131e;
            if (i2 <= i3) {
                return Math.min(round, i3);
            }
        }
        if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i4 = this.a;
            int i5 = this.c;
            return i4 >= i5 ? Math.max(round, i5) : round;
        }
        return round;
    }

    private int l(float f2) {
        int round = (int) Math.round(this.b + (f2 * this.f6136j * this.f6133g));
        double d2 = this.f6133g;
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i2 = this.b;
            int i3 = this.f6132f;
            if (i2 <= i3) {
                return Math.min(round, i3);
            }
        }
        if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i4 = this.b;
            int i5 = this.f6130d;
            return i4 >= i5 ? Math.max(round, i5) : round;
        }
        return round;
    }

    public void a(float f2) {
        float min = Math.min(f2, 1.0f);
        float pow = 1.0f - ((float) Math.pow(1.0f - min, 4.0d));
        this.m = k(pow);
        this.n = l(pow);
        this.o = j(min);
    }

    public void b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = i2;
        this.b = i3;
        this.c = i6;
        this.f6130d = i8;
        this.f6131e = i7;
        this.f6132f = i9;
        double d2 = i4;
        double d3 = i5;
        double hypot = Math.hypot(d2, d3);
        this.f6133g = d3 / hypot;
        this.f6134h = d2 / hypot;
        int round = (int) Math.round(Math.pow(Math.abs(hypot), 0.3333333333333333d) * 50.0d);
        this.f6135i = round;
        this.f6136j = (int) Math.round(((hypot * round) / 4.0d) / 1000.0d);
        this.f6137k = k(1.0f);
        this.f6138l = l(1.0f);
    }

    public int c() {
        return (int) Math.round(this.o * this.f6134h);
    }

    public int d() {
        return (int) Math.round(this.o * this.f6133g);
    }

    public int e() {
        return this.m;
    }

    public int f() {
        return this.n;
    }

    public int g() {
        return this.f6135i;
    }

    public int h() {
        return this.f6137k;
    }

    public int i() {
        return this.f6138l;
    }
}
