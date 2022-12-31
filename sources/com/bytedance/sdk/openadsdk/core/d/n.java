package com.bytedance.sdk.openadsdk.core.d;

import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: VideoInfo.java */
/* loaded from: classes.dex */
public class n {
    private int a;
    private int b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private double f1616d;

    /* renamed from: e  reason: collision with root package name */
    private String f1617e;

    /* renamed from: f  reason: collision with root package name */
    private String f1618f;

    /* renamed from: g  reason: collision with root package name */
    private String f1619g;

    /* renamed from: h  reason: collision with root package name */
    private String f1620h;

    /* renamed from: i  reason: collision with root package name */
    private String f1621i;

    /* renamed from: j  reason: collision with root package name */
    private String f1622j;

    /* renamed from: k  reason: collision with root package name */
    private int f1623k;

    /* renamed from: l  reason: collision with root package name */
    private int f1624l = 0;
    private int m = 0;

    public int a() {
        return this.f1623k;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public long d() {
        return this.c;
    }

    public double e() {
        return this.f1616d;
    }

    public String f() {
        return this.f1617e;
    }

    public String g() {
        return this.f1618f;
    }

    public String h() {
        return this.f1619g;
    }

    public String i() {
        return this.f1620h;
    }

    public String j() {
        return this.f1621i;
    }

    public String k() {
        return this.f1622j;
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", g());
            jSONObject.put("cover_width", c());
            jSONObject.put("endcard", i());
            jSONObject.put("file_hash", k());
            jSONObject.put("resolution", f());
            jSONObject.put(BigAlbumStore.PhotoColumns.SIZE, d());
            jSONObject.put("video_duration", e());
            jSONObject.put(TapjoyConstants.TJC_VIDEO_URL, h());
            jSONObject.put("playable_download_url", j());
            jSONObject.put("if_playable_loading_show", m());
            jSONObject.put("remove_loading_page_type", n());
            jSONObject.put("fallback_endcard_judge", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int m() {
        return this.f1624l;
    }

    public int n() {
        return this.m;
    }

    public void a(int i2) {
        this.f1623k = i2;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void c(int i2) {
        this.b = i2;
    }

    public void d(String str) {
        this.f1620h = str;
    }

    public void e(String str) {
        this.f1621i = str;
    }

    public void f(String str) {
        this.f1622j = str;
    }

    public void a(long j2) {
        this.c = j2;
    }

    public void b(String str) {
        this.f1618f = str;
    }

    public void c(String str) {
        this.f1619g = str;
    }

    public void d(int i2) {
        this.f1624l = i2;
    }

    public void e(int i2) {
        this.m = i2;
    }

    public void a(double d2) {
        this.f1616d = d2;
    }

    public void a(String str) {
        this.f1617e = str;
    }
}
