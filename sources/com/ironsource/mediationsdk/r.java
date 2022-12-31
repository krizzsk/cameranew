package com.ironsource.mediationsdk;
/* compiled from: ISBannerSize.java */
/* loaded from: classes2.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f5645d = new r("BANNER", 320, 50);

    /* renamed from: e  reason: collision with root package name */
    protected static final r f5646e = new r("LEADERBOARD", 728, 90);
    private int a;
    private int b;
    private String c;

    public r(String str, int i2, int i3) {
        this.c = str;
        this.a = i2;
        this.b = i3;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        return this.c.equals("SMART");
    }
}
