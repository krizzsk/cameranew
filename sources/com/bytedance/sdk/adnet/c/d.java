package com.bytedance.sdk.adnet.c;

import java.util.Map;
/* compiled from: TNCConfig.java */
/* loaded from: classes.dex */
public class d {
    public boolean a = false;
    public boolean b = true;
    public Map<String, Integer> c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f1197d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f1198e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f1199f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f1200g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f1201h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f1202i = 1;

    /* renamed from: j  reason: collision with root package name */
    public int f1203j = 1;

    /* renamed from: k  reason: collision with root package name */
    public int f1204k = 900;

    /* renamed from: l  reason: collision with root package name */
    public int f1205l = 120;
    public String m = null;
    public int n = 0;
    public long o = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.a);
        sb.append(" probeEnable: ");
        sb.append(this.b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f1197d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f1198e);
        sb.append("#");
        sb.append(this.f1199f);
        sb.append("#");
        sb.append(this.f1200g);
        sb.append(" reqErr: ");
        sb.append(this.f1201h);
        sb.append("#");
        sb.append(this.f1202i);
        sb.append("#");
        sb.append(this.f1203j);
        sb.append(" updateInterval: ");
        sb.append(this.f1204k);
        sb.append(" updateRandom: ");
        sb.append(this.f1205l);
        sb.append(" httpBlack: ");
        sb.append(this.m);
        return sb.toString();
    }
}
