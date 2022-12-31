package com.ironsource.sdk.data;
/* compiled from: AdUnitsReady.java */
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: e  reason: collision with root package name */
    private static String f5764e = "type";

    /* renamed from: f  reason: collision with root package name */
    private static String f5765f = "numOfAdUnits";

    /* renamed from: g  reason: collision with root package name */
    private static String f5766g = "firstCampaignCredits";

    /* renamed from: h  reason: collision with root package name */
    private static String f5767h = "totalNumberCredits";

    /* renamed from: i  reason: collision with root package name */
    private static String f5768i = "productType";
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5769d;

    public a(String str) {
        super(str);
        if (a(f5764e)) {
            u(f(f5764e));
        }
        if (a(f5765f)) {
            q(f(f5765f));
            r(true);
        } else {
            r(false);
        }
        if (a(f5766g)) {
            p(f(f5766g));
        }
        if (a(f5767h)) {
            t(f(f5767h));
        }
        if (a(f5768i)) {
            s(f(f5768i));
        }
    }

    private void r(boolean z) {
        this.f5769d = z;
    }

    public String m() {
        return this.c;
    }

    public String n() {
        return this.b;
    }

    public boolean o() {
        return this.f5769d;
    }

    public void p(String str) {
    }

    public void q(String str) {
        this.c = str;
    }

    public void s(String str) {
        this.b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }
}
